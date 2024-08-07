package kr.sesacjava.swimtutor.security.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.sesacjava.swimtutor.common.util.JWTUtil;
import kr.sesacjava.swimtutor.security.JwtAuthenticationToken;
import kr.sesacjava.swimtutor.security.exception.AccessTokenException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
public class TokenCheckFilter extends OncePerRequestFilter {
    private final JWTUtil jwtUtil;
    private final String passPath;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        log.info("Token Check Filter...");
        log.info("JWTUtil" + jwtUtil);

        var path = request.getRequestURI();
        if (path.equals(passPath)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            Map<String, Object> claim = validateAccessToken(request);
            saveClaimToAuthentication(claim, request);
            filterChain.doFilter(request, response);
        } catch (AccessTokenException accessTokenException) {
            accessTokenException.sendResponseError(response);
        }
    }

    private Map<String, Object> validateAccessToken(HttpServletRequest request) throws AccessTokenException {
        String headerStr = request.getHeader("Authorization");

        if (headerStr == null || headerStr.length() < 8) {
            throw new AccessTokenException(AccessTokenException.TOKEN_ERROR.UNACCEPT);
        }

        String tokenType = headerStr.substring(0, 6);
        String tokenStr = headerStr.substring(7);

        if (tokenType.equalsIgnoreCase("Bearer") == false) {
            throw new AccessTokenException(AccessTokenException.TOKEN_ERROR.BADTYPE);
        }

        try {
            return jwtUtil.validateToken(tokenStr);
        } catch (MalformedJwtException malformedJwtException) {
            log.error("MalFormedJwtException-------------");
            throw new AccessTokenException((AccessTokenException.TOKEN_ERROR.MALFORM));
        } catch (SignatureException signatureException) {
            log.error("SignatureException-------------");
            throw new AccessTokenException((AccessTokenException.TOKEN_ERROR.BADSIGN));
        } catch (ExpiredJwtException expiredJwtException) {
            log.error("ExpiredJwtException-------------");
            throw new AccessTokenException((AccessTokenException.TOKEN_ERROR.EXPIRED));
        }
    }

    private void saveClaimToAuthentication(Map<String, Object> claim, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);  // "Bearer " 제거

        // 권한 정보 생성 (예시)
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (claim.containsKey("role")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + claim.get("role")));
        }

        // JwtAuthenticationToken 생성
        JwtAuthenticationToken authentication = new JwtAuthenticationToken(token, claim, authorities);

        // SecurityContext에 Authentication 설정
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}

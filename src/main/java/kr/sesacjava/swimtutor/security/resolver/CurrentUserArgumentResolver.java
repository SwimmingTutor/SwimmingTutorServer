package kr.sesacjava.swimtutor.security.resolver;

import kr.sesacjava.swimtutor.security.CurrentUser;
import kr.sesacjava.swimtutor.security.JwtAuthenticationToken;
import kr.sesacjava.swimtutor.security.dto.UserInfo;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Map;

@Component
public class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(CurrentUser.class) != null
                && parameter.getParameterType().equals(UserInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken) {
            Map<String, Object> principal = (Map<String, Object>) authentication.getPrincipal();
            UserInfo userInfo = new UserInfo();
            userInfo.setEmail((String) principal.get("email"));
            userInfo.setPlatform((String) principal.get("platform"));
            return userInfo;
        }
        return null;
    }
}

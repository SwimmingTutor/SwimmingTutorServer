package kr.sesacjava.swimtutor.repository;

import kr.sesacjava.swimtutor.entity.OauthLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthLoginRepository extends JpaRepository<OauthLogin, Long> {
}

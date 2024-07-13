package kr.sesacjava.swimtutor.repository;

import kr.sesacjava.swimtutor.entity.OauthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthRepository extends JpaRepository<OauthEntity, Long> {
  OauthEntity findByUsername(String username);
}

package kr.sesacjava.swimtutor.repository;

import kr.sesacjava.swimtutor.entity.OauthData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthDataRepository extends JpaRepository<OauthData, Long> {
}

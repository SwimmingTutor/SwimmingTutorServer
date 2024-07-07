package kr.sesacjava.swimtutor.repository;

import kr.sesacjava.swimtutor.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findByUsername(String username);
}

package kr.sesacjava.swimtutor.repository;

import kr.sesacjava.swimtutor.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}

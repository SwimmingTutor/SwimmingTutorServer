package kr.sesacjava.swimtutor.users.repository;

import kr.sesacjava.swimtutor.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
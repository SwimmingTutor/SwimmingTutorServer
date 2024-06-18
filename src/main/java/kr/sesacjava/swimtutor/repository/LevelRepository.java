package kr.sesacjava.swimtutor.repository;

import kr.sesacjava.swimtutor.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
}

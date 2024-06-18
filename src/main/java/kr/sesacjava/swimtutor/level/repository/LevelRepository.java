package kr.sesacjava.swimtutor.level.repository;

import kr.sesacjava.swimtutor.level.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
}

package kr.sesacjava.swimtutor.performance.repository;

import kr.sesacjava.swimtutor.performance.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {
}

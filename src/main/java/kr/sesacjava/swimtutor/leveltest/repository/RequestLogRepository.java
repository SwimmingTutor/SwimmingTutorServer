package kr.sesacjava.swimtutor.leveltest.repository;

import kr.sesacjava.swimtutor.leveltest.entity.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestLogRepository extends JpaRepository<RequestLog, Integer> {
}

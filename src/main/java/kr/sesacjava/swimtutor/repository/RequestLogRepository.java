package kr.sesacjava.swimtutor.repository;

import kr.sesacjava.swimtutor.model.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestLogRepository extends JpaRepository<RequestLog, Integer> {
}

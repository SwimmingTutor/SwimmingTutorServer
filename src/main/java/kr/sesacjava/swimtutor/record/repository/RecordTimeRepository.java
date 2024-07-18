package kr.sesacjava.swimtutor.record.repository;

import kr.sesacjava.swimtutor.record.entity.RecordTime;
import kr.sesacjava.swimtutor.record.entity.RecordTimeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordTimeRepository extends JpaRepository<RecordTime, RecordTimeId> {
}

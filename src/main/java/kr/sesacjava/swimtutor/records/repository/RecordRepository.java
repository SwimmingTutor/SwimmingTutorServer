package kr.sesacjava.swimtutor.records.repository;

import kr.sesacjava.swimtutor.records.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}

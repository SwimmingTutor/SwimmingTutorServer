package kr.sesacjava.swimtutor.repository;

import kr.sesacjava.swimtutor.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}

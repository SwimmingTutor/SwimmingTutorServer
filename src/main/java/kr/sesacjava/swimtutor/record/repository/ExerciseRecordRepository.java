package kr.sesacjava.swimtutor.record.repository;

import kr.sesacjava.swimtutor.record.entity.ExerciseRecord;
import kr.sesacjava.swimtutor.record.entity.ExerciseRecordId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRecordRepository extends JpaRepository<ExerciseRecord, ExerciseRecordId> {
}

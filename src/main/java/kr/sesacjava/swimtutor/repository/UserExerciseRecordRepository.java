package kr.sesacjava.swimtutor.repository;

import kr.sesacjava.swimtutor.domain.UserExerciseRecord;
import kr.sesacjava.swimtutor.domain.UserExerciseRecordId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExerciseRecordRepository extends JpaRepository<UserExerciseRecord, UserExerciseRecordId> {
}

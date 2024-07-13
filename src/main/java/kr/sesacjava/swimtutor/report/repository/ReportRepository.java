package kr.sesacjava.swimtutor.report.repository;

import kr.sesacjava.swimtutor.records.entity.Record;
import kr.sesacjava.swimtutor.records.entity.RecordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Record, RecordId> {
    List<Record> findByRecordId_OauthLoginIdAndRecordId_OauthLoginPlatform(String oauthLoginId, String oauthLoginPlatform);
}
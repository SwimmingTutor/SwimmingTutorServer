package kr.sesacjava.swimtutor.record.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import kr.sesacjava.swimtutor.common.entity.BaseEntity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@IdClass(RecordTimeId.class)
public class RecordTime extends BaseEntity {
    @Id
    private String oauthLoginId;
    @Id
    private String oauthLoginPlatform;

    private LocalDateTime recordTime;
}

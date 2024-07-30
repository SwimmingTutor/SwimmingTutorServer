package kr.sesacjava.swimtutor.routine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "routine_sequence_update")
public class RoutineSequenceUpdate {
    @Id
    private Long id;
    private String oauthLoginId;
    private String oauthLoginPlatform;
    private int currentNo;
}

package kr.sesacjava.swimtutor.routine.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseRoutineDetailDTO {
    // Routine
    private String routineName;
    private int poolLength;
    private int targetDistance;
    private String selStrokes;
    private LocalDateTime created;
    private LocalDateTime updated;

    // ResponseTrainingForRoutine
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routine_id")
    private List<ResponseTrainingForRoutineDTO> responseTrainingForRoutineDTOS;

    @Builder
    public ResponseRoutineDetailDTO(String routineName, int poolLength, int targetDistance, String selStrokes, LocalDateTime created, LocalDateTime updated, List<ResponseTrainingForRoutineDTO> responseTrainingForRoutineDTOS) {
        this.routineName = routineName;
        this.poolLength = poolLength;
        this.targetDistance = targetDistance;
        this.selStrokes = selStrokes;
        this.created = created;
        this.updated = updated;
        this.responseTrainingForRoutineDTOS = responseTrainingForRoutineDTOS;
    }
}
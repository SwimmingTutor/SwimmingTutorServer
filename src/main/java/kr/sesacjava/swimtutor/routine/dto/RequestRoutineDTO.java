package kr.sesacjava.swimtutor.routine.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import kr.sesacjava.swimtutor.routine.entity.id.RoutineId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestRoutineDTO {
    // RoutineId
    @OneToMany(mappedBy = "routine", cascade = CascadeType.ALL, orphanRemoval = true)
    private RoutineId routineId;

    // Routine
    private String routineName;
    private int poolLength;
    private int targetDistance;
    private String selStrokes;
}
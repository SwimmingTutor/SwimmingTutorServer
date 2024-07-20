package kr.sesacjava.swimtutor.routine.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import kr.sesacjava.swimtutor.routine.entity.id.RoutineId;
import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestRoutineDTO {
    // RoutineId
    @OneToMany(mappedBy = "routine", cascade = CascadeType.ALL, orphanRemoval = true)
    private RoutineId routineId;

    private String oauthLoginId;
    private String oauthLoginPlatform;

    // Routine
    private String routineName;
    private Integer poolLength;
    private Integer targetDistance;
    private String selStrokes;
}
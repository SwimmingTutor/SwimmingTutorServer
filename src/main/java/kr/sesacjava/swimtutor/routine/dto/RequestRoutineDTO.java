package kr.sesacjava.swimtutor.routine.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import kr.sesacjava.swimtutor.routine.entity.id.RoutineId;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestRoutineDTO {
    // RoutineId
    @OneToMany(mappedBy = "routine", cascade = CascadeType.ALL, orphanRemoval = true)
    private RoutineId routineId;

    private String oauthLoginId;
    private String oauthLoginPlatform;

    // Routine
    private String routineName;
    private int poolLength;
    private int targetDistance;
    private String selStrokes;

    @Builder
    public RequestRoutineDTO(String oauthLoginId, String oauthLoginPlatform, String routineName, int poolLength, int targetDistance, String selStrokes) {
        this.oauthLoginId = oauthLoginId;
        this.oauthLoginPlatform = oauthLoginPlatform;
        this.routineName = routineName;
        this.poolLength = poolLength;
        this.targetDistance = targetDistance;
        this.selStrokes = selStrokes;
    }
}
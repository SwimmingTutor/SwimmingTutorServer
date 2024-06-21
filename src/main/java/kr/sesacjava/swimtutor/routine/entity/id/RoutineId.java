package kr.sesacjava.swimtutor.routine.entity.id;

import lombok.*;

import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class RoutineId implements Serializable {
    private Integer routineId;
    private String oauthLoginId;
    private String oauthLoginPlatform;

    @Builder
    public RoutineId(Integer routineId, String oauthLoginId, String oauthLoginPlatform) {
        this.routineId = routineId;
        this.oauthLoginId = oauthLoginId;
        this.oauthLoginPlatform = oauthLoginPlatform;
    }
}
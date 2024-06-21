package kr.sesacjava.swimtutor.routine.entity.id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor
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
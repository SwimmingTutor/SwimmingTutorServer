package kr.sesacjava.swimtutor.routine.entity.id;

import lombok.*;

import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class RoutineId implements Serializable {
    private Integer routineNo;
    private String oauthLoginId;
    private String oauthLoginPlatform;

    @Builder
    public RoutineId(Integer routineNo, String oauthLoginId, String oauthLoginPlatform) {
        this.routineNo = routineNo;
        this.oauthLoginId = oauthLoginId;
        this.oauthLoginPlatform = oauthLoginPlatform;
    }
}
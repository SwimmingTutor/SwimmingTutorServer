package kr.sesacjava.swimtutor.users.entity;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsersId implements Serializable {
    private String oauthLoginId;
    private String oauthLoginPlatform;
}

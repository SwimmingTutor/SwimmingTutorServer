package kr.sesacjava.swimtutor.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private String email;
    private String platform;
}

package kr.sesacjava.swimtutor.users.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String oauthLoginId;
    private String oauthLoginPlatform;
    private String name;
    private String gender;
    private LocalDate birth;
    private Float height;
    private Float weight;
    private String preference;
    private String goal;
    private LocalDateTime created;
    private LocalDateTime updated;
}

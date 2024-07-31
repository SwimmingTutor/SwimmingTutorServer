package kr.sesacjava.swimtutor.users.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersExperienceDTO {
    private String preference;
    private String goal;
}

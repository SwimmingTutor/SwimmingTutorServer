package kr.sesacjava.swimtutor.users.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersDTO {

    private String name;
    private String gender;
    private LocalDate birth;
    private Double height;
    private Double weight;
    private String preference;
    private String goal;
}

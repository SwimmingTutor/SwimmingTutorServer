package kr.sesacjava.swimtutor.users.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String gender;

    @NotNull
    private LocalDate birth;

    @Min(100)
    @Max(300)
    private Double height;

    @Min(0)
    @Max(200)
    private Double weight;

    @NotEmpty
    private String preference;

    @NotEmpty
    private String goal;
}

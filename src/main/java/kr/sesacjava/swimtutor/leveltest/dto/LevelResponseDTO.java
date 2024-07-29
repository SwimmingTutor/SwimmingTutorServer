package kr.sesacjava.swimtutor.leveltest.dto;

import lombok.*;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LevelResponseDTO {
    private String lcTrainingName;
    private String userLevel;
}

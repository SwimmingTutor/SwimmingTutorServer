package kr.sesacjava.swimtutor.leveltest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LevelLogResponseDTO {
    private String lcTrainingName;
    private String userLevel;

}

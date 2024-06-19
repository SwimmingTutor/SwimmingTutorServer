package kr.sesacjava.swimtutor.leveltest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LevelLogDTO {
    private String style;
    private Integer speed;
    private Integer distance;
    private Integer technique;
}

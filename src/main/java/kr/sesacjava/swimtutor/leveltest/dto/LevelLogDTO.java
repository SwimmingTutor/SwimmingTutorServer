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

    public String getUserLevel() {
        int total = this.speed + this.distance + this.technique;

        if (total >= 7) return "상급";
        if (total >= 4) return "중급";
        return "초급";
    }
}

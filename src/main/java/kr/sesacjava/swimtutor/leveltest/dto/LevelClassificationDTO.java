package kr.sesacjava.swimtutor.leveltest.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LevelClassificationDTO {

    private String lcTrainingName;
    private String userLevel;
    private String standardName;
    private String content;
//    private LocalDateTime created;
//    private LocalDateTime updated;
}
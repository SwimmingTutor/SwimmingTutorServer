package kr.sesacjava.swimtutor.records.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RecordDTO {

    private LocalDateTime starttime;
    private LocalDateTime stoptime;
    private String oauthLoginId;
    private String oauthLoginPlatform;
    private String category;
    private long value;
    private LocalDateTime created;
    private LocalDateTime updated;
}


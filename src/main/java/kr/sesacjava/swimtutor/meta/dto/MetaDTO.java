package kr.sesacjava.swimtutor.meta.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MetaDTO {

    private String section;
    private String item;
    private String value;
    private String description;
    private LocalDateTime created;
    private LocalDateTime updated;
}

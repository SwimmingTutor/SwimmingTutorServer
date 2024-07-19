package kr.sesacjava.swimtutor.common.meta;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class MetaDTO {
    private String section;
    private String item;
    private String value;
    private String description;
}
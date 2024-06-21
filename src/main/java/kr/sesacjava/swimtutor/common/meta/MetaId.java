package kr.sesacjava.swimtutor.common.meta;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@EqualsAndHashCode
public class MetaId implements Serializable {
    private String section;
    private String item;
    private String value;
}
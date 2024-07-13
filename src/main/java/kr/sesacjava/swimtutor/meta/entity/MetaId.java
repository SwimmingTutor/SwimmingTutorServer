package kr.sesacjava.swimtutor.meta.entity;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class MetaId implements Serializable {
    private String section;
    private String item;
    private String value;
}
package kr.sesacjava.swimtutor.meta.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "meta")
@IdClass(MetaId.class)
@Getter
@ToString
public class Meta {
    @Id
    @Column(name = "section")
    private String section;

    @Id
    @Column(name = "item")
    private String item;

    @Id
    @Column(name = "value")
    private String value;

    @Column(name = "description")
    private String description;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;
}
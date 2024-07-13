package kr.sesacjava.swimtutor.common.meta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "meta")
@IdClass(MetaId.class)
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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

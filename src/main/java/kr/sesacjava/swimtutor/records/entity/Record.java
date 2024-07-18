package kr.sesacjava.swimtutor.records.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "record")
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Record {

    @EmbeddedId
    private RecordId recordId;

    @Column(name = "stoptime", nullable = false)
    private LocalDateTime stoptime;

    @Column(name = "value", nullable = false)
    private Long value;

    @Column(name = "created", nullable = false, updatable = false, insertable = false, columnDefinition = "datetime default current_timestamp")
    private LocalDateTime created;

    @Column(name = "updated", nullable = false, insertable = false, columnDefinition = "datetime default current_timestamp on update current_timestamp")
    private LocalDateTime updated;
}
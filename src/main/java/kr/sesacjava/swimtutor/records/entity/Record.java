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

    @Id
    @Column(name = "starttime", nullable = false)
    private LocalDateTime starttime;

    @Column(name = "stoptime", nullable = false)
    private LocalDateTime stoptime;

    @Column(name = "oauth_login_id", nullable = false)
    private String oauthLoginId;

    @Column(name = "oauth_login_platform", nullable = false)
    private String oauthLoginPlatform;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "value", nullable = false)
    private Long value;

    @Column(name = "created", nullable = false, updatable = false, insertable = false, columnDefinition = "datetime default current_timestamp")
    private LocalDateTime created;

    @Column(name = "updated", nullable = false, insertable = false, columnDefinition = "datetime default current_timestamp on update current_timestamp")
    private LocalDateTime updated;
}

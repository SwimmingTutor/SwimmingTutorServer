package kr.sesacjava.swimtutor.record.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RecordTimeId implements Serializable {
    private String oauthLoginId;
    private String oauthLoginPlatform;
}

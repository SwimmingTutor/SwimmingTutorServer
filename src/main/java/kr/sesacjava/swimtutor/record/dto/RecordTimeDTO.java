package kr.sesacjava.swimtutor.record.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordTimeDTO {
    LocalDateTime recordTime;
}

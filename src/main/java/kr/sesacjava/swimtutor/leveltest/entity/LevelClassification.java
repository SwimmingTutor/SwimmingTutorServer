package kr.sesacjava.swimtutor.leveltest.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class LevelClassification {

    @EmbeddedId
    private oauthAccount id;

    // classification
    private String lcTrainingName;  // 테스트 할 영법명
    private String standardName;    // 레벨 판단 기준명
    private String content;         // 기준별 내용

    public String getLcTrainingName() {
        return lcTrainingName;
    }

    public void setLcTrainingName(String lcTrainingName) {
        this.lcTrainingName = lcTrainingName;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

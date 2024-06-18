package kr.sesacjava.swimtutor.leveltest.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

// 레벨테스트 정보 저장
@Entity
public class LevelLog {

    @EmbeddedId
    private oauthAccount id;

    private int levellogId;         // db에서 자동입력하도록..?
    private String lcTrainingName;
    private String userLevel;

    // Getters and Setters
    public oauthAccount getId() {
        return id;
    }

    public void setId(oauthAccount id) {
        this.id = id;
    }

    public int getLevellogId() {
        return levellogId;
    }

    public void setLevellogId(int levellog_id) {
        this.levellogId = levellog_id;
    }

    public String getLcTrainingName() {
        return lcTrainingName;
    }

    public void setLcTrainingName(String lc_training_name) {
        this.lcTrainingName = lc_training_name;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String user_level) {
        this.userLevel = user_level;
    }
}

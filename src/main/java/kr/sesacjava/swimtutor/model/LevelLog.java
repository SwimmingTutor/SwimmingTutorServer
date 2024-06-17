package kr.sesacjava.swimtutor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// 레벨테스트 정보 저장
@Entity
public class LevelLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int levellogId;                 // level_log_id (PK, Auto Increment)
    private String oauthLoginId;        // oauth_lobin_id
    private String oauthLoginPlatform;        // oauth_login_platform
    private String lcTrainingName;
    private String userLevel;

    // Getters and Setters
    public int getLevellogId() {
        return levellogId;
    }

    public void setLevellogId(int levellog_id) {
        this.levellogId = levellog_id;
    }

    public String getOauthLoginId() {
        return oauthLoginId;
    }

    public void setOauthLoginId(String oauth_login_id) {
        this.oauthLoginId = oauth_login_id;
    }

    public String getOauthLoginPlatform() {
        return oauthLoginPlatform;
    }

    public void setOauthLoginPlatform(String oauth_login_platform) {
        this.oauthLoginPlatform = oauth_login_platform;
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

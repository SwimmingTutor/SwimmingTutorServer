package kr.sesacjava.swimtutor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// 레벨테스트 정보 저장
@Entity
@Table(name = "level_log")
public class LevelLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;                 // level_log_id (PK, Auto Increment)
    private String login_id;        // oauth_lobin_id
    private String platform;        // oauth_login_platform
    private String training_name;
    private int user_level;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginId() {
        return login_id;
    }

    public void setLoginId(String login_id) {
        this.login_id = login_id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getTrainingName() {
        return training_name;
    }

    public void setTrainingName(String training_name) {
        this.training_name = training_name;
    }

    public int getUserLevel() {
        return user_level;
    }

    public void setUserLevel(int user_level) {
        this.user_level = user_level;
    }
}

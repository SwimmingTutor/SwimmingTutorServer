package kr.sesacjava.swimtutor.levelClassification.service;

import kr.sesacjava.swimtutor.levelClassification.entity.LevelClassification;

import java.util.List;

public interface LevelClassificationService {
    List<LevelClassification> findAll();
}

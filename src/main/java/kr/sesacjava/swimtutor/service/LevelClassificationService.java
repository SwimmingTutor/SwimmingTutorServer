package kr.sesacjava.swimtutor.service;

import kr.sesacjava.swimtutor.entity.LevelClassification;

import java.util.List;

public interface LevelClassificationService {
    List<LevelClassification> findAll();
}

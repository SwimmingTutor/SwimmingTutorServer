package kr.sesacjava.swimtutor.service;

import jakarta.transaction.Transactional;
import kr.sesacjava.swimtutor.entity.LevelClassification;
import kr.sesacjava.swimtutor.repository.LevelClassificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class LevelClassificationServiceImpl implements LevelClassificationService {
    // 생성자 주입, autowired랑 비교해서 뭐가 나은 지 모르겠음..
    private final LevelClassificationRepository repository;
    @Override
    public List<LevelClassification> findAll() {
        return repository.findAll();
    }
}

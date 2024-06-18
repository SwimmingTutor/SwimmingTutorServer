package kr.sesacjava.swimtutor.common.meta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MetaService {
    @Autowired
    private MetaRepository metaRepository;

    public Optional<Meta> findBySectionAndItem(String section, String item) {
        return metaRepository.findBySectionAndItem(section, item);
    }
}
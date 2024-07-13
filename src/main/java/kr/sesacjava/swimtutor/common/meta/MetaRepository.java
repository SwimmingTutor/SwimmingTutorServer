package kr.sesacjava.swimtutor.common.meta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MetaRepository extends JpaRepository<Meta, String> {
    Optional<Meta> findBySectionAndItem(String section, String item);
}
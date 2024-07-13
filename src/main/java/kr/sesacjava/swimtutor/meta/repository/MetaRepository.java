package kr.sesacjava.swimtutor.meta.repository;

import kr.sesacjava.swimtutor.meta.entity.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Long> {
}

package kr.sesacjava.swimtutor.repository;

import kr.sesacjava.swimtutor.entity.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Long> {
}

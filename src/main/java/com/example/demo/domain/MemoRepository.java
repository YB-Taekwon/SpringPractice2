package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// JpaRepository는 객체와 테이블 간의 매핑을 담당하는 역할로, 기본적인 CRUD 메서드를 자동으로 제공
public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();
}
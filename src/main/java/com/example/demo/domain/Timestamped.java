package com.example.demo.domain;


import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // 부모 클래스가 DB에 매핑되지 않도록 하는 애너테이션 (자식 클래스인 Memo 클래스만 DB와 매핑될 수 있도록 설정)
@EntityListeners(AuditingEntityListener.class) // 생성 및 변경 시간을 자동으로 업데이트
public class Timestamped {

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
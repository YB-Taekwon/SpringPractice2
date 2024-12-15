package com.example.demo.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본 생성자 생성 애너테이션
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려주는 애너테이션
public class Memo extends Timestamped {
    @Id // 해당 필드가 엔티티의 기본키(Primary Key)임을 나타내는 애너테이션
    @GeneratedValue(strategy = GenerationType.AUTO) // 기본키의 값을 자동으로 생성하는 애너테이션, AUTO_INCREMENT와 비슷한 용도로 사용
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Memo(String username, String contents) {
        this.username = username;
        this.contents = contents;
    }

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }


}

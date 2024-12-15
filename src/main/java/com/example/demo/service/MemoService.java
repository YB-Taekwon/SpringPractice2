package com.example.demo.service;

import com.example.demo.domain.Memo;
import com.example.demo.domain.MemoRepository;
import com.example.demo.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 의존성 주입을 간소화 하는 목적으로 사용, 서비스 클래스에서 필요한 DAO, Repository 등을 생성자 주입 방식으로 자동 주입
@RequiredArgsConstructor // final 필드, @NonNull 필드에 대해 자동으로 생성자를 만들어주는 애너테이션
@Service
public class MemoService {

    private final MemoRepository memoRepository; // RequiredArgsConstructor를 통해 의존성을 주입할 리포지토리

    @Transactional // 트랜잭션을 자동으로 관리해주는 애너테이션
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow( // findById()의 반환 타입이 Optional이기 때문에 메서드 체이닝 방식으로 바로 이어서 orElseThrow() 호출 가능
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }
}
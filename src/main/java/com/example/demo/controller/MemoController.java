package com.example.demo.controller;


import com.example.demo.domain.Memo;
import com.example.demo.domain.MemoRepository;
import com.example.demo.domain.MemoRequestDto;
import com.example.demo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // 의존성 주입을 간소화 하는 목적으로 사용
@RestController
public class MemoController {

    private final MemoRepository memoRepository; // 의존성을 주입할 리포지토리
    private final MemoService memoService; // 의존성을 주입할 서비스

    // 글 작성
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    // 모든 글 조회
    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    // 글 삭제
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }

    // 글 수정
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }
}
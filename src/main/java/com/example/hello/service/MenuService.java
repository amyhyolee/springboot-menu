package com.example.hello.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.hello.domain.menu.MenuRepository;
import com.example.hello.dto.MenuListResponseDto;
import com.example.hello.dto.MenuSaveRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MenuService {
    private final MenuRepository menuRepository;
    
    // 데이터 넣기
    @Transactional
    public Long save(MenuSaveRequestDto requestDto) {
        return menuRepository.save(requestDto.toEntity()).getId();
    }

    // 전체 데이터 불러오기
    @Transactional(readOnly = true)
    public List<MenuListResponseDto> findAll() {
        return menuRepository.findAll().stream()
                .map(MenuListResponseDto::new)
                .collect(Collectors.toList());
    }
}
package com.example.hello.service;

import com.example.hello.domain.menu.MenuRepository;
import com.example.hello.dto.MenuSaveRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MenuService {
    private final MenuRepository menuRepository;
    
    @Transactional
    public Long save(MenuSaveRequestDto requestDto) {
        return menuRepository.save(requestDto.toEntity()).getId();
    }
}
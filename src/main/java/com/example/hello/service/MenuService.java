package com.example.hello.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.example.hello.domain.menu.Menu;
import com.example.hello.domain.menu.MenuRepository;
import com.example.hello.dto.MenuListResponseDto;
import com.example.hello.dto.MenuSaveRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
// import org.springframework.web.bind.annotation.PutMapping;

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

    // 데이터 수정
    @Transactional
    public Long update(Long id, MenuSaveRequestDto requestDto) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("수정할 메뉴가 없다." + id));

        menu.update(requestDto.getMenu());
        return id;
    }

    // 데이터 삭제
    @Transactional
    public void delete(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 id=" + id));

        menuRepository.delete(menu);
    }

    // 전체 데이터를 불러와서 무작위의 값 하나만 리턴
    @Transactional(readOnly = true)
    public MenuListResponseDto findRndOne() {
        List<MenuListResponseDto> list = menuRepository.findAll().stream()
                .map(MenuListResponseDto::new)
                .collect(Collectors.toList());

        Random rnd = new Random();
        MenuListResponseDto dto = list.get(rnd.nextInt(list.size()));
        return dto;
    }
}
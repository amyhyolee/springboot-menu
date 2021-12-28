package com.example.hello.web;

import java.util.List;

import com.example.hello.dto.MenuListResponseDto;
import com.example.hello.dto.MenuSaveRequestDto;
import com.example.hello.service.MenuService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MenuApiController {

   private final MenuService menuService;

   @PostMapping("/api/v1/savemenu")
   public Long save(@RequestBody MenuSaveRequestDto requestDto) {
        // System.out.println(requestDto.getMenu());
       return menuService.save(requestDto);
   }

   @GetMapping("/api/v1/menuall")
   public List<MenuListResponseDto> menuFindAll() {
        // System.out.println(requestDto.getMenu());
       return menuService.findAll();
   }
}

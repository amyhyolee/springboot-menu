package com.example.hello.web;

import com.example.hello.dto.MenuSaveRequestDto;
import com.example.hello.service.MenuService;

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
}

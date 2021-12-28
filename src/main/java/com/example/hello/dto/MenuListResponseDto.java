package com.example.hello.dto;

import com.example.hello.domain.menu.Menu;

import lombok.Getter;

@Getter
public class MenuListResponseDto {
   private Long id;
   private String menu;

   public MenuListResponseDto(Menu entity) {
       this.id = entity.getId();
       this.menu = entity.getMenu();
   }
}
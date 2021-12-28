package com.example.hello.dto;

import com.example.hello.domain.menu.Menu;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuSaveRequestDto {
    private String menu;

    @Builder
    public MenuSaveRequestDto(String menu) {
        this.menu = menu;
    }

    public Menu toEntity() {
        return Menu.builder()
                .menu(menu)
                .build();
    }
}

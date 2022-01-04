package com.example.hello.web;

import java.util.List;

import com.example.hello.dto.MusicInfoDto;
import com.example.hello.dto.PlaylistDto;
import com.example.hello.service.MelonService;
import com.example.hello.service.NaverApiService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class HelloController {
    @PostMapping("/api/v1/senddata")
    public String sendPostData(@RequestParam(value = "data") String data) {
        return "당신이 입력한 데이터는? " + data;
    }

    @GetMapping("/api/v1/sendgetdata")
    public String sendGetData(@RequestParam(value = "data", defaultValue = "없음") String data) {
        return "당신이 입력한 데이터는? " + data;
    }

    private final MelonService melonService;
    @GetMapping("/api/v1/melon")
    public List<MusicInfoDto> melon() {
        return melonService.findMusicList();
    }

    private final NaverApiService naverApiService;
    @GetMapping("/api/v1/news")
    public String news(@RequestParam(value = "data", defaultValue = "없음") String data) {
        System.out.println(data);
        return naverApiService.searchNews(data);
    }

    @GetMapping("/api/v1/playlist")
    public PlaylistDto playlist() {
        PlaylistDto dto = new PlaylistDto();
        dto.setTitle("겨울잠");
        dto.setArtist("아이유");
        dto.setSongLink("https://www.youtube.com/watch?v=FXfvbMEWkhk");
        return dto;
    }

}

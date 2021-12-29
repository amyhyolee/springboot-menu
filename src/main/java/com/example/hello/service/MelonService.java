package com.example.hello.service;

import java.util.List;

import com.example.hello.dto.MusicInfoDto;
import com.example.hello.utils.Melon;

import org.springframework.stereotype.Service;

@Service
public class MelonService {
    public List<MusicInfoDto> findMusicList() {
        return Melon.getMusicList();
    }
}

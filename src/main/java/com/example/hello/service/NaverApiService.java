package com.example.hello.service;

import com.example.hello.utils.NaverAPI;

import org.springframework.stereotype.Service;

@Service
public class NaverApiService {
    public String searchNews(String data) {
        return NaverAPI.searchNews(data);
    }
}


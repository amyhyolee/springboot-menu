package com.example.hello.web;

import com.example.hello.domain.user.UserDetailsImpl;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) { // @ResponseBody - 나오는지 확인 가능
        model.addAttribute("username", userDetails.getUsername());
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/input")
    public String input() {
        return "input";
    }

    // @GetMapping("/menu")
    // public String menu(Model model) {
    //     model. addAttribute("menuname", "고기");
    //     return "menu";
    // }

    @GetMapping("/random")
    public String random() {
        return "random";
    }

    @GetMapping("/sheet")
    public String sheet() {
        return "sheet";
    }

    @GetMapping("/melon")
    public String melon() {
        return "melon";
    }

    @GetMapping("/naverapi")
    public String naverapi() {
        return "naverapi";
    }
    @GetMapping("/playlist")
    public String playlist() {
        return "playlist";
    }
}

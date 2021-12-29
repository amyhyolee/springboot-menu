package com.example.hello.web;

import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() { // @ResponseBody - 나오는지 확인 가능
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
}

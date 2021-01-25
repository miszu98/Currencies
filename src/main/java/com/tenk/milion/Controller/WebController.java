package com.tenk.milion.Controller;

import com.tenk.milion.Services.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private ApiService apiService;

    public WebController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("currencies", apiService.getData());
        return "index";
    }
}

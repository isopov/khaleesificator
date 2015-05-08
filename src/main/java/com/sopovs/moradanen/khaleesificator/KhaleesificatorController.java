package com.sopovs.moradanen.khaleesificator;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class KhaleesificatorController {

    @RequestMapping(method = GET)
    public String index() {
        return "index";
    }

    @RequestMapping(method = POST)
    public String byInput(@RequestParam String input) {
        return "index";
    }

    @RequestMapping(value = "u", method = GET)
    public String byUrl(@PathVariable("url") String url) {
        return "index";
    }

}

package com.sopovs.moradanen.khaleesificator;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class KhaleesificatorController {

    @RequestMapping(method = GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "khaleesificate", method = GET)
    public ModelAndView byInput(@RequestParam String input) {
        Map<String, String> args = new HashMap<>();
        args.put("input", input);
        args.put("text", Khaleesificator.khaleesificate(input));
        return new ModelAndView("khaleesificator", args);
    }

}

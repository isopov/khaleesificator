package com.sopovs.moradanen.khaleesificator;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class KhaleesificatorController {

    @Autowired
    private RecentPhrases recentPhrases;

    @RequestMapping(method = GET)
    public ModelAndView index() {
        return new ModelAndView("index", Collections.singletonMap("recent", recentPhrases.getRecent()));
    }

    @RequestMapping(value = "khaleesificate", method = GET)
    public ModelAndView byInput(@RequestParam String input) {
        recentPhrases.offer(input);
        Map<String, String> args = new HashMap<>();
        args.put("input", input);
        args.put("text", Khaleesificator.khaleesificate(input));
        return new ModelAndView("khaleesificator", args);
    }

}

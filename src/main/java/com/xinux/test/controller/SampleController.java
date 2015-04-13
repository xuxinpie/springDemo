package com.xinux.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/sampleTest")
public class SampleController {

    private static int             counter = 0;
    private final org.slf4j.Logger logger  = org.slf4j.LoggerFactory
                                               .getLogger(UserController.class);

    @RequestMapping(value = "/result")
    public String test() {
        return "passTest";
    }

    @RequestMapping(value = "/welcome")
    public String welcome(ModelMap model) {
        model.addAttribute("message", "Welcome");
        model.addAttribute("counter", ++counter);
        return "welcome";
    }

    @RequestMapping(value = "/login/{name}", method = RequestMethod.GET)
    public String welcomName(@PathVariable String name, ModelMap model) {
        model.addAttribute("message", "Welcome " + name);
        model.addAttribute("counter", ++counter);
        logger.debug("[welcomeName] counter : {}", counter);

        return "welcome";
    }

}

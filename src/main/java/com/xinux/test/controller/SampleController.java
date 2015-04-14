package com.xinux.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/sampleTest")
//SampleController即为一个Handler
public class SampleController {

    private static int             counter = 0;
    private final org.slf4j.Logger logger  = org.slf4j.LoggerFactory
                                               .getLogger(UserController.class);

    //每一个方法为一个HandlerAdapter
    @RequestMapping(value = "/result")
    public String test() {
        return "passTest";
    }

    @RequestMapping(value = "/welcome")
    public String welcome(ModelMap model) {
        model.addAttribute("message", "Welcome");
        model.addAttribute("counter", ++counter);
        return "counter";
    }

    //形如REST风格的地址访问，使用@PathVariable接收rest风格的参数
    @RequestMapping(value = "/login/{name}", method = RequestMethod.GET)
    public String welcomName(@PathVariable String name, ModelMap model) {
        model.addAttribute("message", "Welcome " + name);
        model.addAttribute("counter", ++counter);
        logger.debug("[welcomeName] counter : {}", counter);

        return "counter";
    }

    //支持正则表达式 比如如下的URL：/sometext.123，则输出： 
    //Textual part: sometext, numeric part: 123
    /*@RequestMapping(value="/{textualPart:[a-z-]+}.{numericPart:[\\d]+}")  
    public String regularExpression(  
      @PathVariable String textualPart,  
      @PathVariable String numericPart){  
      
        System.out.println("Textual part: " + textualPart +   
          ", numeric part: " + numericPart);  
        return "someResult";  
    }  */

}

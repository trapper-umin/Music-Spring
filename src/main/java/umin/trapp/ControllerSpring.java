package umin.trapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerSpring {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
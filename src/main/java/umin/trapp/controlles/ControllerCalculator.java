package umin.trapp.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/app")
public class ControllerCalculator {

    @GetMapping("/calculator")
    public String calculator(@RequestParam("first") int first,
                             @RequestParam("second") int second,
                             @RequestParam("action") String action,
                             Model model){
        String username="Vlad";
        model.addAttribute("username",username);

        switch (action){
            case "multiplication" -> model.addAttribute("action",first*second);
            case "addition" -> model.addAttribute("action",first+second);
            case "subtraction" -> model.addAttribute("action",first-second);
            case "division" -> model.addAttribute("action",first/(double)second);
            default -> model.addAttribute("action","Incorrect request");
        }

        return "spring/calculator";
    }
}
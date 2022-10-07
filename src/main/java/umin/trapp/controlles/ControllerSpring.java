package umin.trapp.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/app")
public class ControllerSpring {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request, Model model){
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");

        if(name==null && surname==null){
            model.addAttribute("message","HELLO");
        }else model.addAttribute("message","Hello "+name+" "+surname);

        return "spring/hello";
    }
    @GetMapping("/list")
    public String list(@RequestParam(value = "columns", required = false) String columns, Model model){
        model.addAttribute("info","Number of columns: "+columns);

        return "spring/list";
    }

}
package umin.trapp.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import umin.trapp.dao.WarriorDAO;

@Controller
@RequestMapping("/app/batch")
public class BatchController {

    WarriorDAO warriorDAO;

    @Autowired
    public BatchController(WarriorDAO warriorDAO){
        this.warriorDAO=warriorDAO;
    }

    @GetMapping
    public String index(){

        return "batch/index";
    }

    @PostMapping("/without")
    public String withoutBatch(){

        warriorDAO.withoutBatch();

        return "redirect:/app/warrior";
    }

    @PostMapping("/with")
    public String withBatch(){

        warriorDAO.withBatch();

        return "redirect:/app/warrior";
    }

}

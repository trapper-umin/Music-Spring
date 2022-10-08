package umin.trapp.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import umin.trapp.dao.WarriorDAO;

@Controller
@RequestMapping("/app/warrior")
public class WarriorsController {

    private final WarriorDAO warriorDAO;

    @Autowired
    public WarriorsController(WarriorDAO warriorDAO) {
        this.warriorDAO = warriorDAO;
    }

    @GetMapping
    public String showAll(Model model){

        model.addAttribute("warriors",warriorDAO.showAll());

        return "warriors/array";
    }
    @GetMapping("/{id}")
    public String showViaId(@PathVariable("id") int id,Model model){

        model.addAttribute("warrior",warriorDAO.showViaId(id));

        return "warriors/one";
    }

}

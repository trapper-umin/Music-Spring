package umin.trapp.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import umin.trapp.dao.WarriorDAO;
import umin.trapp.models.Warrior;

@Controller
@RequestMapping("/app/warrior")
public class WarriorsController {

    private final WarriorDAO warriorDAO;

    @Autowired
    public WarriorsController(WarriorDAO warriorDAO) {
        this.warriorDAO = warriorDAO;
    }
    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("warrior",new Warrior());

        return "warriors/create";
    }
    @PostMapping
    public String createSuccess(@ModelAttribute("warrior") Warrior warrior){
        warriorDAO.create(warrior);

        return "redirect:/app/warrior";
    }

    @GetMapping
    public String read(Model model){

        model.addAttribute("warriors",warriorDAO.read());

        return "warriors/read";
    }
    @GetMapping("/{id}")
    public String readId(@PathVariable("id") int id,Model model){

        model.addAttribute("warrior",warriorDAO.readId(id));

        return "warriors/readId";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("warrior",warriorDAO.readId(id));

        return "warriors/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("warrior")Warrior warrior,@PathVariable("id")int id){
        warriorDAO.update(warrior,id);

        return "redirect:/app/warrior/{id}";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id){
        warriorDAO.delete(id);

        return "redirect:/app/warrior";
    }

}

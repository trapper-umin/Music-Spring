package umin.trapp.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import umin.trapp.dao.PictureDAO;
import umin.trapp.models.Picture;

@Controller
@RequestMapping("/app/picture")
public class TestPictureController {

    private final PictureDAO pictureDAO;
    @Autowired
    public TestPictureController(PictureDAO pictureDAO){
        this.pictureDAO=pictureDAO;
    }

    @GetMapping
    public String show(Model model){
        model.addAttribute("pictures",pictureDAO.show());

        return "picture/show";
    }

    @GetMapping("/{id}")
    public String index(@PathVariable("id") int id,Model model){
        model.addAttribute(pictureDAO.index(id));

        return "picture/index";
    }
    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("picture",new Picture());

        return "picture/create";
    }
    @PostMapping()
    public String createPost(@ModelAttribute("picture") Picture picture){
        pictureDAO.create(picture);

        return "redirect:/app/picture";
    }


}

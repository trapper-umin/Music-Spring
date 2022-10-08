package umin.trapp.dao;

import org.springframework.stereotype.Component;
import umin.trapp.models.Warrior;

import java.util.ArrayList;
import java.util.List;

@Component("warriorDAO")
public class WarriorDAO {

    private List<Warrior> warriors;
    private int id;

    {
        warriors=new ArrayList<>();
        warriors.add(new Warrior(0,"Knight"));
        warriors.add(new Warrior(1,"Wizard"));
        warriors.add(new Warrior(2,"Archer"));
    }

    public List<Warrior> showAll(){
        return warriors;
    }
    public Warrior showViaId(int id){
        return warriors.stream().filter(warriors -> warriors.getId() ==id).findAny().orElse(null);
    }

}

package umin.trapp.dao;

import org.springframework.stereotype.Component;
import umin.trapp.models.Warrior;

import java.util.ArrayList;
import java.util.List;

@Component("warriorDAO")
public class WarriorDAO {

    private List<Warrior> warriors;
    private static int id=0;

    {
        warriors=new ArrayList<>();
    }

    public List<Warrior> read(){
        return warriors;
    }
    public Warrior readId(int id){
        return warriors.stream().filter(warriors -> warriors.getId() ==id).findAny().orElse(null);
    }
    public void create(Warrior warrior){
        warrior.setId(id++);
        warriors.add(warrior);
    }
    public void update(Warrior warrior,int id){
        warriors.get(id).setName(warrior.getName());
    }
    public void delete(int id){
        warriors.removeIf(warrior -> warrior.getId()==id);
    }
}

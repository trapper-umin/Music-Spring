package umin.trapp.models;

import lombok.Getter;
import lombok.Setter;

public class Warrior {
    @Setter@Getter
    private int id;
    @Setter@Getter
    private String name;

    public Warrior(int id,String name){
        this.id=id;
        this.name=name;
    }
    public Warrior(){}

}

package umin.trapp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Warrior implements WarriorInterface{

    private int healthPoint;
    private int damage;
    private String type;

    private void init(){}
    private void destroy(){}
    public void doSkill(){
        System.out.println(type+" USED SUPER SKILL");
    }
}

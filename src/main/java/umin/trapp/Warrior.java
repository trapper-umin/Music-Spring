package umin.trapp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Warrior implements WarriorInterface{

    private int healthPoint;
    private int damage;
    private String type;

    public Warrior(int healthPoint,int damage,String type){
        this.healthPoint=healthPoint;
        this.damage=damage;
        this.type=type;
    }
    public Warrior(){}
    public void doSkill(){
        System.out.println(type+" USED SUPER SKILL");
    }
}

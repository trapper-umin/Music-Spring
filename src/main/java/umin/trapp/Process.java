package umin.trapp;

import lombok.Setter;
import java.util.List;

public class Process {
    @Setter
    private List<Warrior> warriors;

    public Process(List<Warrior> warriors){
        this.warriors=warriors;
    }
    public Process(){}

    public void getInfoAboutWarriorsCollection(){
        for (Warrior warrior : warriors) {
            System.out.printf("Name: %s\nHP: %d\nDamage: %d\n\n", warrior.getType(), warrior.getHealthPoint(), warrior.getDamage());
        }
    }
}
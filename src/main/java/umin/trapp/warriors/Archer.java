package umin.trapp.warriors;

import umin.trapp.Warrior;

public class Archer extends Warrior {

    private void init(){
        System.out.println("Archer ready to war!");
    }
    private void destroy(){
        System.out.println("Archer die!");
    }
    public Archer(int healthPoint, int damage, String type) {
        super(healthPoint, damage, type);
    }
    public Archer(){}
}
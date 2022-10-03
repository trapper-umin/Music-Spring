package umin.trapp.warriors;

import umin.trapp.Warrior;

public class Archer extends Warrior {
    private Archer(){}
    public static Warrior factory(){
        return new Archer();
    }

    private void init(){
        System.out.println("Archer ready to war!");
    }
    private void destroy(){
        System.out.println("Archer die!");
    }
}
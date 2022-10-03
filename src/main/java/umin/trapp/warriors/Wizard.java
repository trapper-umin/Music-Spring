package umin.trapp.warriors;

import umin.trapp.Warrior;

public class Wizard extends Warrior {

    private void init(){
        System.out.println("Wizard ready to war!");
    }
    private void destroy(){
        System.out.println("Wizard die!");
    }
    public Wizard(int healthPoint,int damage, String type){
        super(healthPoint,damage,type);
    }
    public Wizard(){}
}
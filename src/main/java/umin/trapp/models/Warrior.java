package umin.trapp.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Warrior {
    @Setter@Getter
    private int id;
    @Setter@Getter
    @NotEmpty(message="Name should not be empty")
    @Size(min = 2,max = 30,message = "Name should be between 2 and 30 characters")
    private String name;

    @Setter@Getter
    @Min(value = 1,message = "HP should be greater then 0")
    private int healthPoint;

    @Setter@Getter
    @NotEmpty(message="Weapon should not be empty")
    private String weapon;

    public Warrior(int id,String name,int healthPoint,String weapon){
        this.id=id;
        this.name=name;
        this.healthPoint=healthPoint;
        this.weapon=weapon;
    }
    public Warrior(int id,String name){
        this.id=id;
        this.name=name;
    }
    public Warrior(){}

}

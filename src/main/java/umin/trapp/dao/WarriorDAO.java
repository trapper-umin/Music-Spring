package umin.trapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import umin.trapp.models.Warrior;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component("warriorDAO")
public class WarriorDAO {
    private static int id=2;
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public WarriorDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    public List<Warrior> read(){
        return jdbcTemplate.query("SELECT * FROM Warrior", new BeanPropertyRowMapper<>(Warrior.class));
    }
    public Warrior readId(int id){
        return jdbcTemplate.query("SELECT * FROM Warrior WHERE id=?",new Object[]{id},new BeanPropertyRowMapper<>(Warrior.class)).stream().findAny().orElse(null);
    }
    public void create(Warrior warrior){
        jdbcTemplate.update("INSERT INTO Warrior VALUES (?,?,?,?)",id++,warrior.getName(),warrior.getHealthPoint(),warrior.getWeapon());
    }
    public void update(Warrior warrior,int id){
        jdbcTemplate.update("UPDATE Warrior SET name=?,healthPoint=?,weapon=? WHERE id=?",warrior.getName(),warrior.getHealthPoint(),warrior.getWeapon(),id);
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Warrior WHERE id=?",id);
    }
}
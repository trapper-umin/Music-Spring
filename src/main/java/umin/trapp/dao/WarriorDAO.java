package umin.trapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import umin.trapp.models.Warrior;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public void deleteAll(){
        jdbcTemplate.update("DELETE FROM warrior WHERE id>-1");
    }

    ///////////////////////////
    ///Testing speed batch update
    //////////////////////////

    public void withoutBatch(){
     List<Warrior> warriors=new ArrayList<>();
     warriors=create1000Objects();

     long before=System.currentTimeMillis();

     for (int i=0;i<warriors.size();i++){
         jdbcTemplate.update("INSERT INTO warrior(id,name,healthPoint,weapon) VALUES (?,?,?,?)",
                 warriors.get(i).getId(),
                 warriors.get(i).getName(),
                 warriors.get(i).getHealthPoint(),
                 warriors.get(i).getWeapon());
     }

     long after=System.currentTimeMillis();

     System.out.println("Times without Batch: "+((after-before)/60));
    }

    public void withBatch(){
        List<Warrior> warriors;
        warriors=create1000Objects();

        long before=System.currentTimeMillis();

        jdbcTemplate.batchUpdate("INSERT INTO warrior(id,name,healthPoint,weapon) VALUES (?,?,?,?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1,warriors.get(i).getId());
                ps.setString(2,warriors.get(i).getName());
                ps.setInt(3,warriors.get(i).getHealthPoint());
                ps.setString(4,warriors.get(i).getWeapon());
            }

            @Override
            public int getBatchSize() {
                return warriors.size();
            }
        });

        long after=System.currentTimeMillis();

        System.out.println("Times with Batch: "+(after-before));
    }

    public List<Warrior> create1000Objects(){
        List<Warrior> warriors=new ArrayList<>();
        for(int i=0;i<1000;i++){
            warriors.add(new Warrior(i,"Name "+i,i*10,"Weapon "+i));
        }
        return warriors;

    }
}
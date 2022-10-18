package umin.trapp.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import umin.trapp.models.Picture;

import java.util.List;

@Component
public class PictureDAO {

    private final JdbcTemplate jdbcTemplate;

    public PictureDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    public List<Picture> show(){
        return jdbcTemplate.query("SELECT * FROM picture",new BeanPropertyRowMapper<>(Picture.class));
    }
    public Picture index(int id){
        return jdbcTemplate.query("SELECT * FROM picture WHERE id=?",new Object[]{id},new BeanPropertyRowMapper<>(Picture.class))
                .stream().findAny().orElse(null);
    }

    public void create(Picture picture){
        jdbcTemplate.update("INSERT INTO picture(url) VALUES (?)",picture.getUrl());
    }

}

package umin.trapp;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("umin.trapp")
@PropertySource("classpath:MusicPlayer.properties")
public class SpringConfiguration {
}

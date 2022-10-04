package jkms.jakomas.springcourse;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("jkms.jakomas.springcourse") нам больше не нужно сканировать отдельную директорию для создания Bean-ов,
// вместо этого, мы явно указываем все необходимые Bean-ы в этом конфигурационном файле.
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
/*    @Bean
    public MusicGenre musicGenre() {
        return new MusicGenre();
    }*/
    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }
    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }
    @Bean
    public PopMusic popMusic() {
        return new PopMusic();
    }
    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(classicalMusic(), rockMusic(), popMusic());
    }
    @Bean
    public Computer computer() {
        return new Computer(musicPlayer());
    }

}

package jkms.jakomas.springcourse;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;


public class ClassicalMusic implements Music {
    private final String genreName = "ClassicalMusic";
    private final List<String> listSongs = new ArrayList<>();
    // инициализировать private лист песен
    {
        listSongs.add("Classic #1");
        listSongs.add("Classic #2");
        listSongs.add("Classic #3");
    }

    // реализация интерфейса
    @Override
    public String getSong() {return "Classic music #0";}
    @Override
    public List<String> getListSongs() {return listSongs;}
    @Override
    public String getGenreName() {return genreName;}

    // Оба метода не принимают аргументы!
    // при создании Bean класса вызвать метод
    @PostConstruct
    public void doMyInit() {
        System.out.println("Do my Init (classicalMusic).");
    }
    // при завершении работы приложения уничтожить класс (освободить память)
    @PreDestroy
    public void doMyDestroy() {
        System.out.println("Do my Destroy.");
    }
}

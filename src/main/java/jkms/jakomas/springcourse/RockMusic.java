package jkms.jakomas.springcourse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;


public class RockMusic implements Music {
    private final String genreName = "RockMusic";
    private final List<String> listSongs = new ArrayList<>();
    // инициализировать private лист песен
    {
        listSongs.add("Rock #1");
        listSongs.add("Rock #2");
        listSongs.add("Rock #3");
    }

    // реализация интерфейса
    public String getSong() {
        return "Rock music #0";
    }
    public List<String> getListSongs() {
        return listSongs;
    }
    @Override
    public String getGenreName() {
        return genreName;
    }

    // Оба метода не принимают аргументы!
    // при создании Bean класса вызвать метод
    @PostConstruct
    public void doMyInit() {
        System.out.println("Do my Init (rockMusic).");
    }
    // при завершении работы приложения уничтожить класс (освободить память)
    @PreDestroy
    public void doMyDestroy() {
        System.out.println("Do my Destroy.");
    }
}
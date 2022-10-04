package jkms.jakomas.springcourse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;


public class PopMusic implements Music{
    private final String genreName = "PopMusic";

    private final List<String> listSongs = new ArrayList<>();
    // инициализировать private лист песен
    {
        listSongs.add("Pop music #1");
        listSongs.add("Pop music #2");
        listSongs.add("Pop music #3");
    }

    // реализация интерфейса
    public String getSong() {
        return "Pop music #0";
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
        System.out.println("Do my Init (popMusic).");
    }
    // при завершении работы приложения уничтожить класс (освободить память)
    @PreDestroy
    public void doMyDestroy() {
        System.out.println("Do my Destroy.");
    }
}

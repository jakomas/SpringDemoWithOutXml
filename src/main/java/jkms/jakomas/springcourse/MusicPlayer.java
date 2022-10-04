package jkms.jakomas.springcourse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Locale;


public class MusicPlayer {
    // Spring установит значения для этих полей из файла musicPlayer.properties
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private String volume;

    // музыка для конструктора (нужно от этого избавиться)
    private final Music music1;
    private final Music music2;
    private final Music music3;

    // хеш мап с жанрами
    HashMap<MusicGenre, Music> genreSounds = new HashMap<>();

    // конструктор, @Qualifier - уточнение

    public MusicPlayer(
        @Qualifier("classicalMusic") Music music1,
        @Qualifier("rockMusic") Music music2,
        @Qualifier("popMusic") Music music3)
    {
        this.music1 = music1;
        this.music2 = music2;
        this.music3 = music3;

        // инициализация хеш мап при создании объекта
        {
            genreSounds.put(MusicGenre.CLASSICAL, music1);
            genreSounds.put(MusicGenre.ROCK, music2);
            genreSounds.put(MusicGenre.POP, music3);
        }
    }



    // методы "воспроизведения" музыки
    // воспроизвести все по одному стандартному треку #0 из каждого жанра
    public String playMusic() {
        return "Playing: "
                + music1.getSong() + ", "
                + music2.getSong() + ", "
                + music3.getSong();
    }
    // просмотреть доступные жанры в плеере
    public void showAllGenre() {
        System.out.println("Список загруженных жанров:");
        System.out.println(music1.getGenreName() + ", " + music2.getGenreName() + ", " + music3.getGenreName());
    }

    // все треки одного жанра, сокращение дальнейшего кода
    public void forEachGenre(MusicGenre genre) {
        System.out.println("Жанр: " + genreSounds.get(genre).getGenreName());
        System.out.println("Треки: ");
        for(String s : genreSounds.get(genre).getListSongs()) {
            System.out.println(s);
        }
    }


    // воспроизвести все треки одного жанра
    public void playAllSongsOfTheOneGenre(MusicGenre musicGenre) {
/*        return "Playing: "
                + music1.getListSongs();*/
        switch (musicGenre) {
            case CLASSICAL, POP, ROCK ->
                forEachGenre(musicGenre);
        }
    }


    // для name
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    // для volume
    public String getVolume() {return "Volume: " + volume;}
    public void setVolume(String volume) {this.volume = volume;}


}

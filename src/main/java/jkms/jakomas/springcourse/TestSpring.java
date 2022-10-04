package jkms.jakomas.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);

/*      MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        // Вывести в консоль название плеера громкость
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());*/

        // создадим ПК, в его конструкторе должен быть плеер
        Computer computer = context.getBean("computer", Computer.class);
        // получим его id и имя плеера в нём
        System.out.println("ПК " + computer.getId());
        System.out.println(computer.getMusicPlayer().getName());

        // Вывести в консоль все доступные жанры в плеере
        computer.getMusicPlayer().showAllGenre();

        // вывести в консоль все треки одного жанра через плеер
        computer.getMusicPlayer().playAllSongsOfTheOneGenre(MusicGenre.ROCK);






    }
}

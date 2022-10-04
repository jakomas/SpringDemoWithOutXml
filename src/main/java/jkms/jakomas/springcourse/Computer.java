package jkms.jakomas.springcourse;

public class Computer {

    private String id;
    private MusicPlayer musicPlayer;


    public Computer(MusicPlayer musicPlayer) {
        this.id = "1";
        this.musicPlayer = musicPlayer;
    }

    public String getId() {
        return "id: " + id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public MusicPlayer getMusicPlayer() {
        return this.musicPlayer;
    }
}

package jkms.jakomas.springcourse;

import org.springframework.stereotype.Component;

import java.util.List;

public interface Music {
    String getSong();
    //int getVolume();
    List<String> getListSongs();
    String getGenreName();
}

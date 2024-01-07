package com.core.strings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * performs reading a file content and analysing with StringTokenizer
 *
 * @author Srinath.Rayabarapu
 */
public class JukeBoxListMain {

    List<Song> songList = new ArrayList<>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        new JukeBoxListMain().go();
    }

    private class ArtistCompare implements Comparator<Song> {
        public int compare(Song o1, Song o2) {
            return o1.getArtist().compareTo(o2.getArtist());
        }
    }

    ArtistCompare artistCompare = new ArtistCompare();

    private class TitleCompare implements Comparator<Song> {
        public int compare(Song o1, Song o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    TitleCompare titleCompare = new TitleCompare();

    private void go() {
        getSongs();
        System.out.println("Before sort : " + songList);

        // with Comparable I
        Collections.sort(songList);

        // with Comparator I
        Collections.sort(songList, artistCompare);
        Collections.sort(songList, titleCompare);

        System.out.println("After sort : " + songList);
    }

    private void getSongs() {

        File file = new File("JukeBox.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                addSong(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // complaint no : 107508907
    private void addSong(String line) {
        String[] strings = line.split("/");
        Song newSong = new Song(strings[0], strings[1], strings[2], strings[3]);
        songList.add(newSong);
    }

}

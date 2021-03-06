import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String songTitle, double songDuration) {
        if (findSong(songTitle) == null) {
            return songs.add(new Song(songTitle, songDuration));
        }
        return false;
    }

    private Song findSong(String songTitle) {
        for (Song song : songs) {
            if (song.getTitle().equals(songTitle)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index < songs.size())) {
            return playList.add(songs.get(index));
        }
        return false;
    }

    public boolean addToPlayList(String trackName, LinkedList<Song> playList) {
        Song song = findSong(trackName);
        if (song != null) {
            return playList.add(song);
        }
        return false;
    }

}
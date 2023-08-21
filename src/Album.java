import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String artist;
    private String name;
    private List<Song> songs;

    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs = new ArrayList<>();
    }
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    //check song present or not
    public boolean findSong(String name)
    {
        for(Song song : songs)
        {
            if(!song.getTitle().equals(name))
            {
                return false;
            }
        }
        return false;
    }
    //add song
    public String addSongToAlbum(String title,double duration)
    {
        if(!findSong(title))
        {
            Song song = new Song(title,duration);
            this.songs.add(song);
            return "Song Added to playList";
        }
        return "Song Alredy Exist";
    }
    public String addSongToPlayListFromAlbum(String title, LinkedList<Song> playList)
    {
        for(Song song : this.songs)
        {
            if(song.getTitle().equals(title))
            {
                playList.add(song);
                return "Song Add To Your PlayList";
            }
        }
        return "Song Does Not Exit into The Album";
    }

    /**
     * polymorphism method overloading
     * @param songNo
     * @param playList
     * @return
     */
    public String addSongToPlayListFromAlbum(int songNo, LinkedList<Song> playList)
    {
        int index = songNo - 1;
        if(index >= 0 && index < songs.size())
        {
            playList.add(songs.get(index));
            return "Song Added Successfully To PlayList";
        }
        return "Song No Is Incorrect";
    }
}

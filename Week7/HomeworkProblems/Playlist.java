public class Playlist {
    private String[] songs;
    private int songCount;
    private final int maxSongs;

    public Playlist(int maxSongs) {
        this.maxSongs = maxSongs;
        songs = new String[maxSongs];
        songCount = 0;
    }

    public void addSong(String song) {
        if (song != null && songCount < maxSongs) {
            songs[songCount] = song;
            songCount++;
        } else {
            System.out.println("Playlist is full or song is invalid.");
        }
    }

    public String[] getSongs() {
        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist(3);

        playlist.addSong("Perfect");
        playlist.addSong("Believer");
        playlist.addSong("Memories");

        System.out.println("Songs in playlist:");

        for (String song : playlist.getSongs()) {
            System.out.println(song);
        }

        System.out.println("Total songs: " + playlist.getSongCount());
    }
}
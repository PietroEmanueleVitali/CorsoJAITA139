package model;

// song
// id, album_id, name, duration
public class Song extends Entity{

    private Long album_id;
    private String name;
    private double duration;

    public Song(){}

    public Song(Long id, Long album_id, String name, double duration) {
        super(id);
        this.album_id = album_id;
        this.name = name;
        this.duration = duration;
    }
    
    public Long getAlbum_id() {
        return album_id;
    }
    public void setAlbum_id(Long album_id) {
        this.album_id = album_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song [id=" + id + ", album_id=" + album_id + ", name=" + name + ", duration=" + duration + "]";
    }

    


}

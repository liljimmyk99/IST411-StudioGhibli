/**
 * Movie
 */
public class Movie {

    private String title;
    private String description;
    private String movieID;
    private String releaseDate;
    private String producer;

    public Movie(String title, String description, String movieID, String releaseDate, String producer) {
        this.title = title;
        this.description = description;
        this.movieID = movieID;
        this.releaseDate = releaseDate;
        this.producer = producer;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getMovieID() {
        return movieID;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public String getProducer() {
        return producer;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }
    public void printFullInfo(){
        System.out.println("Title: " + getTitle() + " \nDescription: " + getDescription() + " \nRelease Date: " + getReleaseDate() + " \nProducer: " + getProducer());
    }

}
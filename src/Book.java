public class Book extends LibraryItem {
    private String genre;

    public Book(String title, String author, boolean availability, String genre) {
        super(title, author, availability, LibraryCategory.BOOK);
        this.genre = genre;
    }
    //Setters and getters
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    @Override
    public String toString() {
        return super.toString() + ", Genre: " + genre;
    }
}
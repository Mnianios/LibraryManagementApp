public class AudioBook extends LibraryItem {
    private double duration;

    public AudioBook(String title, String author, boolean availability, double duration) {
        super(title, author, availability, LibraryCategory.AUDIOBOOK);
        this.duration = duration;
    }
    //Setters and getters
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }
    @Override
    public String toString() {
        return super.toString() + ", Duration: " + duration + " hours";
    }
}
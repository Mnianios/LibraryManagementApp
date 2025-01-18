import java.io.Serializable;

public class LibraryItem implements Serializable {
    private static int idCounter = 1000;
    private String title;
    private String author;
    private String ID;
    private boolean availability;
    private int borrowCount;
    private LibraryCategory category;

    // Constructor
    public LibraryItem(String title, String author, boolean availability, LibraryCategory category) {
        this.title = title;
        this.author = author;
        this.ID = "#" + idCounter++;
        this.availability = availability;
        this.category = category;
        this.borrowCount = 0;
    }
    //Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    //Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getID() { return ID; }
    public boolean isAvailable() { return availability; }
    public int getBorrowCount() { return borrowCount; }
    public LibraryCategory getCategory() { return category; }

    public void borrowItem() {
        if (availability) {
            availability = false;
            System.out.println("Item successfully borrowed!");
            borrowCount++;

        } else {
            System.out.println("Item is already borrowed.");
        }
    }

    public void returnItem() {
        availability = true;
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", Title: " + title + ", Author: " + author +
                ", Category: " + category + ", Available: " + (availability ? "Yes" : "No") +
                ", Borrowed: " + borrowCount + " times";
    }
}
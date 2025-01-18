
import java.util.*;
import java.util.stream.Collectors;

public class LibraryManager {
    private HashMap<String, LibraryItem> libraryItems = new HashMap<>();

    public void addLibraryItem(LibraryItem item) {
        libraryItems.put(item.getID(), item);
    }

    public void borrowItem(String itemID) {
        LibraryItem item = libraryItems.get(itemID);
        if (item != null) {
            item.borrowItem();
        } else {
            System.out.println("Item not found.");
        }
    }

    public void returnItem(String itemID) {
        LibraryItem item = libraryItems.get(itemID);
        if (item != null) {
            item.returnItem();
        } else {
            System.out.println("Item not found.");
        }
    }

    public void displayItems() {
        libraryItems.values().forEach(System.out::println);
    }

    public LibraryItem getMostBorrowedItem() {
        return libraryItems.values().stream()
                .max(Comparator.comparingInt(LibraryItem::getBorrowCount))
                .orElse(null);
    }
    public Collection<LibraryItem> getLibraryItems() {
        return libraryItems.values(); // Return a collection of all library items
    }
    public void displayAvailableItems() {
        libraryItems.values().stream()
                .filter(LibraryItem::isAvailable)
                .forEach(System.out::println);
    }
}
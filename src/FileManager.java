import java.io.*;
import java.util.HashMap;

public class FileManager {
    public static void saveData(HashMap<String, LibraryItem> libraryItems, String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(libraryItems);
        }
    }

    public static HashMap<String, LibraryItem> loadData(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (HashMap<String, LibraryItem>) in.readObject();
        }
    }
}
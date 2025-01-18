import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage implements ActionListener {
    JFrame frame = new JFrame("Library Management System");
    JLabel welcomeLabel = new JLabel("Welcome to the Library System");
    JButton viewItemsButton = new JButton("View Items");
    JButton borrowItemButton = new JButton("Borrow Item");
    JButton returnItemButton = new JButton("Return Item");
    JButton mostBorrowedButton = new JButton("Most Borrowed Item");
    JButton logoutButton = new JButton("Logout");

    LibraryManager libraryManager = new LibraryManager();

    public WelcomePage(String userID) {
        // Frame setup
        frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Label
        welcomeLabel.setBounds(50, 50, 300, 35);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(welcomeLabel);

        // Buttons
        viewItemsButton.setBounds(50, 100, 300, 25);
        borrowItemButton.setBounds(50, 150, 300, 25);
        returnItemButton.setBounds(50, 200, 300, 25);
        mostBorrowedButton.setBounds(50, 250, 300, 25);
        logoutButton.setBounds(50, 300, 300, 25);

        frame.add(viewItemsButton);
        frame.add(borrowItemButton);
        frame.add(returnItemButton);
        frame.add(mostBorrowedButton);
        frame.add(logoutButton);

        viewItemsButton.addActionListener(this);
        borrowItemButton.addActionListener(this);
        returnItemButton.addActionListener(this);
        mostBorrowedButton.addActionListener(this);
        logoutButton.addActionListener(this);

        // Initialize some items in the library
        libraryManager.addLibraryItem(new Book("1984", "George Orwell", true, "Dystopian"));
        libraryManager.addLibraryItem(new Book("To Kill a Mockingbird", "Harper Lee", true, "Classic"));
        libraryManager.addLibraryItem(new Book("A Song of Ice and Fire: A Storm of Swords", "George R.R. Martin", true, "Fantasy"));
        libraryManager.addLibraryItem(new AudioBook("Sapiens", "Yuval Noah Harari", true, 15.5));
        libraryManager.addLibraryItem(new Magazine("Proto Thema", "Multiple authors", true, 43));
        libraryManager.addLibraryItem(new AudioBook("Meditations", "Marcus Aurelius", true, 6.30));

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewItemsButton) {
            showViewItemsWindow();
        } else if (e.getSource() == borrowItemButton) {
            String itemID = JOptionPane.showInputDialog("Enter Item ID to Borrow:");
            libraryManager.borrowItem(itemID);
        } else if (e.getSource() == returnItemButton) {
            String itemID = JOptionPane.showInputDialog("Enter Item ID to Return:");
            libraryManager.returnItem(itemID);
        } else if (e.getSource() == mostBorrowedButton) {
            LibraryItem mostBorrowed = libraryManager.getMostBorrowedItem();
            if (mostBorrowed != null) {
                JOptionPane.showMessageDialog(frame, "Most Borrowed Item:\n" + mostBorrowed.toString());
            } else {
                JOptionPane.showMessageDialog(frame, "No items have been borrowed yet.");
            }
        } else if (e.getSource() == logoutButton) {
            frame.dispose();
            new LoginPage(new IDandPasswords().getLoginInfo());
        }
    }


    public void showViewItemsWindow() {
        // Create a new JFrame window to display the items
        JFrame viewItemsFrame = new JFrame("Library Items");
        viewItemsFrame.setSize(500, 400);
        viewItemsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);


        for (LibraryItem item : libraryManager.getLibraryItems()) {
            textArea.append(item.toString() + "\n\n");
        }


        JScrollPane scrollPane = new JScrollPane(textArea);
        viewItemsFrame.add(scrollPane);


        viewItemsFrame.setVisible(true);
    }
}
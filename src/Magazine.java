public class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String title, String author, boolean availability, int issueNumber) {
        super(title, author, availability, LibraryCategory.MAGAZINE);
        this.issueNumber = issueNumber;
    }
    //Setters and getters
    public int getIssueNumber() {
        return issueNumber;
    }
    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }
    @Override
    public String toString() {
        return super.toString() + ", Issue Number: " + issueNumber;
    }
}
package com.pluralsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;
    private int availableIn;

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo, int availableIn) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
        this.availableIn = availableIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public int getAvailableIn() {
        return availableIn;
    }

    public void setAvailableIn(int borrowLimit) {
        this.availableIn = borrowLimit;
    }

    public void checkOut(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
        isCheckedOut = true;
        availableIn = 14;
    }

    public void checkIn() {
        checkedOutTo = "";
        isCheckedOut = false;
        availableIn = 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                ", checkedOutTo=" + checkedOutTo +
                ", availableIn=" + availableIn +
                '}';
    }
}

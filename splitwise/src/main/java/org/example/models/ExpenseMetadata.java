package org.example.models;

public class ExpenseMetadata {
    private String name;
    private String notes;
    private String image;

    public ExpenseMetadata(String name, String notes, String image) {
        this.name = name;
        this.notes = notes;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

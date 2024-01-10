package com.example.miniprojet;

public class item {
    // Member variables
    String name;
    int img;

    // Constructor with all arguments
    public item(String name, int img) {
        this.name = name;
        this.img = img;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for img
    public int getImg() {
        return img;
    }
}

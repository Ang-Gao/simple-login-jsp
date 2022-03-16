package com.annotation_demo;

public class Apple {
    @FruitName(name = "apple007")
    String name;

    @FruitColor(fruitColor = FruitColor.Color.GREEN)
    FruitColor.Color color;

    @FruitProvider(name = "富士康")
    String nameProvider;

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", nameProvider=" + nameProvider +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FruitColor.Color getColor() {
        return color;
    }

    public void setColor(FruitColor.Color color) {
        this.color = color;
    }

    public String getNameProvider() {
        return nameProvider;
    }

    public void setNameProvider(String nameProvider) {
        this.nameProvider = nameProvider;
    }
}

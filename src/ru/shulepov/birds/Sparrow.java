package ru.shulepov.birds;

/**
 * Воробей - умеет петь "чырык"
 */
public class Sparrow extends Bird {

    public Sparrow(String name, int age, String color) {
        super(name, age, color);
    }

    @Override
    public void sing() {
        System.out.println("чырык");
    }

    @Override
    public String toString() {
        return "Sparrow{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
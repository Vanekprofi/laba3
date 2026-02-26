package ru.shulepov.birds;

/**
 * Абстрактный класс Птица - корень иерархии
 */
public abstract class Bird {
    protected String name;
    protected int age;
    protected String color;

    public Bird(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public abstract void sing();

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
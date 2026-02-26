package ru.shulepov.birds;
import java.util.Random;

/**
 * Попугай - имеет текст и поет первые N символов (случайное N)
 */
public class Parrot extends Bird {
    private String text;
    private static final Random random = new Random();

    public Parrot(String name, int age, String color, String text) {
        super(name, age, color);
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст попугая не может быть пустым");
        }
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст не может быть пустым");
        }
        this.text = text;
    }

    @Override
    public void sing() {
        int n = random.nextInt(text.length()) + 1;
        System.out.println(text.substring(0, n));
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
package ru.shulepov.birds;
import java.util.Random;

/**
 * Кукушка - поет "ку-ку" случайное количество раз (1-10)
 */
public class Cuckoo extends Bird {
    private static final Random random = new Random();

    public Cuckoo(String name, int age, String color) {
        super(name, age, color);
    }

    @Override
    public void sing() {
        int times = random.nextInt(10) + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append("ку-ку");
            if (i < times - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        return "Cuckoo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
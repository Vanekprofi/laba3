package ru.shulepov.main;

import ru.shulepov.birds.*;
import ru.shulepov.cities.*;
import ru.shulepov.geometry.Point3D;
import ru.shulepov.graph.Graph;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

/**
 * Главный класс программы
 * Демонстрирует работу всех классов
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== ЛАБОРАТОРНАЯ РАБОТА ===\n");

        task1Roads();
        task2Route();
        task3Bidirectional();
        task4Birds();
        task5Graph();
        task6CompareCities();
        task7Power(args);
        task8ClonePoint();

        System.out.println("\n=== ВСЕ ЗАДАНИЯ ВЫПОЛНЕНЫ ===");
    }

    private static void task1Roads() {
        System.out.println("=== ЗАДАНИЕ 1: ДОРОГИ ===");

        City moscow = new City("Москва");
        City spb = new City("Санкт-Петербург");
        City kazan = new City("Казань");

        moscow.addRoad(spb);
        moscow.addRoad(kazan);
        spb.addRoad(kazan);

        System.out.println(moscow);
        System.out.println(spb);
        System.out.println(kazan);

        System.out.println("\nУдаляем дорогу Москва -> Казань");
        moscow.removeRoad(kazan);
        System.out.println(moscow);

        System.out.println();
    }

    private static void task2Route() {
        System.out.println("=== ЗАДАНИЕ 2: МАРШРУТ ===");

        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");

        A.addRoad(B);
        A.addRoad(C);
        B.addRoad(D);
        C.addRoad(D);
        D.addRoad(E);
        F.addRoad(A);
        F.addRoad(C);

        Route route = new Route(F, D);
        System.out.println("\nМаршрут из F в D:");
        System.out.println(route);

        System.out.println();
    }

    private static void task3Bidirectional() {
        System.out.println("=== ЗАДАНИЕ 3: ДВУСТОРОННЯЯ ДОРОГА ===");

        BidirectionalCity city1 = new BidirectionalCity("Город1");
        BidirectionalCity city2 = new BidirectionalCity("Город2");

        System.out.println("До добавления дороги:");
        System.out.println(city1);
        System.out.println(city2);

        System.out.println("\nДобавляем дорогу Город1 -> Город2");
        city1.addRoad(city2);

        System.out.println("После добавления:");
        System.out.println(city1);
        System.out.println(city2);

        System.out.println();
    }

    private static void task4Birds() {
        System.out.println("=== ЗАДАНИЕ 4: ПТИЦЫ ===");

        Bird sparrow = new Sparrow("Чик", 2, "коричневый");
        System.out.println(sparrow);
        System.out.print("Пение: ");
        sparrow.sing();

        Bird cuckoo = new Cuckoo("Кука", 5, "серый");
        System.out.println("\n" + cuckoo);
        System.out.print("Пение: ");
        cuckoo.sing();

        Bird parrot = new Parrot("Кеша", 3, "разноцветный", "Привет, как дела?");
        System.out.println("\n" + parrot);
        System.out.print("Пение: ");
        parrot.sing();

        System.out.println();
    }

    private static void task5Graph() {
        System.out.println("=== ЗАДАНИЕ 5: ГРАФ ===");

        Graph graph = new Graph();
        graph.build();
        graph.print();

        System.out.println();
    }

    private static void task6CompareCities() {
        System.out.println("=== ЗАДАНИЕ 6: СРАВНЕНИЕ ГОРОДОВ ===");

        City city1 = new City("Город1");
        City city2 = new City("Город2");
        City common = new City("Общий");

        city1.addRoad(common);
        city2.addRoad(common);

        System.out.println("city1: " + city1);
        System.out.println("city2: " + city2);

        City city1Copy = new City("Город1");
        city1Copy.addRoad(common);

        System.out.println("\ncity1.equals(city1Copy): " + city1.equals(city1Copy));
        System.out.println("city1.equals(city2): " + city1.equals(city2));

        System.out.println();
    }

    private static void task7Power(String[] args) {
        System.out.println("=== ЗАДАНИЕ 7: ВОЗВЕДЕНИЕ В СТЕПЕНЬ ===");

        if (args.length >= 2) {
            try {
                int x = parseInt(args[0]);
                int y = parseInt(args[1]);
                double result = pow(x, y);
                System.out.println(x + "^" + y + " = " + result);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: аргументы должны быть числами");
            }
        } else {
            System.out.println("Введите число X:");
            String xStr = scanner.nextLine();

            System.out.println("Введите степень Y:");
            String yStr = scanner.nextLine();

            try {
                int x = parseInt(xStr);
                int y = parseInt(yStr);
                double result = pow(x, y);
                System.out.println("\nРезультат: " + x + "^" + y + " = " + result);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректные числа");
            }
        }

        System.out.println();
    }

    private static void task8ClonePoint() {
        System.out.println("=== ЗАДАНИЕ 8: КЛОНИРОВАНИЕ ТОЧКИ ===");

        Point3D original = new Point3D(1, 2, 3);
        System.out.println("Оригинал: " + original);

        Point3D clone = original.clone();
        System.out.println("Клон: " + clone);

        System.out.println("\nЭто разные объекты: " + (original != clone));
        System.out.println("Значения равны: " + original.equals(clone));

        System.out.println("\nX оригинала: " + original.getX());
        System.out.println("X клона: " + clone.getX());
        System.out.println("Z оригинала: " + original.getZ());
        System.out.println("Z клона: " + clone.getZ());

        System.out.println();
    }
}
package ru.shulepov.util;

/**
 * Класс для возведения числа в степень
 */
public class Pow {

    /**
     * Возводит число X в степень Y
     * @param x строка с числом
     * @param y строка со степенью
     * @return результат возведения в степень
     */
    public static double pow(String x, String y) {
        int numX = Integer.parseInt(x);
        int numY = Integer.parseInt(y);
        return Math.pow(numX, numY);
    }
}
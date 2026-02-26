package ru.shulepov.cities;

import java.util.*;

/**
 * Маршрут между двумя городами
 * O(1) создание и изменение точек начала/конца
 */
public class Route {
    private City start;
    private City end;

    public Route(City start, City end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Начало и конец маршрута не могут быть null");
        }
        this.start = start;
        this.end = end;
    }

    public City getStart() {
        return start;
    }

    public City getEnd() {
        return end;
    }

    public void setStart(City start) {
        if (start == null) {
            throw new IllegalArgumentException("Начало маршрута не может быть null");
        }
        this.start = start;
    }

    public void setEnd(City end) {
        if (end == null) {
            throw new IllegalArgumentException("Конец маршрута не может быть null");
        }
        this.end = end;
    }

    public City[] getPath() {
        if (start.equals(end)) {
            return new City[]{start};
        }

        Queue<City> queue = new LinkedList<>();
        Map<City, City> previous = new HashMap<>();
        Set<City> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);
        previous.put(start, null);

        while (!queue.isEmpty()) {
            City current = queue.poll();

            if (current.equals(end)) {
                return reconstructPath(previous, start, end);
            }

            for (City neighbor : current.getRoads()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    previous.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }

        return new City[0];
    }

    private City[] reconstructPath(Map<City, City> previous, City start, City end) {
        List<City> path = new ArrayList<>();
        City current = end;

        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }

        Collections.reverse(path);
        return path.toArray(new City[0]);
    }

    @Override
    public String toString() {
        City[] path = getPath();
        if (path.length == 0) {
            return "Путь не найден";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.length; i++) {
            sb.append(path[i].getName());
            if (i < path.length - 1) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }
}
package ru.shulepov.graph;

import ru.shulepov.cities.BidirectionalCity;
import ru.shulepov.cities.City;
import ru.shulepov.cities.Route;

import java.util.HashMap;
import java.util.Map;

/**
 * Граф городов из задачи 2.5.9
 */
public class Graph {
    private Map<String, City> cities;

    public Graph() {
        this.cities = new HashMap<>();
    }

    public void build() {
        City A = new City("A");
        City B = new BidirectionalCity("B");
        City C = new City("C");
        City D = new BidirectionalCity("D");
        City E = new BidirectionalCity("E");

        A.addRoad(B);
        A.addRoad(C);
        B.addRoad(C);
        B.addRoad(D);
        E.addRoad(C);

        cities.put("A", A);
        cities.put("B", B);
        cities.put("C", C);
        cities.put("D", D);
        cities.put("E", E);
    }

    public void print() {
        System.out.println("=== Граф городов ===");
        for (Map.Entry<String, City> entry : cities.entrySet()) {
            City city = entry.getValue();
            System.out.println(city.getName() + " -> " + city.getRoads());
        }

        City A = cities.get("A");
        City E = cities.get("E");

        if (A != null && E != null) {
            Route route = new Route(A, E);
            System.out.println("\nМаршрут из A в E:");
            System.out.println(route);
        }
    }

    public City getCity(String name) {
        return cities.get(name);
    }
}
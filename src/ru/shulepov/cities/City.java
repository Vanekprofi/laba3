package ru.shulepov.cities;

import java.util.*;

/**
 * Город с дорогами (односторонними)
 * Гарантирует: между двумя городами только одна прямая дорога
 */
public class City {
    protected String name;
    protected Map<String, City> roads;

    public City(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя города не может быть пустым");
        }
        this.name = name;
        this.roads = new HashMap<>();
    }

    public City(String name, List<City> initialRoads) {
        this(name);
        if (initialRoads != null) {
            for (City city : initialRoads) {
                addRoad(city);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void addRoad(City city) {
        if (city == null) {
            throw new IllegalArgumentException("Город не может быть null");
        }
        if (city.equals(this)) {
            throw new IllegalArgumentException("Нельзя добавить дорогу в сам себя");
        }
        roads.put(city.name, city);
    }

    public void removeRoad(City city) {
        if (city == null) {
            throw new IllegalArgumentException("Город не может быть null");
        }
        roads.remove(city.name);
    }

    public void removeRoad(String cityName) {
        roads.remove(cityName);
    }

    public Collection<City> getRoads() {
        return Collections.unmodifiableCollection(roads.values());
    }

    public City getRoadTo(String cityName) {
        return roads.get(cityName);
    }

    public boolean hasRoadTo(City city) {
        return city != null && roads.containsKey(city.name);
    }

    public int getRoadCount() {
        return roads.size();
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", roads=" + roads.keySet() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) &&
                Objects.equals(roads.keySet(), city.roads.keySet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, roads.keySet());
    }
}
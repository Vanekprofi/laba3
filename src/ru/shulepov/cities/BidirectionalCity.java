package ru.shulepov.cities;

import java.util.List;

/**
 * Город с двусторонними дорогами
 * При добавлении дороги автоматически добавляется обратная дорога
 */
public class BidirectionalCity extends City {

    public BidirectionalCity(String name) {
        super(name);
    }

    public BidirectionalCity(String name, List<City> initialRoads) {
        super(name, initialRoads);
    }

    @Override
    public void addRoad(City city) {
        if (city == null) {
            throw new IllegalArgumentException("Город не может быть null");
        }
        if (city.equals(this)) {
            throw new IllegalArgumentException("Нельзя добавить дорогу в сам себя");
        }

        super.addRoad(city);

        if (city instanceof BidirectionalCity) {
            city.roads.put(this.name, this);
        } else {
            city.roads.put(this.name, this);
        }
    }

    @Override
    public void removeRoad(City city) {
        if (city == null) {
            throw new IllegalArgumentException("Город не может быть null");
        }
        super.removeRoad(city);
        city.roads.remove(this.name);
    }

    @Override
    public String toString() {
        return "BidirectionalCity{" +
                "name='" + name + '\'' +
                ", roads=" + roads.keySet() +
                '}';
    }
}
package ru.shulepov.geometry;

public class Point3D extends Point {
    private final int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    @Override
    public Point3D clone() {
        return new Point3D(getX(), getY(), z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point3D)) return false;
        if (!super.equals(o)) return false;
        Point3D point3D = (Point3D) o;
        return z == point3D.z;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + z;
    }

    @Override
    public String toString() {
        return "{" + getX() + "; " + getY() + "; " + z + "}";
    }
}
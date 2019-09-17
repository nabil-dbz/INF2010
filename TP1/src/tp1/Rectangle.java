package tp1;

import java.util.Set;

public class Rectangle extends BaseShape {
    // TODO creer un rectangle avec une largeur et une longueur.
    public Rectangle(Double width, Double height) {
        // ...
    }

    // TODO creer un rectangle avec un point contenant la largeur et longueur.
    public Rectangle(Point2d dimensions) {
        // ...
    }

    private Rectangle(Set<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Rectangle translate(Point2d point) {
        return null;
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Rectangle rotate(Double angle) {
        return null;
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Rectangle clone() {
        return null;
    }
}

package tp1;

import java.util.HashSet;
import java.util.Set;

/**
* This class provides a Rectangle object
* @author Nabil Dabouz and Andrew Al-Romhein
* @version 19/09/2019
**/

public class Rectangle extends BaseShape {
    // TODO creer un rectangle avec une largeur et une longueur.
    public Rectangle(Double width, Double height) {
        super();
        for (Double x = -width; x <= width; x += 0.5){
            for (Double y = -height; y <= height; y += 0.5) {
                add(new Point2d(new Double(x), new Double(y)));
            }
        }
    }

    // TODO creer un rectangle avec un point contenant la largeur et longueur.
    public Rectangle(Point2d dimensions) {
        super();
        for (Double x = -dimensions.X(); x <= dimensions.X(); x += 0.5){
            for (Double y = -dimensions.Y(); y <= dimensions.Y(); y += 0.2) {
                add(new Point2d(new Double(x), new Double(y)));
            }
        }
    }

    private Rectangle(Set<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Rectangle translate(Point2d point) {
        return new Rectangle(translateAll(point));
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Rectangle rotate(Double angle) {
        return new Rectangle(rotateAll(angle));
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Rectangle clone() {
        return new Rectangle(getCoords());
    }
}

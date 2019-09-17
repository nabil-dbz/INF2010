package tp1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ellipse extends BaseShape {
    // TODO creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
        super(new Set<Point2d>(new Point2d(new Double(-0.5 * widthRadius), new Double(0))) {
        });
        Set<Point2d> coords = new HashSet<>();
        coords.add(new Point2d(new Double(-0.5 * widthRadius), new Double(0)));
        coords.add(new Point2d(new Double(+0.5 * widthRadius), new Double(0)));
                new Point2d(new Double(0), new Double(-0.5 * heightRadius)),
                new Point2d(new Double(0), new Double(+0.5 * heightRadius)));
    }

    private Ellipse(Set<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Ellipse translate(Point2d point) {
        return new Ellipse(translateAll(point));
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Ellipse rotate(Double angle) {
        return new Ellipse(rotateAll(angle));
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Ellipse clone() { return new Ellipse(getCoords()); }
}

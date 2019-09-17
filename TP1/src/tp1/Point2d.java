package tp1;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    // TODO creer un point en 2d avec 2 donnees
    public Point2d(Double x, Double y) {
        super(new Double[]{x, y});
    }

    // TODO creer un point a partir d'un vecteur de donnees
    public Point2d(Double[] vector) {
        super(vector);
    }

    public Double X() { return vector[X];}
    public Double Y() { return vector[Y];}

    // TODO prendre un vecteur de donnees et appliquer la translation.
    @Override
    public Point2d translate(Double[] translateVector) {
        return new Point2d(vector[X] + translateVector[X],  vector[Y] + translateVector[Y]);
    }

    // TODO prendre un point et appliquer la translation.
    public Point2d translate(Point2d translateVector) {
        return new Point2d(this.X() + translateVector.X(), this.Y() + translateVector.Y());
    }

    // TODO prendre un vecteur de donnees et appliquer la rotation.
    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
        return null;
    }

    // TODO prendre un angle de rotation, creer une matrice et appliquer la rotation.
    public Point2d rotate(Double angle) {
        return null;
    }

    // TODO prendre un facteur de division et l'appliquer.
    @Override
    public Point2d divide(Double divider) {
        return null;
    }

    // TODO prendre un facteur de multiplication et l'appliquer.
    @Override
    public Point2d multiply(Double multiplier) {
        return null;
    }

    // TODO prendre un facteur d'addition et l'appliquer.
    @Override
    public Point2d add(Double adder) {
        return null;
    }

    // TODO creer un nouveau point.
    @Override
    public Point2d clone() {
        return this;
    }
}

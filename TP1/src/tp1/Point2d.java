package tp1;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    // TODO creer un point en 2d avec 2 donnees
    public Point2d(Double x, Double y) {
        super(new Double[]{x, y});
    }

    // TODO creer un point a partir d'un vecteur de donnees
    public Point2d(Double[] vector) { super( new Double[]{vector[0], vector[1]}); }

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
        return new Point2d(this.X() * rotationMatrix[0][0] + this.Y() * rotationMatrix[0][1],
                            this.X() * rotationMatrix[1][0] + this.Y() * rotationMatrix[1][1]);
    }

    // TODO prendre un angle de rotation, creer une matrice et appliquer la rotation.
    public Point2d rotate(Double angle) {

        Double[][] rotationMatrix = new Double[][]{
                {new Double(Math.cos(angle)), new Double(-Math.sin(angle))},
                {new Double(Math.sin(angle)), new Double(Math.cos(angle))}
        };

        return new Point2d(this.X() * rotationMatrix[0][0] + this.Y() * rotationMatrix[0][1],
                this.X() * rotationMatrix[1][0] + this.Y() * rotationMatrix[1][1]);
    }

    // TODO prendre un facteur de division et l'appliquer.
    @Override
    public Point2d divide(Double divider) {
        return new Point2d(this.X() / divider, this.Y() / divider) ;
    }

    // TODO prendre un facteur de multiplication et l'appliquer.
    @Override
    public Point2d multiply(Double multiplier) {
        return new Point2d(this.X() * multiplier, this.Y() * multiplier);
    }

    // TODO prendre un facteur d'addition et l'appliquer.
    @Override
    public Point2d add(Double adder) {
        return new Point2d(this.X() + adder, this.Y() + adder);
    }

    // TODO creer un nouveau point.
    @Override
    public Point2d clone() {
        return new Point2d(this.vector);
    }
}

package tp1;

/**
* This class provides a Point 2d object
* @author Nabil Dabouz and Andrew Al-Romhein
* @version 19/09/2019
**/

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    public Point2d(Double x, Double y) {
        super(new Double[]{x, y});
    }

    public Point2d(Double[] vector) { super( new Double[]{vector[0], vector[1]}); }

    // X et Y sont des nos attributs finaux qui correspondent à l'index 0 et 1 du vecteur 
    public Double X() { return vector[X];}
    public Double Y() { return vector[Y];}

    @Override
    // Applique la translation au vecteur donné
    public Point2d translate(Double[] translateVector) {
        return new Point2d(vector[X] + translateVector[X],  vector[Y] + translateVector[Y]);
    }

    // Applique la translation au point donné
    public Point2d translate(Point2d translateVector) {
        return new Point2d(this.X() + translateVector.X(), this.Y() + translateVector.Y());
    }

    // Applique la martice de rotation sur vecteur de donnes
    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
        return new Point2d(this.X() * rotationMatrix[0][0] + this.Y() * rotationMatrix[0][1],
                            this.X() * rotationMatrix[1][0] + this.Y() * rotationMatrix[1][1]);
    }

    // Applique la matrice de rotation sur un point2d
    public Point2d rotate(Double angle) {

        Double[][] rotationMatrix = new Double[][]{
                {new Double(Math.cos(angle)), new Double(-Math.sin(angle))},
                {new Double(Math.sin(angle)), new Double(Math.cos(angle))}
        };

        return new Point2d(this.X() * rotationMatrix[0][0] + this.Y() * rotationMatrix[0][1],
                this.X() * rotationMatrix[1][0] + this.Y() * rotationMatrix[1][1]);
    }

    @Override
    // Applique le facteur de division sur le point2d
    public Point2d divide(Double divider) {
        return new Point2d(this.X() / divider, this.Y() / divider) ;
    }

    @Override
    // Applique le facteur de multiplication sur le point2d
    public Point2d multiply(Double multiplier) {
        return new Point2d(this.X() * multiplier, this.Y() * multiplier);
    }

    @Override
    // Applique l'addition sur les composantes du point2d
    public Point2d add(Double adder) {
        return new Point2d(this.X() + adder, this.Y() + adder);
    }

    @Override
    // Clone un point2d
    public Point2d clone() {
        return new Point2d(this.vector);
    }
}

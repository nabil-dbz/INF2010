package tp1;

import java.util.*;

public final class PointOperator {
    // TODO appliquer la translation sur le vecteur d'entree.
    public static Double[] translate(Double[] vector, Double[] translateVector) {

        Double[] vectDeRetour =  new Double[vector.length];

        for (int i=0; i < vector.length; i++) {
            vectDeRetour[i] = vector[i] + translateVector[i];
        }

        return vectDeRetour;
    }

    // TODO appliquer la rotation sur le vecteur d'entree.
    public static Double[] rotate(Double[] vector, Double[][] rotationMatrix) {

        Double[] vectDeRetour =  new Double[vector.length];

        for(int i=0; i < vector.length; i++) {
            vectDeRetour[i] = 0.0;
            for(int j=0; j< vector.length; j++) {
                vectDeRetour[i] += vector[j] * rotationMatrix[i][j];
            }
        }

        return vectDeRetour;
    }

    // TODO appliquer le facteur de division sur le vecteur d'entree.
    public static Double[] divide(Double[] vector, Double divider) {

        Double[] vectDeRetour =  new Double[vector.length];
        if (divider != 0) {
            for(int i=0; i < vector.length; i++) {
                vectDeRetour[i] = vector[i] / divider;
            }
        }
        return vectDeRetour;
    }

    // TODO appliquer le facteur de multiplication sur le vecteur d'entree.
    public static Double[] multiply(Double[] vector, Double multiplier) {

        Double[] vectDeRetour =  new Double[vector.length];
        for(int i=0; i < vector.length; i++) {
            vectDeRetour[i] = vector[i] * multiplier;
        }
        return vectDeRetour;
    }

    // TODO appliquer le facteur d'addition sur le vecteur d'entree.
    public static Double[] add(Double[] vector, Double adder) {
        Double[] vectDeRetour =  new Double[vector.length];
        for(int i=0; i < vector.length; i++) {
            vectDeRetour[i] = vector[i] + adder;
        }
        return vectDeRetour;
    }

    // TODO retourne la coordonnee avec les plus grandes valeurs en X et en Y.
    public static Point2d getMaxCoord(Collection<Point2d> coords) {

        Double xMax = 0.0;
        Double yMax = 0.0;
        for(Point2d point: coords) {
            if (point.X() > xMax) xMax = point.X();
            if (point.Y() > yMax) yMax = point.Y();
        }

        return new Point2d(xMax, yMax);
    }


    // TODO retourne la coordonnee avec les plus petites valeurs en X et en Y.
    public static Point2d getMinCoord(Collection<Point2d> coords) {
        System.out.println(0.0);
        Double xMin = new Double(((Point2d)coords.iterator().next()).X());
        Double yMin = new Double(((Point2d)coords.iterator().next()).Y());

        for(Point2d point: coords) {
            if (point.X() < xMin) xMin = point.X();
            if (point.Y() < yMin) yMin = point.Y();
        }

        return new Point2d(xMin, yMin);
    }
}

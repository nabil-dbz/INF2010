package tp1;

import java.util.*;

/**
* This class provides a Point Operator object
* @author Nabil Dabouz and Andrew Al-Romhein
* @version 19/09/2019
**/

public final class PointOperator {

    public static Double[] translate(Double[] vector, Double[] translateVector) {

        Double[] vectDeRetour =  new Double[vector.length];
        // boucle qui permet d'appliquer la translation sur un vecteur de N dimensions
        for (int i=0; i < vector.length; i++) {
            vectDeRetour[i] = vector[i] + translateVector[i];
        }

        return vectDeRetour;
    }

    public static Double[] rotate(Double[] vector, Double[][] rotationMatrix) {

        Double[] vectDeRetour =  new Double[vector.length];

        // boucle imbriquée pour appliquer la rotation sur le vecteur de N dimensions
        for(int i=0; i < vector.length; i++) {
            vectDeRetour[i] = 0.0;
            for(int j=0; j< vector.length; j++) {
                vectDeRetour[i] += vector[j] * rotationMatrix[i][j];
            }
        }

        return vectDeRetour;
    }

    public static Double[] divide(Double[] vector, Double divider) {

        // On divise chaque composante du vecteur de N dimension  par
        // le facteur de division
        Double[] vectDeRetour =  new Double[vector.length];
        if (divider != 0) {
            for(int i=0; i < vector.length; i++) {
                vectDeRetour[i] = vector[i] / divider;
            }
        }
        return vectDeRetour;
    }

    public static Double[] multiply(Double[] vector, Double multiplier) {

        // On multiplie chaque composante du vecteur de N dimension  par
        // le facteur de multiplication
        Double[] vectDeRetour =  new Double[vector.length];
        for(int i=0; i < vector.length; i++) {
            vectDeRetour[i] = vector[i] * multiplier;
        }
        return vectDeRetour;
    }

    public static Double[] add(Double[] vector, Double adder) {

        // On additionne à chaque composante du vecteur de N dimension 
        // le facteur de multiplication
        Double[] vectDeRetour =  new Double[vector.length];
        for(int i=0; i < vector.length; i++) {
            vectDeRetour[i] = vector[i] + adder;
        }
        return vectDeRetour;
    }

    public static Point2d getMaxCoord(Collection<Point2d> coords) {

        Double xMax = 0.0;
        Double yMax = 0.0;

        //Parcourrir la collection de point2d pour trouver le x max et le y max
        for(Point2d point: coords) {
            if (point.X() > xMax) xMax = point.X();
            if (point.Y() > yMax) yMax = point.Y();
        }

        //Retourne un point avec le x max et le y max comme coordonnées
        return new Point2d(xMax, yMax);
    }

    public static Point2d getMinCoord(Collection<Point2d> coords) {

        Double xMin = new Double(((Point2d)coords.iterator().next()).X());
        Double yMin = new Double(((Point2d)coords.iterator().next()).Y());

        //Parcourrir la collection de point2d pour trouver le x min et le y min
        for(Point2d point: coords) {
            if (point.X() < xMin) xMin = point.X();
            if (point.Y() < yMin) yMin = point.Y();
        }

        //Retourne un point avec le X min et le Y min comme coordonnées
        return new Point2d(xMin, yMin);
    }
}

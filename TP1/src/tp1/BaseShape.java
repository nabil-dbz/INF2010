package tp1;

import java.util.*;
import java.util.stream.Collectors;

/**
* This class provides a Base Shape object
* @author Nabil Dabouz and Andrew Al-Romhein
* @version 19/09/2019
**/


public class BaseShape {
    // Vous aller apprendre plus en details le fonctionnement d'un Set lors
    // du cours sur les fonctions de hashage, vous pouvez considerez ceci comme une liste normale.
    private Set<Point2d> coords;

    // Initialise les point de la BaseShape
    public BaseShape() {
        this.coords = new HashSet<>();
    }

    // Creer une forme à partir d'une collection de point2d
    public BaseShape(Collection<Point2d> coords) {
        this.coords = new HashSet<>(coords);
    }

    //Ajoute un point à la liste de point
    public void add(Point2d coord) {
        this.coords.add(coord);
    }

    //Ajoute les coordonnées d'une forme a la liste de points
    public void add(BaseShape shape) {
        this.coords.addAll(shape.getCoords());
    }
    
    //Ajoute une collection de point2d à la liste de points
    public void addAll(Collection<Point2d> coords) {
        this.coords.addAll(coords);
    }

    //Enleve un point a la liste de point
    public void remove(Point2d coord) {
        this.coords.remove(coord);
    }

    //Enleve les points d'une forme a la liste de point
    public void remove(BaseShape shape) {
        this.coords.removeAll(shape.getCoords());
    }

    //Enleve tous les points de la collection
    public void removeAll(Collection<Point2d> coords) {
        this.coords.removeAll(coords);
    }


    // Setter qui retourne les coordonnees de la liste.
    public Set<Point2d> getCoords() {
        return new HashSet<>(this.coords);
    }

    // Applique la translation sur la forme
    public BaseShape translate(Point2d point) {
        return new BaseShape(translateAll(point));
    }

    // Applique la translation sur tous les point2d dans la liste de point
    public Set<Point2d> translateAll(Point2d point) {
        Set<Point2d> coords = new HashSet<>();
        this.coords.stream().forEach(pointTranslate -> {coords.add(pointTranslate.translate(point));});
        return coords;
    }

    // Applique la rotation sur une forme avec un angle de rotation passé en parametre
    public BaseShape rotate(Double angle) {
        return new BaseShape(rotateAll(angle));
    }

    // Applique la rotation sur la liste de point
    public Set<Point2d> rotateAll(Double angle) {
        Set<Point2d> coords = new HashSet<>();
        this.coords.stream().forEach(pointTranslate -> {coords.add(pointTranslate.rotate(angle));});
        return coords;
    }

    // Permet de retourner une nouvelle forme
    public BaseShape clone() {
        return new BaseShape(this.coords);
    }
}

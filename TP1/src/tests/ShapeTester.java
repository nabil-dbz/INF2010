package tests;

import org.ejml.simple.SimpleMatrix;
import tp1.*;

import java.util.*;

public final class ShapeTester {
    public static Double start(Double value) {
        Double total = 0.0;
        total += Tester.runner("shapeConstructor", ShapeTester::shapeConstructor, 1.0);
        total += Tester.runner("shapeCoords", ShapeTester::shapeCoords, 1.0);
        total += Tester.runner("translate", ShapeTester::translate, 0.5);
        total += Tester.runner("rotate", ShapeTester::rotate, 0.5);
        total += Tester.runner("squareRectangle", ShapeTester::squareRectangle, 1.0);
        total += Tester.runner("circleEllipse", ShapeTester::circleEllipse, 1.0 );
        return total;
    }

    private static Double shapeConstructor(Double value) {
        Set<Point2d> set = new HashSet<>();
        set.add(new Point2d(0.0, 0.0));
        BaseShape shape = new BaseShape(set);
        set.add(new Point2d(1.0, 0.0));
        return shape.getCoords().size() != set.size() ? value : 0.0;
    }

    private static Double shapeCoords(Double value) {
        BaseShape shape = new BaseShape();
        Set<Point2d> set = shape.getCoords();
        set.add(new Point2d(1.0, 0.0));
        return shape.getCoords().size() != set.size() ? value : 0.0;
    }

    private static Double translate(Double value) {
        Double[][] rawVector = { {0.0, 0.0} };
        Double[][] rawTranslate = { {1.0, 2.0} };
        SimpleMatrix vector = new SimpleMatrix(Tester.toPromitive(rawVector));
        SimpleMatrix translate = new SimpleMatrix(Tester.toPromitive(rawTranslate));
        SimpleMatrix correctOutput = vector.plus(translate);
        List<Point2d> list = new ArrayList<>();
        list.add(new Point2d(rawVector[0][0], rawVector[0][1]));
        BaseShape output = new BaseShape(list).translate(new Point2d(rawTranslate[0][0], rawTranslate[0][1]));
        Point2d point = output.getCoords().iterator().next();
        return Tester.isEqual(correctOutput, new Double[] { point.X(), point.Y() }) ? value : 0.0;
    }

    private static Double rotate(Double value) {
        Double[][] rawVector = { {1.0, 5.0} };
        Double[][] rawRotate = {
                {0.0, -1.0},
                {1.0, 0.0},
        };
        SimpleMatrix vector = new SimpleMatrix(Tester.toPromitive(rawVector));
        SimpleMatrix rotate = new SimpleMatrix(Tester.toPromitive(rawRotate));
        SimpleMatrix correctOutput = rotate.mult(vector.transpose()).transpose();
        List<Point2d> list = new ArrayList<>();
        list.add(new Point2d(rawVector[0][0], rawVector[0][1]));
        BaseShape output = new BaseShape(list).rotate(Math.toRadians(90));
        Point2d point = output.getCoords().iterator().next();
        return Tester.isEqual(correctOutput, new Double[] { point.X(), point.Y() }) ? value : 0.0;
    }

    private static Double squareRectangle(Double value) {
        Square square = new Square(5.0);
        Rectangle rectangle = new Rectangle(5.0, 5.0);
        rectangle.remove(square);
        return rectangle.getCoords().size() == 0.0 ? value : 0.0;
    }

    private static Double circleEllipse(Double value) {
        Circle circle = new Circle(5.0);
        Ellipse ellipse = new Ellipse(5.0, 5.0);
        ellipse.remove(circle);
        return ellipse.getCoords().size() == 0.0 ? value : 0.0;
    }
}

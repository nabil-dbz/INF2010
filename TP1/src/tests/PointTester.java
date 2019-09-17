package tests;

import org.ejml.simple.SimpleMatrix;
import tp1.Point2d;
import tp1.PointOperator;

import java.util.ArrayList;
import java.util.List;

public final class PointTester {
    public static Double start(Double value) {
        Double total = 0.0;
        total += Tester.runner("translate", PointTester::translate, 1.5);
        total += Tester.runner("rotate", PointTester::rotate, 1.5);
        total += Tester.runner("divide", PointTester::divide, 0.5);
        total += Tester.runner("multiply", PointTester::multiply, 0.5);
        total += Tester.runner("add", PointTester::add, 0.5);
        total += Tester.runner("getMaxCoord", PointTester::getMaxCoord, 0.5);
        total += Tester.runner("getMinCoord", PointTester::getMinCoord, 0.5);
        total += Tester.runner("pointConstructor", PointTester::pointConstructor, 0.5);
        total += Tester.runner("methodsDontChangeInternal", PointTester::methodsDontChangeInternal, 1.5);
        total += Tester.runner("rotatePoint", PointTester::rotatePoint, 1.0);
        total += Tester.runner("translatePoint", PointTester::translatePoint, 1.0);
        total += Tester.runner("clone", PointTester::clone, 0.5);
        return total;
    }

    public static Double translate(Double value) {
        Double[][] rawVector = { {0.0, 0.0, 0.0} };
        Double[][] rawTranslate = { {1.0, 2.0, 3.0} };
        SimpleMatrix vector = new SimpleMatrix(Tester.toPromitive(rawVector));
        SimpleMatrix translate = new SimpleMatrix(Tester.toPromitive(rawTranslate));
        SimpleMatrix correctOutput = vector.plus(translate);
        Double[] output = PointOperator.translate(rawVector[0], rawTranslate[0]);
        return Tester.isEqual(correctOutput, output) ? value : 0.0;
    }

    public static Double rotate(Double value) {
        Double[][] rawVector = { {1.0, 2.0, 3.0} };
        Double[][] rawRotate = {
                {1.0, 2.0, 0.0},
                {3.0, 4.0, 0.0},
                {0.0, 0.0, 1.0}
        };
        SimpleMatrix vector = new SimpleMatrix(Tester.toPromitive(rawVector));
        SimpleMatrix rotate = new SimpleMatrix(Tester.toPromitive(rawRotate));
        SimpleMatrix correctOutput = rotate.mult(vector.transpose()).transpose();
        Double[] output = PointOperator.rotate(rawVector[0], rawRotate);
        return Tester.isEqual(correctOutput, output) ? value : 0.0;
    }

    public static Double divide(Double value) {
        Double[][] rawVector = { {1.0, 2.0, 3.0} };
        Double scale = 5.0;
        SimpleMatrix vector = new SimpleMatrix(Tester.toPromitive(rawVector));
        SimpleMatrix correctOutput = vector.divide(scale);
        Double[] output = PointOperator.divide(rawVector[0], scale);
        return Tester.isEqual(correctOutput, output) ? value : 0.0;
    }

    public static Double multiply(Double value) {
        Double[][] rawVector = { {1.0, 2.0, 3.0} };
        Double scale = 5.0;
        SimpleMatrix vector = new SimpleMatrix(Tester.toPromitive(rawVector));
        SimpleMatrix correctOutput = vector.scale(scale);
        Double[] output = PointOperator.multiply(rawVector[0], scale);
        return Tester.isEqual(correctOutput, output) ? value : 0.0;
    }

    public static Double add(Double value) {
        Double[][] rawVector = { {1.0, 2.0, 3.0} };
        Double scale = 5.0;
        SimpleMatrix vector = new SimpleMatrix(Tester.toPromitive(rawVector));
        SimpleMatrix correctOutput = vector.plus(scale);
        Double[] output = PointOperator.add(rawVector[0], scale);
        return Tester.isEqual(correctOutput, output) ? value : 0.0;
    }

    public static Double getMaxCoord(Double value) {
        List<Point2d> coords = new ArrayList<>();
        coords.add(new Point2d(1.0, 2.0));
        coords.add(new Point2d(-1.0, 5.0));
        coords.add(new Point2d(10.0, 0.0));
        return new Point2d(10.0, 5.0).equals(PointOperator.getMaxCoord(coords)) ? value : 0.0;
    }

    public static Double getMinCoord(Double value) {
        List<Point2d> coords = new ArrayList<>();
        coords.add(new Point2d(1.0, 2.0));
        coords.add(new Point2d(-1.0, 5.0));
        coords.add(new Point2d(10.0, 0.0));
        return new Point2d(-1.0, 0.0).equals(PointOperator.getMinCoord(coords)) ? value : 0.0;
    }

    public static Double pointConstructor(Double value) {
        Double[] data = { 1.0, 2.0 };
        Point2d test = new Point2d(data);
        data[0] = 0.0;
        return test.X() == 1.0 ? value : 0.0;
    }

    public static Double methodsDontChangeInternal(Double value) {
        Double[] data = { 1.0, 2.0 };
        Point2d test = new Point2d(data);
        test.rotate(1.0);
        test.translate(new Double[] { 1.0, 1.0});
        test.divide(5.0);
        test.multiply(3.5);
        test.add(22.0);
        return test.equals(new Point2d(data)) ? value : 0.0;
    }

    public static Double rotatePoint(Double value) {
        Double[][] rawVector = { {1.0, 5.0} };
        Double[][] rawRotate = {
                {0.0, -1.0},
                {1.0, 0.0},
        };
        SimpleMatrix vector = new SimpleMatrix(Tester.toPromitive(rawVector));
        SimpleMatrix rotate = new SimpleMatrix(Tester.toPromitive(rawRotate));
        SimpleMatrix correctOutput = rotate.mult(vector.transpose()).transpose();
        Point2d output = new Point2d(rawVector[0]).rotate(Math.toRadians(90));
        return Tester.isEqual(correctOutput, new Double[] {output.X(), output.Y()}) ? value : 0.0;
    }

    public static Double translatePoint(Double value) {
        Double[][] rawVector = { {0.0, 0.0} };
        Double[][] rawTranslate = { {1.0, 2.0} };
        SimpleMatrix vector = new SimpleMatrix(Tester.toPromitive(rawVector));
        SimpleMatrix translate = new SimpleMatrix(Tester.toPromitive(rawTranslate));
        SimpleMatrix correctOutput = vector.plus(translate);
        Point2d output = new Point2d(rawVector[0]).translate(new Point2d(rawTranslate[0]));
        return Tester.isEqual(correctOutput, new Double[] {output.X(), output.Y()}) ? value : 0.0;
    }

    public static Double clone(Double value) {
        Point2d test = new Point2d(1.0, 2.0);
        return test != test.clone() ? value : 0.0;
    }
}

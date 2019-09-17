package tests;

import org.ejml.simple.SimpleMatrix;

import java.util.Collections;
import java.util.function.Function;

public final class Tester {
    private static Integer count = 0;

    public static Double start(Double value) {
        Double total = 0.0; // Point de style
        total += runner("PointTester", PointTester::start, 10.0);
        total += runner("ShapeTester", ShapeTester::start, 5.0);
        total += runner("LetterTester", LetterTester::start, 4.0);
        total += runner("Style", Tester::style, 1.0);
        return total;
    }

    private static Double style(Double value) {
        return value;
    }

    public static Double runner(String message, Function<Double, Double> function, Double outOf) {
        String prefix = String.join("", Collections.nCopies(count++, " -> "));
        System.out.println(prefix + message + ":");
        Double result = 0.0;
        try {
            result = function.apply(outOf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(prefix + result + " / " + outOf);
        --count;
        return result;
    }


    public static double[][] toPromitive(Double[][] input) {
        double[][] output = new double[input.length][input[0].length];
        for (int i = 0; i < output.length; ++i) {
            for (int j = 0; j < output[i].length; ++j) {
                output[i][j] = input[i][j];
            }
        }
        return output;
    }

    public static boolean isEqual(SimpleMatrix first, Double[] second) {
        for (int i = 0; i < second.length; ++i) {
            if (Math.round(first.get(0, i)) != Math.round(second[i])) {
                return false;
            }
        }
        return true;
    }
}

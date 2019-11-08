package tests;

import java.util.Collections;
import java.util.function.Supplier;

public final class Corrector {
    private static Integer unitTestCount = 0;
    private static Integer testerCount = 0;

    public static Double start() {
        Double subTotal = 0.0;

        Double stylePoints = 1.0;

        subTotal += executeTester("LinkedHashMapTester", LinkedHashMapTester::start, 11.5);
        subTotal += executeTester("InterviewTester", InterviewTester::start, 7.5);

        return subTotal + stylePoints;
    }

    public static Double executeUnitTest(String unitTestName, Supplier<Boolean> function, Double pointsForTest) {
        String prefix = String.join("", Collections.nCopies(testerCount, "    "));
        prefix += String.join("", Collections.nCopies(++unitTestCount, " -> "));

        System.out.println(prefix + unitTestName + ":");

        boolean isSuccess = false;

        try {
            isSuccess = function.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Double result = isSuccess ? pointsForTest : 0.0;

        System.out.println(prefix + result + " / " + pointsForTest);
        --unitTestCount;

        return result;
    }

    public static Double executeTester(String testerName, Supplier<Double> function, Double outOf) {
        String prefix = String.join("", Collections.nCopies(testerCount++, "    "));
        System.out.println(prefix + "[ " + testerName + " ]");

        Double result = function.get();

        result = Math.min(result, outOf);

        System.out.println(prefix + result + " / " + outOf);
        --testerCount;

        return result;
    }
}

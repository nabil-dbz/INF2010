package tests;

import net.sourceforge.tess4j.Tesseract;
import tp1.LetterPlacer;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LetterTester {
    public static Double start(Double value) {
        Double total = 0.0;
        total += Tester.runner("all", LetterTester::all, 1.0);
        return Math.max(0, Math.min(value, total));
    }

    private static Double all(Double value) {
        Tesseract tesseract = new Tesseract();
        LetterPlacer letterPlacer = new LetterPlacer();
        try {
            letterPlacer.placeNext('H');
            letterPlacer.placeNext('e');
            letterPlacer.placeNext('l');
            letterPlacer.placeNext('l');
            letterPlacer.placeNext('o');
            letterPlacer.placeNextln('W');
            letterPlacer.placeNext('o');
            letterPlacer.placeNext('r');
            letterPlacer.placeNext('l');
            letterPlacer.placeNext('d');
            letterPlacer.saveImage("all", true);
            String output = tesseract.doOCR(new File("all.jpg"))
                    .replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            String input = "helloworld";
            return findMatchingChars(output, input).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    private static Integer findMatchingChars(String str1, String str2) {
        Set<String> chars1 = new HashSet<String>(Arrays.asList(str1.split("(?!^)")));
        Set<String> chars2 = new HashSet<String>(Arrays.asList(str2.split("(?!^)")));
        chars1.retainAll(chars2);
        return chars1.size();
    }
}

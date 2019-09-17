package tp1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class LetterPlacer {
    private final static Integer enlargeFactor = 3;
    private final static Double padding = 20.0;
    private final static Integer maxColor = 256;
    private Collection<Collection<Point2d>> coordsList;
    private BaseShape previousLetter;
    private int numberOfLines;

    public LetterPlacer() {
        coordsList = new ArrayList<>();
        previousLetter = new Rectangle(0.0, 0.0);
        numberOfLines = 1;
    }

    public void placeNext(char letter) throws Exception {
        BaseShape nextLetter = getNextLetter(letter);
        previousLetter = insertShape(nextLetter, new Point2d(
                        PointOperator.getMaxCoord(previousLetter.getCoords()).X() + padding,
                        (numberOfLines - 1) * LetterFactory.maxHeight + numberOfLines * padding));
    }

    public void placeNextln(char letter) throws Exception {
        BaseShape nextLetter = getNextLetter(letter);
        previousLetter = insertShape(nextLetter, new Point2d(padding,
                        numberOfLines++ * LetterFactory.maxHeight + numberOfLines * padding));
    }

    private BaseShape getNextLetter(char letter) throws Exception {
        switch (letter) {
            case 'H': return LetterFactory.create_H();
            case 'e': return LetterFactory.create_e();
            case 'l': return LetterFactory.create_l();
            case 'o': return LetterFactory.create_o();
            case 'W': return LetterFactory.create_W();
            case 'r': return LetterFactory.create_r();
            case 'd': return LetterFactory.create_d();
            default: throw new Exception("Cette lettre n'est pas valide: " + letter);
        }
    }

    private static int getRandomRGB() {
        Random rand = new Random();
        return  rand.nextInt(maxColor) * 0x010000 +
                rand.nextInt(maxColor) * 0x000100 +
                rand.nextInt(maxColor) * 0x000001;
    }

    private static int getWhite() {
        return  255 * 0x010000 +
                255 * 0x000100 +
                255 * 0x000001;
    }

    private BaseShape insertShape(BaseShape nextLetter, Point2d nextPosition) {
        nextLetter = nextLetter.translate(PointOperator.getMaxCoord(nextLetter.getCoords()))
                .translate(nextPosition);
        coordsList.add(nextLetter.getCoords());
        return nextLetter;
    }

    public File saveImage(String fileName, boolean saveInWhite) throws IOException {
        Point2d max = PointOperator.getMaxCoord(coordsList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
        int[][] pixels = new int[(int)(max.Y() + padding)][(int)(max.X() + padding)];
        for (Collection<Point2d> coords : coordsList) {
            int color = saveInWhite ? getWhite() : getRandomRGB();
            for (Point2d point : coords) {
                enlarge(pixels, (int)Math.round(point.Y()), (int)Math.round(point.X()), color);
            }
        }

        int[] flatPixels = Arrays.stream(pixels)
                .flatMapToInt(Arrays::stream)
                .toArray();
        BufferedImage img = new BufferedImage(pixels[0].length, pixels.length,
                BufferedImage.TYPE_INT_RGB);
        img.setRGB(0, 0, pixels[0].length, pixels.length,
                flatPixels, 0, pixels[0].length);
        File imgFile = new File(fileName + ".jpg");
        ImageIO.write(img, "jpg", imgFile);
        return imgFile;
    }

    private void enlarge(int[][] pixels, int y, int x, int color) {
        for (int i = -enlargeFactor; i <= enlargeFactor; ++i) {
            for (int j = -enlargeFactor; j <= enlargeFactor; ++j) {
                try {
                    pixels[j + y][i + x] = color;
                } catch (ArrayIndexOutOfBoundsException e) {}
            }
        }
    }
}

package tp1;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 10;

    // TODO
    public static BaseShape create_H() {
        Double degrees90 = Math.toRadians(90);
        Double spacing = stripeThickness * 4;
        BaseShape mainStripe = new Rectangle(stripeThickness / 2, maxHeight / 2);
        BaseShape leftStripe = mainStripe.translate(new Point2d(-spacing / 2, 0.0));
        BaseShape middleStripe = new Rectangle(stripeThickness / 2, spacing / 2).rotate(degrees90).translate(new Point2d(0.0, 0.0));
        BaseShape rightStripe = mainStripe.translate(new Point2d(spacing / 2, 0.0));
        leftStripe.add(middleStripe);
        leftStripe.add(rightStripe);
        return leftStripe;
    }

    // TODO
    public static BaseShape create_e() {
        Double degrees90 = Math.toRadians(90);
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness / 2, spacing);
        BaseShape middleStripe = mainStripe.rotate(degrees90).translate(new Point2d(0.0, 0.0));

        BaseShape outsideEllipse =  new Ellipse(spacing , maxHeight / 2);
        for(Point2d point: outsideEllipse.getCoords()){
            if ((point.X() > 0.0) && (point.Y() > 0) && (point.Y() < 50))
                outsideEllipse.remove(point);
        }

        BaseShape insideEllipse =  new Ellipse(spacing -2 , maxHeight / 2 - 5);
        for(Point2d point: insideEllipse.getCoords()){
            if ((point.X() > 0.0) && (point.Y() > 0.0) && (point.Y() < 50))
                insideEllipse.remove(point);
        }

        middleStripe.add(insideEllipse);
        middleStripe.add(outsideEllipse);
        return middleStripe;
    }

    // TODO
    public static BaseShape create_l() {
        Double spacing = stripeThickness * 4;
        BaseShape mainStripe = new Rectangle(stripeThickness / 2, maxHeight / 2);
        return mainStripe;
    }

    // TODO
    public static BaseShape create_o() {
        BaseShape mainStripe = new Ellipse(stripeThickness * 3, maxHeight / 2);
        BaseShape insideStripe = new Ellipse(stripeThickness * 3 - 7, maxHeight / 2 - 7);
        BaseShape secondInsideStripe = new Ellipse(stripeThickness * 3 - 14, maxHeight / 2 - 14);
        mainStripe.add(insideStripe);
        mainStripe.add(secondInsideStripe);
        return mainStripe;
    }

    // On vous donne la lettre W comme exemple.
    public static BaseShape create_W() {
        Double degrees15 = Math.toRadians(8);
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness / 2, maxHeight / 2);
        BaseShape leftStripe = mainStripe.rotate(-degrees15).translate(new Point2d(-spacing, 0.0));
        BaseShape middleLeftStripe = mainStripe.rotate(degrees15).translate(new Point2d(-spacing / 3, 0.0));
        BaseShape middleRightStripe = mainStripe.rotate(-degrees15).translate(new Point2d(spacing / 3, 0.0));
        BaseShape rightStripe = mainStripe.rotate(degrees15).translate(new Point2d(spacing, 0.0));
        leftStripe.add(middleLeftStripe);
        leftStripe.add(middleRightStripe);
        leftStripe.add(rightStripe);
        return leftStripe;
    }

    // TODO
    public static BaseShape create_r() {
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness / 2, maxHeight / 2);
        BaseShape leftStripe = mainStripe.translate(new Point2d(-spacing, 0.0));

        BaseShape upperSemiCircle = new Ellipse(stripeThickness * 2.5, stripeThickness * 3).translate(new Point2d(stripeThickness / 2, -maxHeight / 5));
        for (Point2d point: upperSemiCircle.getCoords()) {
            if (point.Y() > -maxHeight / 5)
                upperSemiCircle.remove(point);
        }

        BaseShape lowerSemiCircle = new Ellipse(stripeThickness * 2.5 - 5, stripeThickness * 3 - 7).translate(new Point2d(stripeThickness / 2, -maxHeight / 5));
        for (Point2d point: lowerSemiCircle.getCoords()) {
            if (point.Y() > -maxHeight / 5)
                lowerSemiCircle.remove(point);
        }

        leftStripe.add(upperSemiCircle);
        leftStripe.add(lowerSemiCircle);

        return leftStripe;
    }

    // TODO
    public static BaseShape create_d() {
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness / 2, maxHeight / 2);
        BaseShape rightStripe = mainStripe.translate(new Point2d(spacing, 0.0));

        BaseShape upperCircle = new Ellipse(stripeThickness * 2, stripeThickness * 2).translate(new Point2d(-stripeThickness / 3, maxHeight / 4));

        BaseShape lowerCircle = new Ellipse(stripeThickness * 2 + 5, stripeThickness * 2 + 7).translate(new Point2d(-stripeThickness / 3, maxHeight / 4));

        rightStripe.add(upperCircle);
        rightStripe.add(lowerCircle);

        return rightStripe;
    }
}

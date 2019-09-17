#!/bin/bash

if test $1 && test $2
then
    if (($1 < $2))
    then
    zip -j $1_$2.zip src/tp1/Point2d.java src/tp1/PointOperator.java src/tp1/BaseShape.java src/tp1/Rectangle.java src/tp1/Ellipse.java src/tp1/LetterFactory.java
    else
    zip -j $2_$1.zip src/tp1/Point2d.java src/tp1/PointOperator.java src/tp1/BaseShape.java src/tp1/Rectangle.java src/tp1/Ellipse.java src/tp1/LetterFactory.java
    fi
else
echo "Manque un matricule"
fi

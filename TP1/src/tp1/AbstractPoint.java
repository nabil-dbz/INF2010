package tp1;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class AbstractPoint {
    protected Double[] vector;

    public AbstractPoint(Double[] vector) {
        this.vector = vector;
    }

    public abstract AbstractPoint translate(Double[] translateVector);
    public abstract AbstractPoint rotate(Double[][] rotationMatrix);
    public abstract AbstractPoint divide(Double divider);
    public abstract AbstractPoint multiply(Double multiplier);
    public abstract AbstractPoint add(Double adder);

    @Override
    public String toString() {
        return Arrays.stream(vector)
                .map(v -> String.valueOf(Math.round(v)))
                .collect(Collectors.joining(";"));
    }

    @Override
    public boolean equals(Object o) {
        AbstractPoint abstractPoint = (AbstractPoint)o;
        for (int i = 0; i < vector.length; ++i) {
            if (Math.round(vector[i]) != Math.round(abstractPoint.vector[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}

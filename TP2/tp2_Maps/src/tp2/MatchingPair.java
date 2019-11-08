package tp2;

public class MatchingPair {
    Integer first;
    Integer second;

    public MatchingPair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object other)
    {
        boolean isEqual = false;

        if (other != null && other instanceof MatchingPair)
        {
            MatchingPair otherPair = (MatchingPair) other;
            isEqual = (first.equals(otherPair.first) && second.equals(otherPair.second))
                    || (first.equals(otherPair.second) && second.equals(otherPair.first));
        }

        return isEqual;
    }
}

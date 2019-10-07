package tp2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Interview {
    /**
     * Finds all pairs within values which sum up to targetSum
     * @param values All possible values that can form a pair (can contain duplicates)
     * @param targetSum Pairs should add up to this
     * @return A collection containing all valid pairs with no permutations, but all combinations (empty collection if none found)
     */
    public Collection<MatchingPair> matchingPairs(Collection<Integer> values, Integer targetSum){
        LinkedHashMap<Integer, Boolean> map = new LinkedHashMap<Integer, Boolean>();
        Collection<MatchingPair> collectionRetour = new ArrayList<>();

        for (Integer element : values) {
            if ((map.get((targetSum - element)) != null)) {
                collectionRetour.add(new MatchingPair(element, targetSum - element));
            }
            else {
                map.put(element, true);
            }
        }
        return collectionRetour;
    }
}


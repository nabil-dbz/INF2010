package tests;

import tp3.AvlTree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AvlTreeTester {
    static private AvlTree<Integer> tree;
    static private final int BALANCED_TREE_SIZE = 7;
    public static Double start (){
        double subTotal = 0;

        // Every method not respecting its time complexity will remove 1.5 points
        Double timeComplexityPoints = 7.5;

        subTotal += Corrector.executeUnitTest("contains", AvlTreeTester::contains, 0.5);
        subTotal += Corrector.executeUnitTest("removePerfectCase", AvlTreeTester::removePerfectCase, 0.5);
        subTotal += Corrector.executeUnitTest("cannotContainDuplicates", AvlTreeTester::cannotContainDuplicates, 0.5);
        subTotal += Corrector.executeUnitTest("findMin", AvlTreeTester::findMin, 0.5);

        subTotal += Corrector.executeUnitTest("getHeight", AvlTreeTester::getHeight, 0.5);
        subTotal += Corrector.executeUnitTest("infixOrder", AvlTreeTester::infixOrder, 0.5);
        subTotal += Corrector.executeUnitTest("levelOrder", AvlTreeTester::levelOrder, 1.0);

        // Rotations do not need to be implemented until these tests
        subTotal += Corrector.executeUnitTest("rotateLeftPerfectCase", AvlTreeTester::rotateLeftPerfectCase, 2.0);
        subTotal += Corrector.executeUnitTest("rotateRightPerfectCase", AvlTreeTester::rotateRightPerfectCase, 0.5);

        subTotal += Corrector.executeUnitTest("removeBalances", AvlTreeTester::removeBalances, 0.5);

        subTotal += Corrector.executeUnitTest("doubleRotateOnLeftPerfectCase", AvlTreeTester::doubleRotateOnLeftPerfectCase, 2.0);
        subTotal += Corrector.executeUnitTest("doubleRotateOnRightPerfectCase", AvlTreeTester::doubleRotateOnRightPerfectCase, 0.5);

        subTotal += Corrector.executeUnitTest("completeBalancingTest", AvlTreeTester::completeBalancingTest, 2.0);

        return subTotal + timeComplexityPoints;
    }

    public static boolean contains(){
        setUp();

        boolean containsOnEmptyTree = tree.contains(0);

        insertBalancedTree();

        boolean containsOnFilledTree = true;
        for (int value = 0; value < BALANCED_TREE_SIZE && containsOnFilledTree; ++value){
            containsOnFilledTree = tree.contains(value);
        }

        return !containsOnEmptyTree && containsOnFilledTree;
    }

    public static boolean removePerfectCase(){
        setUp();
        insertBalancedTree();

        boolean areRemoved = true;

        tree.remove(0);
        areRemoved &= !tree.contains(0) && tree.contains(2);
        tree.remove(2);
        areRemoved &= !tree.contains(2) && tree.contains(4);
        tree.remove(4);
        areRemoved &= !tree.contains(4) && tree.contains(6);
        tree.remove(6);
        areRemoved &= !tree.contains(6) && tree.contains(1);


     /*   // First level
        tree.remove(1);
        areRemoved &= !tree.contains(1) && tree.contains(5);
        tree.remove(5);
        areRemoved &= !tree.contains(5) && tree.contains(3);
*/

        // Root
        tree.remove(3);
        areRemoved &= !tree.contains(3);

        return areRemoved;
    }

    public static boolean cannotContainDuplicates(){
        setUp();

        int duplicatedValue = 1;
        tree.insert(duplicatedValue);
        tree.insert(duplicatedValue);

        boolean containedValue = tree.contains(duplicatedValue);

        tree.remove(duplicatedValue);

        boolean removedValue = !tree.contains(duplicatedValue);

        return containedValue && removedValue;
    }

    public static boolean findMin() {
        setUp();

        boolean returnsNullIfEmpty = tree.findMin() == null;

        insertBalancedTree();

        Integer minimum = tree.findMin();
        boolean returnsMinimalValue = minimum != null && minimum.equals(0);

        return returnsNullIfEmpty && returnsMinimalValue;
    }

    public static boolean getHeight() {
        setUp();

        boolean worksWithEmptyTree = tree.getHeight() == -1;

        boolean worksWithRegularCases = true;

        // Root
        tree.insert(3);
        worksWithRegularCases &= tree.getHeight() == 0;

        // First level
        tree.insert(1);
        worksWithRegularCases &= tree.getHeight() == 1;
        tree.insert(5);
        worksWithRegularCases &= tree.getHeight() == 1;

        // Second level
        tree.insert(2);
        worksWithRegularCases &= tree.getHeight() == 2;
        tree.insert(4);
        worksWithRegularCases &= tree.getHeight() == 2;
        tree.insert(6);
        worksWithRegularCases &= tree.getHeight() == 2;

        // Third level
        tree.insert(7);
        worksWithRegularCases &= tree.getHeight() == 3;

        return worksWithEmptyTree && worksWithRegularCases;
    }

    public static boolean infixOrder(){
        setUp();
        insertBalancedTree();

        List<Integer> result = tree.infixOrder();

        List<Integer> sortedList = IntStream.range(0, BALANCED_TREE_SIZE).boxed().collect(Collectors.toList());

        return result.equals(sortedList);
    }

    public static boolean levelOrder() {
        setUp();
        insertBalancedTree();

        List<Integer> result = tree.levelOrder();

        List<Integer> levelOrderedList = Arrays.asList(3, 1, 5, 0, 2, 4, 6);

        return result.equals(levelOrderedList);
    }

    public static boolean rotateRightPerfectCase(){
        setUp();

        tree.insert(0);
        tree.insert(1);
        tree.insert(2);

        boolean isBalanced = tree.getHeight() == 1;

        List<Integer> result = tree.infixOrder();
        List<Integer> sortedList = IntStream.range(0, 3).boxed().collect(Collectors.toList());
        boolean isRotatedProperly = result.equals(sortedList);

        return isBalanced && isRotatedProperly;
    }

    public static boolean rotateLeftPerfectCase(){
        setUp();

        tree.insert(2);
        tree.insert(1);
        tree.insert(0);

        boolean isBalanced = tree.getHeight() == 1;

        List<Integer> result = tree.infixOrder();
        List<Integer> sortedList = IntStream.range(0, 3).boxed().collect(Collectors.toList());
        boolean isRotatedProperly = result.equals(sortedList);

        return isBalanced && isRotatedProperly;
    }

    public static boolean doubleRotateOnRightPerfectCase(){
        setUp();

        tree.insert(2);

        tree.insert(1);
        tree.insert(5);

        tree.insert(0);
        tree.insert(4);
        tree.insert(6);

        tree.insert(3);

        tree.remove(0);

        boolean isBalanced = tree.getHeight() == 2;

        List<Integer> result = tree.infixOrder();
        List<Integer> sortedList = IntStream.range(1, 7).boxed().collect(Collectors.toList());
        boolean isRotatedProperly = result.equals(sortedList);

        return isBalanced && isRotatedProperly;
    }

    public static boolean doubleRotateOnLeftPerfectCase(){
        setUp();

        tree.insert(4);

        tree.insert(1);
        tree.insert(5);

        tree.insert(0);
        tree.insert(2);
        tree.insert(6);

        tree.insert(3);

        tree.remove(6);

        boolean isBalanced = tree.getHeight() == 2;

        List<Integer> result = tree.infixOrder();
        List<Integer> sortedList = IntStream.range(0, 6).boxed().collect(Collectors.toList());
        boolean isRotatedProperly = result.equals(sortedList);

        return isBalanced && isRotatedProperly;
    }

    public static boolean removeBalances(){
        setUp();

        tree.insert(1);

        tree.insert(0);
        tree.insert(2);

        tree.insert(3);

        tree.remove(0);

        boolean isBalanced = tree.getHeight() == 1;

        List<Integer> result = tree.infixOrder();
        List<Integer> sortedList = IntStream.range(1, 4).boxed().collect(Collectors.toList());
        boolean isRotatedProperly = result.equals(sortedList);

        return isBalanced && isRotatedProperly;
    }

    public static boolean completeBalancingTest(){
        int n = 10;
        int expectedHeight =  (int) Math.floor(Math.log(n) / Math.log(2)); // Numerically instable calculation, won't work for all n values

        // Insertion to the left
        setUp();

        for (int i = n; i > 0; --i){ tree.insert(i); }

        boolean goodLeftInsertionHeight = tree.getHeight() == expectedHeight;

        List<Integer> sortedList = IntStream.range(1, n+1).boxed().collect(Collectors.toList());
        List<Integer> leftResult = tree.infixOrder();
        boolean leftInsertionRotatedProperly = leftResult.equals(sortedList);

        // Insertion to the right
        setUp();

        for (int i = 0; i < n; ++i) { tree.insert(i); }

        boolean goodRightInsertionHeight = tree.getHeight() == expectedHeight;

        List<Integer> rightResult = tree.infixOrder();
        sortedList = IntStream.range(0, n).boxed().collect(Collectors.toList());
        boolean rightInsertionRotatedProperly = rightResult.equals(sortedList);

        return goodLeftInsertionHeight && leftInsertionRotatedProperly && goodRightInsertionHeight && rightInsertionRotatedProperly;
    }

    private static void setUp(){
        tree = new AvlTree<Integer>();
    }

    /**
     *  Produces the following tree
     *               3
     *             /   \
     *           1      5
     *          / \    / \
     *         0   2  4   6
     */
    private static void insertBalancedTree(){

        // Root
        tree.insert(3);

        // First level
        tree.insert(1);
        tree.insert(5);

        // Second level
        tree.insert(0);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
    }
}

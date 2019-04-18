import java.util.*;

class CombinationSum {
    protected List<List<Integer>> findAllPossibilities(int[] diceValues, int dices, int expectedTotal) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (dices <= 0 || expectedTotal <= 0 || dices > expectedTotal) {
            return result;
        }

        List<Integer> combinations = new ArrayList<Integer>();
        findAllPossibilities(diceValues, expectedTotal, 0, dices, combinations, result);

        return result;
    }

    private void findAllPossibilities(int[] diceValues, int expectedTotal, int sumSoFar, int dices, List<Integer> combinations, List<List<Integer>> result) {
        if (sumSoFar > expectedTotal || combinations.size() > dices) {
            return;
        }

        if (sumSoFar == expectedTotal && combinations.size() == dices) {
            result.add(new ArrayList<Integer>(combinations));
            return;
        }

        for (int i = 0; i < diceValues.length; i++) {
            combinations.add(diceValues[i]);
            findAllPossibilities(diceValues, expectedTotal, sumSoFar + diceValues[i], dices, combinations, result);
            combinations.remove(combinations.size() - 1);
        }

    }

    public static void main(String[] arr) {
        CombinationSum sum = new CombinationSum();

        int[] diceValues = {1, 2, 3, 4, 5, 6};
        int totalDice = 2;
        int expectedTotal = 10;

        System.out.println(sum.findAllPossibilities(diceValues, totalDice, expectedTotal));
    }
}

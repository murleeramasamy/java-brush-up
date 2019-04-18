import java.util.*;

class Permutations {
    public List<List<Character>> findPermutations(List<Character> list) {
        List<List<Character>> result = new ArrayList<List<Character>>();

        if (list.isEmpty()) {
            return result;
        }

        if (list.size() == 1) {
            result.add(new ArrayList<Character>(list));
            return result;
        }

        Character ch = list.remove(0);

        List<List<Character>> subSolutions = findPermutations(list);

        for (List<Character> subSolution : subSolutions) {
            for (int i = 0; i <= subSolution.size(); i++) {
                List<Character> tmpList = new ArrayList<Character>(subSolution);
                tmpList.add(i, ch);
                result.add(tmpList);
            }
        }

        return result;
    }


    public static void main(String[] arr) {
        Permutations permutations = new Permutations();

        List<Character> list = new ArrayList<Character>();
        list.add('A');
        list.add('B');
        list.add('C');

        System.out.println(permutations.findPermutations(list));
    }
}

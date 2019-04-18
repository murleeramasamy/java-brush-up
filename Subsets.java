import java.util.*;

class Subsets {
    public List<List<Integer>> getSubsets(List<Integer> numbers, int size) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsetsRec(numbers, 0, new ArrayList<>(), subsets, size);
        return subsets;
    }

    private void subsetsRec(List<Integer> numbers, int start, List<Integer> prefix, List<List<Integer>> subsets, int size) {
        if (prefix.size() == size) {
            subsets.add(new ArrayList<Integer>(prefix));
            return;
        }

        prefix.add(numbers.get(start));
        subsetsRec(numbers, start + 1, prefix, subsets, size);
        prefix.remove(prefix.size() - 1);
        subsetsRec(numbers, start + 1, prefix, subsets, size);
    }

    public static void main(String[] arr) {
        Subsets subset = new Subsets();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        
        System.out.println(subset.getSubsets(list, 2));
    }
}

class FindMinimum {
    public int findMinimum(int[] input) {
        if (input.length == 0) {
            return Integer.MIN_VALUE;
        }

        return findMinimum(input, 0, input.length - 1);
    }

    private int findMinimum(int[] input, int start, int end) {
        if (start >= end) {
            return input[start];
        }

        int mid = (end - start) / 2 + start;

        if (mid > 0 && input[mid] < input[mid - 1]) {
            return input[mid];
        }
       
        if (input[mid] < input[end]) {
            return findMinimum(input, start, mid - 1);
        } else {
            return findMinimum(input, mid + 1, end);
        }
    }

    public static void main(String[] arr) {
        FindMinimum find = new FindMinimum();

        //int[] input = {1, 2, 3, 4, 4, 5};
        //int[] input = {11, 12, 13, 14, 14, 5};
        //int[] input = {11, 12, 3, 4, 4, 5};
        int[] input = {11, 12, 13, 14, 4, 5};
        //int[] input = {};
        //int[] input = {1};
        //int[] input = {1, 2};
        //int[] input = {2, 1};

        System.out.println(find.findMinimum(input));
    }
}

class Solution {
    public List<List<Integer>> perm(int index, List<Integer> processed, int[] unprocessed) {
        List<List<Integer>> res = new ArrayList<>();
        if (index == unprocessed.length) {
            res.add(new ArrayList<>(processed));
        } else {
            for (int i = 0; i <= processed.size(); i++) {
                processed.add(i, unprocessed[index]);
                res.addAll(perm(index + 1, processed, unprocessed));
                processed.remove(i);
            }
        }
        return res;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> processed = new ArrayList<>();
        return perm(0, processed, nums);
    }
}

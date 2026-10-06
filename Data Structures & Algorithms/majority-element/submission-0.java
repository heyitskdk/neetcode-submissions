class Solution {
    public int majorityElement(int[] nums) {
        // In O(n) space
        int n = nums.length;
        int answer = -1;
        Map<Integer, Integer> elements = new HashMap<>();
        for (int num: nums) {
            int frequency = elements.getOrDefault(num, 0);
            frequency++;
            elements.put(num, frequency);
            if (frequency > n/2) {
                answer = num;
                break;
            }
        }

        return answer;
    }
}
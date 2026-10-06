class Solution {
    public boolean isAnagram(String s, String t) {
        // edge case
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> freq = new HashMap<>();
        char[] arr = s.toCharArray();
        for (char c: arr) {
            int frequency = freq.getOrDefault(c, 0);
            frequency++;
            freq.put(c, frequency);
        }

        char[] arr2 = t.toCharArray();
        for (char c: arr2) {
            if (freq.containsKey(c) && freq.get(c) != 0) {
                int frequency = freq.get(c);
                frequency--;
                freq.put(c, frequency);
            } else {
                return false;
            }
        }

        return true;
    }
}

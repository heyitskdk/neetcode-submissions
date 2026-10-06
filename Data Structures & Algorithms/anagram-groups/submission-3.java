class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        String[] strings = Arrays.copyOf(strs, strs.length);

        // Sorting individual Strings inside the array
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            char[] letters = string.toCharArray();
            Arrays.sort(letters);
            strings[i] = new String(letters);
        }

        // Group equal strings together
        // Using HashMap to create buckets
        Map<String, List<String>> buckets = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            List<String> bucket = buckets.getOrDefault(strings[i], new ArrayList<>());
            bucket.add(strs[i]);
            buckets.put(strings[i], bucket);
        }

        for (List<String> bucket : buckets.values()) {
            anagrams.add(bucket);
        }

        return anagrams;
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int min = Integer.MAX_VALUE;
        for (String str: strs) {
            if(str.length() < min) {
                min = str.length();
                sb.delete(0, sb.length());
                sb.append(str);
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return answer.toString();
                }
            }
            answer.append(c);
        }

        return answer.toString();
    }
}

class Solution {
    public String smallestSubsequence(String s) {

        int[] last = new int[26];
        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            int index = ch - 'a';

            if (visited[index]) {
                continue;
            }

            while (!st.isEmpty() &&
                   st.peek() > ch &&
                   last[st.peek() - 'a'] > i) {

                visited[st.pop() - 'a'] = false;
            }

            st.push(ch);
            visited[index] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : st) {
            ans.append(ch);
        }

        return ans.toString();
    }
}

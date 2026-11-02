class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int left = 1;
        int right = position[position.length - 1] - position[0];
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canPlace(position, m, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canPlace(int[] position, int m, int distance) {
        int count = 1;
        int last = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= distance) {
                count++;
                last = position[i];
            }
        }

        return count >= m;
    }
}

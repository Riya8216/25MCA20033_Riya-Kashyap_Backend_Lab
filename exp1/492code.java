class Solution {
    public int[] constructRectangle(int area) {
        for (int w = (int) Math.sqrt(area); w >= 1; w--) {
            if (area % w == 0) {
                int l = area / w;
                return new int[]{l, w};
            }
        }

        return new int[]{area, 1};
    }
}

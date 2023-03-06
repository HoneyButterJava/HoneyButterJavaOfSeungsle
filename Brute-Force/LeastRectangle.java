class Solution {
    public int solution(int[][] sizes) {
        int width_tmp = Integer.MIN_VALUE;
        int height_tmp = Integer.MIN_VALUE;
        for (int i = 0; i < sizes.length; i++) {
            width_tmp = Math.max(Math.max(sizes[i][0], sizes[i][1]), width_tmp);
            height_tmp = Math.max(Math.min(sizes[i][0], sizes[i][1]), height_tmp);
        }
        return width_tmp * height_tmp;
    }
}

public class LeastRectangle {
    public static void main(String[] args) {
        int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        Solution solution = new Solution();
        int answer = solution.solution(sizes);
        System.out.println(answer);
    }
}
import java.util.*;

class TargetNumberSolution {
    private int target;
    private int[] numbers;
    private int max_depth;

    private int solve(int idx, int sum) {
        int ret = 0;
        if (idx == max_depth) {
            if (this.target == sum) {
                return 1;
            } else {
                return 0;
            }
        } else {
            ret += solve(idx + 1, sum + this.numbers[idx]);
            ret += solve(idx + 1, sum - this.numbers[idx]);
        }
        return ret;
    }

    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        this.max_depth = numbers.length;
        int answer = solve(0, 0);
        return answer;
    }
}

public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        TargetNumberSolution solution = new TargetNumberSolution();
        int answer = solution.solution(numbers, target);
        System.out.println(answer);
    }
}
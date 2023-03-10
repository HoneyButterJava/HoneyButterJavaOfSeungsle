import java.util.*;

class KNumSolution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] sliced_array = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(sliced_array);
            answer[i] = sliced_array[commands[i][2] - 1];
        }
        return answer;
    }
}

public class KNum {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        KNumSolution solution = new KNumSolution();
        int[] answer = solution.solution(array, commands);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
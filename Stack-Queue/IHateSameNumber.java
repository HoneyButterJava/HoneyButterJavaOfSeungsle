import java.util.*;

class IHateSameNumberSolution {
    public int[] solution(int[] arr) {
        Vector<Integer> vector = new Vector<Integer>();
        int i = 0;

        vector.add(arr[i]);
        for (; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                vector.add(arr[i + 1]);
            }
        }
        int[] answer = vector.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("Hello Java");
        return answer;
    }
}

public class IHateSameNumber {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        IHateSameNumberSolution solution = new IHateSameNumberSolution();
        int answer[] = solution.solution(arr);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
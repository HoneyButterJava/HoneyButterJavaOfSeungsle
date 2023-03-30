import java.util.ArrayList;

class CarpetSolution {

    private ArrayList<Integer> make_cases(int sum_of_cases, int yellow) {
        int cases = sum_of_cases / 2;
        ArrayList<Integer> ret = new ArrayList<>();

        for (int i = 2; i < sum_of_cases / 2; i++) {
            if (yellow == (i + 1 - 2) * (sum_of_cases - (i + 1) - 2)) {
                ret.add(sum_of_cases - (i + 1)); // 가로
                ret.add(i + 1); // 세로
            }
        }
        return ret;
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum_of_cases = brown / 2 + 2;
        ArrayList<Integer> matrix = make_cases(sum_of_cases, yellow);
        for (int i = 0; i < 2; i++) {
            answer[i] = matrix.get(i);
        }
        return answer;
    }
}

public class Carpet {
    public static void main(String[] args) {
        CarpetSolution solution = new CarpetSolution();
        int answer[] = solution.solution(24, 24);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
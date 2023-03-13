import java.util.HashSet;

class PokemonSolution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return Math.min(set.size(), nums.length / 2);
    }
}

public class Pokemon {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 3};
        PokemonSolution solution = new PokemonSolution();
        int answer = solution.solution(arr);
        System.out.println(answer);
    }
}
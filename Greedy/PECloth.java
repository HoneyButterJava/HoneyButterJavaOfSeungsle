import java.util.*;

class PEClothSolution {

    private int answer;
    private int n;
    private List<Integer> lostList;
    private List<Integer> reserveList;
    private Map<Integer, Integer> clothesMap;

    private int searchList(List<Integer> list, int element) {
        return Collections.binarySearch(list, element);
    }

    private void initializeArrayToMap() {
        this.clothesMap = new HashMap<>();
        for (int i = 1; i <= this.n; i++) {
            int clothes = 1;
            this.clothesMap.put(i, clothes);
            if (searchList(this.lostList, i) >= 0) {
                clothes -= 1;
                this.clothesMap.put(i, clothes);
            }
            if (searchList(this.reserveList, i) >= 0) {
                clothes += 1;
                this.clothesMap.put(i, clothes);
            }
        }
    }

    private void calculate_cases() {
        for (int i = 1; i <= this.n; i++) {
            if (searchList(this.lostList, i) >= 0) {
                if (searchList(this.reserveList, i) >= 0) {
                    answer += 1;
                } else if (searchList(this.reserveList, i + 1) >= 0) {
                    this.clothesMap.put(i + 1, this.clothesMap.get(i + 1) - 1);
                } else if (searchList(this.reserveList, i - 1) >= 0) {
                    this.clothesMap.put(i - 1, this.clothesMap.get(i - 1) - 1);
                } else 
            }
        }
    }

    public int solution(int n, int[] lost, int[] reserve) {
        this.answer = 0;
        this.n = n;
        this.lostList = Arrays.stream(lost).boxed().toList();
        this.reserveList = Arrays.stream(reserve).boxed().toList();
        initializeArrayToMap();
        calculate_cases();
        return this.answer;
    }
}

public class PECloth {
    public static void main(String[] args) {
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};
        PEClothSolution solution = new PEClothSolution();
        int answer = solution.solution(n, lost, reserve);
        System.out.println(answer);
    }
}
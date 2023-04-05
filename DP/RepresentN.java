package DP;

import java.util.ArrayList;

class RepresentNSolution {

    private int numberGenerator(int n, int base) {
        int ret, tmp;
        ret = 0;
        for (int i = 0; i <= n; i++) {
            ret += (int) (base * Math.pow(10, i));
        }
        return ret;
    }
    private ArrayList<ArrayList<Integer>> getPair(int n) {
        ArrayList<ArrayList<Integer>> pairArray = new ArrayList<ArrayList<Integer>>();
        // 사실 더하기 곱하기는 반만 하면되는데 (n / 2)
        for (int i = 0; i < n; i++) {
            pairArray.add(new ArrayList<Integer>());
            pairArray.get(i).add(i);
            pairArray.get(i).add(n - i - 1);
        }
        return pairArray;
    }

    public int solution(int N, int number) {
        if (number > 32000 || N < 1 || N > 10) {
            return -1;
        }
        if (N == number) {
            return 1;
        }
        ArrayList<ArrayList<Integer>> Array = new ArrayList<ArrayList<Integer>>();
        Array.add(new ArrayList<Integer>());
        Array.get(0).add(N);
        for (int i = 1; ; i++) { // N 갯수
            if (i + 1 > 8) {
                return -1;
            }
            ArrayList<ArrayList<Integer>> pairArray = getPair(i);
            Array.add(new ArrayList<Integer>());
            for (int j = 0; j < pairArray.size(); j++) { // pair의 갯수
                int first = pairArray.get(j).get(0);
                int second = pairArray.get(j).get(1);
                int Origin = numberGenerator(i, N);
                Array.get(i).add(Origin);
                if (Origin == number) {
                    return i + 1;
                }
                for (int k = 0; k < Array.get(first).size(); k++) { // pair {i, n - i} 에서 i 3
                    for (int l = 0; l < Array.get(second).size(); l++) { // pair {i, n - i} 에서 n - i 2
                        Array.add(new ArrayList<Integer>());
                        int add = Array.get(first).get(k) + Array.get(second).get(l);
                        int sub = Array.get(first).get(k) - Array.get(second).get(l);
                        int multi = Array.get(first).get(k) * Array.get(second).get(l);
                        int div = 0;
                        if (Array.get(second).get(l) != 0) {
                            div = Array.get(first).get(k) / Array.get(second).get(l);
                        }
                        if (add == number || sub == number || multi == number || div == number) {
                            return i + 1;
                        }
                        Array.get(i).add(add);
                        Array.get(i).add(sub);
                        Array.get(i).add(multi);
                        Array.get(i).add(div);
                    }
                }
            }
        }
    }
}

public class RepresentN {
    public static void main(String[] args) {
        RepresentNSolution solution = new RepresentNSolution();
        int answer = solution.solution(5,12);
        System.out.println(answer);
    }
}

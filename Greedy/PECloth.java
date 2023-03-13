import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class PEClothSolution {
    private int answer = 0;
    private List<Integer> lostList;
    private List<Integer> reserveList;

    private List<Integer> arrayToList(int[] array) {
        List<Integer> newIntegerList = new ArrayList<Integer>();
        for (int element : array) {
            newIntegerList.add(element);
        }
        return newIntegerList;
    }

    private int searchList(List<Integer> list, int element) {
        return Collections.binarySearch(list, element);
    }

    private boolean removeElementIfExist(List<Integer> list, int element) {
        int index = searchList(list, element);
        if (index >= 0) {
            list.remove(index);
            this.answer++;
            return true;
        } else {
            return false;
        }
    }

    public int solution(int n, int[] lost, int[] reserve) {
        this.lostList = arrayToList(lost);
        this.reserveList = arrayToList(reserve);
        for (int studentNumber = 1; studentNumber <= n; studentNumber++) {
            int index;
            if ((index = searchList(this.lostList, studentNumber)) >= 0) {
                boolean ret = removeElementIfExist(this.reserveList, studentNumber) ||
                        removeElementIfExist(this.reserveList, studentNumber + 1) ||
                        removeElementIfExist(this.reserveList, studentNumber - 1);

            } else {
                this.answer++;
            }
        }
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
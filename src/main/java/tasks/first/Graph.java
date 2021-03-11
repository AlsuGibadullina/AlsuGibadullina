package tasks.first;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Graph {

    ArrayDeque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) {

    }

    public String breadthFirst(boolean[][] adjacencyMatrix, int indexStart) {
        ArrayList<Integer> result = new ArrayList<>();
        deque.offerFirst(indexStart);
        while (!deque.isEmpty()) {
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (adjacencyMatrix[indexStart][i] && !result.contains(i) && !inDeque(i)) {
                    deque.offerFirst(i);
                }
            }
            result.add(deque.pollLast());
            if (!deque.isEmpty()) {
                indexStart = deque.peekLast();
            }
        }
        return convertToString1(result);
    }

    private String convertToString(ArrayList<Integer> result) {
        String ans = "";
        for (int i = 0; i < result.size() - 1; i++) {
            ans = ans + result.get(i) + ", ";
        }
        ans = ans + result.get(result.size() - 1);
        return ans;
    }


    private String convertToString1(ArrayList<Integer> result) {
        String ans = result.toString();
        ans = ans.substring(1, ans.length() - 1);
        return ans;
    }

    private boolean inDeque(int i) {
        boolean a = false;
        for (int j = 0; j < deque.size(); j++) {
            Integer z = deque.pollFirst();
            if (z == i) {
                a = true;
            }
            deque.offerFirst(z);
        }
        return a;
    }
}

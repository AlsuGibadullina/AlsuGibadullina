package tasks.first;

import java.util.ArrayDeque;

public class FirstTaskSolution implements FirstTask {

    @Override
    public String breadthFirst(boolean[][] adjacencyMatrix, int startIndex) {
        Graph graph = new Graph();
        return graph.breadthFirst(adjacencyMatrix, startIndex);
    }

    @Override
    public Boolean validateBrackets(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case '(':
                case '[':
                case '{':
                    deque.offerFirst(s.charAt(i));
                    break;
                case ')':
                    if (!deque.isEmpty() && deque.getFirst() == '(') {
                        deque.removeFirst();
                    } else return false;
                    break;

                case ']':
                    if (!deque.isEmpty() && deque.getFirst() == '[') {
                        deque.removeFirst();
                    } else return false;
                    break;

                case '}':
                    if (!deque.isEmpty() && deque.getFirst() == '{') {
                        deque.removeFirst();
                    } else return false;

                    break;
            }
        }
        return deque.isEmpty();
    }

    @Override
    public Long polishCalculation(String s) {

        ArrayDeque<Long> deque = new ArrayDeque<>();
        String[] str = s.split(" ");
        Long result = Long.valueOf(0);
        for (String value : str) {
            if (!(value.equals("+") | value.equals("-") | value.equals("*") | value.equals("/"))) {
                deque.addLast(Long.parseLong(value));
            } else {
                result = deque.peekLast();
                deque.pollLast();
                if (value.equals("*")) {
                    try {
                        result = deque.peekLast() * result;
                    } catch (NullPointerException e) {
                        throw new IllegalArgumentException();
                    }
                }
                if (value.equals("/")) {
                    try {
                        result = deque.peekLast() / result;
                    } catch (NullPointerException e) {
                        throw new IllegalArgumentException();
                    }
                }
                if (value.equals("+")) {
                    try {
                        result = deque.peekLast() + result;
                    } catch (NullPointerException e) {
                        throw new NullPointerException();
                    }
                }
                if (value.equals("-")) {
                    try {
                        result = deque.peekLast() - result;
                    } catch (NullPointerException e) {
                        throw new IllegalArgumentException();
                    }
                }
                deque.pollLast();
                deque.addLast(result);
            }
        }
        deque.pollLast();
        if (deque.isEmpty()) {
            return result;
        } else {
            throw new IllegalArgumentException();
        }
    }
}

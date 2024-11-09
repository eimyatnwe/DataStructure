package solutions.pack12b_SSP;

import java.util.*;

public class Task3 {

    public int stateSpace(int[] beginState, int[] goalState) {
        if (Arrays.equals(beginState, goalState)) {
            return 0;
        }


        InterfaceSwapAdjacentPairs swapPairs = (State s) -> {
            int[] arr = s.getState().clone();
            for (int i = 0; i < arr.length - 1; i += 2) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
            return arr;
        };

        InterfaceSwapCorrespondingHalves swapHalves = (State s) -> {
            int[] arr = s.getState().clone();
            int mid = arr.length / 2;
            for (int i = 0; i < mid; i++) {
                int temp = arr[i];
                arr[i] = arr[i + mid];
                arr[i + mid] = temp;
            }
            return arr;
        };

        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new State(beginState, 0));
        visited.add(Arrays.toString(beginState));

        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            int[] currentArray = currentState.getState();
            int currentOps = currentState.getOperations();

            int[] newState1 = swapPairs.swapAdjacentPairs(currentState);
            if (Arrays.equals(newState1, goalState)) {
                return currentOps + 1; 
            }
            if (visited.add(Arrays.toString(newState1))) {
                queue.offer(new State(newState1, currentOps + 1));
            }

            int[] newState2 = swapHalves.swapCorrespondingHalves(currentState);
            if (Arrays.equals(newState2, goalState)) {
                return currentOps + 1; 
            }
            if (visited.add(Arrays.toString(newState2))) {
                queue.offer(new State(newState2, currentOps + 1));
            }
        }

        return -1;
    }
}
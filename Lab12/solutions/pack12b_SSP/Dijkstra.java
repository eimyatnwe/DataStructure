package solutions.pack12b_SSP;

import java.util.Arrays;

public class Dijkstra {
    int[][] adjMatrix;
    int[] previous, distance;
    boolean[] visted;
    int source;

    public Dijkstra(int[][] adjMatrix, int source) {
        this.adjMatrix = adjMatrix;
        this.source = source;
        previous = new int[adjMatrix.length];
        distance = new int[adjMatrix.length];
        visted = new boolean[adjMatrix.length];
    }
    
    //Task 1 imeplement the findSSP method using Dijkstra's algorithm
    public void findSSP() {
        for(int i = 0; i < adjMatrix.length; i++){
            distance[i] = Integer.MAX_VALUE;
            previous[i] = -1;
            visted[i] = false;
        }

        distance[source] = 0;
        previous[source] = source;

        for(int i = 0; i < adjMatrix.length; i++){
            int u = findDistance(distance, visted);
            if (u == -1) break;
            visted[u] = true;
            for(int v = 0; v < adjMatrix.length; v++){
                if(!visted[v] && adjMatrix[u][v] != -1 && distance[u] + adjMatrix[u][v] < distance[v]){
                    distance[v] = distance[u] + adjMatrix[u][v];
                    previous[v] = u;
                }
            }
        }
    }

    public static int findDistance(int[] distance, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < distance.length; i++){
            if(!visited[i] && distance[i] < min){
                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }


    //Task 2 implement the printAllSSP method to print the shortest path 
    //from the source to all other nodes
    public void printAllSSP() {
        System.out.println(Arrays.toString(distance)); 
        System.out.println(Arrays.toString(previous)); 

        for (int dest = 0; dest < adjMatrix.length; dest++) {
            System.out.print("Shortest path from " + source + " to " + dest + " is ");
            printPath(dest);
            System.out.println("\nwith a distance of " + distance[dest] + "\n");
        }
    }

    // Print the path from source to a destination node
    private void printPath(int dest) {
        if (dest == source) {
            System.out.print(source);
            return;
        }

        if (previous[dest] == -1) {
            System.out.print("No path");
            return;
        }

        printPath(previous[dest]);
        System.out.print(" -> " + dest);
    }

}

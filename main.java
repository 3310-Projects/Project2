import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.*;
import java.utiil.*;
import java.io.*;

class ShortestPath{
    static int inf=99999;
    int length;
    public static void main(String args[]){
        //Declare test graph adjacency matrix
        int matrixGraph[][] = {   
            {0,6,inf,1,inf,inf,5},
            {inf,0,inf,inf,1,inf,inf},
            {2,inf,0,3,inf,inf,inf,},
            {inf,inf,inf,0,4,inf,inf},
            {inf,inf,inf,2,0,inf},
            {inf,inf,inf,inf,2,0,inf},
            {3,inf,2,inf,inf,6,0}
      };
       ShortestPath sp = new ShortestPath();
       sp.dijkstra(matrixGraph, 6);
    }
    public void dijkstra(int graph[][], int sourceNode){
        length = graph.length;
        int distance[] = new int[length];
        Boolean previous[] = new Boolean[length];
        for(int i = 0; i < length; i ++){
            distance[i] = inf;
            previous[i] = false;
        }
        distance[sourceNode] = 0;
        for (int i = 0; i < length - 1; i++){
            int k = minimumDistance(distance, previous);
            previous[k] = true;
            for (int j = 0; j < length - 1; j++)
                if(!previous[j] && graph[k][j] != 0 && distance[k] + graph[k][j] < distance[j] && distance[k] != inf ){
                    distance[j] = distance[k] + graph[k][j];
                }
        }
        printArray(distance);
    }
    public int minimumDistance(int distance[], Boolean previous[]){
        int minimum = inf;
        int minimum_index = -1;
        for(int i = 0; i < length; i++){
            if(previous[i] == false && distance[i] <= minimum){
                minimum = distance[i];
                minimum_index = i;
            }
        }
        return minimum_index;
    }
    void printArray(int distance[])
    {
        System.out.print("Vertex:   ");
        for (int i = 0; i < length; i++){
            System.out.print(((char)(i+65)) + " ");
          
        }
        System.out.println();
        System.out.print("Distance: ");
        for (int i = 0; i < length; i++){
            System.out.print(distance[i] + " ");
        }

    }
  
    public static void printGraph(int graph[][])
    {
        int n = graph.length;
        for (int i=0; i<n-1; i++)
        {
            for (int j=0; j<n-1; j++)
            {
                if (graph[i][j]== inf)
                    System.out.print("Inf");
                else 
                    System.out.print(graph[i][j]+"  ");
            }
            System.out.println();
        }
    }

}
 

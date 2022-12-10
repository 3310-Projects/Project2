public class FloydWarshall 
{
    public static int inf=99999;
    public static void main(String[] args)
    {
        // int matrixGraph[][] = {   {0,10,inf,inf,5},
        //                           {inf,0,1,inf,2},
        //                           {inf,inf,0,4,inf},
        //                           {7,inf,6,0,inf},
        //                           {inf,3,9,2,0},
        //                         };
        int matrixGraph[][] = {   {0,3,inf,7},
                                  {8,0,2,inf},
                                  {5,inf,0,1},
                                  {2,inf,inf,0}
                                };
    
        
        allPairsShortestPath(matrixGraph);

    }
    public static void printGraph(int graph[][])
    {
        int n = graph.length;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {
                if (graph[i][j]== inf)
                    System.out.print("Inf");
                else 
                    System.out.print(graph[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static void allPairsShortestPath(int graph[][])
    {
        int n = graph.length;
        int[][] prev = new int[n][n];
        /*        for  𝑢 ← 1 to 𝑛 do
                    for  𝑣 ← 1 to 𝑛 do
                        𝐷0[u,v] ← 𝑤(𝑢,𝑣) 
        */
        for (int u=0; u<n; u++)
        {
            for (int v=0; v<n; v++)
            {
                prev[u][v]= graph[u][v];
            }
        }

        /*
            for  𝑘 ← 1 to 𝑛 do
                for  𝑢 ← 1 to 𝑛 do
                    for  𝑣 ← 1 to 𝑛 do
                        𝐷k[u,v] ← min(𝐷k-1[u,v],𝐷k-1[u,k]+𝐷k-1[k,v])
         */ 
        for (int k=0; k<n; k++)
        {
            for (int u=0; u<n; u++)
            {
                for (int v=0; v<n; v++)
                {
                    
                    if (prev[u][k]+prev[k][v]< prev[u][v])
                    {
                        prev[u][v]= prev[u][k]+prev[k][v];
                    }
                }

            }
        }
        //return 𝐷k
       printGraph(prev);


    }

    
}

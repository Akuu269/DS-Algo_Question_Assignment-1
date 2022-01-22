// DFS For Graph
// Question >= Graph contain  a src ,  vertex and a destination vertex.
//2.  find if a path exists between src and dest. If it does, print true otherwise print false
import java.util.*;
public class dfsForGraph {
    // Edge class
    public static class Edge{
        int src;
        int nbr;
        int wt;
        public Edge(int src , int nbr , int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;

        }
    }

    // add Edge
    public static void addEdge(ArrayList<Edge>[] graph , int src , int nbr , int wt){
        graph[src].add(new Edge(src, nbr, wt));
        graph[nbr].add(new Edge(nbr, src , wt));
     

    }
    // Creation 
    public static ArrayList<Edge>[] creation(){
        int n = 7;
        ArrayList<Edge>[] graph = new ArrayList[n];
        // to provide memory of arraylist of every index array
        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }

        addEdge(graph , 0 , 1 , 10);
        addEdge(graph , 0 , 3 , 40);
        addEdge(graph, 1 , 2 , 10);
        addEdge(graph , 2 , 3 , 10);
        addEdge(graph , 3 , 4 , 2);
        addEdge(graph , 4 , 5 , 3);
        addEdge(graph , 4 , 6 , 8);
        addEdge(graph , 5 , 6 , 3);

        return graph;
        

    }
    // Display
    public static void display(ArrayList<Edge>[] graph){
        for(int v = 0 ; v < graph.length; v++){
            System.out.print("[" + v + "] -> ");
            for(Edge e : graph[v]){
                System.out.print("[" + e.src + "-" + e.nbr + " @ " + e.wt + "], ");
            }
            System.out.println();
        }
    }
    
    // Src To Dst has Path or not
    
    public static boolean hasPath(ArrayList<Edge>[] graph , int src , int dst , 
    boolean[] vis){
        if (src == dst){
            return true;
        }
        vis[src] = true;
        for(Edge e : graph[src] ){
            int nbr = e.nbr;
            if(vis[nbr] == false){
                boolean res = hasPath(graph , nbr , dst , vis );
                if(res == true) return true;
            }
        }
        return false;
    }

    public static void demo(){
        int n = 7;
        ArrayList<Edge>[] graph = creation();
        display(graph);
        int src = 0;
        int dst = 6;
        boolean[] vis = new boolean[n];
        boolean res = hasPath(graph, src, dst, vis);
        System.out.println("Has Path From " + src + " To " + dst + " : " + res);

    }
    public static void main(String[] args) {
        demo();
    }
}

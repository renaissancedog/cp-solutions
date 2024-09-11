//This Dijkstra implementation is built with a Node class and this class.
import java.util.*;
public class MyDijkstra {
  public static void dijkstra(int[][] graph, int start) {
    int n = graph.length;
    //min distances stored in dist
    int[] dist = new int[n];

    //has node been visited?
    boolean[] visited = new boolean[n];
    PriorityQueue<Node> pq = new PriorityQueue<>();
    
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;
    pq.add(new Node(start, 0));
    
    while (!pq.isEmpty()) {
      //picks next node and removes it
      Node currentNode = pq.poll();
      int u = currentNode.id;
      
      if (visited[u]) continue;
      visited[u] = true;
      
      for (int v = 0; v < n; v++) {
        //if a node connects to this node and it has not been explored
        if (graph[u][v] != 0 && !visited[v]) {
          int newDist = dist[u] + graph[u][v];
          //if dist from u is less than v's current distance
          if (newDist < dist[v]) {
            dist[v] = newDist;
            pq.add(new Node(v, dist[v]));
          }
        }
      }
    }
    
    System.out.println("Vertex\tDistance from Source");
    for (int i = 0; i < n; i++) {
      System.out.println(i + "\t\t" + dist[i]);
    }
  }
  
  public static void main(String[] args) {
    int[][] graph = {
      {0, 10, 0, 0, 0, 0},
      {10, 0, 5, 0, 0, 0},
      {0, 5, 0, 15, 0, 0},
      {0, 0, 15, 0, 20, 0},
      {0, 0, 0, 20, 0, 25},
      {0, 0, 0, 0, 25, 0}
    };
    
    MyDijkstra.dijkstra(graph, 5);
  }
}

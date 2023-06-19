import java.util.*;

public class graphImp {

    // defination of an edge
    static class Edge {
        int src;// source
        int dest;// destination
        int wt;// weight

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
            this.wt = 1;
        }
    }

    // BFS || Time Complixity - O (V + E)
    // V = vertices E = edges
    public static void BFS(ArrayList<Edge> graph[]) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        q.add(0);// source
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                visited[curr] = true;
                System.out.print(curr + " ");
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // DFS || Time Complixity - O (V + E)
    // V = vertices E = edges
    public static void DFS(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        System.out.print(curr + " ");
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                DFS(graph, e.dest, visited);
            }
        }
    }

    // has path function: it will check a particular path form a node to another
    // node exists or not
    public static boolean hasPath(ArrayList<Edge> graph[], int source, boolean visited[], int destination,
            ArrayList<Integer> path) {
        visited[source] = true;
        if (source == destination) {
            return true;
        }
        for (int i = 0; i < graph[source].size(); i++) {
            Edge e = graph[source].get(i);
            if (!visited[e.dest]) {
                if (hasPath(graph, e.dest, visited, destination, path)) {
                    path.add(e.dest);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 4));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));

        ArrayList<Integer> path = new ArrayList<>();
        System.out.println(hasPath(graph, 0, new boolean[graph.length], 6, path));
        System.out.println(path);
    }
}
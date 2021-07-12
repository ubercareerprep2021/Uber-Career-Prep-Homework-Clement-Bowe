import java.util.*;

public class GraphWithAdjacencyList {

    private Map<GraphNode, List<GraphNode>> graph;

    static class GraphNode {
        public int data;

        GraphNode(int data) {
            this.data = data;
        }
    }

    /**
     * creates a new empty graph
     */
    public GraphWithAdjacencyList() {
        graph = new HashMap<GraphNode, List<GraphNode>>();
    }

    /**
     * adds a GraphNode to the graph
     * 
     * @param key
     */
    public void addNode(int key) {
        GraphNode node = new GraphNode(key);
        graph.put(node, new ArrayList<GraphNode>());
    }

    /**
     * adds an undirected Edge between key1 and key2
     * 
     * @param key1
     * @param key2
     */
    public void addEdge(int key1, int key2) {
        GraphNode node1 = new GraphNode(key1);
        GraphNode node2 = new GraphNode(key2);
        graph.get(node1).add(node2);
        graph.get(node2).add(node1);
    }

    /**
     * adds directed edge between two nodes
     * 
     * @param key1
     * @param key2
     */
    public void addDirectedEdge(int key1, int key2) {
        GraphNode node1 = new GraphNode(key1);
        GraphNode node2 = new GraphNode(key2);
        graph.get(node1).add(node2);
    }

    /**
     * 
     * @param key removes a graphnode from the graph
     */
    public void removeNode(int key) {
        GraphNode node = new GraphNode(key);
        graph.values().stream().forEach(e -> e.remove(node));
        graph.remove(new GraphNode(key));
    }

    /**
     * removes edges between two graphnodes
     * 
     * @param key1
     * @param key2
     */
    public void removeEdge(int key1, int key2) {
        GraphNode node1 = new GraphNode(key1);
        GraphNode node2 = new GraphNode(key2);
        List<GraphNode> list1 = graph.get(node1);
        List<GraphNode> list2 = graph.get(node2);
        if (list1 != null) {
            list1.remove(node2);
        }
        if (list2 != null) {
            list2.remove(node1);
        }
    }

    /**
     * 
     * @param key
     * @return adjacency list of the given key
     */
    public List<GraphNode> getAdjNodes(int key) {
        GraphNode node = new GraphNode(key);
        return graph.get(node);
    }

    /**
     * performs a dfs from a starting node
     * 
     * @param key
     */
    public void DFSGraph(int key) {
        Set<GraphNode> visited = new HashSet<>();
        GraphNode startNode = new GraphNode(key);
        Stack<GraphNode> graphNodeStack = new Stack<>();
        graphNodeStack.push(startNode);
        while (!graphNodeStack.isEmpty()) {
            GraphNode currentNode = graphNodeStack.pop();
            List<GraphNode> adjList = getAdjNodes(currentNode.data);
            for (int i = 0; i < adjList.size(); i++) {
                GraphNode adjNode = adjList.get(i);
                if (!visited.contains(adjNode)) {
                    graphNodeStack.push(adjNode);
                }
            }
        }
    }

    /**
     * performs BFS traversal of the graph
     * 
     * @param key
     */
    public void BFSGraph(int key) {
        Set<GraphNode> visited = new HashSet<>();
        GraphNode startNode = new GraphNode(key);
        Queue<GraphNode> graphNodeQueue = new LinkedList<>();
        graphNodeQueue.add(startNode);
        while (!graphNodeQueue.isEmpty()) {
            GraphNode currentNode = graphNodeQueue.poll();
            List<GraphNode> adjList = getAdjNodes(currentNode.data);
            for (int i = 0; i < adjList.size(); i++) {
                GraphNode adjNode = adjList.get(i);
                if (!visited.contains(adjNode)) {
                    graphNodeQueue.add(adjNode);
                }
            }
        }
    }

    /**
     * 
     * @param node1
     * @param node2
     * @return - the length of shortest path between two nodes in the graph if it
     *         exists otherwise it will return -1.
     * 
     */
    public int minNumberOfEdges(int node1, int node2) {
        HashMap<Integer, Integer> pathLengths = new HashMap<>();
        for (GraphNode node : graph.keySet()) {
            if (node.data != node1) {
                pathLengths.put(node.data, -1);
            }
        }
        pathLengths.put(node1, 0);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { node1, 0 });
        while (!queue.isEmpty()) {
            int[] currentNodeandSteps = queue.poll();
            int currentNodeData = currentNodeandSteps[0];
            int currentStepsData = currentNodeandSteps[1];
            if (currentNodeData == node2) {
                pathLengths.put(currentNodeData, currentStepsData);
            }
            List<GraphNode> currentAdjacencyList = getAdjNodes(currentNodeData);
            for (int i = 0; i < currentAdjacencyList.size(); i++) {
                int adjacentGraphNode = currentAdjacencyList.get(i).data;
                if (pathLengths.get(adjacentGraphNode) == -1) {
                    queue.add(new int[] { adjacentGraphNode, currentStepsData + 1 });
                } else {
                    if(pathLengths.get(adjacentGraphNode) > currentStepsData+1){
                        queue.add(new int[] {adjacentGraphNode, currentStepsData+1});
                    }
                }
            }
        }

        return pathLengths.get(node2);
    }

}
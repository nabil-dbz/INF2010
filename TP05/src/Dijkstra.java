import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;



public class Dijkstra {

	private Graph graph;
	private Map<Node, Edge> dijkstraTable[];
	private Stack<Edge> path;
	private Map<Integer, Node> visitedNodes;
	

	public Dijkstra (Graph g) {
		this.graph = g;
		this.visitedNodes =  new HashMap<>();
	}

	public void findPath(Node s, Node d) {

		dijkstraTable = new HashMap[graph.getNodes().size()];
		path = new Stack<Edge>();

		int i = 1;

		this.dijkstraTable[0] = new HashMap<Node, Edge>();
		dijkstraTable[s.getId()].put(s, new Edge(s, s));
		visitedNodes.put(s.getId(), s);

		while(path.empty() || !path.peek().getDestination().equals(d)) {
			this.dijkstraTable[i] = new HashMap<Node, Edge>(this.dijkstraTable[i-1]);
			this.dijkstraTable[i].remove(s);
			for (Edge edg : s.getArcs()) {
				Edge lastEdgeSameDestination = this.dijkstraTable[i-1].get(edg.getDestination());
				if(lastEdgeSameDestination == null || lastEdgeSameDestination.getDistance() > edg.getDistance() + path.peek().getDistance())
					if (!visitedNodes.containsValue(edg.getDestination())) {
						this.dijkstraTable[i].put(edg.getDestination(), edg);
						if (!path.empty()) this.dijkstraTable[i].get(edg.getDestination()).setDistance(edg.getDistance() + path.peek().getDistance());
					}
			}
			Node min = getMinimum(this.dijkstraTable[i]);
			path.push(dijkstraTable[i].get(min));
			visitedNodes.put(min.getId(), min);
			s = min;
			i++;
		}
	}

	private Node getMinimum(Map<Node, Edge> map) {
		Edge min = null;
		for (Node Key : map.keySet()) {
			if ( min == null || map.get(Key).getDistance() < min.getDistance()) {
				min = map.get(Key); 
			}
		}
		return min.getDestination();
	}

	private Edge getMinimum (Edge e1, Edge e2) {
		if (e1 == null && e2 == null)
			return null;
		if (e1 == null)
			return e2;
		if (e2 == null)
			return e1;
		return (e1.getDistance() > e2.getDistance()) ? e2 : e1;
	}
	
	public String printShortPath(Node source, Node destination) {
		// A completer
		return null;
	}

	public void showTable() {
		// A completer
		
	}
}

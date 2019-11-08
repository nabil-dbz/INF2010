import java.util.ArrayList;
import java.util.List;



public class Graph {

	private List<Node> nodes; // Noeuds
	private List<Edge> edges; // Les arcs
	
	public Graph() {
		nodes = new ArrayList<>();
		edges = new ArrayList<>();
	}
	
	public List<Edge> getEdgesGoingFrom(Node source) {
		ArrayList<Edge> listRetour = new ArrayList<>();
		for (Edge edge : edges)
			if (edge.getSource().equals(source))
				listRetour.add(edge);
		return listRetour;
	}
	public List<Edge> getEdgesGoingTo(Node dest) {
		ArrayList<Edge> listRetour = new ArrayList<>();
		for (Edge edge : edges)
			if (edge.getDestination().equals(dest))
				listRetour.add(edge);
		return listRetour;
	}
	
	// Accesseurs 
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
}

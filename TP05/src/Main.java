import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		System.out.println("TP05 : Graphes");
		
		// Partie 1: A completer : Création du graphe
		ArrayList<Node> listNodes = new ArrayList<>();
		ArrayList<Edge> listEdges = new ArrayList<>();
		int id = 0;
		for (char caractere = 'A'; caractere < 'H'; caractere++)
			listNodes.add(new Node(id++, String.valueOf(caractere)));

		listEdges.add(new Edge(listNodes.get(0), listNodes.get(1), 2));
		listEdges.add(new Edge(listNodes.get(0), listNodes.get(2), 1));

		listEdges.add(new Edge(listNodes.get(1), listNodes.get(0), 2));
		listEdges.add(new Edge(listNodes.get(1), listNodes.get(2), 2));
		listEdges.add(new Edge(listNodes.get(1), listNodes.get(3), 1));
		listEdges.add(new Edge(listNodes.get(1), listNodes.get(4), 3));

		listEdges.add(new Edge(listNodes.get(2), listNodes.get(0), 1));
		listEdges.add(new Edge(listNodes.get(2), listNodes.get(1), 2));
		listEdges.add(new Edge(listNodes.get(2), listNodes.get(3), 4));
		listEdges.add(new Edge(listNodes.get(2), listNodes.get(4), 3));
		listEdges.add(new Edge(listNodes.get(2), listNodes.get(5), 5));

		listEdges.add(new Edge(listNodes.get(3), listNodes.get(1), 1));
		listEdges.add(new Edge(listNodes.get(3), listNodes.get(2), 4));
		listEdges.add(new Edge(listNodes.get(3), listNodes.get(5), 6));
		listEdges.add(new Edge(listNodes.get(3), listNodes.get(6), 5));

		listEdges.add(new Edge(listNodes.get(4), listNodes.get(1), 3));
		listEdges.add(new Edge(listNodes.get(4), listNodes.get(2), 3));
		listEdges.add(new Edge(listNodes.get(4), listNodes.get(5), 1));

		listEdges.add(new Edge(listNodes.get(5), listNodes.get(2), 5));
		listEdges.add(new Edge(listNodes.get(5), listNodes.get(3), 6));
		listEdges.add(new Edge(listNodes.get(5), listNodes.get(4), 1));
		listEdges.add(new Edge(listNodes.get(5), listNodes.get(6), 2));

		listEdges.add(new Edge(listNodes.get(6), listNodes.get(3), 5));
		listEdges.add(new Edge(listNodes.get(6), listNodes.get(5), 2));
		g.setNodes(listNodes);
		g.setEdges(listEdges);

		// Affichage du graphe
		for (Node node : g.getNodes()) {
			for (int i = 0; i < node.getNbArcs(); i++) {
				System.out.print(node.getArc(i).getSource().getName() + " -> ");
				System.out.println(node.getArc(i).getDestination().getName());
			}
		}
		System.out.println();

		// Partie 2: A completer : Implémentation de l’algorithme Dijkstra
		
		Dijkstra d = new Dijkstra(g);
		
		d.findPath(null, null/* Spécifiez les paramètres */);
		
		d.showTable();

		// Partie 3 : Afficher le chemin le plus court
		System.out.println(d.printShortPath(null, null/* Spécifiez les paramètres */));
	
	}
}

import java.util.ArrayList;
import java.util.List;

public class Node {

	private int id;
	private String name;
	private int longitude;
	private int altitude;
	private List<Edge> arcs;
	
	public Node(int id, String n, int longitude, int altitude) {
		this.id = id;
		this.name = n;
		this.longitude = longitude;
		this.altitude = altitude;
		this.arcs = new ArrayList<>();
	}

	public Node(int id, String n) {
		this.id = id;
		this.name = n;
		this.longitude = 0; 
		this.altitude = 0;
		this.arcs = new ArrayList<>();
	}
	
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	} 
	
	@Override
	public int hashCode() {
		return id;
	}

	
	public int getLongitude() {
		return longitude;
	}

	
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	
	public int getLaltitude() {
		return altitude;
	}

	
	public void setLaltitude(int laltitude) {
		this.altitude = laltitude;
	}

	public Edge getArc(int index) { return this.arcs.get(index); }

	public void setArc(Edge edge) { this.arcs.add(edge); }

	public int getNbArcs() { return this.arcs.size(); }

}

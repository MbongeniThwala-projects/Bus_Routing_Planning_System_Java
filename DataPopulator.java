package csc3a.ui;


import com.jwetherell.algorithms.data_structures.Graph;

public class DataPopulator {

	private Station Walkerville;
	private Station Pimville;
	private Station[] stations;
	private Graph<String> graph;
	
	
	
	public DataPopulator()
	{
		
		graph = populateGraph();
		
		System.out.println(graph.toString());
		
		populateStations();
	}
	
	public Graph<String> populateGraph()
	{
		System.out.println("Populating the graph");
		Graph<String> graph = new Graph<>();
		
		//graph.Vertex(Pimville, Walkerville);
		
		//graph.addEdge("Pimville");
		
		//add data to the graph
		//graph.pathTo(Pimville);		

		return graph;
	}
	
	private void addStations() {
		
		stations = new Station[1];
		stations[0] = Pimville;
		stations[1] = Walkerville;
	}
	
	private void populateStations()
	{
		System.out.println("Creating stations");
		Pimville = new Station("Pimville");
		Walkerville = new Station("Walkerville");
		addStations();
	}
	
	public Station[] getStations()
	{
		return this.stations;
	}
	
	public Station getStation(int selectedStation)
	{
		return stations[selectedStation];
	}
}



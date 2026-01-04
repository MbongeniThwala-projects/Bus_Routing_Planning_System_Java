package csc3a.ui;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.jwetherell.algorithms.data_structures.Graph;
import com.jwetherell.algorithms.data_structures.Graph.Vertex;


public class DrawPath {

	public static <T> HashMap<T, Double> shortestPath(Graph<String> location, Station from) {
        HashMap<T, Double> shortestDistances = new HashMap<>();
        PriorityQueue<VertexDistance<T>> priorityQueue = new PriorityQueue<>();
        
        // Initialize all distances to infinity except for the source vertex
        for (Vertex<String> vertex : location.getVertices()) {
            if (vertex.getData().equals(from)) {
                shortestDistances.put((T) vertex.getData(), 0.0);
            } else {
                shortestDistances.put((T) vertex.getData(), Double.POSITIVE_INFINITY);
            }
        }
        
        priorityQueue.offer(new VertexDistance<>((T) from, 0.0));
        
        while (!priorityQueue.isEmpty()) {
            VertexDistance<T> currentVertex = priorityQueue.poll();
            T current = currentVertex.getVertex();
            
            if (currentVertex.getDistance() > shortestDistances.get(current)) {
                continue;  // Skip if a shorter path to current has already been found
            }
            
            for (com.jwetherell.algorithms.data_structures.Graph.Edge<String> edge : location.getEdges()) {
                T neighbor = (T) edge.getDestination();//.getData();
                double distanceThroughCurrent = shortestDistances.get(current) + edge.getWeight();
                
                if (distanceThroughCurrent < shortestDistances.get(neighbor)) {
                    shortestDistances.put(neighbor, distanceThroughCurrent);
                    priorityQueue.offer(new VertexDistance<>(neighbor, distanceThroughCurrent));
                }
            }
        }
        
        return shortestDistances;
    }

	public static ArrayList<Station> shortestUnweightedPath(Graph<String> location, Station from, Station to) {
		// TODO Auto-generated method stub
ArrayList<Station> shortestPath = new ArrayList<>();
        
        // Perform a breadth-first search (BFS) to find the shortest unweighted path
        
        // Keep track of visited stations
        HashSet<Station> visited = new HashSet<>();
        
        // Keep track of the parent station for each visited station
        HashMap<Station, Station> parentMap = new HashMap<>();
        
        // Use a queue for BFS
        Queue<Station> queue = new LinkedList<>();
        queue.offer(from);
        visited.add(from);
        
        while (!queue.isEmpty()) {
            Station currentStation = queue.poll();
            
            if (currentStation.equals(to)) {
                // Found the destination, construct the shortest path
                buildShortestPath(shortestPath, parentMap, from, to);
                break;
            }
            
            // Visit all neighboring stations
            for (Station neighbor : location.getNeighbors(currentStation)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, currentStation);
                    queue.offer(neighbor);
                }
            }
        }
        
        return shortestPath;
    }
    
    private static void buildShortestPath(ArrayList<Station> shortestPath, HashMap<Station, Station> parentMap, Station from, Station to) {
        // Build the shortest path list by backtracking from the destination to the source
        Station currentStation = to;
        while (currentStation != null) {
            shortestPath.add(0, currentStation);
            currentStation = parentMap.get(currentStation);
        }
    }
    }
    
    class VertexDistance<T> implements Comparable<VertexDistance<T>> {
        private T vertex;
        private double distance;
        
        public VertexDistance(T vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        
        public T getVertex() {
            return vertex;
        }
        
        public double getDistance() {
            return distance;
        }
        
        @Override
        public int compareTo(VertexDistance<T> other) {
            return Double.compare(distance, other.distance);
        }
    
    
    /** public static <T> ArrayList<T> shortestUnweightedPath(Graph<T> graph, T source, T end) {
            HashMap<T, T> predecessorMap = new HashMap<>();
            Queue<T> queue = new LinkedList<>();
            
            queue.offer(source);
            
            while (!queue.isEmpty()) {
                T current = queue.poll();
                
                if (current.equals(end)) {
                    break;  // Found the end vertex
                }
                
                for (com.jwetherell.algorithms.data_structures.Graph.Edge<T> edge : graph.getEdges()) {
                    T neighbor = edge.getDestination();
                    
                    if (!predecessorMap.containsKey(neighbor)) {
                        predecessorMap.put(neighbor, current);
                        queue.offer(neighbor);
                    }
                }
            }
            
            return buildPath(predecessorMap, source, end);
        }
        
        public static <V> ArrayList<V> buildPath(HashMap<V, V> predecessorMap, V source, V end) {
            ArrayList<V> path = new ArrayList<>();
            V current = end;
            
            while (current != null) {
                path.add(current);
                
                if (current.equals(source)) {
                    break;  // Reached the source vertex
                }
                
                current = predecessorMap.get(current);
            }
            
            Collections.reverse(path);
            return path;
      }*/

		
}

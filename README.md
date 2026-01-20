# Bus_Routing_Planning_System_Java
This is a JavaFX based Bus Route Planning System that allows users to find the shortest route between bus stations

🚍 Bus Route Planning System
A JavaFX GUI application for visualizing and calculating optimal bus routes between stations using graph algorithms. The system supports both least stops (unweighted BFS) and shortest distance (weighted Dijkstra-like) pathfinding methods.

📌 Features
Interactive GUI built with JavaFX for station selection and route visualization

Graph-based routing using custom Graph, Vertex, and Edge data structures

Two route-finding algorithms:

Least Stops (Unweighted BFS)

Shortest Distance (Weighted Dijkstra)

Visual station mapping with draggable nodes and connecting edges

Dynamic station selection via dropdown menus

Route calculation and display in a text area

🏗️ Project Structure
text
src/
├── csc3a/ui/
│   ├── Main.java              # JavaFX application entry point
│   ├── myPane.java            # Main UI layout and controls
│   ├── Station.java           # Station class representing bus stops
│   ├── DataPopulator.java     # Mock data generator for stations
│   ├── DrawPath.java          # Pathfinding algorithms (BFS & Dijkstra)
│   └── Edge.java              # Custom edge for drawing connections
├── com/jwetherell/algorithms/data_structures/
│   ├── Graph.java             # Generic Graph implementation
│   └── Path.java              # (Placeholder) Path representation

⚙️ Technologies Used:

-Java (JDK 8+)

-JavaFX (for UI)

-Graph Algorithms (BFS, Dijkstra)

-Object-Oriented Design

🎯 How It Works

-Launch the application to view the interactive map.

-Select From and To stations from dropdown menus.

-Choose a routing method: Least Stops or Shortest Distance.

-Click "Calculate Route" to compute and display the optimal path.

-View the route details in the results panel.


🚀 Future Enhancements

-Real-time bus tracking integration

-Database persistence for stations and routes

-Map zoom/pan functionality

-Multi-route comparison

-Export routes to PDF/CSV

📄 License

This project is for educational purposes as part of a university assignment.

👨‍💻 Author

Developed as part of a CSC3A (Data Structures & Algorithms) project.

package csc3a.ui;

import java.util.ArrayList;

import com.jwetherell.algorithms.data_structures.Graph;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class myPane {

	private Button btnRoute;
	
	private Text txtVertex1;
	private Text txtVertex2;
	private Text txtCost;
	private Text txtStation;
	private TextField txtLocation;
	
	private ArrayList<Station> result;
	
	private ComboBox<Station> comboBoxFrom, comboBoxTo;
	private ComboBox<String> comboBoxSearchType;
	
	private Station from, to;
	private Label  labelFrom, labelTo, labelResult, labelMethod, icon;
	
	private DataPopulator dataPopulator;
	private Graph<String> locations;
	String[] Methods = {"Least stops", "Shortest distance" };
	String method;
	
	public myPane()
	{
		
	}
	
	public BorderPane Gridpane()
	{
		BorderPane border = new BorderPane();
		Pane stack = new Pane();
		stack.setStyle("-fx-background-color: black;");
		stack.prefWidthProperty().bind(border.widthProperty());
		
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		
		border.setLeft(pane);
		border.setRight(stack);
		
		txtVertex1 = new Text("Vertex 1");
		txtVertex2 = new Text("Vertex 2");
		txtCost = new Text("Cost");
		pane.add(txtVertex1, 0, 5);
		pane.add(txtVertex2, 0, 6);
		pane.add(txtCost, 0, 7);
		
		
		labelTo= new Label("Please select the station you would like to go to");
		labelFrom = new Label("Please select your current location");
		labelMethod = new Label("Please select a route option");
		labelResult = new Label("Directions will display here");
		icon = new Label();
		Image image = new Image("C:\\Users\\tebza\\218091161__mimiProject\\data\\gau_province.gif");

	    // Create an Icon with the Image
	    /**ImageView icon = new ImageView(image);
	    icon.setFitWidth(132);
	    icon.setFitHeight(132);*/
		
		pane.add(icon, 2, 1);
	    pane.add(labelFrom, 2, 2);
	    pane.add(labelResult, 2, 3);
		pane.add(labelMethod, 2, 4);
		pane.add(labelTo, 2, 5);
	    
		pane.setAlignment(Pos.TOP_LEFT);
		
		txtStation = new Text("Stations[0-30]");
		txtLocation = new TextField();
		TextArea txtArea = new TextArea();
		
		txtArea.setPrefWidth(300);
		pane.add(txtArea, 1, 8);
		pane.add(txtLocation, 1, 1);
		
		btnRoute = new Button("Find route");
		pane.add(btnRoute, 1, 2);
		
		btnRoute.setOnAction(event->{
			String text = "Create stations";
			txtArea.setText(text);
			DataPopulator populate = new DataPopulator();
			
		});
		
		Button btnCalculate = new Button("Calculate route");
		pane.add(btnCalculate, 1, 3);
		
		btnCalculate.setOnAction(event->{
			System.out.println("---- Least stops----");
			result = DrawPath.shortestUnweightedPath(locations, from, to);
			System.out.println("---- calculating path----");
			System.out.println(result.toString());
			labelResult.setText(result.toString());
		});
		
		return border;
	}
	
	private Pane createToPanel() {
	    FlowPane pane = new FlowPane();
	    ObservableList<Station> stations = FXCollections.observableArrayList(dataPopulator.getStations());
	    ComboBox<String> comboBoxTo = new ComboBox<>();
	    comboBoxTo.setOnAction(e -> {
	        to = dataPopulator.getStation(comboBoxTo.getSelectionModel().getSelectedIndex());
	    });
	    
	    Label labelTo = new Label("To:");
	    pane.getChildren().addAll(labelTo, comboBoxTo);
	    
	    return pane;
	}
	
	private Pane createMethodPanel() {
	    FlowPane pane = new FlowPane();
	    ObservableList<String> methods = FXCollections.observableArrayList(Methods);
	    ComboBox<String> comboBoxSearchType = new ComboBox<>(methods);
	    comboBoxSearchType.setOnAction(e -> {
	        method = comboBoxSearchType.getSelectionModel().getSelectedItem();
	    });
	    
	    Label labelMethod = new Label("Method:");
	    pane.getChildren().addAll(labelMethod, comboBoxSearchType);
	    
	    return pane;
	}
	
	private Pane createFromPanel() {
	    FlowPane pane = new FlowPane();
	    ObservableList<Station> stations = FXCollections.observableArrayList(dataPopulator.getStations());
	    ComboBox<Station> comboBoxFrom = new ComboBox<>(stations);
	    comboBoxFrom.setOnAction(e -> {
	        from = comboBoxFrom.getSelectionModel().getSelectedItem();
	    });
	    
	    Label labelFrom = new Label("From:");
	    pane.getChildren().addAll(labelFrom, comboBoxFrom);
	    
	    return pane;
	}
	
	private Pane createResultsPanel() {
	    FlowPane pane = new FlowPane();
	    Label labelResult = new Label("Results:");
	    pane.getChildren().add(labelResult);
	    
	    return pane;
	}
	
	private Pane createFormPanel() {
	    GridPane pane = new GridPane();
	    pane.setVgap(10);
	    pane.setPadding(new Insets(10));

	    pane.add(createFromPanel(), 2, 7);
	    pane.add(createToPanel(), 2, 8);
	    pane.add(createMethodPanel(), 2, 9);
	    pane.add(createResultsPanel(), 2, 10);

	    return pane;
	}
	
	public static Ellipse DrawVertex(String text, int weight, int XX, int YY, Pane stack, Text txtNode) {
        // Create the ellipse shape
        Ellipse ellipse = new Ellipse(XX, YY, weight / 2, weight / 2);
        ellipse.setStyle("-fx-fill: white; -fx-stroke: black;"); // Set the fill and stroke color

        // Create and set the text node
        txtNode.setText(text);
        txtNode.setFont(Font.font("Arial", 14));
        txtNode.setX(XX - (weight / 4));
        txtNode.setY(YY + 5);

        // Add the ellipse and text node to the pane
        stack.getChildren().addAll(ellipse, txtNode);
        
        txtNode.setOnMouseReleased(event->{
        	stack.getChildren();
        });
        return ellipse; // Return the created ellipse shape
    }
}

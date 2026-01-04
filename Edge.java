import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Polyline;

public class Edge {

	private SimpleDoubleProperty point1 = new SimpleDoubleProperty();
	private SimpleDoubleProperty point2 = new SimpleDoubleProperty();
	private SimpleDoubleProperty des1 = new SimpleDoubleProperty();
	private SimpleDoubleProperty des2 = new SimpleDoubleProperty();
	private Polyline Line;
	
	public SimpleDoubleProperty getPoint1()
	{
		return point1;
	}
	
	public void setPoint1(SimpleDoubleProperty Point1)
	{
		point1 = Point1;
	}
	
	public SimpleDoubleProperty getPoint2()
	{
		return point2;
	}
	
	public void setPoint2(SimpleDoubleProperty Point2)
	{
		point2 = Point2;
	}
	
	public SimpleDoubleProperty getDes1()
	{
		return des1;
	}
	
	public void setDes1(SimpleDoubleProperty Des1)
	{
		des1 = Des1;
	}
	
	public SimpleDoubleProperty getDes2()
	{
		return des2;
	}
	
	public void setDes2(SimpleDoubleProperty Des2)
	{
		des2 = Des2;
	}
	
	public Edge(double point1, double des1, double point2, double des2)
	{
		Line = new Polyline();
		this.point1.set(point1);
		this.point2.set(point2);
		this.des1.set(des1);
		this.des2.set(des2);
		
		for(SimpleDoubleProperty d : new SimpleDoubleProperty[] 
				{getPoint1(), getDes1(), getPoint2(), getDes2()})
		{
			d.addListener((e, ev, ex)->Check());
		}
		Check();
	}

	private void Check() {
		// TODO Auto-generated method stub
		Line.getPoints().setAll(point1.get(), des1.get(), point2.get(), des2.get());
	}
}

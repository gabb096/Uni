import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public abstract class Rifiuto 
{
	protected Ellipse2D forma;
	
	public Rifiuto(double x, double y, double w, double h)
	{
		forma = new Ellipse2D.Double(x,y,w,h);
	}
	
	public boolean Contains(Point2D p)
	{
		if(forma.contains(p))
		return true;
		else
			return false;
	}
	
	public Rectangle2D getBounds2D()
	{
		return forma.getBounds2D();
	}
	
	
	public void setFrameFromCenter(double x, double y)
	{
		forma.setFrameFromCenter(x, y, x+forma.getWidth()/2, y+forma.getHeight()/2);
	}
	
	public abstract void  Draw(Graphics2D g);
	
}

class Misto extends Rifiuto
{

	public Misto(double x, double y, double w, double h) 
	{
		super(x, y, w, h);
	}

	public void Draw(Graphics2D g) 
	{
		g.setPaint(Color.gray);
		g.draw(forma);
		g.setPaint(Color.black);
		g.fill(forma);
	}
}

  class Umido extends Rifiuto
 {

 	public Umido(double x, double y, double w, double h) 
 	{
 		super(x, y, w, h);
 	}

 	public void Draw(Graphics2D g) 
 	{
 		g.setPaint(Color.yellow);
 		g.draw(forma);
 		g.setPaint(Color.green);
 		g.fill(forma);
 	}
 }

 class Vetro extends Rifiuto
 {

 	public Vetro(double x, double y, double w, double h) 
 	{
 		super(x, y, w, h);
 	}

 	public void Draw(Graphics2D g) 
 	{
 		g.setPaint(Color.blue);
 		g.draw(forma);
 		g.setPaint(Color.cyan);
 		g.fill(forma);
 	}
 }

 class Plastica extends Rifiuto
 {

 	public Plastica(double x, double y, double w, double h) 
 	{
 		super(x, y, w, h);
 	}

 	public void Draw(Graphics2D g) 
 	{
 		g.setPaint(Color.darkGray);
 		g.draw(forma);
 		g.setPaint(Color.gray);
 		g.fill(forma);
 	}
 }


 class Carta extends Rifiuto
 {

 	public Carta(double x, double y, double w, double h) 
 	{
 		super(x, y, w, h);
 	}

 	public void Draw(Graphics2D g) 
 	{
 		g.setPaint(Color.black);
 		g.draw(forma);
 		g.setPaint(Color.white);
 		g.fill(forma);
 	}
 }




/*
 Creare una classe MoveableSimpleEmoji che estenda ReframeableSimpleEmoji.
Deve avere come campo di classe un Point2D direction ed un float speed.
Il costruttore dovrà prendere come argomento un rettangolo e passarlo al 
costruttore della classe madre, e poi inizializzare direction con i valori (1,1) e speed a 5.
Deve avere un metodo move() che sposti la faccina lungo la direzione descritta da 
direction per un valore pari a speed ( le coordinate dovranno quindi cambiare di un 
fattore pari a speed moltiplicato per direction ); deve avere get e set per direction e speed.*/

import java.awt.geom.*;

public class ESE47_MovableSimpleEmoji extends ESE46_ReframeableSimpleEmoji
{

	Point2D direction;
	float speed;
	
	public ESE47_MovableSimpleEmoji(Rectangle2D rect) 
	{
		super(rect);
		direction = new Point2D.Double(1,1);
		speed = 5;
	}

	public void move() 
	{
		this.setFrame(new Rectangle2D.Double(face.getX()+(speed*direction.getX()), face.getY()+(speed*direction.getY()), face.getWidth(), face.getHeight() ));
	}
	
	public Point2D getDirection() 
	{
		return direction;
	}

	public void setDirection(Point2D d) 
	{
		direction = d;
	}

	public float getSpeed() 
	{
		return speed;
	}

	public void setSpeed(float s) 
	{
		speed = s;
	}

}

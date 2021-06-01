/*
 Creare una classe ExactMoveableSimpleEmoji che estenda MoveableSimpleEmoji.
Deve avere effettuare un override del metodo set per direction: questo nuovo metodo 
dovrà assicurarsi che dopo l'assegnazione direction sia nullo (con valori (0,0) ) 
oppure normalizzato ( ovvero che la sua norma definita come radice di x^2 + y^2 sia uguale a 1), 
nel caso in cui non rispetti nessuna delle due condizioni, questo metodo dovrà normalizzarlo 
( dividendo individualmente le due componenti X ed Y per il valore attuale della norma ).*/

import java.awt.geom.*;

public class ESE48_ExactMoveableSimpleEmoji extends ESE47_MovableSimpleEmoji
{

	public ESE48_ExactMoveableSimpleEmoji(Rectangle2D rect) 
	{
		super(rect);
		
	}
//216 181
	public void setDirection() 
	{		
		if(this.getDirection().getX()!=0 && this.getDirection().getX()!=0)
		   this.setDirection(new Point2D.Double(0,0));
	}
	
}

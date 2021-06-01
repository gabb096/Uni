/*
 Creare una classe SimpleEmoji che rappresenti una faccina.
Deve avere come variabili membro tre circonferenze 
( face, leftEye, rightEye ) e due colori ( faceColor e eyesColor ).
Deve avere un costruttore che prenda un rettangolo come argomento 
ed inizializzi le tre circonferenze: face dovrà essere centrata 
al centro del rettangolo, ma dovrà essere sempre un cerchio, 
non deve deformarsi se il rettangolo passato non corrisponde 
ad un quadrato (trovate voi la soluzione). 
Gli occhi devono avere come dimensioni la metà del raggio 
di face e devono essere posizionati adeguatamente 
(vedete voi come gestire le loro coordinate). 
Il costruttore dovrà anche inizializzare i due colori: 
essere GIALLO per faceColor e NERO per eyesColor.
Deve avere i metodi set e get per i suoi colori 
(ma non per le circonferenze).
Deve avere un metodo per disegnare su schermo la faccina 
contornandola con un bordo nero.
*/
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import java.awt.geom.Rectangle2D.Double;

import javax.swing.*;

public class ESE45_SimpleEmoji 
{

	Ellipse2D face, leftEye, rightEye, mouth ;
	Color faceColor, eyeColor;
	protected double raggio;
	
	public ESE45_SimpleEmoji(Rectangle2D rect)
	{
		face = new Ellipse2D.Double();
		leftEye = new Ellipse2D.Double();
		rightEye = new Ellipse2D.Double();
		mouth = new Ellipse2D.Double();
		
		if(rect.getHeight()<=rect.getWidth())
			raggio=rect.getHeight();
		else 
			raggio=rect.getWidth();
		
		face.setFrame(rect.getX(), rect.getY(), raggio, raggio);
		leftEye.setFrame(rect.getX()+raggio/6, rect.getMinY()+raggio/4, raggio/4, raggio/3);
		rightEye.setFrame(rect.getX()+4*raggio/6, rect.getMinY()+raggio/4, raggio/4, raggio/3);
		mouth.setFrame(rect.getX()+3*raggio/7, rect.getMinY()+3*raggio/5, raggio/5, raggio/3);
		
		 faceColor = Color.YELLOW;
		 eyeColor = Color.BLACK;
	}
	
	public void setFaceColor(Color colore) 
	{
		faceColor = colore;
	}
	
	public void setEyeColor(Color colore) 
	{
		eyeColor = colore;
	}
	
	public Color getFaceColor() 
	{
		return faceColor;
	}
	
	public Color getEyeColor() 
	{
		return eyeColor;
	}
	
	public void draw(Graphics2D g)
	{
	      g.setPaint(faceColor);
	      g.draw(face);
	      g.fill(face);
	      
	      g.setPaint(eyeColor);
	      g.draw(leftEye);
	      g.fill(leftEye);
	      g.draw(rightEye);
	      g.fill(rightEye);
	      
	      g.setPaint(Color.BLACK);
	      g.draw(mouth);
	      g.fill(mouth);
	      
	}
}

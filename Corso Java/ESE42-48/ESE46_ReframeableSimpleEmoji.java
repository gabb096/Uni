import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/*
Creare una classe ReframeableSimpleEmoji che estenda SimpleEmoji.
Deve avere un metodo setFrame() che prenda come argomento 
un rettangolo e riposizioni/ridimensioni la faccina al suo interno.

 */
public class ESE46_ReframeableSimpleEmoji extends ESE45_SimpleEmoji
{

	Rectangle2D re;
	
	public ESE46_ReframeableSimpleEmoji(Rectangle2D rect) 
	{
		super(rect);
		re=rect;
	}

	public void  setFrame(Rectangle2D rect) 
	{
		face.setFrame(rect.getX(), rect.getY(), raggio, raggio);
		leftEye.setFrame(rect.getX()+raggio/6, rect.getMinY()+raggio/4, raggio/4, raggio/3);
		rightEye.setFrame(rect.getX()+4*raggio/6, rect.getMinY()+raggio/4, raggio/4, raggio/3);
		mouth.setFrame(rect.getX()+3*raggio/7, rect.getMinY()+3*raggio/5, raggio/5, raggio/3);
	}
	
}

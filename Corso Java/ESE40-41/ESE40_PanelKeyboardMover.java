/*
 Creare una classe PanelKeyboardMover che estenda JFrame non ridimensionabile.
Il frame deve contenere un JPanel che deve poter ricevere il focus 
e avere un KeyListener.
Il frame non deve avere alcun layout manager ed il pannello dovra' 
avere posizioni assolute. Se l'utente preme sulle frecce direzionali, 
il pannello dovrà postarsi di qualche pixel nella direzione premuta.
Se l'utente preme sui caratteri WASD il pannello dovrà espandersi 
nella direzione selezionata ( W verso l'alto, A verso sinistra, S verso il basso, 
D verso destra).
Se l'utente preme sui caratteri RGBCMYK il pannello dovrà cambiare 
di colore ( R = red, G = green, .... K = black )*/

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class ESE40_PanelKeyboardMover extends JFrame
{

	JPanel pan;
	Random ran;
	int fw=600, fh=600,flx=450, fly=150,pw=50,ph=50;
	public ESE40_PanelKeyboardMover()
	{
		super("PanelKeyboardMover");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(fw , fh);
		this.setLocation(flx,fly);
		this.setLayout(null);
		this.setResizable(false);
		
		pan = new JPanel();
		pan = new JPanel();
		
		pan.setSize(new Dimension(50,50));
		pan.setBackground(Color.BLUE);
	
		pan.setBounds(this.getWidth()/2-25, this.getHeight()/2-25, 50, 50);
		this.add(pan);
		validate();
		ran = new Random();
		
		setFocusable(true);
		
		this.addKeyListener(new KeyListener() 
		{
			public void keyPressed(KeyEvent e) 
			{
				
				switch(e.getKeyCode()) 
				{
				case KeyEvent.VK_UP : pan.setBounds(pan.getX(), pan.getY()-10,pan.getWidth(), pan.getHeight());
						break;
				case KeyEvent.VK_LEFT : pan.setBounds(pan.getX()-10, pan.getY(),pan.getWidth(), pan.getHeight());
						break;
				case KeyEvent.VK_RIGHT : pan.setBounds(pan.getX()+10, pan.getY(),pan.getWidth(), pan.getHeight());
						break;
				case KeyEvent.VK_DOWN : pan.setBounds(pan.getX(), pan.getY()+10,pan.getWidth(), pan.getHeight());
						break;
				case KeyEvent.VK_W : pan.setBounds(pan.getX(), pan.getY()-10,pan.getWidth(), pan.getHeight()+10);
						break;
				case KeyEvent.VK_A : pan.setBounds(pan.getX()-10, pan.getY(),pan.getWidth()+10, pan.getHeight());
						break;
				case KeyEvent.VK_S : pan.setBounds(pan.getX(), pan.getY(),pan.getWidth(), pan.getHeight()+10);
						break;
				case KeyEvent.VK_D: pan.setBounds(pan.getX(), pan.getY(),pan.getWidth()+10, pan.getHeight());
						break;
				case KeyEvent.VK_R : pan.setBackground(Color.red);
						break;
				case KeyEvent.VK_G : pan.setBackground(Color.green);
						break;
				case KeyEvent.VK_B : pan.setBackground(Color.blue);
						break;
				case KeyEvent.VK_C : pan.setBackground(Color.cyan);
						break;
				case KeyEvent.VK_M : pan.setBackground(Color.magenta);
						break;
				case KeyEvent.VK_Y : pan.setBackground(Color.yellow);
						break;
				case KeyEvent.VK_K : pan.setBackground(Color.black);
						break;
					default: pan.setBackground(new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
							 validate();
						break;
				}
			}

			public void keyReleased(KeyEvent e) 
			{
			}

			public void keyTyped(KeyEvent e) 
			{
			}
		} );
	}
	
	public static void main(String [] args) 
	{
		ESE40_PanelKeyboardMover pkm = new ESE40_PanelKeyboardMover();
		pkm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
}
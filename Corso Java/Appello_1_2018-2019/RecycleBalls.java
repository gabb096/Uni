import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class RecycleBalls extends JFrame
{
	ArrayList<Rifiuto> rifiuti;
	Rifiuto selected, rif;
	Timer t;
	Rectangle2D cassonettoMisto, cassonettoUmido, cassonettoVetro, cassonettoPlastica, cassonettoCarta;
	int punti, tempoRimasto, random;
	double ranX,ranY;
	JLabel puntiLabel, tempoLabel;
	Random ran;
	JPanel panUp, panDown;
	
	public RecycleBalls()
	{
		setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(550,700));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		panUp = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				super.paintComponents(g);
				Graphics2D g2 =(Graphics2D) g;

				g2.setPaint(Color.gray);
		 		g2.draw(cassonettoMisto);
		 		g2.setPaint(Color.black);
		 		g2.fill(cassonettoMisto);
				
				g2.setPaint(Color.yellow);
		 		g2.draw(cassonettoUmido);
		 		g2.setPaint(Color.green);
		 		g2.fill(cassonettoUmido);
				
				g2.setPaint(Color.blue);
		 		g2.draw(cassonettoVetro);
		 		g2.setPaint(Color.cyan);
		 		g2.fill(cassonettoVetro);
				
				g2.setPaint(Color.darkGray);
		 		g2.draw(cassonettoPlastica);
		 		g2.setPaint(Color.gray);
		 		g2.fill(cassonettoPlastica);
				
				g2.setPaint(Color.black);
			 	g2.draw(cassonettoCarta);
			 	g2.setPaint(Color.white);
			 	g2.fill(cassonettoCarta);
				
				repaint();
			}
		};
		panUp.setSize(500, 600);
		panDown = new JPanel();
		panDown.setSize(50,600);
		
		tempoRimasto=20;
		punti = 0;
		
		cassonettoMisto = new Rectangle2D.Double(80,100,10,panUp.getHeight()-100);
		cassonettoUmido = new Rectangle2D.Double(80,100,cassonettoMisto.getX()+120,panUp.getHeight()-100);
		cassonettoVetro = new Rectangle2D.Double(80,100,cassonettoUmido.getX()+120,panUp.getHeight()-100);
		cassonettoPlastica = new Rectangle2D.Double(80,100,cassonettoVetro.getX()+120,panUp.getHeight()-100);
		cassonettoCarta = new Rectangle2D.Double(80,100,panUp.getWidth()-90,panUp.getHeight()-100);
		
		rifiuti = new ArrayList();
		
		puntiLabel = new JLabel(""+punti);
		tempoLabel = new JLabel(""+tempoRimasto);
		
		panDown.add(new JLabel("Punti: "));
		panDown.add(puntiLabel);
		panDown.add(new JLabel("Tempo: "));
		panDown.add(tempoLabel);
		
		this.addMouseMotionListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				for(int i=0;i<rifiuti.size();i++)
				{
					if(rifiuti.get(i).Contains(e.getPoint()))
					{
						selected = rifiuti.get(i);
					}
					else
						selected=null;
				}
			}
			public void mouseReleased(MouseEvent e)
			{
				selected=null;
			}
			
			public void mouseDragged(MouseEvent e)
			{
				selected.setFrameFromCenter(e.getX(), e.getY());
				
				if(cassonettoMisto.contains(e.getPoint()))
				{
					if(selected instanceof Misto)
					{
						punti+=25;
					}
					else 
						{
						selected=null;
						punti-=15;
						}
				}
				
				if(cassonettoUmido.contains(e.getPoint()))
				{
					if(selected instanceof Umido)
					{
						punti+=25;
					}
					else 
						{
						selected=null;
						punti-=15;
						}
				}
				
				if(cassonettoVetro.contains(e.getPoint()))
				{
					if(selected instanceof Vetro)
					{
						punti+=25;
					}
					else 
						{
						selected=null;
						punti-=15;
						}
				}
				
				if(cassonettoPlastica.contains(e.getPoint()))
				{
					if(selected instanceof Plastica)
					{
						punti+=25;
					}
					else 
						{
						selected=null;
						punti-=15;
						}
				}
				
				if(cassonettoCarta.contains(e.getPoint()))
				{
					if(selected instanceof Carta)
					{
						punti+=25;
					}
					else 
						{
						selected=null;
						punti-=15;
						}
				}
			}
		});
		
		t = new Timer(1000, new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			tempoRimasto--;
			tempoLabel.setText(""+tempoRimasto);
			validate();
			repaint();
			if(tempoRimasto<0)
			{
				t.stop();
				JOptionPane.showMessageDialog(getContentPane(), "tempo scaduto, hai fatto "+punti+" punti");
			}
				
			}
		});

		ran= new Random();
		
		for(int i=0; i<60;i++)
		{
			random = ran.nextInt(5);
			ranX = ran.nextInt(26)+25;
			ranY = ran.nextInt(326)+275;
			switch(random)
			{
			case 0: rif = new Misto(ranX,ranY,50,50);
				break;
			case 1: rif = new Umido(ranX,ranY,50,50);
				break;
			case 2: rif = new Vetro(ranX,ranY,50,50);
				break;
			case 3: rif = new Plastica(ranX,ranY,50,50);
				break;
			case 4: rif = new Carta(ranX,ranY,50,50);
				break;

			}
			rifiuti.add(rif);
		}
		
		
		add(panUp,BorderLayout.CENTER);
		add(panDown,BorderLayout.PAGE_END);
		
		validate();
		t.start();
		System.out.println("START");
	}
	
	
	
	
	public static void main(String [] a)
	{
		RecycleBalls r = new RecycleBalls();
	}

}

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class ESE20_PanelAdder extends JFrame // ESE 20
{
	JButton b1 = new JButton("RED");
	JButton b2 = new JButton("GREEN");
	JButton b3 = new JButton("BLUE");
	JButton b4 = new JButton("RANDOM");
	JPanel p = new JPanel();
	Random ran = new Random();
	
	public ESE20_PanelAdder() 
	{
		int x =100, y=70;
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		//this.setLocation(this.getX(), this.getX());
		this.setSize(600, 600);
		this.setLayout(new FlowLayout());
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		//add(p);
		
		b1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				JPanel p = new JPanel();
				p.setSize(x, y);
				p.setBackground(Color.RED);
				add(p);
				validate();
			}
			
		});		
		
		b2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				JPanel p = new JPanel();
				p.setSize(x, y);
				p.setBackground(Color.GREEN);
				add(p);
				validate();

			}
			
		});		
		
		b3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				JPanel p = new JPanel();
				p.setSize(x, y);
				p.setBackground(Color.BLUE);
				add(p);
				validate();

			}
			
		});		
		
		b4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				JPanel p = new JPanel();
				p.setSize(x, y);
				p.setBackground(Color.RED);
				int r,g,b;
				r = ran.nextInt(255);
				g = ran.nextInt(255);
				b = ran.nextInt(255);
				p.setBackground(new Color(r,g,b));
				add(p);
				validate();
			}
			
		});	
		
		
	}
	
	public static void main(String [] args) 
	{
		ESE20_PanelAdder pa = new ESE20_PanelAdder();
		pa.setVisible(true);
        pa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}

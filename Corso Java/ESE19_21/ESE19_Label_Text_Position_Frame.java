import java.net.URL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ESE19_Label_Text_Position_Frame extends JFrame // ESE 19
{
	
	URL icon_url = getClass().getResource("bug1.gif");
    Icon icon = new ImageIcon(  icon_url ); 
    JPanel p1 = new JPanel();
    
	JLabel label = new JLabel("Testo con Icona",icon,SwingConstants.CENTER);	
	
	
	JButton b1 = new JButton("Horizontal SX");
	JButton b2 = new JButton("Horizontal DX");
	JButton b3 = new JButton("Horizontal Center");
	JButton b4 = new JButton("Vertical Tøp");
	JButton b5 = new JButton("Vertical Bottom");
	JButton b6 = new JButton("Vertical Center");
	
	
	public ESE19_Label_Text_Position_Frame()
	{
		super("FINESTRONE");
		
		this .setLocationRelativeTo(null);
		this.setSize(600, 600);
		this.setLayout(new GridLayout(2,0));
		
		add(label,SwingConstants.CENTER);
		
		
		b1.addActionListener(  new ActionListener() 
        {
        		public void actionPerformed(ActionEvent e)
        		{
        			label.setHorizontalTextPosition(SwingConstants.LEFT);
        		}
        	});
		
		b2.addActionListener(  new ActionListener() 
        {
        		public void actionPerformed(ActionEvent e)
        		{
        			label.setHorizontalTextPosition(SwingConstants.RIGHT);
        		}
        	});
		
		b3.addActionListener(  new ActionListener() 
        {
        		public void actionPerformed(ActionEvent e)
        		{
        			label.setHorizontalTextPosition(SwingConstants.CENTER);
        		}
        	});
		
		b4.addActionListener(  new ActionListener() 
        {
        		public void actionPerformed(ActionEvent e)
        		{
        			label.setVerticalTextPosition(SwingConstants.TOP);
        		}
        	});
		
		b5.addActionListener(  new ActionListener() 
        {
        		public void actionPerformed(ActionEvent e)
        		{
        			label.setVerticalTextPosition(SwingConstants.BOTTOM);
        		}
        	});
		
		b6.addActionListener(  new ActionListener() 
        {
        		public void actionPerformed(ActionEvent e)
        		{
        			label.setHorizontalTextPosition(SwingConstants.CENTER);
        			label.setVerticalTextPosition(SwingConstants.CENTER);
        		}
        	});
		
		p1.setLayout(new GridLayout(0,3));
		add(p1);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);

	}
	
	public static void main(String [] args) 
	{
		ESE19_Label_Text_Position_Frame la = new ESE19_Label_Text_Position_Frame();
		la.setVisible(true);
        la.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

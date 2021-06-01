
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ESE30_TastierinoGrid extends JFrame
{
	JButton btn [] = new JButton [12] ;
	JTextField text = new JTextField("", 15);
	
		public ESE30_TastierinoGrid() 
		{
			super("TastierinoGrid");
			this.setVisible(true);
			this.setLocationRelativeTo(null);
			this.setSize(250 , 200);
			this.setLayout(new GridLayout(5,3));
			
			text.setEditable(false);
			
			for(int i=0;i<12;i++)
			{
				if(i==9)
					{
					btn[i]= new JButton("C");
					btn[i].addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							text.setText(text.getText().substring(0, text.getText().length()-1));
						}
						});
					}
				else 
					if(i==11)
						{
						btn[i]= new JButton("OK");
						btn[i].addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								System.out.println(text.getText() );
							}
							});
						}
					else 
						if(i==10)
							{
							btn[i]= new JButton("0");
							btn[i].addActionListener(new ActionListener() 
							{
								public void actionPerformed(ActionEvent e) 
								{
									text.setText(text.getText() + "0" );

								}
								});
							}
				else
					{
					btn[i]= new JButton(""+(i+1));
					int j = i;
					btn[i].addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							text.setText(text.getText() + btn[j].getText() );
						}
						});
					}
				
				this.add(btn[i]);
			}
			
			this.add(new JPanel());
			this.add(text);
		}

		
	public static void main(String [] args) 
	{
		ESE30_TastierinoGrid t = new ESE30_TastierinoGrid();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

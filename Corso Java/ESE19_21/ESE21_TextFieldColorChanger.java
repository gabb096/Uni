/*Creare una classe TextFieldColorChanger che estenda JFrame.
Il frame dovrà contenere 4 JPanel i cui nomi devono essere: 
RGBpanel, FBgroundPanel, ButtonPanel e TFpanel.
RGBpanel deve contenere 3 JCheckBox i cui testi siano "R", "G" e "B".
FBgroundPanel deve contenere 2 JRadioButton i cui testi siano "Foreground","Background". 
TFpanel deve contenere un JTextField con testo iniziale "Text Field Color Changer". 
ButtonPanel deve contenere un JButton con testo "Apply" che quando viene premuto 
deve cambiare il colore (di background o foreground in base al JRadioButton selezionato)
del JTextField creando un nuovo colore i cui tre valori (int) 
dovranno variare in base ai JCheckBox selezionati 
(ad esempio se "R" è selezionato, il primo intero del nuovo colore 
dovrà essere 255, altrimenti 0).
Numero di classi e variabili membro a scelta.*/

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class ESE21_TextFieldColorChanger extends JFrame // ESE 21
{
	JPanel RGBpanel = new JPanel();
	JPanel FBgroundPanel = new JPanel();
	JPanel ButtonPanel = new JPanel();
	JPanel TFpanel = new JPanel();
	JCheckBox rCB = new JCheckBox("R");
	JCheckBox gCB = new JCheckBox("G");
	JCheckBox bCB = new JCheckBox("B");
	JRadioButton foreRB = new JRadioButton("Foreground");
	JRadioButton backRB = new JRadioButton("Background");
	JTextField tf = new JTextField("Text Field Color Changer",15);
	JButton bt = new JButton("Apply");
	
	public ESE21_TextFieldColorChanger() 
	{
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(600 , 150);
		this.setLayout(new FlowLayout());
		
		this.add(tf);
		
		this.add(RGBpanel);
		RGBpanel.add(rCB);
		RGBpanel.add(gCB);
		RGBpanel.add(bCB);

		this.add(FBgroundPanel);
		FBgroundPanel.add(foreRB);
		FBgroundPanel.add(backRB);

		this.add(ButtonPanel);
		ButtonPanel.add(bt);
		bt.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				int val = Integer.parseInt(tf.getText());
				
				if(val >= 0 && val <= 255) 
				{
					if(foreRB.isSelected()) 
					{
						if(rCB.isSelected())
							tf.setForeground(new Color(val, 0 , 0 ));	 
						if(gCB.isSelected())
							tf.setForeground(new Color(0, val , 0));							
						if(bCB.isSelected())
							tf.setForeground(new Color(0, 0, val ));
					}
					 if (backRB.isSelected())
					{
						if(rCB.isSelected())
							tf.setBackground(new Color(val, 0 , 0 ));	
						if(gCB.isSelected())
							tf.setBackground(new Color(0, val , 0 ));
						if(bCB.isSelected())
							tf.setBackground(new Color(0, 0 , val ));
					}
				}
				validate();
			}
		});
		
		
		
	} 
	
	public static void main(String [] args) 
	{
		ESE21_TextFieldColorChanger t = new ESE21_TextFieldColorChanger();
		
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}

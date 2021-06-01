/*
 Creare una classe SplitPaneColorText che estenda Jframe.
Il frame deve contenere uno JsplitPane separato verticalmente 
(un componente in alto, l'altro in basso).
Il componente in basso deve contenere un JTextArea con testo iniziale 
"Text Area Color Changer".
Il componente in alto deve contenere un Jpanel che a sua volta contenga:
3 JPanel i cui nomi devono essere: RGBpanel, FBgroundPanel, ButtonPanel .
RGBpanel deve contenere 3 JCheckBox i cui testi siano "R", "G" e "B".
FBgroundPanel deve contenere 2 JRadioButton i cui testi siano 
"Foreground","Background". 
ButtonPanel deve contenere un JButton con testo "Apply" che quando 
viene premuto deve cambiare il colore (di background o foreground in 
base al JRadioButton selezionato) del JTextArea creando un nuovo colore
i cui tre valori (int) dovranno variare in base ai JCheckBox selezionati 
(ad esempio se "R" è selezionato, il primo intero del nuovo colore dovrà essere 255,
altrimenti 0).
*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ESE38_SplitPanelColorTest extends JFrame
{
	JSplitPane sp;
	JTextArea ta;
	JPanel pan, RGBpan,FBpan,btnPan;
	JCheckBox CBr,CBg,CBb;
	JRadioButton back, fore;
	JButton btn;
	int r,g,b;
	
	public ESE38_SplitPanelColorTest()
	{
		super("SplitPanelColorTest");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(600 , 600);
		this.setLocation(450,150);
        		
		ta = new JTextArea("Text Area Color Changer");
		
		pan = new JPanel();
		
		RGBpan = new JPanel();
		CBr = new JCheckBox("R");
		RGBpan.add(CBr);
		CBg = new JCheckBox("G");
		RGBpan.add(CBg);
		CBb = new JCheckBox("B");
		RGBpan.add(CBb);
		
		FBpan = new JPanel();
		back = new JRadioButton("BackGround");
		FBpan.add(back);
		fore = new JRadioButton("ForeGround");
		FBpan.add(fore);
	
		btnPan = new JPanel();
		btn = new JButton("APPLY");
		btnPan.add(btn);
	        
	        btn.addActionListener(new ActionListener() 
	        		{
	        			public void actionPerformed(ActionEvent e) 
	        			{
	        				if(back.isSelected()) 
	        				{
	        					if(CBr.isSelected())   
	        					r=255;
	        					else r=0;
	        					if(CBg.isSelected())   
	        					g=255;
	        					else g=0;
	        					if(CBb.isSelected())  
	        					b=255;
	        					else b=0;
	        					
	        					ta.setBackground(new Color(r,g,b));
	        					validate();
	        				}
	        				if(fore.isSelected()) 
	        				{
	        					if(CBr.isSelected())   
	            					r=255;
	            					else r=0;
	            					if(CBg.isSelected())   
	            					g=255;
	            					else g=0;
	            					if(CBb.isSelected())  
	            					b=255;
	            					else b=0;
	            					
	            					ta.setForeground(new Color(r,g,b));
	            					validate();
	        				}
	        				
	        			}
	        		});
	        
		pan.add(RGBpan);
		pan.add(FBpan);
		pan.add(btnPan);
		
		sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pan, ta );
        sp.setDividerLocation(150);
        sp.setOneTouchExpandable(true);
        add(sp);
       
		validate();
	}

	public static void main(String [] args)
	{
		ESE38_SplitPanelColorTest spct = new ESE38_SplitPanelColorTest();
		spct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

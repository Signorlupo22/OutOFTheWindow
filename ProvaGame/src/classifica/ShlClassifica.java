package classifica;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.image.*;

import Utility.LoadSave;

import java.awt.*;

///TODO carattere del gioco
public class ShlClassifica {
	
	protected JFrame []shells = new JFrame[4];
	protected Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
	long min,sec,cent;
	BufferedImage tmp;
	JLabel tableBG;
	
	public ShlClassifica(Classifica c) {
	
		
		for(int i=0;i<4;i++) {
			shells[i]=new JFrame();
		}
		
		shells[0].setSize(300,420); //1 posto
		shells[1].setSize(300,350);	//2 posto
		shells[2].setSize(300,300);	//3 posto
		shells[3].setSize(660,440);	//gli altri
		  
		shells[0].setLocation(screenSize.width/2 - 350/2, 0+100);		
		shells[1].setLocation(shells[0].getLocation().x - 300, 170);
		shells[2].setLocation(shells[0].getLocation().x + 300, 220);
		shells[3].setLocation(shells[0].getLocation().x-190,520);
		
		
		shells[0].setTitle("Primo posto");
		shells[1].setTitle("Secondo posto");
		shells[2].setTitle("Terzo posto");
		
		
		tmp = LoadSave.GetSpriteAtlas("Map.png");
		JLabel tableBG= new JLabel(new ImageIcon(tmp));	
				
		
		//shell gold
		JPanel contentPaneGold = new JPanel();
		
		cent=c.getPartitaById(0).getTempo();
		sec=cent/100;
		cent%=100;
		min=sec/60;
		sec%=60;	
		
		shells[0].setResizable(false);
		contentPaneGold = new JPanel();
		contentPaneGold.setBorder(new EmptyBorder(0,0,0,0));

		shells[0].setContentPane(contentPaneGold);
		contentPaneGold.setLayout(null);
		
		JLabel nameGold = new JLabel(c.getPartitaById(0).getNome());
		nameGold.setForeground(new Color(255, 140, 0));
		nameGold.setFont(new Font("CityStencil", Font.PLAIN, 30));
		nameGold.setBounds(95, 280, 191, 42);
		contentPaneGold.add(nameGold);
		
		BufferedImage tmp = LoadSave.GetSpriteAtlas("gold.png");
		
		JLabel timeGold = new JLabel(min+" "+sec+" "+cent);
		timeGold.setForeground(new Color(255, 140, 0));
		timeGold.setFont(new Font("CityStencil", Font.PLAIN, 30));
		timeGold.setBounds(95, 333, 191, 50);
		contentPaneGold.add(timeGold);
		JLabel BGGold = new JLabel(new ImageIcon(tmp));
		BGGold.setBounds(0, 0, 296, 400);
		contentPaneGold.add(BGGold);
	


		//shell silver
		JPanel contentPaneSilver = new JPanel();
		
		cent=c.getPartitaById(1).getTempo();
		sec=cent/100;
		cent%=100;
		min=sec/60;
		sec%=60;	
		
		shells[1].setResizable(false);
		contentPaneSilver = new JPanel();
		contentPaneSilver.setBorder(new EmptyBorder(0,0,0,0));

		shells[1].setContentPane(contentPaneSilver);
		contentPaneSilver.setLayout(null);
		
		JLabel nameSilver = new JLabel(c.getPartitaById(1).getNome());
		nameSilver.setHorizontalAlignment(SwingConstants.CENTER);
		nameSilver.setForeground(new Color(255, 140, 0));
		nameSilver.setFont(new Font("CityStencil", Font.PLAIN, 30));
		nameSilver.setBounds(0, 0, 296, 42);
		contentPaneSilver.add(nameSilver);
		
		tmp = LoadSave.GetSpriteAtlas("silver.png");
		
		JLabel timeSilver = new JLabel(min+" "+sec+" "+cent);
		timeSilver.setHorizontalAlignment(SwingConstants.CENTER);
		timeSilver.setForeground(new Color(255, 140, 0));
		timeSilver.setFont(new Font("CityStencil", Font.PLAIN, 30));
		timeSilver.setBounds(0, 29, 296, 50);
		contentPaneSilver.add(timeSilver);
		JLabel BGSilver = new JLabel(new ImageIcon(tmp));
		BGSilver.setBounds(0, 0, 296, 350);
		contentPaneSilver.add(BGSilver);
		
		
		
		//shell bronze
		JPanel contentPaneBronze = new JPanel();
		
		cent=c.getPartitaById(2).getTempo();
		sec=cent/100;
		cent%=100;
		min=sec/60;
		sec%=60;	
		
		shells[2].setResizable(false);
		contentPaneBronze = new JPanel();
		contentPaneBronze.setBorder(new EmptyBorder(0,0,0,0));

		shells[2].setContentPane(contentPaneBronze);
		contentPaneBronze.setLayout(null);
		
		JLabel nameBronze = new JLabel(c.getPartitaById(2).getNome());
		nameBronze.setHorizontalAlignment(SwingConstants.CENTER);
		nameBronze.setForeground(new Color(255, 140, 0));
		nameBronze.setFont(new Font("CityStencil", Font.PLAIN, 30));
		nameBronze.setBounds(0, 0, 296, 42);
		contentPaneBronze.add(nameBronze);
		
		tmp = LoadSave.GetSpriteAtlas("bronze.png");
		
		JLabel timeBronze = new JLabel(min+" "+sec+" "+cent);
		timeBronze.setHorizontalAlignment(SwingConstants.CENTER);
		timeBronze.setForeground(new Color(255, 140, 0));
		timeBronze.setFont(new Font("CityStencil", Font.PLAIN, 30));
		timeBronze.setBounds(0, 29, 296, 50);
		contentPaneBronze.add(timeBronze);
		JLabel BGBronze = new JLabel(new ImageIcon(tmp));
		BGBronze.setBounds(0, 0, 296, 300);
		contentPaneBronze.add(BGBronze);
		
		
		
		///tabella con tutta la classifica
		
		JPanel panel=new JPanel();
		panel.setOpaque(false);
		
		//creo la tabella
		String[] columnsNames = {"posizione","nome","tempo"};                
        JTable table =new JTable(c.getStringMatrix(), columnsNames);
        table.setTableHeader(null);
        ((JComponent) table.getDefaultRenderer(Object.class)).setOpaque(false);
		table.setOpaque(false);
		table.setForeground(Color.white);
		table.setFont(new Font("Citystencil",0,25));
		table.setRowHeight(33);
		table.setEnabled(false);
		
		
        
        
        //scroll panel per la tabella
        JScrollPane pane=new JScrollPane(table);
		pane.setOpaque(false);
		pane.getViewport().setOpaque(false);
		pane.getVerticalScrollBar().setOpaque(false);
		pane.setPreferredSize(new Dimension(shells[3].getSize().width-50,shells[3].getSize().height-80));
		
		panel.add(pane,BorderLayout.CENTER);
		panel.setLayout(new GridBagLayout());		
		shells[3].add(panel);    
        shells[3].setVisible(true); 
		shells[3].add(tableBG);

		
		shells[3].setResizable(false);
		
        for(int i=0;i<4;i++) {
			shells[i].setVisible(true);
			shells[i].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
        
	}

}

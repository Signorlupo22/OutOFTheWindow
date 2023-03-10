package classifica;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
		
		shells[0].setSize(250,350); //1 posto
		shells[1].setSize(250,300);	//2 posto
		shells[2].setSize(250,270);	//3 posto
		shells[3].setSize(660,440);	//gli altri
		  
		shells[0].setLocation(screenSize.width/2 - 350/2, 0+100);		
		shells[1].setLocation(shells[0].getLocation().x - 220, 50+100);
		shells[2].setLocation(shells[0].getLocation().x + 250, 80+100);
		shells[3].setLocation(shells[0].getLocation().x-220,500);
		
		
		shells[0].setTitle("Primo posto");
		shells[1].setTitle("Secondo posto");
		shells[2].setTitle("Terzo posto");
		
		
		tmp = LoadSave.GetSpriteAtlas("Map.png");
		JLabel tableBG= new JLabel(new ImageIcon(tmp));	
		
		/*tmp = LoadSave.GetSpriteAtlas("gold.png");
		Image goldImg = tmp.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
		JLabel goldMedal= new JLabel(new ImageIcon(goldImg));
		goldMedal.setSize(250,350);
		goldMedal.setLayout(null);
		JLabel nome=new JLabel(c.getPartitaById(0).getNome());
		nome.setFont(new Font("Citystencil",0,30));
		nome.setForeground(Color.orange);
		nome.setBounds(10,20,nome.getPreferredSize().width,nome.getPreferredSize().height);
		
				
		cent=c.getPartitaById(0).getTempo();
		sec=cent/100;
		cent%=100;
		min=sec/60;
		sec%=60;
		
		JLabel tempo=new JLabel(min+" "+sec+" "+cent);
		tempo.setFont(new Font("Citystencil",0,30));
		tempo.setForeground(Color.orange);
		goldMedal.add(nome);
		goldMedal.add(tempo);
		shells[0].add((goldMedal), null);
		shells[0].pack();
		
		
		*/
		
		
		//shell gold
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0,0,0,0));

		shells[0].setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cent=c.getPartitaById(0).getTempo();
		sec=cent/100;
		cent%=100;
		min=sec/60;
		sec%=60;
		
		
		JLabel lblNewLabel = new JLabel(c.getPartitaById(0).getNome());
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setFont(new Font("CityStencil", Font.PLAIN, 18));
		lblNewLabel.setBounds(26, 116, 124, 42);
		contentPane.add(lblNewLabel);
		
		BufferedImage tmp = LoadSave.GetSpriteAtlas("gold.png");
		Image goldImg = tmp.getScaledInstance(250,350, Image.SCALE_SMOOTH);
		
		JLabel lblTempoXY = new JLabel(min+" "+sec+" "+cent);
		lblTempoXY.setForeground(new Color(255, 140, 0));
		lblTempoXY.setFont(new Font("CityStencil", Font.PLAIN, 18));
		lblTempoXY.setBounds(12, 149, 124, 42);
		contentPane.add(lblTempoXY);
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(goldImg));
		lblNewLabel_1.setBounds(0, 0, shells[0].getSize().width, shells[0].getSize().height);
		contentPane.add(lblNewLabel_1);
	


		//shell silver
		JPanel contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(0,0,0,0));

		shells[1].setContentPane(contentPane2);
		contentPane2.setLayout(null);
		
		cent=c.getPartitaById(1).getTempo();
		sec=cent/100;
		cent%=100;
		min=sec/60;
		sec%=60;
		
		
		JLabel lblNewLabel2 = new JLabel(c.getPartitaById(1).getNome());
		lblNewLabel2.setForeground(new Color(255, 140, 0));
		lblNewLabel2.setFont(new Font("CityStencil", Font.PLAIN, 18));
		lblNewLabel2.setBounds(26, 116, 124, 42);
		contentPane2.add(lblNewLabel2);
		
		tmp = LoadSave.GetSpriteAtlas("silver.png");
		Image silverImg = tmp.getScaledInstance(250,350, Image.SCALE_SMOOTH);
		
		JLabel lblTempoXY2 = new JLabel(min+" "+sec+" "+cent);
		lblTempoXY2.setForeground(new Color(255, 140, 0));
		lblTempoXY2.setFont(new Font("CityStencil", Font.PLAIN, 18));
		lblTempoXY2.setBounds(12, 149, 124, 42);
		contentPane2.add(lblTempoXY2);
		JLabel lblNewLabel_12 = new JLabel(new ImageIcon(silverImg));
		lblNewLabel_12.setBounds(0, 0, shells[1].getSize().width, shells[1].getSize().height);
		contentPane2.add(lblNewLabel_12);
		
		
		
		//shell bronze
		JPanel contentPane3 = new JPanel();
		contentPane3.setBorder(new EmptyBorder(0,0,0,0));

		shells[2].setContentPane(contentPane3);
		contentPane3.setLayout(null);
		
		cent=c.getPartitaById(2).getTempo();
		sec=cent/100;
		cent%=100;
		min=sec/60;
		sec%=60;
		
		
		JLabel lblNewLabel3 = new JLabel(c.getPartitaById(2).getNome());
		lblNewLabel3.setForeground(new Color(255, 140, 0));
		lblNewLabel3.setFont(new Font("CityStencil", Font.PLAIN, 18));
		lblNewLabel3.setBounds(26, 116, 124, 42);
		contentPane3.add(lblNewLabel3);
		
		tmp = LoadSave.GetSpriteAtlas("bronze.png");
		Image bronzeImg = tmp.getScaledInstance(250,350, Image.SCALE_SMOOTH);
		
		JLabel lblTempoXY3 = new JLabel(min+" "+sec+" "+cent);
		lblTempoXY3.setForeground(new Color(255, 140, 0));
		lblTempoXY3.setFont(new Font("CityStencil", Font.PLAIN, 18));
		lblTempoXY3.setBounds(12, 149, 124, 42);
		contentPane3.add(lblTempoXY3);
		JLabel lblNewLabel_13 = new JLabel(new ImageIcon(bronzeImg));
		lblNewLabel_13.setBounds(0, 0, shells[2].getSize().width, shells[2].getSize().height);
		contentPane3.add(lblNewLabel_13);
		
		
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

		
		
        for(int i=0;i<4;i++) {
			shells[i].setVisible(true);
			shells[i].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
        
	}

}

package menu;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.image.*;

import javax.swing.border.EmptyBorder;

import Utility.LoadSave;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InNome extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private static String nome;
	protected static volatile boolean controllo=false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//InNome frame = new InNome();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InNome(FrameSelectionListener caio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width / 2 -120 + Menu.LARGHEZZA, screenSize.height / 2 -200, 462, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BufferedImage tmp = LoadSave.GetSpriteAtlas("Map.png");
		
		txtName = new JTextField();
		txtName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("nome: "+txtName.getText());
				nome=txtName.getText();
				caio.AvvioScelta(nome);
				controllo=true;
				dispose();
			}
		});
		txtName.setText("Your nick here");
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setBackground(new Color(255, 140, 0));
		txtName.setFont(new Font("CityStencil", Font.PLAIN, 30));
		txtName.setBounds(94, 94, 254, 81);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ENTER YOUR NAME");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setFont(new Font("CityStencil", Font.PLAIN, 34));
		lblNewLabel.setBounds(0, 0, 446, 96);
		contentPane.add(lblNewLabel);
		//Image goldImg = tmp.getScaledInstance(150,225, Image.SCALE_SMOOTH);
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(tmp));
		lblNewLabel_1.setBackground(new Color(255, 140, 0));
		lblNewLabel_1.setBounds(0, 0, 446, 207);
		contentPane.add(lblNewLabel_1);
	}
	
	public static String getNome() {
		return nome;
	}
}

package classifica;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.image.*;

import javax.swing.border.EmptyBorder;

import Utility.LoadSave;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class Prova extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prova frame = new Prova();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Prova() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 160, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("nome player");
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setFont(new Font("CityStencil", Font.PLAIN, 18));
		lblNewLabel.setBounds(26, 116, 124, 42);
		contentPane.add(lblNewLabel);
		
		BufferedImage tmp = LoadSave.GetSpriteAtlas("gold.png");
		Image goldImg = tmp.getScaledInstance(150,225, Image.SCALE_SMOOTH);
		
		JLabel lblTempoXY = new JLabel("tempo x y\r\n");
		lblTempoXY.setForeground(new Color(255, 140, 0));
		lblTempoXY.setFont(new Font("CityStencil", Font.PLAIN, 18));
		lblTempoXY.setBounds(26, 149, 124, 42);
		contentPane.add(lblTempoXY);
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(goldImg));
		lblNewLabel_1.setBounds(0, 0, 150, 233);
		contentPane.add(lblNewLabel_1);
	}

}

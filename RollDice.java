package Assignment8.PartIV.graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RollDice extends JFrame {
	JButton rollDice = new JButton("Roll Dice");
	JLabel result = new JLabel();
	JPanel panel = new JPanel();
	final BufferedImage[] image = new BufferedImage [6];
	{
		try {
			image[0] = ImageIO.read(new File("/Users/mengzhou/Desktop/Java/Assignment8/PartIV/die1.png"));
			image[1] = ImageIO.read(new File("/Users/mengzhou/Desktop/Java/Assignment8/PartIV/die2.png"));
			image[2] = ImageIO.read(new File("/Users/mengzhou/Desktop/Java/Assignment8/PartIV/die3.png"));
			image[3] = ImageIO.read(new File("/Users/mengzhou/Desktop/Java/Assignment8/PartIV/die4.png"));
			image[4] = ImageIO.read(new File("/Users/mengzhou/Desktop/Java/Assignment8/PartIV/die5.png"));
			image[5] = ImageIO.read(new File("/Users/mengzhou/Desktop/Java/Assignment8/PartIV/die6.png"));
		} catch (
				IOException e) {
			e.printStackTrace();
		}
	}
	public int val1=1;
	public int val2=1;
	JPanel dicePane;
	ImagePanel dice1;
	ImagePanel dice2;

	public RollDice() {
		dice1 = new ImagePanel(image[0]);
		dice2 = new ImagePanel(image[0]);
		//font and text to the button and label
		Font myFont = new Font("Serif", Font.BOLD, 18);
		result.setFont(myFont);
		rollDice.setFont(myFont);
		result.setText("Result: "+(dice1.value+dice2.value));

		//add listeners
		rollDice.addMouseListener(new rollTwoDiceListener());
		dice1.addMouseListener(new rollDiceListener());
		dice2.addMouseListener(new rollDice2Listener());

		//layout
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		result.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(result);
		rollDice.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(rollDice);

		dicePane = new JPanel(new GridLayout(1,2));
		dicePane.add(dice1);
		dicePane.add(dice2);
		setLayout(new BorderLayout());
		this.getContentPane().add(dicePane, BorderLayout.CENTER);
		this.getContentPane().add(panel, BorderLayout.SOUTH);
	}

	class rollTwoDiceListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			int rnd = (int)(Math.random() * 6+1);
			dice1.value=rnd;
			dice1.roll(new ImageIcon(image[rnd-1]));

			int rnd2 = (int)(Math.random() * 6+1);
			dice2.value=rnd2;
			dice2.roll(new ImageIcon(image[rnd2-1]));

			result.setText("Result: "+(dice1.value+dice2.value));
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	class rollDiceListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			int rnd = (int)(Math.random() * 6+1);
			dice1.value=rnd;
			dice1.roll(new ImageIcon(image[rnd-1]));
			result.setText("Result: "+(dice1.value+dice2.value));
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	class rollDice2Listener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			int rnd = (int)(Math.random() * 6+1);
			dice2.value=rnd;
			dice2.roll(new ImageIcon(image[rnd-1]));
			result.setText("Result: "+(dice1.value+dice2.value));
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	public static void main(String[] args) {

		RollDice rollDice = new RollDice();
		rollDice.setVisible(true);
		rollDice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rollDice.setSize(530,280);
	
	}
}

package Assignment8.PartIV;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
	private Image img;

	JLabel imageLable;
	int value=1;
	final BufferedImage[] image = new BufferedImage [6];
	{
		try {
			image[0] = ImageIO.read(new File("die1.png"));
			image[1] = ImageIO.read(new File("die2.png"));
			image[2] = ImageIO.read(new File("die3.png"));
			image[3] = ImageIO.read(new File("die4.png"));
			image[4] = ImageIO.read(new File("die5.png"));
			image[5] = ImageIO.read(new File("die6.png"));
		} catch (
				IOException e) {
			e.printStackTrace();
		}
	}

	//not using it in this case
//	public ImagePanel(String img) {
//		this(new ImageIcon(img).getImage());
//	}
	
	public ImagePanel(BufferedImage img) {
		imageLable = new JLabel(new ImageIcon(img));
	//   Dimension size = new Dimension(image.getWidth(null), img.getHeight(null));
    //    setPreferredSize(size);
        /*setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);*/
       // setLayout(null);
		this.add(imageLable, BorderLayout.CENTER);
	}

  //Don't know how to use this function
//	public void paintComponent(Graphics g) {
//        g.drawImage(img, 50, 0, null);
//    }

	public void roll(ImageIcon img) {
		this.remove(imageLable);
		imageLable= new JLabel(img);
		this.add(imageLable, BorderLayout.CENTER);
	}

}

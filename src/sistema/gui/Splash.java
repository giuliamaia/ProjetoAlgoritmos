package sistema.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class Splash {
	private final int LARGURA_SPLASH = 480;
	private final int ALTURA_SPLASH = 270;
	private final int TEMPO_SPLASH = 6500;
	private final String CAMINHO_SPLASH = "/images/homicomendoterra.gif";
	private final String CAMINHO_SPLASH2 = "/images/moçotirafototerra.gif";
	
	public Splash() {
		Random rand = new Random();
		int x=rand.nextInt(11);
		JWindow janelaSplash = new JWindow();
		System.out.println(x);
		if(x>=0 && x<=5) {
			janelaSplash.getContentPane().add(new JLabel("", new ImageIcon(getClass().getResource(CAMINHO_SPLASH)), SwingConstants.CENTER));
		}
		else {
			janelaSplash.getContentPane().add(new JLabel("", new ImageIcon(getClass().getResource(CAMINHO_SPLASH2)), SwingConstants.CENTER));
		}
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimensao = toolkit.getScreenSize();
		janelaSplash.setBounds((dimensao.width -  LARGURA_SPLASH)/2, (dimensao.height -  ALTURA_SPLASH)/2, LARGURA_SPLASH, ALTURA_SPLASH);
		janelaSplash.setVisible(true);
		try {
			Thread.sleep(TEMPO_SPLASH);
		}catch(InterruptedException e) {}
		janelaSplash.dispose();
	}
}



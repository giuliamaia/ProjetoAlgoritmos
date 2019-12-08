package sistema.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class Splash {
	private final int LARGURA_SPLASH = 650;
	private final int ALTURA_SPLASH = 470;
	private final int TEMPO_SPLASH = 6000;
	private final String CAMINHO_SPLASH = "/images/terraplana.gif";
	
	public Splash() {
		JWindow janelaSplash = new JWindow();
		janelaSplash.getContentPane().add(new JLabel("", new ImageIcon(getClass().getResource(CAMINHO_SPLASH)), SwingConstants.CENTER));
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



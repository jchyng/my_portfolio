package rhythm_game_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameManager extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
//	���� ���۸��� ���� ��üȭ���� �̹����� ��� �ν��Ͻ�
//	���� ���۸� : ���ۿ� �ִ� �̹����� ����ؼ� ��������
	private Image introBackground;
//  ��Ʈ��ȭ�� �̹��� ��ü
	public GameManager() {
		setTitle("Rhythm Game");
//		â �� �̸� ǥ��
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
//		������ ����
		setResizable(false);
//		������ ���� �Ұ�
		setLocationRelativeTo(null);
//		â�� ȭ�� ��� ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		â�� �ݾ��� �� ���α׷��� ���� ����
		setVisible(true);
//		â�� ���̰� ��
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
//		Main Ŭ������ ��ġ�� ������� introBackground��� �̹��������� ���� ���� �̹��� �ν��Ͻ��� �־ ��ü ����
	}
	
		public void paint(Graphics g) {
//		JFrame�� ��� �޾��� �� ���� ù��°�� ȭ���� �׷��� (���)
			screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
//			������ �������� �̹��� ����
			screenGraphic = screenImage.getGraphics();
//			��ũ���̹����� �̿��ؼ� �׷��� ��ü get
			screenDraw(screenGraphic);
//			�׷��� ��ü�� �׸��� �׷���
			g.drawImage(screenImage, 0, 0, null);
//			��ũ���̹����� 0.0�� �׷���
		}
		public void screenDraw(Graphics g) {
			g.drawImage(introBackground, 0, 0, null);
			this.repaint();
//			paint ��ȣ�� => ����Լ� -> ����ؼ� �׸��� �������־ ���۸� �ذ�
		}
}

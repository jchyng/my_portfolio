package rhythm_game_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameManager extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
//	더블 버퍼링을 위한 전체화면의 이미지를 담는 인스턴스
//	더블 버퍼링 : 버퍼에 있는 이미지로 계속해서 갱신해줌
	private Image introBackground;
//  인트로화면 이미지 객체
	public GameManager() {
		setTitle("Rhythm Game");
//		창 바 이름 표시
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
//		사이즈 설정
		setResizable(false);
//		사이즈 변경 불가
		setLocationRelativeTo(null);
//		창을 화면 가운데 띄움
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		창을 닫았을 때 프로그램도 같이 종료
		setVisible(true);
//		창이 보이게 함
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
//		Main 클래스의 위치를 기반으로 introBackground라는 이미지파일을 얻어온 다음 이미지 인스턴스에 넣어서 객체 생성
	}
	
		public void paint(Graphics g) {
//		JFrame을 상속 받았을 때 가장 첫번째로 화면을 그려줌 (약속)
			screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
//			지정된 사이즈의 이미지 생성
			screenGraphic = screenImage.getGraphics();
//			스크린이미지를 이용해서 그래픽 객체 get
			screenDraw(screenGraphic);
//			그래픽 객체에 그림을 그려줌
			g.drawImage(screenImage, 0, 0, null);
//			스크린이미지를 0.0에 그려줌
		}
		public void screenDraw(Graphics g) {
			g.drawImage(introBackground, 0, 0, null);
			this.repaint();
//			paint 재호출 => 재귀함수 -> 계속해서 그림을 갱신해주어서 버퍼링 해결
		}
}

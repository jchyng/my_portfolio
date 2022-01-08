package rhythm_game_3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
//	Thread : ���α׷� �ȿ� �ִ� �ϳ��� ���� ���α׷�
	private Player player;
	private boolean isLoop;
//	���� �ݺ�����
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/"+ name).toURI());
//			music������ �ִ� �ش��̸��� ���� toURI�� ������ ��ġ�� ������
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
//			�ش������� ���ۿ� ��Ƽ� �о��
			player = new Player(bis);
//			player�� �ش������� ����
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public int getTime() {
//		���� � ��ġ�� ����ǰ� �ִ��� 
		if(player == null)
			return 0;
		return player.getPosition();
	}
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
//		�ش� �����带 �������·� ����� ��
	}
	@Override
	public void run() {
//		�����带 ��ӹ����� ������ ����ؾ��� - ���� �޼ҵ�
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
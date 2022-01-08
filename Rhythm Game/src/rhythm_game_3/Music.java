package rhythm_game_3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
//	Thread : 프로그램 안에 있는 하나의 작은 프로그램
	private Player player;
	private boolean isLoop;
//	음악 반복여부
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/"+ name).toURI());
//			music폴더에 있는 해당이름의 파일 toURI는 파일의 위치를 가져옴
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
//			해당파일을 버퍼에 담아서 읽어옴
			player = new Player(bis);
//			player가 해당파일을 담음
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public int getTime() {
//		현재 어떤 위치에 실행되고 있는지 
		if(player == null)
			return 0;
		return player.getPosition();
	}
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
//		해당 쓰레드를 중지상태로 만들어 줌
	}
	@Override
	public void run() {
//		쓰레드를 상속받으면 무조건 사용해야함 - 실행 메소드
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
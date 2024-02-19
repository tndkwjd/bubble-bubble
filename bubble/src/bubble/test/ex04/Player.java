package bubble.test.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Movable {

	// 위치 상태
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	private ImageIcon playerR, playerL;

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 55;
		y = 535;

		left = false;
		right = false;
		up = false;
		down = false;

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	// 이벤트 핸들러
	@Override
	public void left() {
		System.out.println("left");
		left = true;
		new Thread(() -> {
			while (left) {
				setIcon(playerL);
				x = x - 1;
				setLocation(x, y);
				try {
					Thread.sleep(10); // 0.01초
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	@Override
	public void right() {
		System.out.println("right");
		right = true;
		new Thread(() -> {
			while (right) {
				setIcon(playerR);
				x = x + 1;
				setLocation(x, y);
				try {
					Thread.sleep(10); // 0.01초
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	@Override
	public void up() {
		System.out.println("up");
	}

	@Override
	public void down() {

	}

	// 이벤트라는 건 OS에서 프로그램 계속 주시하다가 사용하는 유저가 키보드나 마우스 조작할 때
	// 움직임 체크해서 메모리 공간에 저장 => While문 통해서 계속 지켜보고 있음

	// 움직임을 체크해서 순차적으로 기록해두는 메모리 공간을 이벤트 루프(큐)

	// 이벤트 루프에 기록 해 놓은 명령을 실행하기 위해서는 이벤트 핸들러가 호출 된다.

	// 이벤트 핸들러는 Stack 공간. 리스너 내부에 메서드 호출 된다는 뜻

	// 그림 변경 시점 : 이벤트 루프에 모든 임무 (task)가 완료 되어야 repaint(다시 그려진다)가 된다.
	// Java는 메인 스레드가 하나이기 때문에 동시에 여러 가지 동작을 하려면 스레드가 필요하다.
	// 메인 스레드만 있으면 이벤트 루프에 동작을 전달 할 경우
	// 그 동작이 여러 가지 동작이라 해도 스레드가 하나여서 하나만 동작 된다

	// -> 이벤트 루프에 r , u 같이 했을 때 r r r or u u u

	
	
	// Getter/Setter
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public ImageIcon getPlayerR() {
		return playerR;
	}

	public void setPlayerR(ImageIcon playerR) {
		this.playerR = playerR;
	}

	public ImageIcon getPlayerL() {
		return playerL;
	}

	public void setPlayerL(ImageIcon playerL) {
		this.playerL = playerL;
	}
	
}

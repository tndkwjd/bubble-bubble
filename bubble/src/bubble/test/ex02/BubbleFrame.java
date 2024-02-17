package bubble.test.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame{

	private JLabel backgroundMap;
	
	private Player player;
	
	public BubbleFrame() {
		initObject();
		initSetting();
		setVisible(true);
	}
	
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap);
		
		player = new Player();
		add(player);
	}
	
	private void initSetting() {
		
		setSize(1000, 640);
		setLayout(null); // absoulte 레이아웃
		
		setLocationRelativeTo(null); // JFram 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼으로 창 닫을 때 JVM 같이 종료
	}
	
	public static void main(String[] args) {
		new BubbleFrame();
	}
}

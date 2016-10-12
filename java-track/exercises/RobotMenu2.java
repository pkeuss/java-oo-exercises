import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;

public class RobotMenu2 {

	private JFrame frame;
	private DefaultListModel<Robot> listModel;
	private JButton changeSpeed;
	private JButton changePosistion;
	private JButton changeOrientation;
	private JButton move;
	private JList<Robot> robotList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RobotMenu2 window = new RobotMenu2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RobotMenu2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		listModel = new DefaultListModel<Robot>();
		robotList = new JList(listModel);
		robotList.setBounds(138, 165, 269, -142);
		frame.getContentPane().add(robotList);
		
		JButton create_Robot = new JButton("Create Robot");
		create_Robot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //added everything after this
				int selected = robotList.getSelectedIndex();
				String name = (String)JOptionPane.showInputDialog(
						frame,
						"What is the Name of the Robot?",
						"Name Dialog", JOptionPane.PLAIN_MESSAGE,
						null,
						null,
						"");
				Robot r = new Robot(name);
				listModel.add(listModel.size(), r);
			}
		});
		
		
		
		create_Robot.setBounds(10, 11, 118, 38);
		frame.getContentPane().add(create_Robot);
		
		changeSpeed = new JButton("Change Speed");
		changeSpeed.setBounds(10, 56, 118, 23);
		frame.getContentPane().add(changeSpeed);
		
		changePosistion = new JButton("Change Posistion");
		changePosistion.setBounds(10, 86, 118, 23);
		frame.getContentPane().add(changePosistion);
		
		changeOrientation = new JButton("Orientation");
		changeOrientation.setBounds(10, 115, 118, 23);
		frame.getContentPane().add(changeOrientation);
		
		move = new JButton("Move Robot");
		move.setBounds(10, 149, 118, 23);
		frame.getContentPane().add(move);
		
		
	}
}

package Dashboard;
import mps.MPSInstance;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


public class Monitor extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Monitor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("Button.border"));
		panel.setForeground(UIManager.getColor("Tree.hash"));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblMpsMonitor = new JLabel("MPS Monitor");
		lblMpsMonitor.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblMpsMonitor.setBounds(6, 6, 116, 33);
		panel.add(lblMpsMonitor);
		
		Panel panel_1 = new Panel();
		panel_1.setForeground(UIManager.getColor("Tree.selectionBorderColor"));
		panel_1.setBackground(UIManager.getColor("Tree.background"));
		panel_1.setBounds(6, 45, 536, 177);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblZugriffe = new JLabel("Zugriffe");
		lblZugriffe.setBounds(396, 110, 50, 16);
		panel_1.add(lblZugriffe);
		
		JLabel lblMps = new JLabel("MPS 1");
		lblMps.setBounds(6, 6, 41, 17);
		lblMps.setFont(new Font("Lucida Grande", Font.ITALIC, 14));
		panel_1.add(lblMps);
		
		JLabel label = new JLabel("10");
		label.setFont(new Font("Lucida Grande", Font.BOLD, 45));
		label.setBounds(386, 48, 112, 51);
		panel_1.add(label);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.RED);
		canvas.setBounds(43, 37, 50, 51);
		panel_1.add(canvas);
		
		Canvas canvas_1 = new Canvas();
		canvas_1.setBackground(new Color(50, 205, 50));
		canvas_1.setBounds(43, 100, 50, 51);
		panel_1.add(canvas_1);
		
		Canvas canvas_2 = new Canvas();
		canvas_2.setBackground(new Color(105, 105, 105));
		canvas_2.setBounds(386, 101, 100, 4);
		panel_1.add(canvas_2);
		
		Canvas canvas_3 = new Canvas();
		canvas_3.setBackground(new Color(105, 105, 105));
		canvas_3.setBounds(126, 101, 219, 4);
		panel_1.add(canvas_3);
		
		JLabel lblUpdowntime = new JLabel("Up-/Downtime");
		lblUpdowntime.setBounds(136, 110, 126, 16);
		panel_1.add(lblUpdowntime);
		
		Canvas canvas_4 = new Canvas();
		canvas_4.setBackground(new Color(24, 24, 24));
		canvas_4.setBounds(32, 29, 71, 135);
		panel_1.add(canvas_4);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(126, 138, 117, 29);
		panel_1.add(btnStart);
		
		JButton button = new JButton("Stop");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(238, 138, 117, 29);
		panel_1.add(button);
		
		JLabel lblZeitSeitLetzter = new JLabel("Zeit seit letzter Alive-Nachricht:");
		lblZeitSeitLetzter.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblZeitSeitLetzter.setBounds(301, 8, 196, 16);
		panel_1.add(lblZeitSeitLetzter);
		
		JLabel lblMs = new JLabel("110 ms");
		lblMs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMs.setBounds(444, 7, 86, 16);
		panel_1.add(lblMs);
		
		JLabel label_1 = new JLabel("00:00:23");
		label_1.setFont(new Font("Lucida Grande", Font.BOLD, 45));
		label_1.setBounds(131, 48, 214, 51);
		panel_1.add(label_1);
	}

	public MPSInstance getRunningMPS() {
		// TODO Auto-generated method stub
		return null;
	}
}

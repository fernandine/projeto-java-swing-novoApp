package view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import javax.swing.DropMode;

public class MainScreen {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
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
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 28));
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Novo App");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBackground(new Color(95, 158, 160));
		lblNewLabel.setBounds(10, 0, 523, 78);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setIcon(new ImageIcon("C:\\eclipse\\novoApp\\src\\view\\resources\\tick.png"));
		lblNewLabel.setForeground(new Color(160, 82, 45));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Anote tudo, n\u00E3o esque\u00E7a nada\"");
		lblNewLabel_1.setBounds(70, 61, 153, 14);
		lblNewLabel_1.setForeground(new Color(165, 42, 42));
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel.setBounds(10, 89, 153, 51);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\eclipse\\novoApp\\resource\\add.png"));
		lblNewLabel_2.setForeground(new Color(165, 42, 42));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_2.setBounds(111, 11, 32, 29);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Projetos");
		lblNewLabel_2_1.setForeground(new Color(165, 42, 42));
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(10, 11, 58, 21);
		panel.add(lblNewLabel_2_1);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(169, 89, 398, 51);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\eclipse\\novoApp\\resource\\add.png"));
		lblNewLabel_3.setBounds(356, 11, 32, 32);
		panel_1.add(lblNewLabel_3);
		
		Label label = new Label("Tarefas");
		label.setForeground(new Color(165, 42, 42));
		label.setFont(new Font("Segoe UI", Font.BOLD, 15));
		label.setBounds(10, 11, 62, 22);
		panel_1.add(label);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\eclipse\\novoApp\\resource\\add.png"));
		lblNewLabel_4.setBounds(322, 11, 32, 32);
		panel_1.add(lblNewLabel_3);
		
		Panel panel_3 = new Panel();
		panel_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_3.setBackground(SystemColor.menu);
		panel_3.setForeground(SystemColor.menu);
		panel_3.setBounds(10, 146, 153, 340);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		@SuppressWarnings("rawtypes")
		JList list = new JList();
		list.setBounds(23, 147, 106, -98);
		panel_3.add(list);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setRowHeight(40);
		table.setDropMode(DropMode.ON_OR_INSERT);
		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", Boolean.FALSE},
				{"", "", "", null},
				{"", "", "", null},
				{"", "", "Boolean", Boolean.FALSE},
			},
			new String[] {
				"Nome", "Descri\u00E7\u00E3o", "Prazo", "Tarefa conclu\u00EDda"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(98);
		table.setBounds(178, 157, 389, 329);
		frame.getContentPane().add(table);
		

	}
}

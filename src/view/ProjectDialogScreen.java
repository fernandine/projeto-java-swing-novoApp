package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class ProjectDialogScreen extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProjectDialogScreen dialog = new ProjectDialogScreen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProjectDialogScreen() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 414, 33);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Projeto");
				lblNewLabel.setForeground(new Color(165, 42, 42));
				lblNewLabel.setBackground(new Color(165, 42, 42));
				lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
				lblNewLabel.setBounds(10, 0, 51, 32);
				panel.add(lblNewLabel);
			}
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nome");
			lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(20, 55, 36, 18);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JTextPane textPane = new JTextPane();
			textPane.setBounds(10, 73, 414, 20);
			contentPanel.add(textPane);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o");
			lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(20, 104, 57, 18);
			contentPanel.add(lblNewLabel_1);
		}
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 126, 414, 91);
		contentPanel.add(textArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setSelectedIcon(new ImageIcon("C:\\eclipse\\novoApp\\resource\\check.png"));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

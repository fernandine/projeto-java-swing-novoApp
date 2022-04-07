package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class TaskDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TaskDialog dialog = new TaskDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TaskDialog() {
		setBounds(100, 100, 449, 557);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("Nome");
			lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(22, 67, 36, 18);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JTextPane textPane = new JTextPane();
			textPane.setBounds(10, 96, 414, 33);
			contentPanel.add(textPane);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o");
			lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(20, 140, 57, 18);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JTextArea textArea = new JTextArea();
			textArea.setBounds(10, 169, 414, 91);
			contentPanel.add(textArea);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(10, 11, 414, 45);
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("Projeto");
				lblNewLabel.setForeground(new Color(165, 42, 42));
				lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
				lblNewLabel.setBackground(new Color(165, 42, 42));
				lblNewLabel.setBounds(10, 0, 51, 32);
				panel.add(lblNewLabel);
			}
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Prazo");
			lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(20, 271, 57, 18);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JTextPane textPane = new JTextPane();
			textPane.setBounds(10, 300, 414, 33);
			contentPanel.add(textPane);
		}
		{
			JTextArea textArea = new JTextArea();
			textArea.setBounds(10, 373, 414, 101);
			contentPanel.add(textArea);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Notas");
			lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(20, 344, 57, 18);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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

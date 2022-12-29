
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class CurrConverter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrConverter frame = new CurrConverter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/* Create the frame.*/
	public CurrConverter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 470);
		contentPane = new JPanel();
        contentPane.setBackground(new Color(102, 255, 153));
		contentPane.setForeground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the amount\r\n");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(44, 58, 167, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("From");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(69, 158, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(69, 242, 45, 21);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial Black", Font.BOLD, 13));
		textField.setBounds(338, 58, 251, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setName("From..");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"select", "USD", "IndianRupee"}));
		comboBox.setBounds(341, 146, 248, 34);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"select", "IndianRupee", "USD"}));
		comboBox_1.setName("to..");
		comboBox_1.setBounds(338, 239, 251, 34);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Convert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double tot;
				Double amount=Double.parseDouble(textField.getText());
				if(comboBox.getSelectedItem().toString()=="USD"&&comboBox_1.getSelectedItem().toString()=="IndianRupee")
				{
					tot=amount*70.50;
					JOptionPane.showMessageDialog(null,"Converted Amount is "+tot.toString()+"Rupees");
				}
				else if(comboBox.getSelectedItem().toString()=="IndianRupee"&&comboBox_1.getSelectedItem().toString()=="USD")
				{
					tot=amount/70.50;
					JOptionPane.showMessageDialog(null,"Converted Amount is "+tot.toString()+"US Dollar");

				}

			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBounds(504, 348, 104, 21);
		contentPane.add(btnNewButton);
	}
}

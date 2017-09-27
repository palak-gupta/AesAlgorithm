package AesProject_1;

import javax.crypto.SecretKey;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.TextArea;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Base64;
import javax.swing.JLabel;
import java.awt.Font;

public class inputs extends JFrame {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public aesalgorithm a;
SecretKey sec;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inputs frame = new inputs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public inputs() {
		setTitle("Testing");
		
		a = new aesalgorithm();
		try {
			sec = a.keyGenrate();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final TextArea textArea1 = new TextArea();
		textArea1.setBounds(10, 51, 155, 129);
		contentPane.add(textArea1);
		
		final TextArea textArea_11 = new TextArea();
		textArea_11.setBounds(197, 51, 155, 129);
		contentPane.add(textArea_11);
		
		
		JButton btnEncrypt1 = new JButton("Encrypt");
		btnEncrypt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				String PlainText=textArea1.getText();
				
				String aka = a.encryptor(PlainText, sec);
				//textArea_11.setText(a.bytesToHex(aka));
				textArea_11.setText(aka);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
		btnEncrypt1.setBounds(80, 203, 89, 23);
		contentPane.add(btnEncrypt1);
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				String gettit= textArea_11.getText();
				byte[] pka=Base64.getDecoder().decode(gettit);
				byte[] mmm=a.decryptor(pka, sec);
				String xaxa = new String(mmm);
				textArea_11.setText(xaxa);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}) ;
		btnDecrypt.setBounds(197, 203, 89, 23);
		contentPane.add(btnDecrypt);
		
		JLabel lblPlainText = new JLabel("Plain Text");
		lblPlainText.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPlainText.setBounds(10, 11, 155, 34);
		contentPane.add(lblPlainText);
		
		JLabel lblEncryptdecryptText = new JLabel("Encrypt/Decrypt Text");
		lblEncryptdecryptText.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEncryptdecryptText.setBounds(197, 11, 197, 34);
		contentPane.add(lblEncryptdecryptText);
	}
}

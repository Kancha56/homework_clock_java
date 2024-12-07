package clock;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class setSnooze extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static int currentNumber = 0,flagsnnoz; // ตัวแปรสำหรับเก็บค่าปัจจุบัน
	private JLabel lbl_H;
	private JLabel lblMin_FIR;
	private JLabel lblMIN_LA;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public setSnooze()
	{

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 327);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel AlarmLabel = new JLabel("Set Snooze");
		AlarmLabel.setBounds(37, 25, 136, 23);
		AlarmLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(AlarmLabel);

		JLabel lblNewLabel = new JLabel(":");
		lblNewLabel.setBounds(131, 102, 45, 61);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				flagsnnoz = 1;
				int h,m;
				Mailclock main = Mailclock.getInstance();
				String Hourstess = lbl_H.getText().isEmpty() ? "0" : lbl_H.getText();
				String MinFirst = lblMin_FIR.getText().isEmpty() ? "0" : lblMin_FIR.getText();
			    String MinLast = lblMIN_LA.getText().isEmpty() ? "0" : lblMIN_LA.getText(); 
				
			    try
				{
			    	
			    	h = Integer.parseInt(Hourstess);
			    	m = Integer.parseInt(MinFirst+""+MinLast);
			    	main.updateSetSnooze(h, m, flagsnnoz);
			    	main.setVisible(true);
			    	dispose();
			    	
				} catch (NumberFormatException e2)
				{
					JOptionPane.showMessageDialog(null, e2.getMessage());
					
				}
				
			

				
			}
		});
		btnOk.setBounds(74, 228, 127, 38);
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(btnOk);

		JButton btnUpH = new JButton("UpHour");
		btnUpH.setBackground(Color.WHITE);

		contentPane.add(btnUpH);

		JButton btnDownH = new JButton("DownHour");
		btnDownH.setBackground(Color.WHITE);
		btnDownH.setBounds(37, 169, 98, 28);
		contentPane.add(btnDownH);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(47, 102, 74, 56);
		contentPane.add(panel);
		panel.setLayout(null);

		lbl_H = new JLabel("");
		lbl_H.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lbl_H.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_H.setBounds(0, 0, 74, 56);
		panel.add(lbl_H);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(156, 102, 45, 56);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblMin_FIR = new JLabel("");
		lblMin_FIR.setHorizontalAlignment(SwingConstants.CENTER);
		lblMin_FIR.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblMin_FIR.setBounds(0, 0, 45, 56);
		panel_1.add(lblMin_FIR);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(211, 102, 45, 56);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);

		lblMIN_LA = new JLabel("");
		lblMIN_LA.setHorizontalAlignment(SwingConstants.CENTER);
		lblMIN_LA.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblMIN_LA.setBounds(0, 0, 45, 56);
		panel_1_1.add(lblMIN_LA);

		JButton btnUpMin_Fi = new JButton("U");
		btnUpMin_Fi.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnUpMin_Fi.setBackground(Color.WHITE);
		btnUpMin_Fi.setBounds(158, 64, 45, 28);
		contentPane.add(btnUpMin_Fi);

		JButton btnDown_MinFI = new JButton("D");
		btnDown_MinFI.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnDown_MinFI.setBackground(Color.WHITE);
		btnDown_MinFI.setBounds(156, 169, 45, 28);
		contentPane.add(btnDown_MinFI);

		JButton btnDown_MinLa = new JButton("D");
		btnDown_MinLa.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnDown_MinLa.setBackground(Color.WHITE);
		btnDown_MinLa.setBounds(211, 169, 45, 28);
		contentPane.add(btnDown_MinLa);

		JButton btnUpH_MIN_LA = new JButton("U");
		btnUpH_MIN_LA.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		btnUpH_MIN_LA.setBackground(Color.WHITE);
		btnUpH_MIN_LA.setBounds(211, 64, 45, 28);
		contentPane.add(btnUpH_MIN_LA);

		btnUpH.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
			
				increaseNumber(lbl_H, 23);

				
			}
		});
		btnUpH.setBounds(37, 64, 98, 28);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				flagsnnoz = 0;
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCancel.setBounds(237, 228, 127, 38);
		contentPane.add(btnCancel);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{AlarmLabel, lblNewLabel, btnOk, btnUpH, btnDownH, panel, lbl_H, panel_1, panel_1_1, btnUpMin_Fi, btnDown_MinFI, btnDown_MinLa, btnUpH_MIN_LA, lblMin_FIR, lblMIN_LA, btnCancel}));

		btnDownH.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
			
				decreaseNumber(lbl_H, 0);

			

			}
		});

		btnUpMin_Fi.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
			

				increaseNumber(lblMin_FIR, 5);

		

			}
		});

		btnDown_MinFI.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
			
				decreaseNumber(lblMin_FIR, 0);
			

			}
		});

		btnUpH_MIN_LA.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
		
				increaseNumber(lblMIN_LA, 9);
			

			}
		});

		btnDown_MinLa.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
			
				decreaseNumber(lblMIN_LA, 0);
	
			}
		});
		
	

	}

	public void increaseNumber(JLabel label, int maxLimit)
	{
		
		if (currentNumber < maxLimit)
		{

			currentNumber++;
			label.setText(String.valueOf(currentNumber));

			
		}

	
	}

	public void decreaseNumber(JLabel label, int minLimit)
	{
		
		if (currentNumber > minLimit)
		{

			currentNumber--;
			label.setText(String.valueOf(currentNumber));

		}
	
	}

}

package clock;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;

public class setAlam extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_setname;
	private Font f4;

	public static String temp_h, temp_m;
	public String temp_am;
	public static int flag = 0;
	public static String filesoundselect;
	private static JComboBox<String> sel_H;
	private static JComboBox<String> sel_Mf;
	private static JComboBox<String> sel_Ml;
	public static boolean[] tempdayflag;
	private JCheckBox chckbxAlam;
	private JComboBox<Integer> selectsound;
	private JCheckBox chckS;
	private JCheckBox chckS_m;
	private JCheckBox chckS_tue;
	private JCheckBox chckS_wen;
	private JCheckBox chckS_th;
	private JCheckBox chckS_fri;
	private JCheckBox chckS_sat;
	private JButton btnBrowse;
	private JButton btnSubmit;
	public static String nameOAlam;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public setAlam()
	{
		tempdayflag = new boolean[7];

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 327);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		f4 = new Font("Tahoma", Font.BOLD, 30);

		JLabel AlarmLabel = new JLabel("Alarm:");
		AlarmLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AlarmLabel.setBounds(37, 25, 87, 23);
		contentPane.add(AlarmLabel);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(37, 72, 87, 23);
		contentPane.add(lblName);

		String[] namesound =
		{ "", "alarm_clock", "alarm_bell", "chiptune", "house_alarm", "star_dus", "tic_tac" };

		selectsound = new JComboBox(namesound);
		selectsound.setFont(new Font("Tahoma", Font.PLAIN, 14));
		selectsound.setBounds(95, 25, 172, 28);
		selectsound.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{

				refreshDataSetAlam();
			}
		});
		contentPane.add(selectsound);

		chckbxAlam = new JCheckBox("Alarm on");
		chckbxAlam.setForeground(new Color(0, 0, 255));
		chckbxAlam.setBackground(Color.LIGHT_GRAY);
		chckbxAlam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxAlam.setBounds(373, 6, 93, 28);
		chckbxAlam.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (chckbxAlam.isSelected())
				{

					flag = 1;

				} else
				{
					flag = 0;
				}

			}
		});
		contentPane.add(chckbxAlam);

		textField_setname = new JTextField();
		textField_setname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_setname.setBounds(94, 67, 312, 28);
		contentPane.add(textField_setname);
		textField_setname.setColumns(10);

		JLabel lblName_1 = new JLabel(":");
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1.setBounds(198, 124, 24, 23);
		contentPane.add(lblName_1);

		chckS = new JCheckBox("Su");
		chckS.setBackground(Color.LIGHT_GRAY);
		chckS.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckS.setBounds(6, 180, 55, 28);
		chckS.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (chckS.isSelected())
				{

				
					tempdayflag[0] = true;

				} else
				{
					tempdayflag[0] = false;
				

				}

			}
		});
		contentPane.add(chckS);

		chckS_m = new JCheckBox("Mo");
		chckS_m.setBackground(Color.LIGHT_GRAY);
		chckS_m.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckS_m.setBounds(76, 180, 55, 28);
		chckS_m.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{

				if (chckS_m.isSelected())
				{

					
					tempdayflag[1] = true;
				} else
				{

				
					tempdayflag[1] = false;
				}

			}
		});
		contentPane.add(chckS_m);

		chckS_tue = new JCheckBox("Tu");
		chckS_tue.setBackground(Color.LIGHT_GRAY);
		chckS_tue.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckS_tue.setBounds(144, 180, 55, 28);
		chckS_tue.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (chckS_tue.isSelected())
				{

					tempdayflag[2] = true;
				} else
				{
					
					tempdayflag[2] = false;
				}

			}
		});
		contentPane.add(chckS_tue);

		chckS_wen = new JCheckBox("We");
		chckS_wen.setBackground(Color.LIGHT_GRAY);
		chckS_wen.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckS_wen.setBounds(212, 180, 55, 28);
		chckS_wen.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				tempdayflag[3] = isCheckBoxDay(chckS_wen);

			}
		});
		contentPane.add(chckS_wen);

		chckS_th = new JCheckBox("Th");
		chckS_th.setBackground(Color.LIGHT_GRAY);
		chckS_th.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckS_th.setBounds(276, 180, 55, 28);
		chckS_th.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				tempdayflag[4] = isCheckBoxDay(chckS_th);

			}
		});

		contentPane.add(chckS_th);

		chckS_fri = new JCheckBox("Fr");
		chckS_fri.setBackground(Color.LIGHT_GRAY);
		chckS_fri.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckS_fri.setBounds(345, 180, 55, 28);
		chckS_fri.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				tempdayflag[5] = isCheckBoxDay(chckS_fri);

			}
		});

		contentPane.add(chckS_fri);

		chckS_sat = new JCheckBox("Sa");
		chckS_sat.setBackground(Color.LIGHT_GRAY);
		chckS_sat.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckS_sat.setBounds(411, 180, 55, 28);
		chckS_sat.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				tempdayflag[6] = isCheckBoxDay(chckS_sat);

			}
		});
		contentPane.add(chckS_sat);

		btnBrowse = new JButton("Browse");
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBrowse.setBounds(106, 232, 104, 34);
		btnBrowse.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				filesoundselect = selectWavFile();
			}
		});
		contentPane.add(btnBrowse);
		System.out.println(flag);

		btnSubmit = new JButton("Submit");

		btnSubmit.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{

				if (!checkSelectchoice(sel_H))
					return;
				if (!checkSelectchoice(sel_Mf))
					return;
				if (!checkSelectchoice(sel_Ml))
					return;

				if (flag == 1)
				{

					Mailclock main = Mailclock.getInstance();
					main.setVisible(true);

					nameOAlam = textField_setname.getText().toString();
					int hour = Integer.parseInt(temp_h);
					int mini = Integer.parseInt(temp_m);

					
					if(selectsound.getSelectedItem()!=null) {
						
						
						refreshDataSetAlam();
						
					
						main.updateAlamSettings(hour, mini, flag, nameOAlam,filesoundselect);

					}else
					{
				
						filesoundselect = selectWavFile();
						main.updateAlamSettings(hour, mini, flag, nameOAlam,filesoundselect);

					}

					dispose();

				} else
				{
					JOptionPane.showMessageDialog(null, "You dont set set Alam");
					
				}

			}

		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(254, 232, 104, 34);
		contentPane.add(btnSubmit);

		String hour[] = new String[25];
		hour[0] = "HH";
		for (int i = 0; i < 24; i++)
		{

			hour[i + 1] = String.valueOf(String.format("%02d", i));

		}
		sel_H = new JComboBox(hour);
		sel_H.setBackground(new Color(255, 255, 255));
		sel_H.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sel_H.setBounds(94, 115, 94, 49);
		sel_H.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{

				if (sel_H.getSelectedIndex() != 0)
				{

					temp_h = sel_H.getSelectedItem().toString();

				}

			}
		});
		contentPane.add(sel_H);

		String MinF[] = new String[7];
		MinF[0] = "m";
		for (int i = 0; i < 6; i++)
		{

			MinF[i + 1] = String.valueOf(i);

		}

		sel_Mf = new JComboBox(MinF);
		sel_Mf.setBackground(new Color(255, 255, 255));
		sel_Mf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sel_Mf.setBounds(208, 115, 47, 49);

		sel_Mf.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (sel_Mf.getSelectedItem() != null)
				{

					temp_m = sel_Mf.getSelectedItem().toString();

				}

			}
		});
		contentPane.add(sel_Mf);

		String MinL[] = new String[11];
		MinL[0] = "m";
		for (int i = 0; i < 10; i++)
		{

			MinL[i + 1] = String.valueOf(i);

		}

		sel_Ml = new JComboBox(MinL);
		sel_Ml.setBackground(new Color(255, 255, 255));
		sel_Ml.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sel_Ml.setBounds(265, 115, 47, 49);
		sel_Ml.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{

				if (sel_Ml.getSelectedItem() != null)
				{

					if (sel_Ml.getSelectedItem().equals(0))
					{

						temp_m += "0";

					} else
					{
						temp_m += sel_Ml.getSelectedItem().toString();
					}

				}

			}
		});
		contentPane.add(sel_Ml);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				playSound(filesoundselect);
			}
		});
		btnPlay.setForeground(Color.WHITE);
		btnPlay.setBackground(Color.LIGHT_GRAY);
		btnPlay.setBounds(282, 25, 75, 28);
		contentPane.add(btnPlay);
		nameOAlam = textField_setname.getText();

		if (sel_Mf.getSelectedItem() != null)
			refreshMini();

		if (sel_H.getSelectedItem() != null)
			refreshHour();

	}

	public void refreshDataSetAlam()
	{

		if (selectsound.getSelectedIndex() != 0)
		{
			int indexfile = selectsound.getSelectedIndex();

			String[] pathsound =
			{ "", ".//sound//alarm_clock.wav", ".//sound//alarmclock-bell.wav", ".//sound//chiptune.wav",
					".//sound//house_alarm.wav", ".//sound//star-dus.wav", ".//sound//tic-tac.wav" };

			filesoundselect = pathsound[indexfile];

		}

	}

	public static boolean checkSelectchoice(JComboBox<String> select)
	{

		boolean isCk = false;

		if (select.getSelectedIndex() != 0)
		{

			isCk = true;
		}

		return isCk;

	}

	public static String selectWavFile()
	{

		// สร้าง JFileChooser object
		JFileChooser filecshoser = new JFileChooser();
		// กรองไฟล์นามสกุล .wav
		FileNameExtensionFilter filter = new FileNameExtensionFilter("WAV Sound files", "wav");

		filecshoser.setFileFilter(filter);
		// open windwow
		int returnvalue = filecshoser.showOpenDialog(null);
		// if user ok
		if (returnvalue == JFileChooser.APPROVE_OPTION)
		{
			// accep file
			File selectFile = filecshoser.getSelectedFile();
			System.out.println("Select file : " + selectFile.getAbsolutePath());

			return selectFile.getAbsolutePath();

		} else
		{

			System.out.println("No file selected");

			return null;
		}
	}


	public static void refreshHour()
	{

		if (sel_H.getSelectedIndex() != 0)
		{

			temp_h = sel_H.getSelectedItem().toString();

		}
	}

	public static void refreshMini()
	{

		if (sel_Mf.getSelectedIndex() != 0)
		{

			temp_m = sel_Mf.getSelectedItem().toString();

		}
	}

	public static boolean isCheckBoxDay(JCheckBox c)
	{

		if (c.isSelected())
		{

			return true;
		} else
		{
			return false;
		}

	}
	
	public static void playSound(String filepath)
	{

		try
		{
			File soundfile = new File(filepath);
			AudioInputStream audioStrem = AudioSystem.getAudioInputStream(soundfile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStrem);
			clip.start();

			clip.drain();

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}

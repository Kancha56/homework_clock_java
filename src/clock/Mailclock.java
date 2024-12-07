package clock;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.SwingConstants;



public class Mailclock extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private Font f3;
	private static Mailclock instance;

	public static int temp_h, temp_m, minite, hour, day, snooze_h, snooze_m, mainSetsnooze;
	public String temp_am, nameAlarm, wd;
	public static int flag;
	public static String pathsoud;
	public JLabel lbHH;
	public JLabel lbmm;
	public JLabel lblDateMmYyyy;
	public JLabel lblSetalm;
	public JButton btn_setAlam;
	public JButton btn_setSnooze;
	private JLabel Temdayalarm;
	private JLabel lblcoundown;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Mailclock frame = new Mailclock();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mailclock()
	{
		currentTime();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 327);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		f3 = new Font("Digital-7", Font.BOLD, 85);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(20, 10, 428, 210);
		contentPane.add(panel);
		panel.setLayout(null);

		lbHH = new JLabel();
		lbHH.setHorizontalAlignment(SwingConstants.CENTER);
		lbHH.setForeground(new Color(30, 144, 255));
		lbHH.setFont(f3);
		lbHH.setBounds(109, 31, 101, 79);
		panel.add(lbHH);

		lbmm = new JLabel();
		lbmm.setHorizontalAlignment(SwingConstants.CENTER);
		lbmm.setForeground(new Color(30, 144, 255));
		lbmm.setFont(f3);
		lbmm.setBounds(220, 31, 101, 79);
		panel.add(lbmm);

		lblDateMmYyyy = new JLabel("");
		lblDateMmYyyy.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateMmYyyy.setForeground(new Color(30, 144, 255));
		lblDateMmYyyy.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDateMmYyyy.setBounds(89, 90, 270, 79);
		panel.add(lblDateMmYyyy);

		lblSetalm = new JLabel("");
		lblSetalm.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetalm.setForeground(new Color(255, 0, 0));
		lblSetalm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSetalm.setBounds(89, 147, 270, 49);
		panel.add(lblSetalm);

		Temdayalarm = new JLabel("");
		Temdayalarm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Temdayalarm.setForeground(Color.WHITE);
		Temdayalarm.setHorizontalAlignment(SwingConstants.RIGHT);
		Temdayalarm.setBounds(274, 179, 144, 21);
		panel.add(Temdayalarm);

		lblcoundown = new JLabel("");
		lblcoundown.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblcoundown.setHorizontalAlignment(SwingConstants.CENTER);
		lblcoundown.setForeground(Color.WHITE);
		lblcoundown.setBounds(369, 147, 45, 13);
		panel.add(lblcoundown);

		btn_setAlam = new JButton("Set Alarms");
		btn_setAlam.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btn_setAlam.setBackground(Color.LIGHT_GRAY);
		btn_setAlam.setBounds(30, 226, 202, 54);
		btn_setAlam.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				displaySetAlarmWindow();
			}
		});

		contentPane.add(btn_setAlam);

		btn_setSnooze = new JButton("Set Snooze");
		btn_setSnooze.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		btn_setSnooze.setBackground(Color.LIGHT_GRAY);
		btn_setSnooze.setBounds(242, 226, 202, 54);
		btn_setSnooze.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				displaySetSnoozeWindow();

			}
		});
		contentPane.add(btn_setSnooze);

	}

	public void currentTime()
	{

		Thread clock;
		clock = new Thread()
		{

			public void run()
			{

				for (;;)
				{
					Calendar cal = new GregorianCalendar();

					minite = cal.get(Calendar.MINUTE);
					hour = cal.get(Calendar.HOUR_OF_DAY);
					day = cal.get(Calendar.DAY_OF_MONTH) ;
					int second = cal.get(Calendar.SECOND);
					int mont = cal.get(Calendar.MONTH) + 1;
					int year = cal.get(Calendar.YEAR);

					// AM PM

					Calendar datetime = Calendar.getInstance();

					// week day

					DateTimeFormatter fommatday = DateTimeFormatter.ofPattern("EEEE, MMM yyyy");
					String days = fommatday.format(LocalDate.of(year, mont, day));

					String[] strDays = new String[]
					{ "Sunday", "Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday" };

					wd = strDays[datetime.get(Calendar.DAY_OF_WEEK) - 1];

					// setting to label time

					lbHH.setText(String.format("%02d", hour));
					lbmm.setText(String.format("%02d", minite));
					lblDateMmYyyy.setText(days);

					if (hour == temp_h && minite == temp_m)
					{

						for (int i = 0; i < setAlam.tempdayflag.length; i++)
						{

							if (setAlam.tempdayflag[i])
							{

								String daysal = strDays[i];

								if (daysal.equals(wd))
								{

									playSound(pathsoud);
								}

							}

						}

					}
					int currenth = (temp_h + snooze_h);
					int curenmin = (temp_m + snooze_m);
					
					
					if (mainSetsnooze== 1 && currenth == hour && minite == curenmin)
					{	
						lblcoundown.setText("เหลือเวลา "+(curenmin - minite));
						playSound(pathsoud);
						
						if (second == 50 || mainSetsnooze == 0)
						{
							break;

						}
					}

					try
					{
						Thread.sleep(1000); // รอ 1 วินาที
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}

				}

			}

		};
		clock.start();

	}

	public void updateAlamSettings(int h, int m, int f, String alarmName, String path)
	{

		temp_h = h;
		temp_m = m;
		flag = f;
		nameAlarm = alarmName;
		pathsoud = path;

		String[] strDays = new String[]
		{ "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		String savdate = "";

		if (setAlam.tempdayflag != null)
		{
			for (int i = 0; i < setAlam.tempdayflag.length; i++)
			{

				if (setAlam.tempdayflag[i])
				{
					savdate += strDays[i] + " ";

				}

			}
		}
		Temdayalarm.setText(savdate);
		lblSetalm.setText(nameAlarm + " ( " + temp_h + " : " + temp_m + " )");

	}

	public void updateSetSnooze(int h, int m, int Setsnooze)
	{

		mainSetsnooze = 0;
		snooze_h = h;
		snooze_m = m;
		mainSetsnooze = Setsnooze;

	}

	public static Mailclock getInstance()
	{

		if (instance == null)
		{
			instance = new Mailclock();
		}

		return instance;

	}

	public void displaySetAlarmWindow()
	{
		setAlam setalam = new setAlam();
		setalam.setVisible(true);
		this.dispose();
	}

	public void displaySetSnoozeWindow()
	{
		setSnooze setsoonz = new setSnooze();
		setsoonz.setVisible(true);
		this.dispose();
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

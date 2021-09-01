package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField textField_lu;
	private JTextField textField_apellido;
	private JTextField textField_nombre;
	private JTextField textField_email;
	private JTextField textField_URL;
	private JLabel lblFoto;
	private JLabel lblDate;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		String rutaLogo= this.getClass().getResource("/images/tdp.png").toString();
		ImageIcon logo=null;
		try {
			logo = new ImageIcon(new URL(rutaLogo));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
		this.setIconImage(logo.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	@SuppressWarnings("deprecation")
	private void init() {
		// Tabbed Pane to student personal data
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBackground(new Color(240, 128, 128));
		tabInformation = new JPanel();
		tabInformation.setBorder(new LineBorder(new Color(220, 20, 60)));
		tabInformation.setForeground(new Color(255, 20, 147));
		tabInformation.setBackground(new Color(255, 228, 225));
		tabInformation.setPreferredSize(new Dimension(400, 160));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LU:");
		lblNewLabel_1.setBounds(20, 11, 71, 14);
		tabInformation.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido:");
		lblNewLabel_2.setBounds(20, 36, 71, 14);
		tabInformation.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setBounds(20, 61, 71, 14);
		tabInformation.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail:");
		lblNewLabel_4.setBounds(20, 86, 71, 14);
		tabInformation.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Github URL:");
		lblNewLabel.setBounds(20, 111, 71, 14);
		
		tabInformation.add(lblNewLabel);
		
		textField_lu = new JTextField();
		textField_lu.setBounds(95, 8, 246, 20);
		tabInformation.add(textField_lu);
		textField_lu.setColumns(10);
		textField_lu.setText(String.valueOf(studentData.getId()));
		
		textField_apellido = new JTextField();
		textField_apellido.setBounds(95, 33, 246, 20);
		tabInformation.add(textField_apellido);
		textField_apellido.setColumns(10);
		textField_apellido.setText(studentData.getLastName());
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(95, 58, 246, 20);
		tabInformation.add(textField_nombre);
		textField_nombre.setColumns(10);
		textField_nombre.setText(studentData.getFirstName());

		textField_email = new JTextField();
		textField_email.setBounds(95, 83, 246, 20);
		tabInformation.add(textField_email);
		textField_email.setColumns(10);
		textField_email.setText(studentData.getMail());
		
		textField_URL = new JTextField();
		textField_URL.setBounds(95, 108, 246, 20);
		tabInformation.add(textField_URL);
		textField_URL.setColumns(10);
		textField_URL.setText(studentData.getGithubURL());
		
		Date date=new Date(); 
		String fecha=date.toLocaleString(); 
		String[] partes = fecha.split(" ");
		String fechaActual=partes[0];
		String horario=partes[1]; 
		
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		lblDate = new JLabel("Esta ventana fue generada el: "+fechaActual+" a las: "+horario);
		contentPane.add(lblDate, BorderLayout.SOUTH);
		
		lblFoto = new JLabel("");
		ImageIcon foto=null;
		try {
			foto = new ImageIcon(new URL(studentData.getPathPhoto()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Image medida= foto.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		lblFoto.setIcon(new ImageIcon(medida));
		contentPane.add(lblFoto, BorderLayout.CENTER);
		
	}
}
package launcher;

import entities.Student;
import gui.SimplePresentationScreen;
import java.awt.Color;

public class Launcher {
	
	private static SimplePresentationScreen screen; 
	private static Student student; 
	
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	String rutaFoto= this.getClass().getResource("/images/foto.jpeg").toString();
            	student=new Student(105536,"Moyano","Yohana","yohi.moyano@gmail.com","https://github.com/yohanakmoyano/",rutaFoto); 
            	screen=new SimplePresentationScreen(student); 
            	screen.getContentPane().setBackground(new Color(255, 182, 193));
            	screen.getContentPane().setForeground(new Color(255, 20, 147));
            	screen.setVisible(true);
            }
        });
    }
	
}
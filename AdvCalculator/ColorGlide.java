import javax.swing.*;
import java.awt.*;
public class ColorGlide extends Thread{

	//System.out.println(r+","+g+","+b);
	ColorGlide()
	{
		run();
	}
	public void run() 
	{
		getFrame(new Calculator().f1);
	}
	
	public void getFrame(JFrame x) 
	{
		Container f= x.getContentPane();
		
		while(x.isVisible())
		{
		//Black to red
		int r=0,g=0,b=0;
		for(r=0;r<=255;r++) {
		try 
		{
			Thread.currentThread().sleep(10);
		}
		catch(Exception e){			}
		Color c= new Color(r,g,b);
		f.setBackground(c);
		}
		
		r=255;
		//Red to Orange
		for(g=0;g<=127;g++) {
		try 
		{
			Thread.currentThread().sleep(10);
		}
		catch(Exception e){			}
		Color c= new Color(r,g,b);
		f.setBackground(c);
		}
		
		
		r=255;
		//Orange to Yellow
		for(g=127;g<=255;g++) {
		try 
		{
			Thread.currentThread().sleep(10);
		}
		catch(Exception e){			}
		Color c= new Color(r,g,b);
		f.setBackground(c);
		}
		
		g=255;
		//Yellow to Green
		for(r=255; r>=0 ;r--) {
		try 
		{
			Thread.currentThread().sleep(10);
		}
		catch(Exception e){	}
		Color c= new Color(r,g,b);
		f.setBackground(c);
		}
		
		
		r=0;
		//Final Green to Blue
		for(b=0,g=255;b<=255;b++) {
		try 
		{
			Thread.currentThread().sleep(10);
		}
		catch(Exception e){			}
		Color c= new Color(r,g,b);
		f.setBackground(c);
		g--;
		}
		
		
		//White to Black
		for(r=0,g=0,b=255; b>=0 ;b--) {
		try 
		{
			Thread.currentThread().sleep(10);
		}
		catch(Exception e){	}
		Color c= new Color(r,g,b);
		f.setBackground(c);
		}
	
		}
	}
	public static void main(String[] args) {
		new ColorGlide();
	}
}

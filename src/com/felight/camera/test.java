package com.felight.camera;
import java.awt.BorderLayout;
import javax.media.*;
import javax.media.protocol.*;
import javax.swing.*;
import java.awt.*; 
import java.util.*;
import javax.media.control.FormatControl;
import javax.media.format.VideoFormat;



public class test {
	
	public static void main(String[] args){
		test t = new test();
		t.getCam();
	}
	
	public void getCam(){
	try{
 
		/* Grab the default web cam*/
		MediaLocator ml = new MediaLocator("vfw://0");

		/* Create my data source */
		DataSource ds = Manager.createDataSource(ml);
 
 		requestFormatResolution(ds);
 
		/* Create & start my player */
		Player p = Manager.createRealizedPlayer(ds);

		p.start();
		
		Thread.currentThread().sleep(1000);

		/* code for creating a JFrame and adding the visual component to it */
		JFrame jfrm=new JFrame("Testing Webcam");
				jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				if(p.getVisualComponent()!=null)jfrm.getContentPane().add(p.getVisualComponent());
				if(p.getControlPanelComponent()!=null)jfrm.getContentPane().add
						(p.getControlPanelComponent(),BorderLayout.SOUTH);
				jfrm.pack();
				jfrm.setLocationRelativeTo(null);
				jfrm.setVisible(true);
				jfrm.setSize(320,240);

				
		}catch(Exception e){
		e.printStackTrace();		 
		}
	}   
	
	
		
	public boolean requestFormatResolution(DataSource ds) {
 
		if (ds instanceof CaptureDevice) {
			FormatControl[] fcs = ((CaptureDevice) ds).getFormatControls();
			for (FormatControl fc : fcs) {
				Format[] formats = ((FormatControl) fc).getSupportedFormats();
				for (Format format : formats) {
					if ((format instanceof VideoFormat) &&
						(((VideoFormat)format).getSize().getHeight() <= 240) &&
						(((VideoFormat)format).getSize().getWidth()  <= 320)) {
							((FormatControl) fc).setFormat(format);
							return true;
					}
				}
			}
		}
		return false;
	}
	
	

}


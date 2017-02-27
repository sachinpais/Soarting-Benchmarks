package com.felight.javamail;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;

public class Mp3 {
	public static void main(String[] args){
		try{
			File file=new File("C:/Users/Sachin S Bethur/Desktop/Follow Follow.mp3");
			FileInputStream fis=new FileInputStream(file);
			BufferedInputStream buff=new BufferedInputStream(fis);
			try{
				javazoom.jl.player.Player player=new javazoom.jl.player.Player(buff);
				player.play();
			}catch(JavaLayerException ex){
				ex.printStackTrace();
			}
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
	}

}

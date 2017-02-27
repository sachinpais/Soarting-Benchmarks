package com.felight.javamail;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class FreeTTS {
	private static final String VOICENAME_kevin = "kevin16";
	private String text; // string to speech

	public FreeTTS(String text) {
		this.text = text;
	}

	public void speak() {
		//System.setProperty("freetts.voices","de.dfki.lt.freetts.en.us.MbrolaVoiceDirectory");
		Voice voice;
		VoiceManager voiceManager = VoiceManager.getInstance();
		voice = voiceManager.getVoice(VOICENAME_kevin);
		voice.allocate();
		voice.speak(text);
	}

	public static void main(String[] args) {
		String text = "Daksh Happy Birthday";
		FreeTTS freeTTS = new FreeTTS(text);
		//for(int i=0;i<10;i++)
			freeTTS.speak();
	}
}
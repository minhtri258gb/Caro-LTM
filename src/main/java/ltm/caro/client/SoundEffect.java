package ltm.caro.client;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundEffect {

	private Clip clip;

	public SoundEffect(String filepath) {
		try {
			URL url = getClass().getClassLoader().getResource(filepath);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void play(boolean loop, boolean force) {
		if (clip.isRunning() && !force)
			return;
		if (clip.isRunning())
			clip.stop();
		clip.setFramePosition(0);
		clip.start();
		if(loop)
			clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stop() {
		clip.stop();
		clip.setFramePosition(0);
	}

}

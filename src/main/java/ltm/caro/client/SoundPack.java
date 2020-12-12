package ltm.caro.client;

import java.util.Random;

public class SoundPack {

	private static final SoundEffect sclicka1 = new SoundEffect("sound/clicka1.wav");
	private static final SoundEffect sclicka2 = new SoundEffect("sound/clicka2.wav");
	private static final SoundEffect sclickb1 = new SoundEffect("sound/clickb1.wav");
	private static final SoundEffect sclickb2 = new SoundEffect("sound/clickb2.wav");
	private static final SoundEffect serror1 = new SoundEffect("sound/error1.wav");
	private static final SoundEffect serror2 = new SoundEffect("sound/error2.wav");
	private static final SoundEffect serror3 = new SoundEffect("sound/error3.wav");
	private static final SoundEffect sturn = new SoundEffect("sound/turn.wav");
	private static final SoundEffect swin = new SoundEffect("sound/win.wav");
	private static final SoundEffect slost = new SoundEffect("sound/lost.wav");
	private static final SoundEffect sdraw = new SoundEffect("sound/draw.wav");
	private static final SoundEffect sticktock = new SoundEffect("sound/ticktock.wav");
//	private static final SoundEffect stheme = new SoundEffect("sound/theme.mp3");

	private static final Random generator = new Random();

	public static void clicka() {
		switch (generator.nextInt(2)) {
			case 0: sclicka1.play(false, true); break;
			case 1: sclicka2.play(false, true); break;
		}
	}

	public static void clickb() {
		switch (generator.nextInt(2)) {
			case 0: sclickb1.play(false, true); break;
			case 1: sclickb2.play(false, true); break;
		}
	}

	public static void error() {
		switch (generator.nextInt(3)) {
			case 0: serror1.play(false, true); break;
			case 1: serror2.play(false, true); break;
			case 2: serror3.play(false, true); break;
		}
	}

	public static void turn() { sturn.play(false, true); }

	public static void win() { swin.play(false, true); }

	public static void draw() { sdraw.play(false, true); }

	public static void lost() { slost.play(false, true); }

	public static void ticktock(boolean play) {
		if (play)
			sticktock.play(true, false);
		else
			sticktock.stop();
	}

//	public static void theme(boolean play) {
//		if (play)
//			stheme.play(true, false);
//		else
//			stheme.stop();
//	}

}

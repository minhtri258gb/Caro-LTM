package ltm.caro.client;

import ltm.caro.server.Match;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.List;

public class CountDown implements Runnable {

	private static LocalTime roundtime;
	private static LocalTime turntime;

	public static void setRoundTime(LocalTime starttime) {
		roundtime = starttime;
		turntime = LocalTime.now();
	}

	public static void turn() {
		turntime = LocalTime.now();
	}

	public static void end() {
		roundtime = turntime = null;
	}

	@Override
	public void run() {
		try {
			roundtime = turntime = null;

			while (true) {

				if (roundtime != null) {
					LocalTime curtime = LocalTime.now();
					int roundCD = Match.MAX_ROUNDTIME - (int)ChronoUnit.SECONDS.between(roundtime , curtime);
					int turnCD = Match.MAX_TURNTIME - (int)ChronoUnit.SECONDS.between(turntime , curtime);

					GameScreenGUI.ins.setCD(roundCD, turnCD);
				}

				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Countdown thread shutdow");
		}
	}
}

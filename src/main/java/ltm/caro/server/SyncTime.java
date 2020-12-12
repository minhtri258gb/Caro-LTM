package ltm.caro.server;


import ltm.caro.util.DateTimeUtil;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SyncTime implements Runnable {
	@Override
	public void run() {
		try {
			while (true) {

				List<Match> processMatch = new ArrayList<>();

				for (Match match : Server.matchs) {
					if (match==null)
						continue;

					String starttimeStr = match.getRoom().getTimeBegin();
					if (starttimeStr == null)
						continue;

					Date starttime = DateTimeUtil.covStringToDateTime(starttimeStr);
					Date curtime = new Date();
					long seconds = (curtime.getTime()-starttime.getTime())/1000;

					if (seconds > Match.MAX_ROUNDTIME)
						processMatch.add(match);
					else if (match.getTimeTurn().plusSeconds(Match.MAX_TURNTIME).isBefore(LocalTime.now())) {
						match.changeturn(666, 666);
					}
				}

				// Fix ConcurrentModificationException
				for (Match match : processMatch)
					match.end(3, -1, -1);

				Thread.sleep(1000); // Kiem tra ~> 1 second
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

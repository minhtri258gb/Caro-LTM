package ltm.caro.server.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "room")

public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "player_id1")
	private Player player1;

	@ManyToOne(optional = false)
	@JoinColumn(name = "player_id2")
	private Player player2;

	@Column(name = "result")
	private int result;

	@Column(name = "timebegin")
	private String timebegin;

	@Column(name = "duration")
	private int duration;


	public Room() {
		id = result = 0;
		player1 = player2 = null;
		timebegin = null;
		duration = 0;
	}

	public int getId() { return id; }

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player p) {
		player1 = p;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player p) {
		player2 = p;
	}

	public int getResult() { return result;	}

	public void setResult(int result) {
		if (this.result > 0) {
			System.out.println("Ko the thay doi ket qua tran dau!");
			return;
		}

		if (result < 1 || result > 3) {
			System.out.println("Ket qua khong hop le!");
			return;
		}

		this.result = result;
	}

	public void setTimeBegin(String time) {
		timebegin = time;
	}

	public String getTimeBegin() {
		return timebegin;
	}

	public void setDuration(int time) {
		duration = time;
	}

	public int getDuration() {
		return duration;
	}

}

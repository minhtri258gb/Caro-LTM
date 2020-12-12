package ltm.caro.server.entity;

import javax.persistence.*;


@Entity
@Table()

public class Player
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "player_id")
	private int id;

	@Column(name = "account", length = 64, nullable = false, unique = true)
	private String account;

	@Column(name = "password", length = 64, nullable = false)
	private String password;

	@Column(name = "email", length = 64, nullable = false, unique = true)
	private String email;

	@Column(name = "gender")
	private boolean gender;

	@Column(name = "birthday", length = 16)
	private String birthday;

	@Column(name = "score")
	private int score;

	@Column(name = "winnum")
	private int winnum;

	@Column(name = "lostnum")
	private int lostnum;

	@Column(name = "winstreak")
	private int winstreak;

	@Column(name = "loststreak")
	private int loststreak;

	@Column(name = "winstreakmax")
	private int winstreakmax;

	@Column(name = "loststreakmax")
	private int loststreakmax;

	@Column(name = "block")
	private boolean block;

	public Player() {
		id = score = winnum = lostnum = winstreak = loststreak = winstreakmax = loststreakmax = 0;
		account = password = email = "";
	}

	public int getID()
	{
		return id;
	}
	public void setID(int id)
	{
		this.id = id;
	}

	public String getAccount()
	{
		return account;
	}
	public void setAccount(String account)
	{
		this.account = account;
	}

	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}

	public boolean getGender()
	{
		return gender;
	}
	public void setGender(boolean gender)
	{
		this.gender = gender;
	}

	public String getBirthday()
	{
		return birthday;
	}
	public void setBirthday(String date)
	{
		this.birthday = date;
	}

	public int getScore()
	{
		return score;
	}
	public void setScore(int score)
	{
		this.score = score;
	}

	public int getWinNum()
	{
		return winnum;
	}
	public void setWinNum(int num)
	{
		this.winnum = num;
	}

	public int getLostNum()
	{
		return lostnum;
	}
	public void setLostNum(int num)
	{
		this.lostnum = num;
	}

	public int getWinStreak()
	{
		return winstreak;
	}
	public void setWinStreak(int streak)
	{
		this.winstreak = streak;
	}

	public int getLostStreak()
	{
		return loststreak;
	}
	public void setLostStreak(int streak)
	{
		this.loststreak = streak;
	}

	public int getWinStreakMax()
	{
		return winstreakmax;
	}
	public void setWinStreakMax(int streakmax)
	{
		this.winstreakmax = streakmax;
	}

	public int getLostStreakMax()
	{
		return loststreakmax;
	}
	public void setLostStreakMax(int streakmax)
	{
		this.loststreakmax = streakmax;
	}

	public boolean getBlock()
	{
		return block;
	}
	public void setBlock(boolean block)
	{
		this.block = block;
	}

	public int getWinRate() {
		return (int)(winnum * 100.0 / (winnum + lostnum));
	}

}

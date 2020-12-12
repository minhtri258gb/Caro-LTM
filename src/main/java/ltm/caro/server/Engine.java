package ltm.caro.server;

import ltm.caro.server.database.impl.PlayerDAO;
import ltm.caro.server.database.impl.RoomDAO;
import ltm.caro.server.entity.Player;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Engine {

	public static void error(String mes) {
		System.out.println(mes);
	}

	public static void warning(String mes) {
		System.out.println(mes);
	}

	public static void notice(String mes) {
		System.out.println(mes);
	}

	public static void log(String mes) {
		System.out.println(mes);
	}

	public static boolean register(String account, String password, String email, boolean gender, String birthday) {
		// Default
		PlayerDAO dao = new PlayerDAO();

		// Kiem tra trung lap tai khoan
		Player ckPlayer = dao.findByAccount(account);
		if (ckPlayer != null) {
			notice("Tài khoản đã tồn tại, vui lòng chọn tên khác");
			return false;
		}
		ckPlayer = dao.findByEmail(email);
		if (ckPlayer != null) {
			notice("Email đã tồn tại, vui lòng chọn email khác");
			return false;
		}

		// kiem tra mat khau
		if (password.length() < 6) {
			notice("Mật khẩu tối thiểu 6 ký tự");
			return false;
		}

		String hashpass = hashMD5(password);

		// kiem tra email
		if (email.isEmpty()) {
			notice("Chưa nhập Email");
			return false;
		}

		final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		if (!matcher.find()) {
			notice("Dinh dang email chua dung");
			return false;
		}

		// Luu player vao database
		Player p = new Player();
		p.setAccount(account);
		p.setPassword(hashpass);
		p.setEmail(email);
		p.setGender(gender);
		p.setBirthday(birthday);

		dao.save(p);

		return true;
	}

	public static Player login(Worker curw, String account, String password) {
		// Default
		PlayerDAO dao = new PlayerDAO();

		// Tai khoan dang dang nhap
		for (Worker w : Server.workers) {
			if (w.getId() == curw.getId())
				continue;
			if (w.player != null && w.player.getAccount().equals(account)) {
				return null;
			}
		}

		// Tim kiem tren database
		Player p = null;
		try {
			p = dao.findByAccount(account);
		} catch (ExceptionInInitializerError | NoClassDefFoundError e) {
			Engine.error("Chưa bật xampp.");
		}

		// Kiem tra ten tai khoan
		if (p == null) {
			notice("Tài khoản hoặc mật khẩu không đúng!");
			return null;
		}

		// kiem tra block
		if (p.getBlock()) {
			notice("Tài khoản đã bị khóa!");
			return null;
		}

		// Kiem tra mat khau
		password = hashMD5(password); // Bam mat khau
		if (!p.getPassword().equals(password)) {
			notice("Tài khoản hoặc mật khẩu không đúng!");
			return null;
		}

		// Dang nhap thanh cong
		return p;
	}

	public static Match createMatch(Worker w1, Worker w2) {
		Match m = new Match();
		m.getRoom().setPlayer1(w1.player);
		m.getRoom().setPlayer2(w2.player);
		m.workerList.add(w1);
		m.workerList.add(w2);
		Server.matchs.add(m);
		return m;
	}

	public static String hashMD5(String s) {
		String hash = "";
		try {
			MessageDigest md = null;
			md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes());
			byte[] digest = md.digest();
			hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hash;
	}

}

package ltm.caro.client;

import ltm.caro.server.Engine;
import ltm.caro.server.entity.Player;
import ltm.caro.util.Crypto;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Client {
	private static String host = "192.168.43.72"; // 192.168.1.23
	private static int port = 1234;
	private static Socket socket;

	private static BufferedWriter out;
	private static BufferedReader in;

	private static ExecutorService executor;
	public static Crypto crypto;

	// thong tin game
	public static Player player = null;

	public static void notice(String mes) {
		SoundPack.error();
		JOptionPane.showMessageDialog(new JFrame(), mes);
	}

	public static int confirm(String mes) {
		return JOptionPane.showConfirmDialog(new JFrame(), mes, "", JOptionPane.YES_NO_OPTION);
	}

	public void run() {
		try {
			// Init
			crypto = new Crypto();
			executor = Executors.newFixedThreadPool(3);

			// Network
			socket = new Socket(host, port);
			Engine.log("Client connected ");

			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// Run
			executor.execute(new SendMessage(socket, out));
			executor.execute(new ReceiveMessage(socket, in));
			executor.execute(new CountDown());

		} catch (IOException e) {
			notice("Không tìm thấy server!");
			executor.shutdownNow();
			System.exit(0);
		}
	}

	public static void close() throws IOException {
		executor.shutdownNow();
		Engine.notice("Client closed");
		in.close();
		out.close();
		socket.close();
	}

}

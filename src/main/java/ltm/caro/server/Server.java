package ltm.caro.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
	public static final int port = 1234;
	public static final int MAX_CLIENT = 32;
	private static ServerSocket server = null;
	public static Vector<Worker> workers = new Vector<>();
	public static List<Match> matchs = new ArrayList<>();
	private static ExecutorService executor;

	public static void main(String[] args) {
		executor = Executors.newFixedThreadPool(MAX_CLIENT + 2);
		try {
			server = new ServerSocket(port);
			Engine.log("Server binding at port " + port + "\nServer ready.");

			// Luong input server
			executor.execute(new AdminCMD());
			executor.execute(new SyncTime());

			// Framework
			while (true) {
				Socket socket = server.accept();
				int id = workers.size();
				Worker client = new Worker(id, socket);
				workers.add(client);
				executor.execute(client);
			}
		} catch (IOException e) {
			Engine.error(e.getMessage());
		}
	}

	public static void close() throws IOException {
		executor.shutdownNow();
		Engine.notice("Client closed");
		if (server != null)
			server.close();
	}

}

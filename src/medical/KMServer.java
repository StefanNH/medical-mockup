package medical;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

import org.postgresql.ds.PGPoolingDataSource;

public class KMServer extends Thread {

	private static ServerSocket serverSock;
	private static Socket clientSock;
	private final static int PORT = 5050;
	public static ArrayList<Thread> clients = new ArrayList<>();

	public static void main(String[] args) {
		new KMServer().start();
	}

	public void run() {
		try {
			try {
				PGPoolingDataSource source = new PGPoolingDataSource();
				// Establish a connection to the database Connection
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/kwikdb", "kwikuser",
						"password");
				Statement stmt = conn.createStatement();
				/*
				 * String sql = "INSERT INTO patient (ID,NAME,ADDRESS) " +
				 * "VALUES (4, 'Karl Zigfried','11 Walter Scott avenue');";
				 * stmt.executeUpdate(sql);
				 */

				ResultSet rs = stmt.executeQuery("SELECT * FROM patient;");
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String address = rs.getString("address");
					System.out.println("ID = " + id);
					System.out.println("NAME = " + name);
					System.out.println("ADDRESS = " + address);

				}
				System.out.println("Server runing");
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
			}


		} catch (Exception e) {
			e.printStackTrace();
			/*
			 * } finally { try { serverSock.close(); clientSock.close(); } catch
			 * (IOException e) { e.printStackTrace(); }
			 */
		}
	}

}

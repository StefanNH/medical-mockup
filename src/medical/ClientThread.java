package medical;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientThread implements Runnable {
	private Socket socket;
	private static DataInputStream in;
	private static ObjectOutputStream out;

	public ClientThread(Socket client) {
		try {
			this.socket = client;
			in = new DataInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			String inData = in.readUTF();
			ArrayList<Packet> arr = new ArrayList<>();
			Packet zzp = new Packet(3, "zzp testing");
			arr.add(new Packet(1, "Dorororo"));
			arr.add(new Packet(2, "Wakamuu"));
			System.out.println(inData);
			out.writeObject(zzp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}
}

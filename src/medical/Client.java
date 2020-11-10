package medical;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	private static final int PORT = 5050;
	public static void main(String args[]) {
		Socket s = null;
		try {
			
			s = new Socket(InetAddress.getLocalHost(), PORT);
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			String str = args[0];
			out.writeUTF(str); // UTF is a string encoding format
			Packet packet = (Packet) in.readObject();
		//	for (Packet packet : data) {
				System.out
						.println("received packet with id: " + packet.getId() + " and message: " + packet.getMessage());
			//}
			s.close();
		} catch (Exception e) {
			System.out.println("Error:" + e.toString());
		}
	}
}

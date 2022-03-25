package Q11.inf.code.java;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class test {

	public static void main(String[] args) throws Exception{

		ServerSocket sct = new ServerSocket(23500, 3);

		while (true)
			new Thread () {
				@Override
				public void run () {
					try {
						AnfrageBearbeiten (sct.accept());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
	}

	protected static void AnfrageBearbeiten (Socket s) {
		System.err.println(s.getInetAddress().toString());
	}
}
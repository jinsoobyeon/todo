package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClass {
	public static void main(String[] args) {
		Socket socket;
		ServerSocket serverSocket;
		InputStream inputStream;
		DataInputStream dataInputStream;
		
		try {
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept();
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			System.out.println(dataInputStream.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

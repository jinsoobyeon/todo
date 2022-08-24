package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class ServerClass {
	public static void main(String[] args) {
		String todo;
		ArrayList<String> todos;
		Socket socket;
		ServerSocket serverSocket;
		InputStream inputStream;
		DataInputStream dataInputStream;
		FileOutputStream fileOutputStream;
		DataOutputStream dataOutputStream;
		
		try {
			todos = new ArrayList<String>();
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept();
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			
			while (true) {
				todo = dataInputStream.readUTF();
				todos.add(todo);
				
				fileOutputStream = new FileOutputStream("./src/database/todos.txt");
				dataOutputStream = new DataOutputStream(fileOutputStream);
				dataOutputStream.writeChars(Arrays.toString(todos.toArray()));
				dataOutputStream.flush();
				dataOutputStream.close();
				fileOutputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

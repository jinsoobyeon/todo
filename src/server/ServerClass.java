package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class ServerClass {
	public static void main(String[] args) {
		String todo;
		String todoList;
		ArrayList<String> todos;
		Socket socket;
		ServerSocket serverSocket;
		InputStream inputStream;
		DataInputStream dataInputStream;
		OutputStream outputStream;
		DataOutputStream dataOutputStream;
		FileInputStream fileInputStream;
		DataInputStream fileDataInputStream;
		FileOutputStream fileOutputStream;
		DataOutputStream fileDataOutputStream;
		
		try {
			todos = new ArrayList<String>();
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept();
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			
			while (true) {
				todo = dataInputStream.readUTF();
				todos.add(todo);
				
				fileOutputStream = new FileOutputStream("./src/database/todos.txt");
				fileDataOutputStream = new DataOutputStream(fileOutputStream);
				fileDataOutputStream.writeUTF(Arrays.toString(todos.toArray()));
				fileDataOutputStream.flush();
				fileDataOutputStream.close();
				fileOutputStream.close();
				
				fileInputStream = new FileInputStream("./src/database/todos.txt");
				fileDataInputStream = new DataInputStream(fileInputStream);
				todoList = fileDataInputStream.readUTF();
				fileDataInputStream.close();
				fileInputStream.close();
				
				dataOutputStream.writeUTF(todoList);
				dataOutputStream.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

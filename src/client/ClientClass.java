package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientClass {
	public static void main(String[] args) {
		String todo;
		String todoList;
		Scanner scanner;
		Socket socket;
		InputStream inputStream;
		DataInputStream dataInputStream;
		OutputStream outputStream;
		DataOutputStream dataOutputStream;
		
		try {
			socket = new Socket("localhost", 9000);
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			scanner = new Scanner(System.in);
			
			while (true) {
				System.out.println("Type what you have to do");
				todo = scanner.nextLine();
				dataOutputStream.writeUTF(todo);
				dataOutputStream.flush();
				
				todoList = dataInputStream.readUTF();
				System.out.println(todoList);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

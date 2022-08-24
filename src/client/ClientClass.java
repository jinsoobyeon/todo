package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientClass {
	public static void main(String[] args) {
		String todo;
		Scanner scanner;
		Socket socket;
		OutputStream outputStream;
		DataOutputStream dataOutputStream;
		
		try {
			scanner = new Scanner(System.in);
			System.out.println("Type what you have to do");
			todo = scanner.nextLine();
			
			socket = new Socket("localhost", 9000);
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			dataOutputStream.writeUTF(todo);
			dataOutputStream.flush();
			
			scanner.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

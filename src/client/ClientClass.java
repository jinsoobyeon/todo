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
			socket = new Socket("localhost", 9000);
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			scanner = new Scanner(System.in);
			
			while (true) {
				System.out.println("Type what you have to do");
				todo = scanner.nextLine();
				dataOutputStream.writeUTF(todo);
				dataOutputStream.flush();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Calendar;

public class Servidor {
	
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(5000);
			
			System.out.println("Esperando conexión");
			Socket socket = server.accept();
			System.out.println("Conectado");
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader breader = new BufferedReader(isr);
			
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bwriter = new  BufferedWriter(osw);
			
			

			while(true) {
				String line = breader.readLine();
				System.out.println("Mensaje recibido: "+line);
				
				if(line.contains("hora")) {
					Calendar c = Calendar.getInstance();
					String fecha = c.getTime().toString();
					
					bwriter.write(fecha+"\n");
					bwriter.flush();
				}else {
					bwriter.write("Hola\n");
					bwriter.flush();
				}
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

package socketCommu;

import java.io.*;
import java.net.*;

public class ClientTest {
	
	public static void main (String astring[])
	{
		String welcom, response;
		Client client = new Client ("192.168.0.242", 8001);
		try{
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.in));
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(client.out), true);
			
			welcom = bufferedReader.readLine();
			System.out.println(welcom + "'");
			System.out.println(welcom + "HELLO");
			printWriter.println("HELLO");
			
			response = bufferedReader.readLine();
			System.out.println(response+ "'");
			System.out.println(response+ "HELP");
			printWriter.println("HELP");
			
			response = bufferedReader.readLine();
			System.out.println(response+ "'");
			System.out.println(response+ "QUIT");
			printWriter.println("QUIT");
			
			
		}
		
		catch(IOException e2)
		{
		
			System.out.println("IOException in client.in.readln()");
			System.out.println(e2);
		}
		
	/*	try 
		{
			Thread.sleep(2000);
			
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		*/
	}

}

class Client
{
	public InputStream in;
	public OutputStream out;
	
	private Socket client;
	
	public Client(String string, int port)
	{
		try
		{
			client = new Socket(string, port);
			System.out.println("Client socket: " + client);
			
			in = client.getInputStream();
			out = client.getOutputStream();
						
		}
		
		catch (IOException e)
		{
			System.out.println(new StringBuffer("IOExc : ").append(e).toString());
			
		}
	}
	
}

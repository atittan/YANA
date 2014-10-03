package socketCommu;

import java.io.*;
import java.util.*;
import java.net.*;

public class ServerTest 

{
	static final int SERVER_PORT = 8001;
	
	public static void main(String args[])
	{ 
	
		String ClientRequest;
	
		Server server = new Server(8001);
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(server.in));
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(server.out), true);
		
		printWriter.println("Java Test Server v0.03, " + new Date());
		
		while (true)
		{
			try
			{ 
				ClientRequest = bufferedReader.readLine();
				System.out.println("Client says: "+ClientRequest);
				if(ClientRequest.startsWith("HELP"))
					printWriter.println("Vocabulary: HELP QUIT");
					else if (ClientRequest.startsWith("QUIT"))
						System.exit(0);
					else
						printWriter.println(ClientRequest + " not understood");
			
			}
			catch(IOException e)
			{
				System.out.println("IOEx in server" + e);
			}
		}
	}


}


class Server
{
	private ServerSocket server;
	private Socket socket;
	public InputStream in;
	public OutputStream out;
	
	public Server(int port)
	{
		try
		{
			server = new ServerSocket(port);
			System.out.println("ServerSocket before accept" + server);
			System.out.println("Java Test server v0.03, on-line!");
			//waiting client for connection server
			
			socket = server.accept();
			System.out.println("ServerSocket after accept:" + server);
			
			in = socket.getInputStream();
			out = socket.getOutputStream();
		}
			catch(IOException e)
		{
				System.out.println("Server constructor IOEx:" + e);
				
		}
			
			
		
	}
}


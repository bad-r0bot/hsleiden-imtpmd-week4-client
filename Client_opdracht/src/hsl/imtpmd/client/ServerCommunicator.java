package hsl.imtpmd.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import android.util.Log;

public class ServerCommunicator implements Runnable
{
	private MainActivity activity;
	private Thread thread;
	
	private String message;
	private String ip;
	private int port;
	
	public ServerCommunicator( MainActivity activity, String ip, int port, String message )
	{	
		//we gebruiken de activity om de userinterface te updaten
		this.activity = activity;
		
		//gegevens om naar de server te verbinden en een message te sturen
		this.message = message;
		this.ip = ip;
		this.port = port;
		
		//de nieuwe thread kan tekst verzenden en ontvangen van en naar een server
		this.thread = new Thread ...;
	}
	

	//dit is een methode die niet op de UI thread wordt aangeroepen, maar door onze eigen nieuwe thread
	//we kunnen dus niet zomaar ontvangen berichten in een userinterface object stoppen m.b.v. view.setText( message )
	//hier gebruiken we de activity voor: activity.runOnUiThread( activity )
	@Override
	public void run()
	{
		try
		{
			Socket serverSocket = new Socket();
			serverSocket.connect( new InetSocketAddress( this.ip, this.port ), 4000 );
			
			//verzend een bericht naar de server
			this.sendMessage( ... );
			
			this.activity.setReceivedServerMessage( "We hebben het bericht verzonden" );
			this.activity.runOnUiThread( this.activity );
		}
		
		catch( UnknownHostException e )
		{
			Log.d("debug", "can't find host");
		}
		
		catch( SocketTimeoutException e )
		{
			Log.d("debug", "time-out");
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	

	//ook deze methoden kunnen niet naar de UI direct communiceren, hou hier rekening mee
	private void sendMessage( String message, Socket serverSocket )
	{
		OutputStreamWriter outputStreamWriter = null;
		
		try
		{
			outputStreamWriter = new ...;
		}
		
		catch (IOException e2)
		{
			e2.printStackTrace();
		}
		
		if( outputStreamWriter != null )
		{
			BufferedWriter bufferedWriter = new ...;
			PrintWriter writer = new PrintWriter( bufferedWriter, true );
			
			writer...;
		}
	}
	
	
	//wacht op server bericht (na versturen)
	private String waitForResponse(Socket serverSocket)
	{
		String serverMessage = null;
		
		//...
		
		return serverMessage;
	}

}

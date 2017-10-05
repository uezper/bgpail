package py.una.pol.BGTP.Clasipar.Sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;

import py.una.pol.BGTP.Clasipar.SparkReceiver.SparkReceiver;
import py.una.pol.BGTPClasipar.Main;
import py.una.pol.BGTPClasipar.datos.Data;

public class Sender {
	
	
	public Sender() {
	
	}

		public static final String HOSTNAME = "ubuntu1";
	  	private BufferedReader in;
	    private PrintWriter out;
	    
	    
	    public void connectToServer() throws IOException, InterruptedException {

	    	
	    	Data d1 = Main.makeAnuncioVisita(1L, 100, 16500);
			Data d2 = Main.makeAnuncioFecha(1L, 50000L, 16500);
			Data d3 = Main.makePublicacion(1L, "uriel", 16500);

	    	
			ServerSocket serverSocket = new ServerSocket(SparkReceiver.PORT);
	            
			 
			while(true) {
		    Socket socket;
		    PrintWriter out;
		    
		    socket = serverSocket.accept();	
		    
		    out = new PrintWriter(socket.getOutputStream(), true);
		   // while(true) {
		    	byte[] b = serialize(d1);
		    	System.out.println(b.length);
		    	out.print(b);
		    	out.flush();
		    //}
		    
		    Thread.sleep(2000);	
		    	
		    out.close();
		    socket.close();
			}
		   /* socket = new Socket(HOSTNAME, SparkReceiver.PORT);		    
		    out = new PrintWriter(socket.getOutputStream(), true);
		    out.print(serialize(d2));
		    out.flush();
		    socket.close();

		    socket = new Socket(HOSTNAME, SparkReceiver.PORT);		    
		    out = new PrintWriter(socket.getOutputStream(), true);
		    out.print(serialize(d3));
		    out.flush();
		    socket.close();*/
		    
	    }
	    
	    private byte[] serialize(Data d) {
	    	try {
				return new TSerializer().serialize((TBase) d);
			} catch (TException e) {
				throw new RuntimeException(e);
			}	    	
	    }

	   
	    public static void executeSender() {
	        Sender s = new Sender();
	        try {
				s.connectToServer();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	
}

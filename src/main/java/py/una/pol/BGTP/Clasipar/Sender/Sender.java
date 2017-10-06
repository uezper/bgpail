package py.una.pol.BGTP.Clasipar.sender;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;

import py.una.pol.BGTP.Clasipar.Main;
import py.una.pol.BGTP.Clasipar.receiver.SparkReceiver;
import py.una.pol.BGTP.Clasipar.utils.datos.Data;

public class Sender {
	
	
	public Sender() {
	
	}

		public static final String HOSTNAME = "ubuntu1";
	  	private BufferedReader in;
	    private PrintWriter out;
	    
	    
	    public void connectToServer() throws IOException, InterruptedException {

	   
	    	InputGenerator ig = new InputGenerator();
			Socket socket;
		    DataOutputStream out;		    
			ServerSocket serverSocket = new ServerSocket(SparkReceiver.PORT);
	   	 
			
		    while(true) {
		    	socket = serverSocket.accept();
		    	System.out.println("Nueva conexion establecida");
		    	out = new DataOutputStream(socket.getOutputStream());
		    			
		    	ArrayList<Data> datos = ig.getNextData();
		    	
		    	out.writeInt(datos.size());
		    	for (Data d : datos) {
		    		byte[] b = serialize(d);
		    		out.writeInt(b.length);
			    	out.write(b);
		    	}
		    	
		    	out.close();
		    	socket.close();
		    }
		    	
		    

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

package py.pol.una.py.BGTPClasipar.Receiver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;

import com.backtype.hadoop.pail.Pail;
import com.backtype.hadoop.pail.Pail.TypedRecordOutputStream;

import py.una.pol.BGTPClasipar.Pail.SplitDataPailStructure;
import py.una.pol.BGTPClasipar.datos.Data;


public class Receiver {

	public static final int PORT = 9999;
	public static final String PAIL_DIR = "/user/hduser/clasipar/new_data";

	private boolean close;
	
	public Receiver() { close = false; }
	public void start() {
		
			ServerSocket listener = null;
		  	
	        try {
	  		  	System.out.println("The serer is running.");
	        	
	        	close = false;		  	        
		        listener = new ServerSocket(PORT);
		        
	            while (true) {
	                new WriteData(listener.accept()).start();
	                if (close) break;
	            }
	        } catch(Exception e) {
	        	e.printStackTrace(System.err);
	        } finally {
	           if (listener != null) { 
	        	   try {
						listener.close();
					} catch (IOException e) {
						e.printStackTrace();
					} 
	        	  }
	        } 

	}
	
	public void stop() {
		close = true;
	}

	
	   private static class WriteData extends Thread {
	        private Socket socket;

	        public WriteData(Socket socket) {
	            this.socket = socket;	            
	        }

	        public void run() {
	            try {
	            	byte[] data = is2ba(socket.getInputStream());	
	            	write(data);
	                
	            } catch (IOException | TException e) {
	            	e.printStackTrace(System.err);
	            } finally {
	                try {
	                    socket.close();
	                } catch (IOException e) {
	                    e.printStackTrace(System.err);	                   
	                }	               
	            }
	        }
	        
	        private byte[] is2ba(InputStream is) throws IOException {
	        	
	        	ByteArrayOutputStream buffer = new ByteArrayOutputStream();

	        	int nRead;
	        	byte[] data = new byte[16384];

	        	while ((nRead = is.read(data, 0, data.length)) != -1) {
	        	  buffer.write(data, 0, nRead);
	        	}

	        	buffer.flush();

	        	return buffer.toByteArray();
	        }

	        
	        private void write(byte[] newDataSerialized) throws TException, IOException {
	        	Data newData = new Data();	        	
	        	new TDeserializer().deserialize((TBase)newData, newDataSerialized);
	        
	        	Pail<Data> pail = getPail();
	        	if (pail != null) {
	        		TypedRecordOutputStream int_os = pail.openWrite(); 	    			
	    			int_os.writeObject(newData);
	    			
	    			int_os.close();
	        	}
	        	
	        
	        	
	        }
	        
	        private Pail<Data> getPail() {
	        	Pail<Data> pail = null;
	        	
				try {
					pail = new Pail(PAIL_DIR);						    
					
				} catch (IOException e) {									
					e.printStackTrace();
				}	        
				
			if (pail == null) {
        		try {
					pail = Pail.create(PAIL_DIR, new SplitDataPailStructure());
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
	        
	        return pail;
	    }
	   }
	   

	   
	   public static void executeReceiver() {
		   Receiver r = new Receiver();
		   r.start();
	   }

}




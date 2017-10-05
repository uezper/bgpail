package py.una.pol.BGTP.Clasipar.SparkReceiver;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;

import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.receiver.Receiver;
import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;

import py.una.pol.BGTP.Clasipar.datos.Data;

public class SparkCustomDataReceiver extends Receiver<Data> {

  String host = null;
  int port = -1;

  public SparkCustomDataReceiver(String host_ , int port_) {
    super(StorageLevel.MEMORY_AND_DISK_2());
    host = host_;
    port = port_;
  }

  public void onStart() {
    // Start the thread that receives data over a connection
    new Thread()  {
      @Override public void run() {
        receive();
      }
    }.start();
  }

  public void onStop() {
    // There is nothing much to do as the thread calling receive()
    // is designed to stop by itself if isStopped() returns false
  }

  /** Create a socket connection and receive data until receiver is stopped */
  private void receive() {
    Socket socket = null;
    String userInput = null;

    try {
    	// connect to the server
    	socket = new Socket(host, port);

    	
    	DataInputStream dIn = new DataInputStream(socket.getInputStream());

    	byte[] message = null;
    	int length = dIn.readInt();                    // read length of incoming message
    	if(length>0) {
    	    message = new byte[length];
    	    dIn.readFully(message, 0, message.length); // read the message
    	}
    	
    	if (message != null) {
			Data newData = new Data();	        	
	    	new TDeserializer().deserialize((TBase)newData, message);    	
			store(newData);     
    	}
	   
		socket.close();

      // Restart in an attempt to connect again when server is active again
      restart("Trying to connect again");
    } catch(ConnectException ce) {
      // restart if could not connect to server
      restart("Could not connect", ce);
    } catch(Throwable t) {
      // restart if there is any other error
      restart("Error receiving data", t);
    }
  }
 
 
  
}


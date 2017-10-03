package py.una.pol.BGTP.Clasipar.SparkReceiver;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.receiver.Receiver;
import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;

import py.una.pol.BGTPClasipar.datos.Data;

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

      
       InputStream is = socket.getInputStream();
	  	ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	
		int nRead;
		byte[] data = new byte[16384];
	
		while ((nRead = is.read(data, 0, data.length)) != -1) {
		  buffer.write(data, 0, nRead);
		}
	
		buffer.flush();
		Data newData = new Data();	        	
    	new TDeserializer().deserialize((TBase)newData, buffer.toByteArray());    	
		store(newData);
	      
	   
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


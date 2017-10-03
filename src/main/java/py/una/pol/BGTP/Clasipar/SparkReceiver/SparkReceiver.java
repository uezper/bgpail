package py.una.pol.BGTP.Clasipar.SparkReceiver;

import java.io.IOException;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.thrift.TException;

import com.backtype.hadoop.pail.Pail;
import com.backtype.hadoop.pail.Pail.TypedRecordOutputStream;

import py.una.pol.BGTPClasipar.Pail.SplitDataPailStructure;
import py.una.pol.BGTPClasipar.datos.Data;

public class SparkReceiver {

	public static final String HOST = "192.168.56.1";
	public static final String PAIL_DIR = "/usr/hduser/clasipar/new_data";
	public static final int PORT = 9999;

	
	public SparkReceiver() {
		
		 // Configure and initialize the SparkStreamingContext
        SparkConf conf = new SparkConf()                
                .setAppName("SparkReceiver");
        JavaStreamingContext ssc =
                new JavaStreamingContext(conf, Durations.seconds(2));

        // Receive streaming data from the source        
        JavaDStream<Data> customReceiverStream = ssc.receiverStream(new SparkCustomDataReceiver(HOST, PORT));
        

        customReceiverStream.foreachRDD(new VoidFunction<JavaRDD<Data>>() {
			
			@Override
			public void call(JavaRDD<Data> rdd) throws Exception {
				List<Data> result = rdd.collect();
           
                for (Data temp : result) {
                	System.out.println("--> " + temp);
                   write(temp);

                }
			}
		}); 
		
		

        
        
        // Execute the Spark workflow defined above
        ssc.start();
        try {
			ssc.awaitTermination();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    
	}
	
	
	
	
	
	private void write(Data newData) throws TException, IOException {
		
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
	
	
	public static void executeReceiver() {
		SparkReceiver sr = new SparkReceiver();
	}
}

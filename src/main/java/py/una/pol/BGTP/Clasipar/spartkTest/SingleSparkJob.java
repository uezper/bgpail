package py.una.pol.BGTP.Clasipar.spartkTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.StorageLevels;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.tools.ant.util.facade.FacadeTaskHelper;

import com.backtype.hadoop.pail.Pail;
import com.backtype.hadoop.pail.Pail.TypedRecordOutputStream;

import py.una.pol.BGTP.Clasipar.Pail.SplitDataPailStructure;
import py.una.pol.BGTP.Clasipar.datos.Data;
import scala.Tuple2;

public class SingleSparkJob {

	private static final String HOSTNAME = "localhost";
	private static final int PORT = 9999;

	private static JavaSparkContext sc;

	public SingleSparkJob(JavaSparkContext sc) {
		this.sc = sc;
	}

	public int run() {

		JavaRDD<Data> datos = converToRDD(leerDatos());

		/*
		 * JavaRDD<String> debug = datos.map(s -> s.toString()); debug.collect();
		 */

		JavaRDD<Integer> mapToOne = datos.map(s -> 1);
		int total = mapToOne.reduce((a, b) -> a + b);

		System.out.println("El total es:" + total);

		return total;
	}

	private ArrayList<Data> leerDatos() {
		Pail<Data> pail;
		ArrayList<Data> ret = new ArrayList<>();

		try {

			pail = new Pail("/user/hduser/pail");

			for (Data d : pail) {
				ret.add(d);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return ret;
	}

	private JavaRDD<Data> converToRDD(ArrayList<Data> data) {
		return sc.parallelize(data);
	}

	public static void execute() {
		JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("SparkTestJob"));
		SingleSparkJob spj = new SingleSparkJob(sc);
		spj.run();
		sc.close();		
		
	}
}

package py.una.pol.BGTPClasipar.spartkTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import com.backtype.hadoop.pail.Pail;

import py.una.pol.BGTPClasipar.datos.Data;

public class SingleSparkJob {

	private static JavaSparkContext sc;
	
	public SingleSparkJob(JavaSparkContext sc) {
		this.sc = sc;
	}
	
	
	public int run() {
		
		
		
		JavaRDD<Data> datos = converToRDD(leerDatos());
	
		/*JavaRDD<String> debug = datos.map(s -> s.toString());
		debug.collect();*/
		
		JavaRDD<Integer> mapToOne = datos.map(s -> 1);
		int total = mapToOne.reduce((a, b) -> a+b); 
		
		System.out.println("El total es:" + total);
		
		return total;
	}
	
	
	private ArrayList<Data> leerDatos() {
		Pail<Data> pail;
		ArrayList<Data> ret = new ArrayList<>();
		
		
		
		try {
			
			pail = new Pail("/user/hduser/pail");
		

			for (Data d: pail) {
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

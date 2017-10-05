package py.una.pol.BGTP.Clasipar;

import java.io.IOException;

import com.backtype.hadoop.pail.Pail;
import com.backtype.hadoop.pail.Pail.TypedRecordOutputStream;

import py.una.pol.BGTP.Clasipar.Pail.SplitDataPailStructure;
import py.una.pol.BGTP.Clasipar.Sender.Sender;
import py.una.pol.BGTP.Clasipar.datos.AnuncioID;
import py.una.pol.BGTP.Clasipar.datos.AnuncioProperty;
import py.una.pol.BGTP.Clasipar.datos.AnuncioPropertyValue;
import py.una.pol.BGTP.Clasipar.datos.Data;
import py.una.pol.BGTP.Clasipar.datos.DataUnit;
import py.una.pol.BGTP.Clasipar.datos.Pedigree;
import py.una.pol.BGTP.Clasipar.datos.PublicacionEdge;
import py.una.pol.BGTP.Clasipar.datos.UserID;

public class Main {

	public static void main(String[] args) {

		//escribir();
		//leer();
		//SingleSparkJob.execute();
		//SparkReceiver.executeReceiver();
		Sender.executeSender();
	}

	
	public static Data makeAnuncioVisita(Long id, int visitas, int timestamp) {
		Pedigree pd = new Pedigree(timestamp);
		DataUnit du = DataUnit.anuncio(new AnuncioProperty(
						AnuncioID.id(id), 
						AnuncioPropertyValue.views(visitas))
				);
		return new Data(pd, du);
	}
	
	public static Data makeAnuncioFecha(Long id, Long secs, int timestamp) {
		Pedigree pd = new Pedigree(timestamp);
		DataUnit du = DataUnit.anuncio(new AnuncioProperty(
						AnuncioID.id(id), 
						AnuncioPropertyValue.date(secs))
				);
		return new Data(pd, du);
	}
	
	public static Data makePublicacion(Long anuncioId, String userId, int timestamp) {
		Pedigree pd = new Pedigree(timestamp);
		DataUnit du = DataUnit.publicacion(new PublicacionEdge(
				AnuncioID.id(anuncioId),
				UserID.id(userId)));
		return new Data(pd, du);
	}
	
	
	public static void escribir() {
		
		Data d1 = makeAnuncioVisita(1L, 100, 16500);
		Data d2 = makeAnuncioFecha(1L, 50000L, 16500);
		Data d3 = makePublicacion(1L, "uriel", 16500);

		try {
			
			Pail<Data> pail = Pail.create("/user/hduser/pail", new SplitDataPailStructure());
			TypedRecordOutputStream int_os = pail.openWrite(); 
			
			int_os.writeObject(d1);
			int_os.writeObject(d2);
			int_os.writeObject(d3);
			
			int_os.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public static void leer() {
		Pail<Data> pail;
		try {
			
			pail = new Pail("/user/hduser/pail");
		

			for (Data d: pail) {
				System.out.println(d);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}

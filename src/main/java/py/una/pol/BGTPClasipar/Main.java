package py.una.pol.BGTPClasipar;

import java.io.IOException;
import com.backtype.hadoop.pail.Pail;
import com.backtype.hadoop.pail.Pail.TypedRecordOutputStream;

import py.una.pol.BGTPClasipar.Pail.DataPailStructure;
import py.una.pol.BGTPClasipar.Pail.SplitDataPailStructure;
import py.una.pol.BGTPClasipar.datos.AnuncioID;
import py.una.pol.BGTPClasipar.datos.AnuncioProperty;
import py.una.pol.BGTPClasipar.datos.AnuncioPropertyValue;
import py.una.pol.BGTPClasipar.datos.Data;
import py.una.pol.BGTPClasipar.datos.DataUnit;
import py.una.pol.BGTPClasipar.datos.Pedigree;
import py.una.pol.BGTPClasipar.datos.PublicacionEdge;
import py.una.pol.BGTPClasipar.datos.UserID;
import py.una.pol.BGTPClasipar.spartkTest.SingleSparkJob;


public class Main {

	public static void main(String[] args) {

		//escribir();
		//leer();
		SingleSparkJob.execute();
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

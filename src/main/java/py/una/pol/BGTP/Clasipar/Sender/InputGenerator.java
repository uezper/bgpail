package py.una.pol.BGTP.Clasipar.sender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import py.una.pol.BGTP.Clasipar.Main;
import py.una.pol.BGTP.Clasipar.utils.datos.AnuncioID;
import py.una.pol.BGTP.Clasipar.utils.datos.AnuncioProperty;
import py.una.pol.BGTP.Clasipar.utils.datos.AnuncioPropertyValue;
import py.una.pol.BGTP.Clasipar.utils.datos.Data;
import py.una.pol.BGTP.Clasipar.utils.datos.DataUnit;
import py.una.pol.BGTP.Clasipar.utils.datos.Pedigree;
import py.una.pol.BGTP.Clasipar.utils.datos.PublicacionEdge;
import py.una.pol.BGTP.Clasipar.utils.datos.UserID;

public class InputGenerator {
	
	private int seccion_size;
	private Random rand;
	private ArrayList<Integer> visitas;
	

	/* TODO_URIEL borrar */
	private int num = 0;
	
	public InputGenerator() {
		visitas = new ArrayList<>();
		rand = new Random();
		seccion_size = SECCION.values().length;
	
	}
	
	
	/* TODO_URIEL borrar */
	public ArrayList<Data> getNextData() {
	
		
		ArrayList<Data> init_set = new ArrayList<>();

		if (num > 0) return init_set; 
		num++;
			
		SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		try {
			init_set.add(makeAnuncioVisita(5L, 10, dt.parse("2017/10/05 10:15").getTime()));
			init_set.add(makeAnuncioVisita(5L, 13, dt.parse("2017/10/05 10:20").getTime()));
			init_set.add(makeAnuncioVisita(3L, 7, dt.parse("2017/10/05 10:17").getTime()));
			init_set.add(makeAnuncioVisita(2L, 9, dt.parse("2017/10/05 10:18").getTime()));
			
			init_set.add(makeAnuncioSeccion(5L, SECCION.MOTO.toString(), dt.parse("2017/10/05 10:15").getTime()));
			init_set.add(makeAnuncioSeccion(5L, SECCION.MOTO.toString(), dt.parse("2017/10/05 10:20").getTime()));
			init_set.add(makeAnuncioSeccion(3L, SECCION.MOTO.toString(), dt.parse("2017/10/05 10:17").getTime()));
			init_set.add(makeAnuncioSeccion(2L, SECCION.CASA.toString(), dt.parse("2017/10/05 10:18").getTime()));
						
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		
		return init_set;
	}
	
	/* TODO_URIEL cambiar nombre */
	public ArrayList<Data> getNextDataOriginal() {
		Data d;
		ArrayList<Data> r = new ArrayList<>();
		
		Long timestamp = System.currentTimeMillis();
		if (visitas.size() == 0 || (visitas.size() < 50 && rand.nextInt(100) < 30)) {
			Long id = new Long(visitas.size() + 1);
			int vis = rand.nextInt(50) + 20;
			String seccion = SECCION.values()[rand.nextInt(seccion_size)].toString();
			
			d = makeAnuncioVisita(id, vis, timestamp);
			r.add(d);
			d = makeAnuncioSeccion(id, seccion, timestamp);
			r.add(d);
			
			visitas.add(vis);
		} else {
			int id = rand.nextInt(visitas.size());
			Long lid = new Long(id);
			int vis = visitas.get(id);
			vis += rand.nextInt(100) + 1;
			
			d = makeAnuncioVisita(lid, vis, timestamp);
			r.add(d);
			
			visitas.set(id, vis);
		}
		
		return r;
	}
	
	
	
	public static Data makeAnuncioSeccion(Long id, String secccion, Long timestamp) {
		Pedigree pd = new Pedigree(timestamp);
		DataUnit du = DataUnit.anuncio(new AnuncioProperty(
						AnuncioID.id(id), 
						AnuncioPropertyValue.section(secccion))
				);
		return new Data(pd, du);
	}
	
	public static Data makeAnuncioVisita(Long id, int visitas, Long timestamp) {
		Pedigree pd = new Pedigree(timestamp);
		DataUnit du = DataUnit.anuncio(new AnuncioProperty(
						AnuncioID.id(id), 
						AnuncioPropertyValue.views(visitas))
				);
		return new Data(pd, du);
	}
	
	public static Data makeAnuncioFecha(Long id, Long secs, Long timestamp) {
		Pedigree pd = new Pedigree(timestamp);
		DataUnit du = DataUnit.anuncio(new AnuncioProperty(
						AnuncioID.id(id), 
						AnuncioPropertyValue.date(secs))
				);
		return new Data(pd, du);
	}
	
	public static Data makePublicacion(Long anuncioId, String userId, Long timestamp) {
		Pedigree pd = new Pedigree(timestamp);
		DataUnit du = DataUnit.publicacion(new PublicacionEdge(
				AnuncioID.id(anuncioId),
				UserID.id(userId)));
		return new Data(pd, du);
	}
	
	
	public static enum SECCION {
		MOTO, 
		CASA,
		CAMION,
		ROPA,
	}
}

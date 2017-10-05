package py.una.pol.BGTP.Clasipar.Sender;

import java.util.ArrayList;
import java.util.Random;

import py.una.pol.BGTP.Clasipar.Main;
import py.una.pol.BGTP.Clasipar.datos.Data;

public class InputGenerator {
	
	private Random rand;
	private ArrayList<Integer> visitas;
	
	public InputGenerator() {
		visitas = new ArrayList<>();
		rand = new Random();
	}
	
	public Data getNextData() {
		Data d = null;
		int timestamp = new Long(System.currentTimeMillis()).intValue();
		if (visitas.size() == 0 || (visitas.size() < 50 && rand.nextInt(100) < 30)) {
			Long id = new Long(visitas.size() + 1);
			int vis = rand.nextInt(50) + 20;
			
			d = Main.makeAnuncioVisita(id, vis, timestamp);
			
			visitas.add(vis);
		} else {
			int id = rand.nextInt(visitas.size());
			Long lid = new Long(id);
			int vis = visitas.get(id);
			vis += rand.nextInt(100) + 1;
			
			d = Main.makeAnuncioVisita(lid, vis, timestamp);
			
			visitas.set(id, vis);
		}
		
		return d;
	}
	
	
	public static enum SECCION {
		MOTO, 
		CASA,
		CAMION,
		ROPA,
	}
}

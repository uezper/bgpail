package py.una.pol.BGTP.Clasipar;

import py.una.pol.BGTP.Clasipar.sender.Sender;

public class Main {

	public static void main(String[] args) {

		//SparkReceiver.executeReceiver();
		Sender.executeSender();
	}

	
	/*
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
*/	

}

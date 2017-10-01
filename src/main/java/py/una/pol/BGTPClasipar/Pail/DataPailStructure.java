package py.una.pol.BGTPClasipar.Pail;

import java.util.Collections;
import java.util.List;

import py.una.pol.BGTPClasipar.datos.Data;

public class DataPailStructure extends ThriftPailStructure<Data> {
	public Class getType() {
		return Data.class;
	}

	protected Data createThriftObject() {
		return new Data();
	}

	public List<String> getTarget(Data object) {
		return Collections.EMPTY_LIST;
	}

	public boolean isValidTarget(String... dirs) {
		return true;
	}
}
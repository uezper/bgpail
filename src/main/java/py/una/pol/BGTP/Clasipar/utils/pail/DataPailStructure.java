package py.una.pol.BGTP.Clasipar.utils.pail;

import java.util.Collections;
import java.util.List;

import py.una.pol.BGTP.Clasipar.utils.datos.Data;

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
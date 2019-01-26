package Server;

public class MyNamenode implements ClientNamenodeProtocol {

	@Override
	public String getMetaData(String path) {
		return path+"3 -{duiwjhduw}";
	}
	

}

package Server;

public interface ClientNamenodeProtocol {
     //1.����Э���ID
	public static final long versionID=1L;
	
	//2.���巽��
	public String getMetaData(String path);
}

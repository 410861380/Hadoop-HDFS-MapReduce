package Server;

public interface ClientNamenodeProtocol {
     //1.定义协议的ID
	public static final long versionID=1L;
	
	//2.定义方法
	public String getMetaData(String path);
}

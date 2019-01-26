package Server;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

public class GetHDFS {

	public static void main(String[] args) throws IOException {
    //1.�õ�Э��
		ClientNamenodeProtocol proxy=RPC.getProxy(ClientNamenodeProtocol.class, 1L,new InetSocketAddress("localhost", 21), new Configuration());
	//2.��������
		String metadata=proxy.getMetaData("f://test//file1//b.txt");
	//3.�õ�Ԫ������Ϣ
        System.out.println(metadata);
	}

}

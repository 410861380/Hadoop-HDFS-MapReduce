package Server;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

public class GetHDFS {

	public static void main(String[] args) throws IOException {
    //1.拿到协议
		ClientNamenodeProtocol proxy=RPC.getProxy(ClientNamenodeProtocol.class, 1L,new InetSocketAddress("localhost", 21), new Configuration());
	//2.发送请求
		String metadata=proxy.getMetaData("f://test//file1//b.txt");
	//3.拿到元数据信息
        System.out.println(metadata);
	}

}

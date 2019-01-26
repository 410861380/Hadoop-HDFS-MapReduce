package Server;

import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Builder;


public class Server {

	public static void main(String[] args) throws HadoopIllegalArgumentException, IOException {
		//1.构建RPC框架
		Builder builder=new RPC.Builder(new Configuration());
		//2.绑定地址
		builder.setBindAddress("localhost");
		
		//3.绑定端口号
		builder.setPort(21);
		//4.绑定协议
		builder.setProtocol(ClientNamenodeProtocol.class);
		//5.调用协议的实现类
	    builder.setInstance(new  MyNamenode());
		//6.创建服务
	    org.apache.hadoop.ipc.RPC.Server build=builder.build();
        build.start();
        
	}

}

package Server;

import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Builder;


public class Server {

	public static void main(String[] args) throws HadoopIllegalArgumentException, IOException {
		//1.����RPC���
		Builder builder=new RPC.Builder(new Configuration());
		//2.�󶨵�ַ
		builder.setBindAddress("localhost");
		
		//3.�󶨶˿ں�
		builder.setPort(21);
		//4.��Э��
		builder.setProtocol(ClientNamenodeProtocol.class);
		//5.����Э���ʵ����
	    builder.setInstance(new  MyNamenode());
		//6.��������
	    org.apache.hadoop.ipc.RPC.Server build=builder.build();
        build.start();
        
	}

}

package src.wordcount;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.TestNewCombinerGrouping.Combiner;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCountDriver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		//1.��ȡjob��Ϣ
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		
		//2.��ȡjar��
		job.setJarByClass(WordCountDriver.class);
		
		//3.��ȡ�Զ����mapper��reducer��
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);
		
		//4.����map�������������
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		//5.����reduce������������ͣ����յ��������ͣ�
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		//��combiner��ʵ�ֶ����ݵ��Ż����䣬�ڶ�map�׶ν����꣬��reducer���������ݽ���С����reducer���ٻ��������
		job.setCombinerClass(WordCountReducer.class);
		//6.����������ڵ�·���봦���Ľ��·��
		FileInputFormat.setInputPaths(job, new Path("f://wc//in"));
		FileOutputFormat.setOutputPath(job, new Path("f://wc//out"));
		
		//7.�ύ����
		boolean rs = job.waitForCompletion(true);
		System.out.println(rs?0:1);
		
		
		
	}
}


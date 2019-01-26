package src.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	//key ��ʼƫ���� value ����  context ������ 
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		//1.��ȡ����
		String line = value.toString();
		
		//2.�и� hello hunter
		String[] words = line.split(" ");
		
		//3.ѭ����д����һ���׶�<hello,1><hunter,1>
		for(String w:words) {
			//4.�����reducer�׶�
			context.write(new Text(w), new IntWritable(1));
		}
		
	}
	
}


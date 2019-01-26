package src.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	//key 起始偏移量 value 数据  context 上下文 
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		//1.读取数据
		String line = value.toString();
		
		//2.切割 hello hunter
		String[] words = line.split(" ");
		
		//3.循环的写到下一个阶段<hello,1><hunter,1>
		for(String w:words) {
			//4.输出到reducer阶段
			context.write(new Text(w), new IntWritable(1));
		}
		
	}
	
}


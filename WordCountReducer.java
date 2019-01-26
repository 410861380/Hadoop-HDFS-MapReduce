package src.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable>{

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Context context) throws IOException, InterruptedException {
		//1.ͳ�Ƶ��ʳ��ֵĴ���
		int sum = 0;

		//2.�ۼ����
		for(IntWritable count:values) {
			//�õ�ֵ�ۼ�
			sum += count.get();
		}
		
		//3.������
		context.write(key, new IntWritable(sum));
	}
	
}

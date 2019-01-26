package com.tiger.FlowSortMapper;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.tiger.FlowBean.FlowBean;
/**
 * @author tiger
 *@version1.0
 */
public class FlowSortMapper extends Mapper<LongWritable, Text, FlowBean, Text>{
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		String string = value.toString();
		String[] split = string.split("\t");
		long upFlow=Long.parseLong(split[1]);
		long dwFlow=Long.parseLong(split[2]);
		context.write(new FlowBean(upFlow, dwFlow), new Text(split[0]));
	}
}

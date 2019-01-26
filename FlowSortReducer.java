package com.tiger.FlowSortReducer;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import com.tiger.FlowBean.FlowBean;

public class FlowSortReducer extends Reducer<FlowBean, Text, Text, FlowBean>{
	@Override
	protected void reduce(FlowBean key, Iterable<Text> value, Context context)
			throws IOException, InterruptedException {
		context.write(value.iterator().next(), key);
	}
}

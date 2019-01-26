package com.tiger.FlowSortDriver;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.tiger.FlowBean.FlowBean;
import com.tiger.FlowSortMapper.FlowSortMapper;
import com.tiger.FlowSortReducer.FlowSortReducer;
import FlowSortPartitioner.FlowSortPartitioner;

public class FlowSortDriver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration configuration=new Configuration();
		Job job=Job.getInstance(configuration);
		job.setJarByClass(FlowSortDriver.class);
		job.setMapperClass(FlowSortMapper.class);
		job.setReducerClass(FlowSortReducer.class);
		job.setMapOutputKeyClass(FlowBean.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputValueClass(Text.class);
		job.setOutputValueClass(FlowBean.class);
		job.setPartitionerClass(FlowSortPartitioner.class);
		job.setNumReduceTasks(5);
		FileInputFormat.setInputPaths(job, new Path("f://fc//out"));
		FileOutputFormat.setOutputPath(job, new Path("f://fc/out1"));
		boolean waitForCompletion = job.waitForCompletion(true);
		System.out.println(waitForCompletion);	
	}		
}

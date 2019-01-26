package FlowCountTestDriver;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import FlowCountTestMapper.FlowBean;
import FlowCountTestMapper.FlowCountTestMapper;
import FlowCountTestReducer.FlowCountTestReducer;


public class FlowCountTestDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration configuration=new Configuration();
		Job job = Job.getInstance(configuration);
		job.setJarByClass(FlowCountTestDriver.class);
		job.setMapperClass(FlowCountTestMapper.class);
		job.setReducerClass(FlowCountTestReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(FlowBean.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FlowBean.class);
		FileInputFormat.setInputPaths(job, new Path("f://fc//in"));
		FileOutputFormat.setOutputPath(job, new Path("f://fc//out"));
        boolean waitForCompletion = job.waitForCompletion(true);
        System.out.println(waitForCompletion);
	}

}

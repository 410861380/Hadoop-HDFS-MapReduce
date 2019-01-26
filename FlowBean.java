package com.tiger.FlowBean;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class FlowBean implements WritableComparable<FlowBean>{
	private long upFlow;
	private long dwFlow;
	private long sum;
	
	public FlowBean() {}

	public FlowBean(long upFlow, long dwFlow) {
		this.upFlow = upFlow;
		this.dwFlow = dwFlow;
		sum=upFlow+dwFlow;
	}
	
	public long getUpFlow() {
		return upFlow;
	}

	public void setUpFlow(long upFlow) {
		this.upFlow = upFlow;
	}

	public long getDwFlow() {
		return dwFlow;
	}

	public void setDwFlow(long dwFlow) {
		this.dwFlow = dwFlow;
	}

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	@Override//序列化
	public void write(DataOutput out) throws IOException {
		out.writeLong(upFlow);
		out.writeLong(dwFlow);
		out.writeLong(sum);
	}

	@Override//反序列化
	public void readFields(DataInput in) throws IOException {
		upFlow=in.readLong();
		dwFlow=in.readLong();
		sum=in.readLong();
		
	}
	@Override
	public String toString() {
		
		return upFlow +"\t"+dwFlow+"\t"+sum;
	}
	@Override//排序
	public int compareTo(FlowBean o) {
		return this.sum>o.getSum()?1:-1;
	}

}

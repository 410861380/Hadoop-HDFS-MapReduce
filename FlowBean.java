package FlowCountTestMapper;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class FlowBean implements Writable{
	//定义属性
	private long upFlow;
	private long dfFlow;
	private long flowSum;
	public FlowBean() {}
	
	//流量累加
	public FlowBean(long upFlow, long dfFlow) {
		this.upFlow = upFlow;
		this.dfFlow = dfFlow;
		this.flowSum = upFlow + dfFlow;
	}
	

	public long getUpFlow() {
		return upFlow;
	}

	public void setUpFlow(long upFlow) {
		this.upFlow = upFlow;
	}

	public long getDfFlow() {
		return dfFlow;
	}

	public void setDfFlow(long dfFlow) {
		this.dfFlow = dfFlow;
	}

	public long getFlowsum() {
		return flowSum;
	}

	public void setFlowsum(long flowsum) {
		this.flowSum = flowsum;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return upFlow +"\t"+dfFlow+"\t"+flowSum;
	}
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeLong(upFlow);
		out.writeLong(dfFlow);
		out.writeLong(flowSum);	
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		upFlow = in.readLong();
		dfFlow = in.readLong();
		flowSum = in.readLong();	
	}
}

package FlowCountTestReducer;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import FlowCountTestMapper.FlowBean;

/**
 * @author tiger
 *@version1.0
 *3631279850362	13726130503	00-FD-07-A4-72-B8:CMCC	120.196.100.82	www.itstaredu.com
 * 教育网站	24	27	299	681	200
 *
 */
public class FlowCountTestReducer extends Reducer<Text, FlowBean, Text, FlowBean>{
	
	@Override
	protected void reduce(Text key, Iterable<FlowBean> values, Context context)
			throws IOException, InterruptedException {
		//1.相同手机号 的流量使用再次汇总
		long upFlow_sum = 0;
		long dfFlow_sum = 0;
		
		//2.累加
		for(FlowBean f:values) {
			upFlow_sum += f.getUpFlow();
			dfFlow_sum += f.getDfFlow();
		}
		
		FlowBean rs = new FlowBean(upFlow_sum, dfFlow_sum);
		
		//3.输出
		context.write(key, rs);
	}

}
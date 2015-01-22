import java.util.Stack;

import idv.ryanptchen.batch.BatchInit;
import idv.ryanptchen.batch.BatchService;
import idv.ryanptchen.batch.Job;
import idv.ryanptchen.batch.JobImpl;
import idv.ryanptchen.batch.impl.MyBatchJobService;


public class BatchStart {

	private static BatchInit batchInit = new BatchInit();
	
	public static void main(String[] args) throws Exception {
		BatchService service = new MyBatchJobService();
		batchJob(service);
		
	}

	private static void batchJob(BatchService service)
			throws Exception {
		Stack<Job> jobs = new Stack<Job>();
		
		for(int i =0; i<5; i++){
			jobs.push(new JobImpl());
			
		}
		
		batchInit.batchJob(service, jobs);
	}


}

import java.util.Stack;

import idv.ryanptchen.batch.BatchInit;
import idv.ryanptchen.batch.BatchService;
import idv.ryanptchen.batch.Job;
import idv.ryanptchen.batch.JobImpl;
import idv.ryanptchen.batch.impl.MyBatchJobService;

/**
 * Batch Job Starter
 * @author ryanchen
 *
 */
public class BatchStart {

	private static BatchInit batchInit = new BatchInit();
	
	public static void main(String[] args) throws Exception {
		BatchService service = new MyBatchJobService();
		batchJob(service, 2);
		
	}

	/**
	 * Setting your Batch Job Service and the amount of concurrent threads to BatchInit for controlling the multithread
	 * @param service :Your Batch Job Service 
	 * @param amountThread : The amount of concurrent threads
	 * @throws Exception
	 */
	private static void batchJob(BatchService service, int amountThread)
			throws Exception {
		Stack<Job> jobs = new Stack<Job>();
		
		for(int i =0; i < amountThread; i++){
			jobs.push(new JobImpl());
			
		}
		
		batchInit.batchJob(service, jobs);
	}


}

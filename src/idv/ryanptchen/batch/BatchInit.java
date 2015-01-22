package idv.ryanptchen.batch;

import java.util.List;
import java.util.Stack;

public class BatchInit {
	//private static Logger log = LogManager.getLogger("BatchInit");
	public static Stack<Job> jobStack;

	private static int JobFinishCount = 0;

	
	public void batchJob(BatchService batchService, Stack<Job> jobs) throws Exception{
		List<?> source = (List<?>)batchService.retrieveSource() ;
		int JobAmount = source.size();
		jobStack = jobs;
		int JobNow = 0;
		//log.info("JobAmount::"+JobAmount);
		
		while(true){
			if (JobAmount==JobFinishCount){
				//System.out.println("做完了::"+JobFinishCount);
				//log.info("做完了::"+JobFinishCount);
				break;
			}
			Job job = null;
			try{
				job = jobStack.pop();
			 
			}catch(java.util.EmptyStackException ex){
		
			}catch(Exception ex){
				ex.printStackTrace();
				//log.error(ex.getMessage());
			}
			
			//log.debug("#######job ::"+job);
			if (job != null && JobNow < JobAmount ){
				loga(JobFinishCount, "");
				Object obj = source.get(JobNow);
				++JobNow;
				job.setData(obj);
				job.setService(batchService);
				Thread t = new Thread(job, job.toString());
				t.start();
				
			}
			
		}
		
	}

	public synchronized static void infoJobFinishCount( Job job){
		++JobFinishCount;
		jobStack.push(job);
		
	}
	
	private void loga(int i, String message){
		if (i % 500 == 0){
			System.out.println("--doing :" +i+", "+message);
			//log.info("--doing :" +i+", "+message);

		}
	}
}

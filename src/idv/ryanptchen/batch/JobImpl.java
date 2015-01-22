package idv.ryanptchen.batch;

/**
 * 
 * @author ryanchen
 *
 */
public class JobImpl implements Job {

	//private static Logger log = Logger.getLogger(JobImpl.class);
	
	/**
	 * 
	 */
	private Object data;
	
	/**
	 * 
	 */
	private BatchService service;
	//private 
	
	@Override
	public void run() {
		Thread.currentThread().setName(Thread.currentThread().getId()+"");
		if (data == null || service == null) return;
		
		try {
			service.doJob(data);
			this.setData(null);
			this.setService(null);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
			//log.error(e.getMessage());
			
		}finally{
			BatchInit.infoJobFinishCount(this);
		}
	}

	@Override
	public void setData(Object obj) {
		data = obj;
		
	}

	@Override
	public void setService(BatchService service) {
		this.service = service;
	}

}

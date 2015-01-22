package idv.ryanptchen.batch;

/**
 * 
 * @author ryanchen
 *
 */
public interface Job extends Runnable {
	/**
	 * 
	 * @param obj
	 */
	public void setData(Object obj);
	
	/**
	 * 
	 * @param service
	 */
	public void setService(BatchService service);
}

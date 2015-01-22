package idv.ryanptchen.batch;

import java.util.Collection;
/**
 * All Batch Service need to implement this interface.
 * @author ryanchen
 *
 */
public interface BatchService {
	/**
	 * Retrieve the processed data. 
	 * @return
	 * @throws Exception
	 */
	public Collection<?> retrieveSource() throws Exception;
	
	/**
	 * process the obj
	 * @param obj :the processed data. 
	 * @throws Exception
	 */
	public void doJob( Object obj ) throws Exception;
}

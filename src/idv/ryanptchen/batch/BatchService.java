package idv.ryanptchen.batch;

import java.util.Collection;

public interface BatchService {
	public Collection<?> retrieveSource() throws Exception;
	public void doJob( Object obj ) throws Exception;
}

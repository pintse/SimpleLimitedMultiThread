package idv.ryanptchen.batch;

public interface Job extends Runnable {
	public void setData(Object obj);
	public void setService(BatchService service);
}

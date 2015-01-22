package idv.ryanptchen.batch.impl;

import java.util.ArrayList;
import java.util.Collection;

import idv.ryanptchen.batch.BatchService;

public class MyBatchJobService implements BatchService {

	@Override
	public Collection<?> retrieveSource() throws Exception {
		//TODO write your code
		ArrayList<String> source = new ArrayList<String>();
		source.add("Hello ");
		source.add("Ryan! ");
		source.add("How ");
		source.add("are ");
		source.add("you? ");
		
		for(int i = 0 ; i < 10 ; i++){
			source.add(""+i);
		}
		return source;
	}

	@Override
	public void doJob(Object obj) throws Exception {
		//TODO write your code 
		String data = (String) obj;
		System.out.println("ThreadId:"+ Thread.currentThread().getId() +"::"+data);
	}

}

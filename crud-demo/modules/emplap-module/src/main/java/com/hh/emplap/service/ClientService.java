package com.hh.emplap.service;

import com.axelor.meta.CallMethod;
import com.hh.emplap.db.Client;

public interface ClientService {
	public void validateDOB(Client client);
	
	@CallMethod
	public String test();
}

package com.hh.emplap.module;

import com.axelor.app.AxelorModule;
import com.hh.emplap.service.ClientService;
import com.hh.emplap.service.ClientServiceImpl;

public class EmplapModule extends AxelorModule{
	@Override
	protected void configure() {
		bind(ClientService.class).to(ClientServiceImpl.class);
	}
}

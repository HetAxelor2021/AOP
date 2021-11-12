package com.hh.emplap.web;

import com.axelor.inject.Beans;
import com.axelor.meta.schema.actions.ActionView;
import com.axelor.meta.schema.actions.ActionView.ActionViewBuilder;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Context;
import com.hh.emplap.db.Client;
import com.hh.emplap.db.Company;
import com.hh.emplap.db.repo.ClientRepository;
import com.hh.emplap.service.ClientService;

public class ClientController {
		public void checkPosibility(ActionRequest request, ActionResponse response) {
			Context context = request.getContext();
			
			Context parentContext = context.getParent();
			
			System.err.println("Parent Context: "+ parentContext);
			
			Client client= context.asType(Client.class);
			System.err.println(client);
			if(client.getId() != null) {
				client = Beans.get(ClientRepository.class).find(client.getId());
				
			}
			
			System.err.println(client);
			
			//1. used to call service methods
			Beans.get(ClientService.class).validateDOB(client);
//			
			//2. used for validations
			response.setFlash("Hello Error");
			
			/* response.setReload(true); */
			System.out.println("refresh");
			
//			System.out.println("close false");
			
			response.setNotify("hello this is notify method");
			
			
			response.setValue("name","HHClient1");
			System.out.println("setValue");
			
			
			response.setReadonly("name",true );
			response.setHidden("budget",true);
//			response.getData();
			System.out.println("read and hide");
			
			client.setName("ccClient1");
			
			response.setValues(client);
			
			
			
			
			//3. used to update attributes.
			response.setAttr("$test",  "title", "Testing");
			
//			response.setCanClose(true);
			System.err.println(Company.class.getName());
			//4. used to open view
//			ActionViewBuilder actionViewBuilder = ActionView.define("Company").model(Company.class.getName()).add("grid","company-grid").add("form","company-form");
//			response.setView(actionViewBuilder.map());
			
		}

}

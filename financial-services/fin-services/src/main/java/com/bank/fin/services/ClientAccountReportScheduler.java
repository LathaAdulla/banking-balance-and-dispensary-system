package com.bank.fin.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bank.fin.model.ClientAccountReportModel;

@Service
public class ClientAccountReportScheduler {
	
	@Autowired
    private ClientAccountService clientAccountService;

    @Scheduled(cron="0 0 9 1 * ?")    
    public void schedule() {
    	try {
        List<ClientAccountReportModel> details = clientAccountService.getClientAccountReportDetails();
        
        System.out.println("Generating Client highest balance transactional account  report-----");
        ClientExcelExporter cl = new ClientExcelExporter(details);
        cl.export();
    	} catch(IOException e) {
    		System.out.println("Error --"+e.getMessage());	
    	}


    }
	
	

}

package com.yps.ypsconnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yps.ypsconnect.model.Credit;
import com.yps.ypsconnect.repositories.YPSConnectCreditDetailRepository;
import com.yps.ypsconnect.repositories.YPSConnectCreditRepository;




@Service
public class YPSConnectCreditService {

	private YPSConnectCreditRepository CreditRepository;
	private YPSConnectCreditDetailRepository CreditDetailRepository;

    @Autowired
    public void setCreditRepository(YPSConnectCreditRepository CreditRepository) {
        this.CreditRepository = CreditRepository;
    }
    
    
    @Autowired
    public void setCreditRepository(YPSConnectCreditDetailRepository CreditRepository) {
        this.CreditDetailRepository = CreditRepository;
    }
    public List<Credit> listAllCredits() {

        return CreditRepository.findAll();
    }

	public Credit getOne(Long id) {
		// TODO Auto-generated method stub
		return CreditRepository.getOne(id);
	}


	public void saveCredit(Credit Credit) {
		// TODO Auto-generated method stub
		CreditRepository.save(Credit);
	}


	public void delete(Long id) {
		// TODO Auto-generated method stub
		CreditRepository.deleteById(id);
	}
	
}

package com.spring.api.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.api.Model.BankEntity;
import com.spring.api.vo.BankVo;

@Component
public interface BankService {

	List<BankEntity> getBanks() ;
	
	BankVo saveBank(BankVo bankVo);

	BankVo getBank(Long id);
	
	BankVo updateBank(BankVo bankVo);
	
	String deleteBank(Long id);
	
	List<BankVo> saveBanks(List<BankVo> banksVo);
	
}

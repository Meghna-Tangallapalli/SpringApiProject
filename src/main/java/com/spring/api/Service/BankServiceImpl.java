package com.spring.api.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.Model.BankEntity;
import com.spring.api.Repository.BankRepository;
import com.spring.api.vo.BankVo;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankRepository bankRepository;

	@Override
	public List<BankEntity> getBanks() {
		return bankRepository.findAll();
	}

	// save list
	@Override
	public List<BankVo> saveBanks(List<BankVo> banksVo) {
		List<BankEntity> banksList = new ArrayList<>();
		// forach loop
		for (BankVo bank : banksVo) {
			// streams foreach loop
			// banksVo.stream().forEach(bank->{

			BankEntity bankEntity = new BankEntity();
			bankEntity.setId(bank.getId());
			bankEntity.setBankName(bank.getBankName());
			bankEntity.setLocation(bank.getLocation());
			bankEntity.setPhoneNumber(bank.getPhoneNumber());
			banksList.add(bankEntity);
			// });
		}

		List<BankEntity> savedBanks = bankRepository.saveAll(banksList);
		List<BankVo> bankVoList = new ArrayList<>();
		for (BankEntity b : savedBanks) {
			// saveAll.stream().forEach(b->{

			BankVo bvo = new BankVo();
			bvo.setId(b.getId());
			bvo.setBankName(b.getBankName());
			bvo.setLocation(b.getLocation());
			bvo.setPhoneNumber(b.getPhoneNumber());
			bankVoList.add(bvo);

			// });
		}

		return bankVoList;

		// entity to vo conversion
		/*
		 * BankVo banksVo1 = new BankVo(); banksVo1.setId(save.getId());
		 * banksVo1.setBankName(save.getBankName());
		 * banksVo1.setLocation(save.getLocation());
		 * banksVo1.setPhoneNumber(save.getPhoneNumber());
		 * banksList.add(bankEntity);
		 * return banksVo1;
		 */

	}

	// save
	@Override
	public BankVo saveBank(BankVo bankVo) {
		// vo to entity conversion
		BankEntity bankEntity = new BankEntity();
		bankEntity.setId(bankVo.getId());
		bankEntity.setBankName(bankVo.getBankName());
		bankEntity.setLocation(bankVo.getLocation());
		bankEntity.setPhoneNumber(bankVo.getPhoneNumber());
		// save to db
		BankEntity save = bankRepository.save(bankEntity);

		// entity to vo conversion
		BankVo bankVo1 = new BankVo();
		bankVo1.setId(save.getId());
		bankVo1.setBankName(save.getBankName());
		bankVo1.setLocation(save.getLocation());
		bankVo1.setPhoneNumber(save.getPhoneNumber());

		return bankVo1;
	}

	// get bank by id
	@Override
	public BankVo getBank(Long id) {
		Optional<BankEntity> bankVo = bankRepository.findById(id);
		if (bankVo.isPresent()) {
			BankEntity bankEntity = bankVo.get();
			BankVo baVo = new BankVo();
			baVo.setId(bankEntity.getId());
			baVo.setLocation(bankEntity.getLocation());
			baVo.setBankName(bankEntity.getBankName());
			baVo.setPhoneNumber(bankEntity.getPhoneNumber());

			return baVo;
		} else {

			throw new RuntimeException("Bank details not found with id" + id);

		}

	}

	// update
	@Override
	public BankVo updateBank(BankVo bankVo) {

		Optional<BankEntity> bankOptional = bankRepository.findById(bankVo.getId());
		BankEntity bankEntity = bankOptional.get();
		if (bankOptional.isPresent()) {
			bankEntity.setId(bankVo.getId());
			bankEntity.setBankName(bankVo.getBankName());
			bankEntity.setLocation(bankVo.getLocation());
			bankEntity.setPhoneNumber(bankVo.getPhoneNumber());

			BankEntity save = bankRepository.save(bankEntity);

			BankVo bankVo2 = new BankVo();
			bankVo2.setId(save.getId());
			bankVo2.setBankName(save.getBankName());
			bankVo2.setLocation(save.getLocation());
			bankVo2.setPhoneNumber(save.getPhoneNumber());
			return bankVo2;
		} else {

			throw new RuntimeException("Bank details not found with id" + bankVo.getId());

		}

	}

	// delete
	@Override
	public String deleteBank(Long id) {
		Optional<BankEntity> bankEntity = bankRepository.findById(id);
		if (bankEntity.isPresent()) {
			bankRepository.delete(bankEntity.get());
		}
		return "Bank deleted successfully";
	}

}

package com.spring.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.Model.BankEntity;
import com.spring.api.Service.BankService;
import com.spring.api.vo.BankVo;

@RestController
@RequestMapping("api/bank")
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	@PostMapping("/savebank")
	public BankVo saveBank(@RequestBody BankVo bankVo) {
		return bankService.saveBank(bankVo);
	}
	
	//get all banks
	@GetMapping("/getbanks")
	public List<BankEntity> getBanks() {
		return bankService.getBanks();
	}
	
	//get bank by id
	@GetMapping("/getbank/{id}")
	public BankVo getBank(@PathVariable Long id) {
		return bankService.getBank(id);
	}
	
	@PutMapping("/updatebank")
	public BankVo updateBank(@RequestBody BankVo bankVo) {
		return bankService.updateBank(bankVo);
	}
	
	@DeleteMapping("/deletebank")
	public String deleteBank(@RequestParam Long id) {
		String deleteBank = bankService.deleteBank(id);
		return "Bank details deleted";
	}
	
	@PostMapping("/savebanks")
	public List<BankVo> saveBanks(@RequestBody List<BankVo> banksVo) {
		List<BankVo> saveBanks = bankService.saveBanks(banksVo);
		return saveBanks;
	}
}

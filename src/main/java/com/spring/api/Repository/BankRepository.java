package com.spring.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.api.Model.BankEntity;


@Repository
public interface BankRepository extends JpaRepository<BankEntity, Long> {




}

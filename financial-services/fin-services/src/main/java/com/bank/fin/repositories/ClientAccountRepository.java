package com.bank.fin.repositories;

import com.bank.fin.model.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientAccountRepository extends JpaRepository<ClientAccount, String> {

	List<ClientAccount> findByClientIdAndAccountType_TransactionalTrueOrderByDisplayBalanceDesc(Integer clientId);
	ClientAccount findByClientIdAndClientAccountNumber(Integer clientId, String accountNumber);
	List<ClientAccount> findByClientIdOrderByDisplayBalanceAsc(Integer clientId);
	
}

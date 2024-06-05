package com.Tax.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TxnService {
	  @Autowired
	    private TxnRepository txnRepository;

	    public Txn addTxn(Txn txn) {
	        return txnRepository.save(txn);
	    }

	    public List<Txn> getTxnsByAmountRange(float initialRange, float finalRange) {
	        return txnRepository.findByAmountBetween(initialRange, finalRange);
	    }

	    public List<Txn> getAllTxnsSortedByAmount() {
	        return txnRepository.findAllByOrderByAmountAsc();
	    }

}

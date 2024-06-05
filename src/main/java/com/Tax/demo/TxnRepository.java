package com.Tax.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TxnRepository extends JpaRepository<Txn, Long> {
    List<Txn> findByAmountBetween(float initialRange, float finalRange);

	List<Txn> findAllByOrderByAmountAsc();

}

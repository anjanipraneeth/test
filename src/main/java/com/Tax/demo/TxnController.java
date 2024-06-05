package com.Tax.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/txn")
public class TxnController {

    @Autowired
    private TxnService txnService;

    @PostMapping("/add")
    public ResponseEntity<String> addTxn(@RequestBody Txn txn) {
        // Validate the amount
        if (txn.getAmount() <= 0) {
            return ResponseEntity.badRequest().body("Amount must not be less than 0.");
        }
        // Validate GST
        if (txn.getGst() <= 0) {
            return ResponseEntity.badRequest().body("GST must not be less than 0.");
        }
        // Validate Commission
        if (txn.getCommission() <= 0) {
            return ResponseEntity.badRequest().body("Commission must not be less than 0.");
        }
        txnService.addTxn(txn);
        return ResponseEntity.ok("Transaction added successfully.");
    }

    @GetMapping("/amount/{initialRange}/{finalRange}")
    public ResponseEntity<?> getTxnsByAmountRange(@PathVariable float initialRange,
                                                  @PathVariable float finalRange) {
        List<Txn> txns = txnService.getTxnsByAmountRange(initialRange, finalRange);
        if (txns.isEmpty()) {
            return ResponseEntity.status(400).body("No transactions found in the specified range.");
        }
        return ResponseEntity.ok(txns);
    }

    @GetMapping("/sort/amount")
    public ResponseEntity<List<Txn>> getAllTxnsSortedByAmount() {
        List<Txn> txns = txnService.getAllTxnsSortedByAmount();
        return ResponseEntity.ok(txns);
    }
}

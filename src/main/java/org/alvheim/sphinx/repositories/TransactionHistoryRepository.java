package org.alvheim.sphinx.repositories;

import org.alvheim.sphinx.entities.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHistoryRepository  extends JpaRepository<TransactionHistory, Long> {

}

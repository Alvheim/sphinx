package org.alvheim.sphinx.services.impl;

import org.alvheim.sphinx.repositories.TransactionHistoryRepository;
import org.alvheim.sphinx.services.TransactionHistoryService;
import org.springframework.stereotype.Service;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

  private final TransactionHistoryRepository transactionHistoryRepository;

  public TransactionHistoryServiceImpl(
      TransactionHistoryRepository transactionHistoryRepository) {
    this.transactionHistoryRepository = transactionHistoryRepository;
  }
}

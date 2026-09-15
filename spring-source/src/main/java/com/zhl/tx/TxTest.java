package com.zhl.tx;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-07 16:42
 */
public class TxTest {
    public static void main(String[] args) {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                return null;
            }
        });
    }
}

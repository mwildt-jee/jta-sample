package de.hsw.jee.sample.transaction;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.Status;
import javax.transaction.UserTransaction;

@Interceptor
@WithTransaction
public class WithTransactionInterceptor {
	
	@Inject
	private UserTransaction userTransaction;
	
	@AroundInvoke
	public Object withTransaction(InvocationContext context) throws Exception {
		try {
			boolean hierGestartet = false;
			final int transactionStatus = userTransaction.getStatus();
			if(transactionStatus == Status.STATUS_NO_TRANSACTION) {
				userTransaction.begin();
				hierGestartet = true;
			}
			Object res = context.proceed();
			
			// wenn wir die Transaction aufgemacht haben, müssen wir acuh commiten
			if(hierGestartet) {
				if(transactionStatus == Status.STATUS_ACTIVE) {
					userTransaction.commit();		
				} else if(transactionStatus == Status.STATUS_MARKED_ROLLBACK) {
					userTransaction.rollback();
				}
			}
			return res;
		} catch(RuntimeException cause) {
			userTransaction.rollback();
			throw cause;
		} catch (Exception e) {
			// Kein Rollback bei Checked-Exceptions
			throw e;
		}
	}

}

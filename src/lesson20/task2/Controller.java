package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

public class Controller {

    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save (Transaction transaction) throws LimitExceeded, BadRequestException, InternalServerException {


        return transactionDAO.save(transaction);

    }

    Transaction[] transactionList () {

        return transactionDAO.transactionList();
    }

    Transaction[] transactionList (String city) throws BadRequestException {

        return transactionDAO.transactionList(city);
    }

    Transaction[] transactionList (int amount){

        return transactionDAO.transactionList(amount);
    }
}

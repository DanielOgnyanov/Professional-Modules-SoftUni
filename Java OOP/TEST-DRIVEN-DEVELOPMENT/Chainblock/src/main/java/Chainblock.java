public interface Chainblock extends Iterable<Transaction> {

    int getCount();

    void add(Transaction transaction);

    boolean contains(Transaction transaction);

    boolean contains(int id);

    void changeTransactionStatus(int id, TransactionStatus newStatus);

    void removeTransactionById(int id);

    Transaction getById(int id);

    Iterable<Transaction> getByTransactionStatus(TransactionStatus status);

}

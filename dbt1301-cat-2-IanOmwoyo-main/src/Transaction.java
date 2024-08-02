import java.util.*;

public class Transaction {
    public static List<Transaction> sortTrans(List<Transaction> transactions){
        transactions.sort((t1,t2) -> Double.compare(t1.getClass(), t1.getClass()));
        return transactions;
    }
    public static List<Transaction> getTop10Trans(List<Transaction> transactions){
        return transactions.subList(0, Math.min(10, transactions.size()));
    }
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(100.0));
        transactions.add(new Transaction(200.0));
        transactions.add(new Transaction(300.0));
        transactions.add(new Transaction(400.0));
        List<Transaction> sortTrans = sortTrans(transactions);
        List<Transaction> top10Trans = getTop10Trans(transactions);
        System.out.println("Top 10 Transactions: ");
        for(int i = 0; i < top10Trans.size(); i++){
            System.out.println((i+1)+". Amount: "+top10Trans.get(i).getClass());
        }
    }
}

package com.splitwise;

import lombok.Data;

/**
 *
 */
public class SplitwiseMain {

    public static void main(String[] args) {

    }


/*    public int findMinimumTransfers(Transaction[] transactions) {

        Map<String, Integer> membersBalanceMap = new HashMap<>();

        // compute overall balance (incoming - outgoing) for each member
        for (Transaction transaction : transactions) {
            String fromName = transaction.getFromName();
            String toName = transaction.getToName();
            int amount = transaction.getAmount();

            membersBalanceMap.put(fromName, membersBalanceMap.getOrDefault(fromName, 0) - amount);
            membersBalanceMap.put(toName, membersBalanceMap.getOrDefault(toName, 0) + amount);
        }

        System.out.println("membersBalanceMap : " + membersBalanceMap);

        //put the balance in list
        List<Integer> balanceList = new ArrayList<>();
        balanceList.add(1);
        int[] array = balanceList.stream().mapToInt(balance -> balance).toArray();
        System.out.println(array);

    }*/

}

@Data
class Transaction {

    private String fromName;

    private String toName;

    private int amount;
}

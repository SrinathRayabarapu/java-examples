package com.design.oopsprinciples;

/**
 * OOPS principles demo classes
 *
 * @author Srinath Rayabarapu
 */
public class Account implements IProcessInterest, IWithdraw{

    @Override
    public double withdraw(double amount) {
        try {

        } catch (Exception ex) {
            // separate out external log writing
            FileHandler.writeToFile("C:/log.txt", ex);
        }
        return 0;
    }

    // defaulting to base calculation
    public double calculateInterest(double amount) {
        return (amount / 100) * 0.5;
    }

}
package com.dpattern.creational.singleton;

/**
 * Most widely accepted approach -
 * <p>
 * Alternative approach to avoid all synchronization issues - inner static helper class
 * <p>
 * When the singleton class is loaded, SingletonHelper class is not loaded into memory and only when someone
 * calls the getInstance method, this class gets loaded and creates the BillPughSinglePattern class instance.
 * <p>
 * Non-breakable with Reflection But with Serializable!
 *
 * @author Srinath.Rayabarapu
 */
public class BillPughSinglePattern {

    private BillPughSinglePattern() {
    }

    public static BillPughSinglePattern getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {
        private static final BillPughSinglePattern INSTANCE = new BillPughSinglePattern();
    }

}
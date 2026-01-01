package com.dpattern.structural.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * Demonstrates the Adapter Design Pattern - one of the Gang of Four (GoF) Structural patterns.
 * 
 * <p>The Adapter pattern converts the interface of a class into another interface that clients expect.
 * It lets classes work together that couldn't otherwise because of incompatible interfaces.
 * Also known as the Wrapper pattern.</p>
 * 
 * <h3>Pattern Structure:</h3>
 * <ul>
 *   <li><b>Target Interface</b> ({@link IDuck}) - The interface the client expects</li>
 *   <li><b>Adaptee</b> ({@link ITurkey}, {@link WildITurkey}) - The existing interface that needs adapting</li>
 *   <li><b>Adapter</b> ({@link TurkeytoIDuckAdapter}) - Wraps the adaptee and implements the target interface</li>
 *   <li><b>Client</b> - Uses objects through the target interface</li>
 * </ul>
 * 
 * <h3>Types of Adapters:</h3>
 * <ul>
 *   <li><b>Object Adapter</b> (used here) - Uses composition, wraps the adaptee</li>
 *   <li><b>Class Adapter</b> - Uses inheritance, extends the adaptee (requires multiple inheritance)</li>
 * </ul>
 * 
 * <h3>Real-World Examples:</h3>
 * <ul>
 *   <li>Java's Arrays.asList() - Adapts array to List interface</li>
 *   <li>InputStreamReader - Adapts InputStream to Reader</li>
 *   <li>JDBC drivers - Adapt database-specific APIs to JDBC interface</li>
 *   <li>Power adapters - Different plug types to wall socket</li>
 * </ul>
 * 
 * <h3>When to Use:</h3>
 * <ul>
 *   <li>When you want to use an existing class but its interface doesn't match</li>
 *   <li>When you need to create a reusable class that cooperates with unrelated classes</li>
 *   <li>When integrating legacy code with new systems</li>
 * </ul>
 *
 * @author Srinath.Rayabarapu
 * @see TurkeytoIDuckAdapter
 * @see IDuck
 * @see ITurkey
 */
@Slf4j
public class AdapterPatternMain {
	
	/**
	 * Demonstrates the Adapter pattern by adapting a Turkey to work as a Duck.
	 * 
	 * <p>Shows how a Turkey (which gobbles and flies short distances) can be
	 * used wherever a Duck (which quacks and flies) is expected.</p>
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		
		IDuck mallardDuck = new MallardDuck();
		ITurkey wildTurkey = new WildITurkey();
		
		IDuck turkeyToIDuck = new TurkeytoIDuckAdapter(wildTurkey);
		
		log.info("The Duck says..");
		callDuck(mallardDuck);

		log.info("The Turkey says..");
		callTurkey(wildTurkey);

		log.info("The TurkeyAdapter says..");
		callDuck(turkeyToIDuck);
		
	}

	/**
	 * Calls Turkey-specific methods.
	 *
	 * @param wildTurkey the turkey to call methods on
	 */
	private static void callTurkey(ITurkey wildTurkey) {
		wildTurkey.gobble();
		wildTurkey.fly();
	}

	/**
	 * Calls Duck interface methods.
	 * 
	 * <p>Works with both real ducks and adapted turkeys.</p>
	 *
	 * @param turkeyToIDuck the duck (or adapter) to call methods on
	 */
	private static void callDuck(IDuck turkeyToIDuck) {
		turkeyToIDuck.quack();
		turkeyToIDuck.fly();
	}

}
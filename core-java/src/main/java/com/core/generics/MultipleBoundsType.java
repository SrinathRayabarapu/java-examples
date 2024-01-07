package com.core.generics;

/**
 * type can have multiple bounds but class should come first in extending hierarchy.
 *
 * @author Srinath.Rayabarapu
 *
 * @param <T>
 */
public class MultipleBoundsType<T extends A & B & C> {

}

class A{

}

interface B{

}

interface C{

}
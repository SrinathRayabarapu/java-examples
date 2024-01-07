package com.core.references;

class Value
{
    public int i = 15;
}
public class MethodReferences2
{
    public static void main(String argv[])
    {
    	MethodReferences2 t = new MethodReferences2();
        t.first();
    }
    
    public void first()
    {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }
    
    public void second(Value v, int i)
    {
        i = 0;
        v.i = 30;
        Value val = new Value(); //a new reference is created and assigned - after this point modifications to this reference all not reflected to original passed parameter
        v =  val;
        System.out.println(v.i + " " + i);
    }
}
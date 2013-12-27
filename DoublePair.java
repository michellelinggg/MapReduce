/*
 * CS 61C Fall 2013 Project 1
 *
 * DoublePair.java is a class which stores two doubles and 
 * implements the Writable interface. It can be used as a 
 * custom value for Hadoop. To use this as a key, you can
 * choose to implement the WritableComparable interface,
 * although that is not necessary for credit.
 */

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.math.*;

public class DoublePair implements WritableComparable {
    
	private double wordTotal;
	private double coOccur;

    /**
     * Constructs a DoublePair with both doubles set to zero.
     */
    public DoublePair() {
        wordTotal = 0;
        coOccur = 0;

    }

    /**
     * Constructs a DoublePair containing double1 and double2.
     */ 
    public DoublePair(double double1, double double2) {
    	
        wordTotal = double1;
        coOccur = double2;

    }

    /**
     * Returns the value of the first double.
     */
    public double getDouble1() {
        return wordTotal;
        
    }

    /**
     * Returns the value of the second double.
     */
    public double getDouble2() {
        return coOccur;
        
    }

    /**
     * Sets the first double to val.
     */
    public void setDouble1(double val) {
        wordTotal = val;

    }

    /**
     * Sets the second double to val.
     */
    public void setDouble2(double val) {
        coOccur = val;

    }

    /**
     * write() is required for implementing Writable.
     */
    public void write(DataOutput out) throws IOException {
    	out.writeDouble(wordTotal);
        out.writeDouble(coOccur);

    }

    /**
     * readFields() is required for implementing Writable.
     */
    public void readFields(DataInput in) throws IOException {
    	wordTotal = in.readDouble();
        coOccur = in.readDouble();

    }
    
    public int compareTo(Object o){
    	DoublePair comp = (DoublePair) o;
    	if (coOccur/wordTotal < comp.coOccur/comp.wordTotal)
    		return -1;
    	else if (coOccur/wordTotal > comp.coOccur/wordTotal)
    		return 1;
    	else 
    		return 0;
    }
    
    public int hashCode(){
    	int a = (int) wordTotal;
    	int b = (int) coOccur;
    	return a*17 + b*37;
    }

    
}

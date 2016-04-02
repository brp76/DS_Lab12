import java.io.*;
import java.util.*;

/**
 * Primes is a program that will compute prime numbers using the sieve of Eratosthenes.
 * 
 * @author Charles Hoot
 * @version 4.0
 */


public class Primes
{

	public static void main(String args[])
	{

		int max;

		System.out.println("Please enter the maximum value to test for primality");
		max = getInt("   It should be an integer value greater than or equal to 2.");

		// COMPLETE THE MAIN
		AList<Integer> candidates = new AList<Integer>(max);
		for (int i = 2; i <= max; i ++) {
			candidates.add(i);
		}

		AList<Integer> primes = new AList<Integer>(max);
		AList<Integer> composites = new AList<Integer>(max);

		while (!candidates.isEmpty()) {
			int prime = candidates.remove(1);
			System.out.println("Prime: "+prime);

			primes.add(prime);

			getComposites(candidates, composites, prime);

			System.out.println("  The candidates list is " + candidates);
			System.out.println("  The primes list is     " + primes);
			System.out.println("  The composites list is " + composites);
		}
	}


	/**
	 * getComposites - Remove the composite values from possibles list and
	 * put them in the composites list.
	 *
	 * @param  candidates   A list of integers holding the possible values.
	 * @param  composites   A list of integers holding the composite values.
	 * @param  prime   An Integer that is prime.
	 */
	public static void getComposites(ListInterface<Integer> candidates, ListInterface<Integer> composites, Integer prime)
	{
		int index = 1;
		while (index <= candidates.getLength()) {
			if (candidates.getEntry(index)%prime == 0) {
				int temp = candidates.remove(index);
				composites.add(temp);
			} else {
				index ++;
			}
		}
	}




	/**
	 * Get an integer value.
	 *
	 * @return     An integer. 
	 */
	private static int getInt(String rangePrompt)
	{
		Scanner input;
		int result = 10;        //Default value is 10
		try
		{
			input = new Scanner(System.in);
			System.out.println(rangePrompt);
			result = input.nextInt();

		}
		catch(NumberFormatException e)
		{
			System.out.println("Could not convert input to an integer");
			System.out.println(e.getMessage());
			System.out.println("Will use 10 as the default value");
		}        
		catch(Exception e)
		{
			System.out.println("There was an error with System.in");
			System.out.println(e.getMessage());
			System.out.println("Will use 10 as the default value");
		}
		return result;

	}    

}

public class Bases {

	/**
	 * Given an array containing the digits of a number, return that number as a long.
	 * 
	 * You may not use function calls in the implementation of this method. 
	 * 
	 * @param base The base of the digits.
	 * @param digits The digits of the number. digits[0] is the least significant digit, digits[digits.length - 1] is the
	 * 		most significant. Each digit can be a number from 0 to base-1
	 * 
	 * @return the converted number.
	 */
	public static long convertFromBase(int[] digits, int base) {
		long result = 0;
		for(int i = 1; i < digits.length; i++){
			long temp = 1;
			for(int j = 0; j < i; j++){
				temp = (temp * base);
			}
			result = result + (temp*digits[i]);
		}
		result += digits[0];
		
		return result;
	}

	/**
	 * Convert an input (in a long) into base notation. The output should be written into digits.
	 * If the input is too large to fit into the given number of digits, write only the digits.length
	 * least-significant digits into the array.
	 * 
	 * You may assume that the input is always positive. You may not use function calls in the implementation of this method.
	 * 
	 * @param input
	 * @param base
	 * @param digits
	 */
	public static void convertToBase(long input, int base, int[] digits) {
		for(int i = 0; i < digits.length; i++){
			long temp = (input % base);
			digits[i] = (int)temp;
			input = (input / base);
		}
	}

	
	/**
	 * Given two inputs in base <i>base</i> (each input is given as an array of its digits in that base), add the inputs and put 
	 * the result in outDigits (if there is an overflow, keep only the least-significant digits).  
	 * 
	 * You may assume aDigits and bDigits are at least as long as outDigits (they may be longer).
	 * You may not use function calls in the implementation of this method.
	 * @param base
	 * @param aDigits
	 * @param bDigits
	 * @param outDigits
	 */
	public static void baseAdd(int base, int[] aDigits, int[] bDigits, int[] outDigits) {
		int overflow = 0;
		for(int i = 0; i < outDigits.length; i++){
			outDigits[i] = ((aDigits[i] + bDigits[i] + overflow) % base);
			overflow = ((aDigits[i] + bDigits[i] + overflow) / base);
		}
	}
	
	/**
	 * Given an input in base  <i>base</i>  (the input is given as an array of its digits in that base), write the negation 
	 * of the number in "base's"-complement notatation in outDigits. 
	 * 
	 * The "base's complement" notation of a number is a generalization of "two's complement": if we treat (-x) as an unsigned 
	 * number in base <i>base</i> and add it to x, we should get 0 (modulo base^digit-size).
	 *   
	 * @param base
	 * @param inDigits
	 * @param outDigits
	 */
	public static void baseNegate(int base, int[] inDigits, int[] outDigits) {
		
		
	}
}

public class Bits {

	/**
	 * Given an 8-byte long composed of the bytes B_1, B_2, ... , B_8, return the long with byte order reversed:
	 * B_8, B_7, ..., B_1
	 * The implementation of this method shouldn't use any function calls.
	 * @param a the number to reverse
	 * @return
	 */
	public static long byteReverse(long a) {
		long result = 0;
 		for(int i = 0; i < 8; i++){
 			long temp = 0b11111111L << i * 8L;
 			long temp2 = a & temp;
			temp2 >>= 8L * i;
			temp2 <<= (7 - i) * 8L;
			result |= temp2;
 		}

		return result;
	}
	
	/**
	 * Given a 32-bit integer composed of 32 bits: b_31,b_30,...b_1,b_0,  return the integer whose bit representation is
	 * b_{31-n},b_{30-n},...,b_1,b_0,b_31,...,b_{31-n+1}. 
	 * The implementation of this method shouldn't use any control structures (if-then, loops) or function calls.
	 * @param a the integer that we are rotating left (ROLing)
	 * @param n the number of bits to rotate.
	 * @return the ROL of a
	 */
	public static int rol(int a, int n) {
		int temp1 = a << (n % 32);
		int temp2 = a >>> ((32-n) % 32);
		int result = 0;
		
		result |= temp1;
		result |= temp2;
		
		return result;
	}

	/**
	 * Given two 32-bit integers a_31,...,a_0 and b_31,...,b_0, return the 64-bit long that contains their bits interleaved:
	 * a_31,b_31,a_30,b_30,...,a_0,b_0.
	 * The implementation of this method shouldn't use any function calls.
	 * @param a
	 * @param b
	 * @return
	 */
	public static long interleave(int a, int b) {
		long temp1 = 0;
		long temp2 = 0;
		
		for(int i = 0; i < 32; i++){
			long indexed = (0b1L << i);
			
			temp1 = temp1 + ((indexed & a) << (i + 1));
			temp2 = temp2 + ((indexed & b) << i);
		}
		return temp1 | temp2;
	}
	
	/**
	 * Pack several values into a compressed 32-bit representation. 
	 * The packed representation should contain
	 * <table>
	 * <tr><th>bits</th>	<th>value</th></tr>
	 * <tr><td>31</td>		<td>1 if b1 is true, 0 otherwise</td></tr>
	 * <tr><td>30-23</td>	<td>the value of the byte a</td></tr>
	 * <tr><td>22</td>		<td>1 if b2 is true, 0 otherwise</td></tr>
	 * <tr><td>21-6</td>	<td>the value of the char c</td></tr>
	 * <tr><td>5-0</td>		<td>the constant binary value 101101</td></tr>
	 * </table>
	 * The implementation of this method shouldn't use any control structures (if-then, loops) or function calls
	 * (you may use the conditional operator "?:").
	 * @param a
	 * @param b1
	 * @param b2
	 * @param c
	 * @return
	 */
	public static int packStruct(byte a, boolean b1, boolean b2, char c) {
		int result = 0;
		int temp = (b1 ? 1 : 0);
		temp <<= 31;
		result |= temp;
		temp = (0xFF & a);
		temp <<= 23;
		result |= temp;
		temp = (b2 ? 1 : 0);
		temp <<= 22;
		result |= temp;
		temp = c;
		temp <<= 6;
		result |= temp;
		result |= 0b101101;
		
		
		return result;
	}
	
	/**
	 * Given a packed struct (with the same format as {@link #packStruct(byte, boolean, boolean, char)}, update
	 * its byte value (bits 23-30) to the new value a.
	 * The implementation of this method shouldn't use any control structures (if-then, loops) or function calls.
	 * @param struct
	 * @param a
	 * @return
	 */
	public static int updateStruct(int struct, byte a) {
		int eraser = 0b10000000011111111111111111111111;
		int result = eraser & struct;
		
		int temp = 0xFF & a;
		temp <<= 23;
		result |= temp;
		
		return result;
	}
}

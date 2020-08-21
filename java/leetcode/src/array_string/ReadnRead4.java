package array_string;

public class ReadnRead4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * The read4 API is defined in the parent class Reader4.
	 *     int read4(char[] buf); 
	 */
	
	public static int read4(char[] buf) {
		return 1;
	}
	

//    File file("abcdefghijk"); // File is "abcdefghijk", initially file pointer (fp) points to 'a'
//    char[] buf = new char[4]; // Create buffer with enough space to store characters
//    read4(buf); // read4 returns 4. Now buf = "abcd", fp points to 'e'
//    read4(buf); // read4 returns 4. Now buf = "efgh", fp points to 'i'
//    read4(buf); // read4 returns 3. Now buf = "ijk", fp points to end of file
	
	
	// "abc"
	// [1,2,1]
	static char[] buff = new char[4];
    static int buffPtr = 0;
    static int buffCounter = 0;
	// Solution 1
    public static int read(char[] buf, int n) {
        int count = 0;
        
        while (count < n) {
            if (buffPtr == 0) { // have to call read4 since this pointer is at 0
            	buffCounter = read4(buff);
            	if(buffCounter == 0) break; // end of file as well (1)
            }
            
            while (count < n && buffPtr < buffCounter) {
                buf[count++] = buff[buffPtr++];
            }
            // all chars in buff used up, set pointer to 0
            if (buffPtr == buffCounter) buffPtr = 0;
            
            // if read4 returns less than 4, end of file
            if (buffCounter < 4) break; // (2) : can define with (1) instead of using (2)
        }
        
        return count;
    }
    
    // Solution 2
    char[] buf4 = new char[4];
    int i4 = 0, n4 = 0;
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int readB(char[] buf, int n) {
        int i = 0;
        while (i < n && (i4 < n4 || (i4 = 0) < (n4 = read4(buf4))))
            buf[i++] = buf4[i4++];
        return i;
    }
}

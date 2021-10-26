package pobj.multiset;


public class InvalidMultiSetFormat extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMultiSetFormat(String s, Throwable cause) {
		super(s,cause);
	}
	
	public InvalidMultiSetFormat(String s) {
		super(s);
	}

}
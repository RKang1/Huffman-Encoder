
public class PrintBinary {
	int bytes;
	String encodedStr = "";

	// prints the binary in the correct format
	public int printIt(int numBits, String target, int bytesIn) {
		bytes = bytesIn;
		for (int i = 0; i < target.length(); i++) {

			if (numBits < 8) {
				encodedStr += target.charAt(i);
				System.out.print(target.charAt(i));
				numBits++;
			} else if (bytes < 2) {
				numBits = 0;
				bytes++;
				encodedStr += target.charAt(i);
				System.out.print(" " + target.charAt(i));
				numBits++;
			} else {
				bytes = 0;
				numBits = 0;
				System.out.print("\n");
			}
		}

		return numBits;
	}// printIt

	public int getBytes() {
		return bytes;
	}

	public String getEncodedStr() {
		return encodedStr;
	}
}// PrintBinary

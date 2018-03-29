import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Driver {
	public static void main(String[] args) {
		PriorityQ queue = new PriorityQ();
		File dataFile = new File(args[0]);
		Input inputChoice = new Input();

		boolean nextStep;
		int aCount = 0, bCount = 0, cCount = 0, dCount = 0, eCount = 0, fCount = 0, gCount = 0;

		if (!dataFile.exists()) {
			System.out.println(args[0] + " does not exist.");
			return;
		}

		// count how many of each letter
		try {
			FileInputStream fStream = new FileInputStream(dataFile);
			char current;
			while (fStream.available() > 0) {
				current = (char) fStream.read();
				switch (current) {
				case 'A':
					aCount++;
					break;
				case 'B':
					bCount++;
					break;
				case 'C':
					cCount++;
					break;
				case 'D':
					dCount++;
					break;
				case 'E':
					eCount++;
					break;
				case 'F':
					fCount++;
					break;
				case 'G':
					gCount++;
					break;
				}
			}
			fStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// create a node for each letter
		Node aNode = new Node('A', aCount, 2);
		Node bNode = new Node('B', bCount, 2);
		Node cNode = new Node('C', cCount, 2);
		Node dNode = new Node('D', dCount, 2);
		Node eNode = new Node('E', eCount, 2);
		Node fNode = new Node('F', fCount, 2);
		Node gNode = new Node('G', gCount, 2);

		// insert each letter in priority queue
		queue.insert(aNode);
		queue.insert(bNode);
		queue.insert(cNode);
		queue.insert(dNode);
		queue.insert(eNode);
		queue.insert(fNode);
		queue.insert(gNode);
		
		// prompt and get input
		nextStep = inputChoice.getInput(1);

		// create huffman tree from priority queue
		Tree qTree = new Tree(queue);
		if (nextStep) {
			qTree.displayTree();
			System.out.println();

			// prompt and get input
			nextStep = inputChoice.getInput(2);

			if (nextStep) {
				// find and print the binary code for each letter the code table
				String aBinary = qTree.getbinaryChar('A');
				String bBinary = qTree.getbinaryChar('B');
				String cBinary = qTree.getbinaryChar('C');
				String dBinary = qTree.getbinaryChar('D');
				String eBinary = qTree.getbinaryChar('E');
				String fBinary = qTree.getbinaryChar('F');
				String gBinary = qTree.getbinaryChar('G');

				PrintBinary printer = new PrintBinary();
				System.out.println();

				// prompt and get input
				nextStep = inputChoice.getInput(3);

				if (nextStep) {
					// Encode the file
					try {
						FileInputStream fStream2 = new FileInputStream(dataFile);
						char current;
						int bits = 0;
						int bytes = 0;
						while (fStream2.available() > 0) {
							current = (char) fStream2.read();

							switch (current) {
							case 'A':
								bits = printer.printIt(bits, aBinary, bytes);
								bytes = printer.getBytes();
								if (bits == 8) {
									System.out.print(" ");
									bits = 0;
									bytes++;
								}
								if (bytes == 3) {
									bytes = 0;
									System.out.print("\n");
								}
								break;
							case 'B':
								bits = printer.printIt(bits, bBinary, bytes);
								bytes = printer.getBytes();
								if (bits == 8) {
									System.out.print(" ");
									bits = 0;
									bytes++;
								}
								if (bytes == 3) {
									bytes = 0;
									System.out.print("\n");
								}
								break;
							case 'C':
								bits = printer.printIt(bits, cBinary, bytes);
								bytes = printer.getBytes();
								if (bits == 8) {
									System.out.print(" ");
									bits = 0;
									bytes++;
								}
								if (bytes == 3) {
									bytes = 0;
									System.out.print("\n");
								}
								break;
							case 'D':
								bits = printer.printIt(bits, dBinary, bytes);
								bytes = printer.getBytes();
								if (bits == 8) {
									System.out.print(" ");
									bits = 0;
									bytes++;
								}
								if (bytes == 3) {
									bytes = 0;
									System.out.print("\n");
								}
								break;
							case 'E':
								bits = printer.printIt(bits, eBinary, bytes);
								bytes = printer.getBytes();
								if (bits == 8) {
									System.out.print(" ");
									bits = 0;
									bytes++;
								}
								if (bytes == 3) {
									bytes = 0;
									System.out.print("\n");
								}
								break;
							case 'F':
								bits = printer.printIt(bits, fBinary, bytes);
								bytes = printer.getBytes();
								if (bits == 8) {
									System.out.print(" ");
									bits = 0;
									bytes++;
								}
								if (bytes == 3) {
									bytes = 0;
									System.out.print("\n");
								}
								break;
							case 'G':
								bits = printer.printIt(bits, gBinary, bytes);
								bytes = printer.getBytes();
								if (bits == 8) {
									System.out.print(" ");
									bits = 0;
									bytes++;
								}
								if (bytes == 3) {
									bytes = 0;
									System.out.print("\n");
								}
								break;
							}// swtich
						} // while
						System.out.println();
						fStream2.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println();

					// get the file in binary format
					String binaryString = printer.getEncodedStr();

					// prompt and get input
					nextStep = inputChoice.getInput(4);

					if (nextStep) {
						// decode the file
						qTree.decodeBinary(binaryString);
						System.out.println();
					}
				}
			}
		}
		inputChoice.closeScan();
		System.out.println("\nfin");
	}// main

}// Driver
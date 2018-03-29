import java.util.Stack;

public class Tree {
	private Node[] pQ;
	private Node root;
	private String revBinaryChar;
	private String binaryChar;

	// builds tree
	public Tree(PriorityQ tQueue) {
		pQ = tQueue.getnodeArr();
		root = pQ[0];

		while (pQ[1] != null) {
			pQ = tQueue.getnodeArr();
			root = new Node('z', 0, 0);

			// sets the first node to the root's left
			root.setLeft(pQ[0]);
			root.getLeft().setParent(root);

			// sets the second node to the root's right
			root.setRight(pQ[1]);
			root.getRight().setParent(root);

			// labels the left child as 0
			root.getLeft().setPlace(0);

			// labels the right child as 1
			root.getRight().setPlace(1);

			// sets the root's weight to the combined weights of the children
			root.setWeight(root.getLeft().getWeight() + root.getRight().getWeight());

			tQueue.removeFirst();
			tQueue.removeFirst();
			tQueue.insert(root);
			// tQueue.displayQueue();

		}
	}// Tree constructor

	// code from the book
	public void displayTree() {
		Stack<Node> globalStack = new Stack<Node>();

		globalStack.push(root);

		int nBlanks = 32;
		boolean isRowEmpty = false;

		System.out.println("**************************************************************************");

		while (isRowEmpty == false) {
			Stack<Node> localStack = new Stack<Node>();
			isRowEmpty = true;

			for (int i = 0; i < nBlanks; i++) {
				System.out.print(' ');
			}

			while (globalStack.isEmpty() == false) {
				Node temp = (Node) globalStack.pop();
				if (temp != null) {

					if (temp.getLeft() == null && temp.getRight() == null) {
						temp.printLetter();
					}

					System.out.print(" ");
					temp.printWeight();

					System.out.print(" ");
					temp.printPlace();

					localStack.push(temp.getLeft());
					localStack.push(temp.getRight());

					if (temp.getLeft() != null || temp.getRight() != null) {
						isRowEmpty = false;
					}
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}

				for (int i = 0; i < nBlanks * 2 - 2; i++) {
					System.out.print(' ');
				}
			} // while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false) {
				globalStack.push(localStack.pop());
			}
		} // while rowIsEmpty false
		System.out.println("**************************************************************************");
	}// displayTree

	// finds the reverse of the binary code for the specified character
	public void findbinaryChar(Node tempRoot, char target) {

		if (tempRoot.leftExists()) {
			findbinaryChar(tempRoot.getLeft(), target);
		}

		if (tempRoot.rightExists()) {
			findbinaryChar(tempRoot.getRight(), target);
		}

		if (tempRoot.getChar() == target) {
			revBinaryChar = Integer.toString(tempRoot.getPlace());
			printParent(tempRoot);
		}

		return;
	}

	public void printParent(Node child) {
		if (child.parentExists() && child.getParent() != root) {
			revBinaryChar = revBinaryChar + child.getParent().getPlace();
			// System.out.print(child.getParent().getPlace());
			printParent(child.getParent());
		}
		return;
	}

	public Node getRoot() {
		return root;
	}

	// reverses the binary character code
	public void fixbinaryChar() {
		binaryChar = new StringBuffer(revBinaryChar).reverse().toString();
		return;
	}

	public String getbinaryChar(char letter) {
		findbinaryChar(root, letter);
		fixbinaryChar();
		System.out.println(letter + " " + binaryChar);
		return binaryChar;
	}

	// traverses the tree based on the path of the binary to print the correct character
	public void decodeBinary(String binaryLong) {
		Node current = root;

		for (int i = 0; i < binaryLong.length(); i++) {
			if (binaryLong.charAt(i) == '0') {
				current = current.getLeft();
			}

			if (binaryLong.charAt(i) == '1') {
				current = current.getRight();
			}
			if (current.isLeaf()) {
				System.out.print(current.getChar());
				current = root;
			}
		}
	}

}// Tree
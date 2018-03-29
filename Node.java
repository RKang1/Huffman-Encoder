
public class Node {
	private char letter;
	private int weight;
	private int place;
	private Node parent;
	private Node left;
	private Node right;

	// create node with given parameters
	public Node(char inLetter, int inWeight, int inPlace) {
		letter = inLetter;
		weight = inWeight;
		place = inPlace;
	}

	public void printWeight() {
		System.out.print(weight);
	}

	public void printLetter() {
		System.out.print(letter);
	}

	public void printPlace() {
		System.out.print(place);
	}

	public char getChar() {
		return letter;
	}

	public int getWeight() {
		return weight;
	}

	public int getPlace() {
		return place;
	}

	public Node getParent() {
		return parent;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public void setWeight(int addWeight) {
		weight = addWeight;
	}

	public void setPlace(int newPlace) {
		place = newPlace;
	}

	public void setParent(Node p) {
		parent = p;
	}

	public void setLeft(Node l) {
		left = l;
	}

	public void setRight(Node r) {
		right = r;
	}

	public boolean leftExists() {
		if (left != null) {
			return true;
		}
		return false;
	}

	public boolean rightExists() {
		if (right != null) {
			return true;
		}
		return false;
	}

	public boolean parentExists() {
		if (parent != null) {
			return true;
		}
		return false;
	}

	public boolean isLeaf() {
		if (!leftExists() && !rightExists()) {
			return true;
		}
		if (leftExists() || rightExists()) {
			return false;
		}
		return false;
	}
}// Node

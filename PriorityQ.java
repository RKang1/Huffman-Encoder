
public class PriorityQ {
	private Node[] nodeArr;
	private int numItems;

	public PriorityQ() {
		nodeArr = new Node[7];
		numItems = 0;
	}

	// inserts nodes in order of weight
	// smallest ends up first
	public void insert(Node item) {
		int i;
		int isNullCounter;

		if (numItems == 0) {
			nodeArr[0] = item;
			numItems++;
		} else {
			for (i = 0; i < nodeArr.length; i++) {
				isNullCounter = 1;

				if (nodeArr[i] == null) {
					nodeArr[i] = item;
					numItems++;

					break;
				}

				if (item.getWeight() <= nodeArr[i].getWeight()) {
					// finds the first null item
					while ((nodeArr[i + isNullCounter] != null) && ((i + isNullCounter) < nodeArr.length - 1)) {
						isNullCounter++;
					}

					// sets the first null item to the last real item
					nodeArr[i + isNullCounter] = nodeArr[numItems - 1];

					// moves everything else down to the right of the new item
					for (int j = numItems - 1; j > i; j--) {
						nodeArr[j] = nodeArr[j - 1];
					}

					// inserts the new node in the empty space
					nodeArr[i] = item;
					numItems++;
					break;
				}

			} // for loop

		}
	}

	// removes first node and resorts
	public void removeFirst() {
		int count = 0;
		nodeArr[0] = null;
		while (count < nodeArr.length - 1) {
			nodeArr[count] = nodeArr[count + 1];
			count++;
		}

		count = 0;
		while (nodeArr[count] != null && count < nodeArr.length - 1) {
			count++;
		}

		if (count == nodeArr.length - 1) {
			nodeArr[count] = null;
		}
		numItems--;
	}

	public void displayQueue() {
		for (int i = 0; i < 7; i++) {
			if (nodeArr[i] != null) {
				System.out.print(nodeArr[i].getWeight() + " ");
			} else {
				System.out.print("null ");
			}
		}
		System.out.print("\n\n");
	}

	public Node[] getnodeArr() {
		return nodeArr;
	}
}// PriorityQ

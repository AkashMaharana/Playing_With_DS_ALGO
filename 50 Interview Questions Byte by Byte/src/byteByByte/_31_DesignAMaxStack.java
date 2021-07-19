package byteByByte;

public class _31_DesignAMaxStack {

	public static void main(String[] args) {

		MaxStack stack = new MaxStack();
		stack.push(1);
		stack.push(3);
		stack.push(2);
		System.out.println(stack.pop());
		System.out.println(stack.max());
		System.out.println(stack.pop());
		System.out.println(stack.max());
		System.out.println(stack.pop());
		System.out.println(stack.max());
	}

}

class MaxStack {
	MaxStackNode maxNode;
	MaxStackNode node;

	public void push(int data) {
		MaxStackNode newNode = new MaxStackNode(data);
		if (node == null) {
			node = newNode;
		} else {
			newNode.nextNode = node;
			node = newNode;
		}

		if (maxNode == null || newNode.data > maxNode.data) {
			newNode.oldMaxNode = maxNode;
			maxNode = newNode;
		}
	}

	public int pop() {
		if (node == null) {
			throw new NullPointerException();
		}
		MaxStackNode temp = node;
		node = temp.nextNode;
		if (temp.oldMaxNode != null) {
			maxNode = temp.oldMaxNode;
		}
		return temp.data;
	}

	public int max() {
		if (maxNode == null || node == null) {
			throw new NullPointerException();
		}
		return maxNode.data;
	}
}

class MaxStackNode {

	int data;
	MaxStackNode nextNode;
	MaxStackNode oldMaxNode;

	public MaxStackNode(int data) {
		this.data = data;
		this.nextNode = null;
		this.oldMaxNode = null;
	}

}

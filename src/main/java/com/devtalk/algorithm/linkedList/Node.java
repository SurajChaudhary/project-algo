package com.devtalk.algorithm.linkedList;

public class Node {

	public int data;
	public Node nextNode;

	public Node(int data) {
		this.data = data;
		this.nextNode = null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + ((nextNode == null) ? 0 : nextNode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		if (nextNode == null) {
			if (other.nextNode != null)
				return false;
		} else if (!nextNode.equals(other.nextNode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

}

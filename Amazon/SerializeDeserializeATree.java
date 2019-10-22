package Amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeATree {
	private static final String NULL_SYMBOL = "X";
	private static final String DELIMITER = ",";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return NULL_SYMBOL + DELIMITER;
		}

		String leftSerialized = serialize(root.left);
		String rightSerialized = serialize(root.right);

		return root.val + DELIMITER + leftSerialized + rightSerialized;
	}

	public TreeNode deserialize(String data) {
		Queue<String> nodesLeft = new LinkedList<>();
		nodesLeft.addAll(Arrays.asList(data.split(DELIMITER)));
		return deserializeHelper(nodesLeft);
	}

	public TreeNode deserializeHelper(Queue<String> nodesLeft) {

		String valueForNode = nodesLeft.poll();

		if (valueForNode.equals(NULL_SYMBOL)) {
			return null;
		}

		TreeNode newNode = new TreeNode(Integer.valueOf(valueForNode));
		newNode.left = deserializeHelper(nodesLeft);
		newNode.right = deserializeHelper(nodesLeft);

		return newNode;
	}

}

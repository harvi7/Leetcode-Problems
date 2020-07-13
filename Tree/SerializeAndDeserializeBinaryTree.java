// https://www.youtube.com/watch?v=suj1ro8TIVY
// https://github.com/bephrem1/backtobackswe/blob/master/Trees%2C%20Binary%20Trees%2C%20%26%20Binary%20Search%20Trees/SerializeDeserializeBinaryTree/SerializeDeserializeBinaryTree.java

public class Codec {
    private static final String NULL_SYMBOL = "X";
    private static final String DELIMITER = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) 
            return NULL_SYMBOL + DELIMITER;
        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);
        return root.val + DELIMITER + leftSerialized + rightSerialized;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodesLeftToMaterialize = new LinkedList<>();
        nodesLeftToMaterialize.addAll(Arrays.asList(data.split(DELIMITER)));
        return deserializeHelper(nodesLeftToMaterialize);
    }
    
    private TreeNode deserializeHelper(Queue<String> nodesLeftToMaterialize) {

    String valueForNode = nodesLeftToMaterialize.poll();

    if (valueForNode.equals(NULL_SYMBOL)) {
      return null;
    }

    TreeNode newNode = new TreeNode(Integer.valueOf(valueForNode));
    newNode.left = deserializeHelper(nodesLeftToMaterialize);
    newNode.right = deserializeHelper(nodesLeftToMaterialize);

    return newNode;
  }
}
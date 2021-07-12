public class BinarySearchTree {
    private Node root;

/**
 * BST with no root node given
 */
    public BinarySearchTree(){

    }

    public BinarySearchTree(int rootKey){
        this.root = new Node(rootKey);
    }
  /**
   * Inserts a key into this binary search tree.
   * If there are n nodes in the tree, then the average runtime of this method should be log(n).
   * 
   * @param key The key to insert.
   */
  public void insert(int key) {
    // Please implement this method.
    if(root == null){
        root = new Node(key);
    }
    Node prev = null;
    Node curr = root;
    while(curr != null){
        if(curr.key < key){
            prev = curr;
            curr = curr.right;
        } else {
            prev = curr;
            curr = curr.left;
        }
    }
    Node newNode = new Node(key);
    if(key > prev.key){
        prev.right = newNode;
    } else{
        prev.left = newNode;
    }

  }

  /**
   * Checks whether or not a key exists in this binary search tree.
   * If there are n nodes in the tree, then the average runtime of this method should be log(n).
   * 
   * @param key The key to check for.
   * @return true if the key is present in this binary search tree, false otherwise.
   */
  public boolean find(int key) {
    // Please implement this method.
    Node curr = root;
    while(curr != null){
        if(curr.key < key){
            curr = curr.right;
        } else if(curr.key > key) {
            curr = curr.left;
        }
        else{
            return true; 
        }
    }
    return false;
  }

  public static class Node {
    public int key;
    public Node left;
    public Node right;
    public Node(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
  }

}

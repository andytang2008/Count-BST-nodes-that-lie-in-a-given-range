// Java code to count BST nodes that
// lie in a given range
class BST {  //BinarySearchTree
 
    /* Class containing left and right child
    of current node and key value*/

 
    // Root of BST
    Node root;
 
    // Constructor
    BST() {
        root = null;
    }
     
    // Returns count of nodes in BST in
    // range [low, high]
    int getCount(Node node, int low, int high)
    {
        // Base Case
        if(node == null)
            return 0;
 
        // If current node is in range, then
        // include it in count and recur for
        // left and right children of it
        if(node.data >= low && node.data <= high)
            return 1 + this.getCount(node.left, low, high)+
                this.getCount(node.right, low, high);
                 
        // If current node is smaller than low,
        // then recur for right child
        else if(node.data < low)
            return this.getCount(node.right, low, high)+this.getCount(node.left, low, high);
               
         
        // Else recur for left child
        else
            return this.getCount(node.left, low, high)+this.getCount(node.right, low, high);    
    }
	
	  int inOrder(Node node, String mark) {
		if (node == null) {
		  return 0;
		} 
		inOrder(node.left, "L=");
		System.out.printf(mark+"%s   ", node.data);
		inOrder(node.right, "R=");
		
		return 0;
	}

}

class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

class Main2{
    // Driver function
    public static void main(String[] args) {
        BST tree = new BST();
         
        tree.root = new Node(10);
        tree.root.left     = new Node(5);
        tree.root.right     = new Node(50);
        tree.root.left.left = new Node(1);
		 tree.root.left.left.left = new Node(6);
		 tree.root.left.left.right = new Node(4);
        tree.root.right.left = new Node(40);
        tree.root.right.right = new Node(100);
        /* Let us constructed BST shown in above example
          10
        /    \
      5       50
     /       /  \
    1       40   100   
   /   \
  6    4
	*/
    int l=5;
    int h=45;
    System.out.println("Count of nodes between [" + l + ", "
                      + h+ "] is " + tree.getCount(tree.root,
                                                  l, h));
	tree.inOrder(tree.root, "T=");
    }
} 

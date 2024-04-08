package edu.cwu.brienenj.lab2;

public class BinarySearchTree{

    /**
     * The starting node for this tree 
     */
    private Node root;

    /**
     * The total number of {@code Nodes}
     */
    private int size;
    
    /**
     * Inserts a new {@code Node} into the {@code BinarySearchTree}
     *
     * @param value The key value given to the {@code Node} that will be inserted
     */
    public void insert(int value) {
        size++;
        root = insert(root, value);
    }

    /**
     * Inserts a new {@code Node} by recursively traversing the {@code BinarySearchTree} to 
     * determine the proper location to maintain the Tree's BinarySearch integrity.
     *
     * @param n The {@code Node} where to start searching
     * @param value The key value given to the {@code Node} that will be inserted
     * 
     * @return {@code Node} object that will either replace or already be in the same position as {@code Node} n
     */
    private Node insert(Node n, int value){
        //base case
        if(n == null){
            n = new Node(value);
            return n;
        }

        //recursive step
        if(value < n.value){
            n.left = insert(n.left, value); 
        } else {
            n.right = insert(n.right, value);
        }

        return n;
    }
    
    /**
     * Creates an {@code int[]} from the {@code BinarySearchTree} in prefix notation
     * 
     * @return {@code int[]} representing the tree in prefix notation
     */
    public int[] preOrderTraversal(){
        // print each node in pre order
        int[] order = new int[size];
        preOrder(root, order, 0);
        return order;
    }
    
    /**
     * Recursively traverse {@code Node}s whle storing the root {@code Node}'s value in the {@code order} {@code int[]}
     * at {@code index}. The order of these actions will be store {@code Node#value}, traverse {@code Node#left}, then 
     * traverse {@code Node#right}.
     *
     * @param n the {@code Node} where to traverse from
     * @param order the {@code int[]} to store the root value in
     * @param index the index of the {@code int[]} to store the root value 
     * 
     * @return the index after storing the root value and performing left and right traversals
     */
    private int preOrder(Node n, int[] order, int index) {
        if(n != null) {
            order[index++] = n.value;
            index = preOrder(n.left, order, index);
            index = preOrder(n.right, order, index);
        }
        return index;
    }
    
    /**
     * Creates an {@code int[]} from the {@code BinarySearchTree} in infix notation
     * 
     * @return {@code int[]} representing the tree in infix notation
     */
    public int[] inOrderTraversal(){
        // print each node in in order
        int[] order = new int[size];
        inOrder(root, order, 0);
        return order;
    }
    
    /**
     * Recursively traverse {@code Node}s whle storing the root {@code Node}'s value in the {@code order} {@code int[]}
     * at {@code index}. The order of these actions will be traverse {@code Node#left}, store {@code Node#value}, then 
     * traverse {@code Node#right}.
     *
     * @param n the {@code Node} where to traverse from
     * @param order the {@code int[]} to store the root value in
     * @param index the index of the {@code int[]} to store the root value 
     * 
     * @return the index after storing the root value and performing left and right traversals
     */
    private int inOrder(Node n, int[] order, int index) {
        if(n != null) {
            index = inOrder(n.left, order, index);
            order[index++] = n.value;
            index = inOrder(n.right, order, index);
        }
        return index;
    }


    /**
     * Creates an {@code int[]} from the {@code BinarySearchTree} in postfix notation
     * 
     * @return {@code int[]} representing the tree in postfix notation
     */
    public int[] postOrderTraversal(){
        // print each node in post order
        int[] order = new int[size];
        postOrder(root, order, 0);
        return order;
    }
    
    /**
     * Recursively traverse {@code Node}s whle storing the root {@code Node}'s value in the {@code order} {@code int[]}
     * at {@code index}. The order of these actions will be traverse {@code Node#left}, traverse {@code Node#right}, 
     * then store {@code Node#value}.
     *
     * @param n the {@code Node} where to traverse from
     * @param order the {@code int[]} to store the root value in
     * @param index the index of the {@code int[]} to store the root value 
     * 
     * @return the index after storing the root value and performing left and right traversals
     */
    private int postOrder(Node n, int[] order, int index) {
        if(n != null) {
            index = postOrder(n.left, order, index);
            index = postOrder(n.right, order, index);
            order[index++] = n.value;
        }
        return index;
    }
    

    /**
     * Finds if a key is contained in the {@code BinarySearchTree}
     *
     * @param key {@code int} to search through the {@code BinarySearchTree} for existance
     *
     * @return {@code true} if the {@code key} was found; otherwise false
     */
    public boolean find(int key) {
        return find(root, key);
    }

    /**
     * Recursively searches {@code Node}'s to find the {@code key}
     *
     * @param {@code Node} to start with the recursive search
     * @param {@code int} to search for
     *
     * @return {@code true} if the key could be found; otherwise false
     */
    private boolean find(Node n, int key){
        if(n != null) {
            if(n.value == key) {
                return true;
            }
            if(key < n.value) {
                return find(n.left, key);
            }
            if(key > n.value) {
                return find(n.right, key);
            }
        }
        return false;           
    }

    
    /**
     * Retreives the minimum key value in the {@code BinarySearchTree}
     *
     * @return the minimum key value
     */
    public int getMin() {
        return getMin(root);
    }

    /**
     * Searches the given {@code Node} for it's minimum value
     * 
     * @param root The {@code Node} to search for it's minimum value
     */
    private int getMin(Node root){
        Node current = root;
        while(current.left != null) {
            current = current.left;
        }
        return current.value;    
    }
    
    /**
     * Retreives the maximum key value in the {@code BinarySearchTree}
     *
     * @return the maximum key value
     */
    public int getMax() {
        return getMax(root);
    }

    /**
     * Searches the given {@code Node} for it's maximum value
     * 
     * @param root The {@code Node} to search for it's maximum value
     */
    private int getMax(Node root){
        Node current = root;
        while(current.right != null) {
            current = current.right;
        }
        return current.value;
    }
    
    /**
     * Removes a given key from the {@code BinarySearchTree}
     *
     * @param key the key to remove from the {@code BinarySearchTree}
     */
    public void delete(int key) {
        root = delete(root, key);
    }

    /**
     * Recursively removes key starting from the root {@code Node}
     *
     * @param root The {@code Node} to search for the {@code key} to delete
     * @param key The key to remove
     *
     * @return the root that has been modified by the deleted key  
     */
    private Node delete(Node root, int key){
        if(root == null){
            return root;
        }else if(key < root.value){
            root.left = delete(root.left, key);
        }else if(key > root.value){
            root.right = delete(root.right, key);
        }else{
            size--;
            //node has been found
            if(root.left==null && root.right==null){
                //case #1: leaf node
                root = null;
            }else if(root.right == null){
                //case #2 : only left child
                root = root.left;
            }else if(root.left == null){
                //case #2 : only right child
                root = root.right;
            }else{
                //case #3 : 2 children
                root.value = getMax(root.left);
                root.left = delete(root.left, root.value);
            }
        }
        return root;  
    }

}

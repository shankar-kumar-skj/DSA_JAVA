package JAVA.SHASHCODE.LECTURE191;

// BST + Balanced Tree => Balanced Binary Search Tree
// AVL TREE => O(Log2 (N))

// AVL => SELF BALANCING BST

// How to balanced a tree
// 1 => check Rules
// 2 => use rotations to balance the tree
//     Rules => Balanced Factor should be (-1,0,1)

// Balanced Factor (BF) -> [-1,0,1]
// BF => (Height of LST - Height of RST)

// Rotations :-
// -> It tends to the change the structure of the BST but not the order.
// -> Left (Anti Clock Wise) & Right Rotation (Clock Wise)

// Right Rotation :-
// => Node will be "Right" child of its "Left" child

// Left Rotation :-
// => Node will be "Left" child of its "Right" child

// AVL ROTATIONS (4 ROTATIONS POSSIBLE):-
// 1.) LL -> 1 Right Rotation
// 2.) RR -> 1 Left Rotation
// 3.) LR -> 1 Left Rotation then 1 Right Rotation
// 4.) RL -> 1 Right Rotation then 1 Left Rotation

// Insertion in AVL TREE 


// AVL DELETE => BST DELETE + BALANCING

// 1.) Find the balanced factor of the all parent of the delete node
// 2.) if you find the first unbalanced factor then find the left height and right height move to the largest height then check the Pattern.

// Pattern 1 (If the node from right):- 
// 1.) we use LL

// Pattern 2 (If the node from right):-
// 1.) If LL not available then LR 

// Pattern 3 (If the node from right):-
// 1.) If LL & LR both available then LL 

// Pattern 4 (If the node from left):-
// 1.) we use RR

// Pattern 5 (If the node from left):-
// 1.) If LL not available then RL 

// Pattern 6 (If the node from left):-
// 1.) If RR & RL both available then RR

public class Complete_avl_tree {
    class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

    Node root;

    // Get height
    int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    // Get balance factor
    int getBalance(Node n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    // Right rotate
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotate
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert
    Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // duplicates not allowed

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // LL Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // RR Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // LR Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Get min value node
    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Delete
    Node deleteNode(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
        else {
            // node with one or no child
            if ((root.left == null) || (root.right == null)) {
                Node temp = (root.left != null) ? root.left : root.right;

                if (temp == null) {
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = deleteNode(root.right, temp.key);
            }
        }

        if (root == null)
            return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        // LL
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // LR
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RR
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // RL
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Inorder traversal
    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    // Main method
    public static void main(String[] args) {
        Complete_avl_tree tree = new Complete_avl_tree();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Inorder traversal after insertion:");
        tree.inorder(tree.root);

        tree.root = tree.deleteNode(tree.root, 40);

        System.out.println("\nInorder traversal after deletion:");
        tree.inorder(tree.root);
    }
}

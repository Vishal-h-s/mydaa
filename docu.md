Sep 14
------

Problem statement 1
-------------------
-------------------
Ramesh is interested to work on Data Structures.
He has constructed BinaryTree-BT.

He asked his friend Gopal to check whether BT is self mirror tree or not.
Can you help Gopal to find and return "true" if BT is a self mirror tree,
otherwise return "false"

Implement the class Solution:
   1. public boolean isSelfMirrorTree(BinaryTreeNode root): returns a boolean value.
  
NOTE:
	- In the tree '-1', indicates empty(null).
   
Input Format:
-------------
Line-1: Space separated integers, values at the treenode

Output Format:
--------------
Line-1: Print a boolean value.


Sample Input-1:
---------------
2 1 1 2 3 3 2

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 1 1 -1 3 -1 3

Sample Output-2:
----------------
false

Q. binary tree symmetric or not?

Boiler plate:

```java
class Solution{
    //Write your code here and return boolean value
    public boolean isSymmetric(BinaryTreeNode root){
        return root==null || isMirror(root.left, root.right);
    }
    private boolean isMirror(BinaryTreeNode left, BinaryTreeNode right){
        if(left==null || right==null) return left==right;
        if(left.data=right.data) reeturn false;
        else{
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
    }
}
```

PS 2:
Mr. Rishil is interested to work on Data Structures.
He has constructed a BinaryTree-BT.

He asked his friend Mr. Anil to check whether BT is a balanced BT or not.
A balanced BT is defined as follows:
    - The binary tree in which the left and right subtrees of every node 
    differ in height by no more than 1.

Can you help Mr. Anil to find and return "true" if the given BT is a balanced tree,
otherwise return "false".

Implement the class Solution:
   1. public boolean isBalanced(BinaryTreeNode root): returns a boolean value.

NOTE:
	- In the tree '-1', indicates empty(null).
   
Input Format:
-------------
Line-1: Space separated integers, values at the treenode

Output Format:
--------------
Line-1: A boolean value.


Sample Input-1:
---------------
2 1 1 2 3 3 2

Sample Output-1:
----------------
true


Sample Input-2:
---------------
1 2 3 4 5 -1 -1 6 7

Sample Output-2:
----------------
false

Q: binary tree balanced or not?

boilerplate:

```java
import java.util.*;

class BinaryTreeNode
{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data)
	{
		this.data = data; 
		left = null; 
		right = null; 
	}
}

class Solution 
{
	public boolean isBalanced(BinaryTreeNode root) 
	{
        //Write your code here and return a boolean value
        
    }

    //Your supporting methods(if any) goes here
}

public class BalancedBinaryTree
{
	static BinaryTreeNode root;
	void insert(BinaryTreeNode temp, int key)
    { 
        if (temp == null) 
		{
            temp = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(temp);
 
        // Do level order traversal until we find an empty place.
        while (!q.isEmpty()) {
            temp = q.remove();
 
            if (temp.left == null) {
                temp.left = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		BalancedBinaryTree ln=new BalancedBinaryTree();
		Solution sol= new Solution();
		
		String str[]=sc.nextLine().split(" ");
		root=new BinaryTreeNode(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			ln.insert(root,Integer.parseInt(str[i]));

		System.out.println(sol.isBalanced(root));
	}
}
```



Sep 15
------
PS:
Balbir singh is working with Binary Trees.
The elements of the tree is given in the level order format.
Balbir is looking the tree from right side. 
So, he can view only rightmost nodes only (one node per level).

You will be given the root of the binary tree.
Your task is to find the nodes which can be viewed by Balbir from right side.
And print the nodes from top to bottom order.

Your task is to implement the class Solution:
	- public List<Integer> rightSideView(BinaryTreeNode root):
	return the list of node values.
	
NOTE: 
Please do consider the node with data=-1 as null node in the given trees.

Input Format:
-------------
Space separated integers, elements of the tree.

Output Format:
--------------
Print a boolean value.

Sample Input-1:
---------------
1 2 3 5 -1 -1 5

Sample Output-1:
----------------
[1, 3, 5]

Sample Input-2:
---------------
3 2 4 3 2

Sample Output-2:
----------------
[3, 4, 2]

Q: Right View of Binary Tree

Approach 1: 

using DFS
call right child first then left
add to result (list) only if the position(same as level) in result is empty

Solution code:

```java
class Solution 
{
	public List<Integer> RightSideView(BinaryTreeNode root) 
	{
        //Write your code here and return a list of nodes
        List<Integer> res=new ArrayList<>();
        helper(root, res, 0);
        return res;
    }
    
    //Your supporting methods(if any) goes here
    private void helper(BinaryTreeNode node, List<Integer> res, int level){
        
        if(node==null || node.data==-1) return;
        if(res.size()==level) res.add(node.data);
        helper(node.right, res, level+1);
        helper(node.left, res, level+1);
    }
}
```



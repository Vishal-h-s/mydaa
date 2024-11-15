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
	public List<Integer> RightSideView(BinaryTreeNode root) 
	{
        //Write your code here and return a list of nodes
        List<Integer> res=new ArrayList<>();
        helper(root, res, 0);
        return res;
    }
    
    //Your supporting methods(if any) goes here
    private void helper(BinaryTreeNode node, List<Integer> res, int level){
        
        if(node==null||node.data==-1) return;
        if(res.size()==level) res.add(node.data);
        helper(node.right, res, level+1);
        helper(node.left, res, level+1);
    }
}

public class RightSideView 
{
	static BinaryTreeNode root;
	static BinaryTreeNode temp = root;
	void insert(BinaryTreeNode temp, int key)
    { 
        if (temp == null) {
            root = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(temp);
 
        // Do level order traversal until we find an empty place.
        while (!q.isEmpty()) 
		{
            temp = q.remove();

            if (temp.left == null) 
			{
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
		String str[]=sc.nextLine().split(" ");
		RightSideView bt=new RightSideView();
		root=new BinaryTreeNode(Integer.parseInt(str[0]));

		for(int i=1; i<str.length; i++)
			bt.insert(root,Integer.parseInt(str[i]));

		Solution sol= new Solution();
		System.out.println(sol.RightSideView(root));
	}
}
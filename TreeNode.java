import java.util.ArrayList;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class TreeNode<T> {
    public T data;
    public ArrayList<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        children = new ArrayList<>();
    }

    public static TreeNode<Integer> takeInput(Scanner s) {
        int n;
        System.out.println("Enter data::");
        n = s.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(n);
        // System.out.print("Enter no of children of" + n + "::");
        int childNo = s.nextInt();
        for (int i = 0; i < childNo; i++) {
            TreeNode<Integer> child = takeInput(s);
            root.children.add(child);
        }

        return root;
    }

    public static TreeNode<Integer> takeInputLevel() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root data::");
        int rootdata = s.nextInt();

        Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
        TreeNode<Integer> root1 = new TreeNode<Integer>(rootdata);
        q.add(root1);
        while (!q.isEmpty()) {
            TreeNode<Integer> root = q.poll();
            System.out.println("Enter the children of " + root.data + "::");
            int childNO = s.nextInt();
            for (int i = 0; i < childNO; i++) {
                System.out.println("Enter the" + (i + 1) + "th chile of" + root.data);
                int child = s.nextInt();
                TreeNode<Integer> childNode = new TreeNode<Integer>(child);
                q.add(childNode);
                root.children.add(childNode);

            }
        }
        return root1;
    }

    public static void printLevel(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = q.poll();
                System.out.print(node.data + " ");
                for (int j = 0; j < node.children.size(); j++) {
                    q.add(node.children.get(j));
                }
            }
            System.out.println();
        }
    }

    public static void print(TreeNode<Integer> root) {
        String s1 = root.data + ":";
        for (int i = 0; i < root.children.size(); i++) {
            s1 = s1 + root.children.get(i).data + " , ";
        }
        System.out.println(s1);
        for (int i = 0; i < root.children.size(); i++) {
            print(root.children.get(i));
        }
    }

    public static int CountNode(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        int count = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            count += CountNode(root.children.get(i));
        }
        return count;
    }

    public static int numNodeGreater(TreeNode<Integer> root, int x) {
        if (root == null)
            return 0;

        int count = 0;
        if (root.data > x) {
            count = 1;
        }
        for (int i = 0; i < root.children.size(); i++) {

            count += numNodeGreater(root.children.get(i), x);

        }
        // Write your code here
        return count;

    }

    public static int heightofTree(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        int maxheight = 0;
        for (int i = 0; i < root.children.size(); i++) {

            int height = heightofTree(root.children.get(i));
            maxheight = Math.max(maxheight, height);
        }
        return maxheight + 1;
    }

    public static void printPostOrder(TreeNode<Integer> root) {
        if (root == null)
            return;
        for (int i = 0; i < root.children.size(); i++) {
            printPostOrder(root.children.get(i));
        }
        System.out.print(root.data + " ");
    }


public static void printPreOrder(TreeNode<Integer> root) {
    if (root == null)
        return;
        System.out.print(root.data + " ");
    for (int i = 0; i < root.children.size(); i++) {
        printPostOrder(root.children.get(i));
    }
   
} 
public static void Depth(TreeNode<Integer> root,int k){
    if (k<0)
        return;
        if(k==0){
            System.out.print(root.data + " ");
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            Depth(root.children.get(i),k-1);
        }
    
}

public static int countLeafNodes(TreeNode<Integer> root){
    if(root == null) return 0;
    int count =0;
    if(root.children.size()==0){
        count = 1;
    }
    for(int i = 0; i < root.children.size(); i++){
       count += countLeafNodes(root.children.get(i));
    }
 // Write your code here
     return count;
}
    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        // TreeNode<Integer> root = takeInput(s);
        TreeNode<Integer> root = takeInputLevel();
        // print(root);
        printLevel(root);
        System.out.println("Nodes which are greter than 8 :: " + numNodeGreater(root, 8));
        System.out.println("Nodes are :: " + heightofTree(root));
        Depth(root,2);
    }
}

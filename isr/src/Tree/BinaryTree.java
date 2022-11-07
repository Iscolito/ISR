package Tree;

public class BinaryTree {
    public int val;
    public BinaryTree left;
    public BinaryTree right;
    public BinaryTree next;
    public int label;
    public BinaryTree(int val,BinaryTree  left, BinaryTree right){
        this.val=val;
        this.left=left;
        this.right=right;
        this.label=-1;
    }
    public BinaryTree(int val, int label){
        this.val=val;
        this.label=label;
    }
    public BinaryTree(BinaryTree now,BinaryTree next){
        this.val=now.val;
        this.left=now.left;
        this.right=now.right;
        this.next=next;
        this.label=now.label;
    }
    public boolean isnode() {
    	return this.left==null&&this.right==null;
    }
}
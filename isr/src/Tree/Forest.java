package Tree;

public class Forest {
    public BinaryTree dummyhead;
    public Forest(){
        dummyhead=new BinaryTree(0,-1);
    } 
    public void add(BinaryTree tree){
        BinaryTree ptr=dummyhead;
        while(ptr.next!=null&&tree.val>ptr.next.val){
            ptr=ptr.next;
        }
        ptr.next=new BinaryTree(tree, ptr.next);
    }
    public void pop() {
    	dummyhead.next=dummyhead.next.next;
    }
    public BinaryTree top() {
    	return dummyhead.next;
    }
    public BinaryTree second() {
    	return dummyhead.next.next;
    }
    public boolean isonly() {
    	return dummyhead.next.next==null;
    }
}

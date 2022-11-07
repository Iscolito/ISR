package Coding;
import In.Readin;
import Out.Sendout;

import java.io.IOException;
import java.util.ArrayList;
import Tree.*;
import java.util.HashMap;
import java.util.Stack;

public class Encoding {
    Readin file;
    Sendout isr;
    HashMap<Integer,Integer[]> CodeMap;
    HashMap<Integer,String> res;
    ArrayList<Integer> index;
    Forest forest;
    private Stack<Integer> temp;
	String filepath;
	String target;
    public Encoding(String filepath, String target) throws IOException{
		this.filepath=filepath;
		this.target=target;
        file=new Readin();
        isr=new Sendout(target);
        CodeMap=new HashMap<>();
        res=new HashMap<>();
        index=new ArrayList<>();
        temp=new Stack<>();
        try{
            file.readtxt(filepath);
        }catch(Exception e){
            System.out.println("wrong input");
        }
        count();
        forest=new Forest();
        makeforest();
        HuffmanTree();
        test();
        nodesmap(forest.dummyhead.next);
        output();
    }
    void count(){
        int code=-1;
        for(int i=0;i<file.codings.size();i++){
            code=file.codings.get(i);
            if(CodeMap.containsKey(code)){
                CodeMap.get(code)[0]++;
            }
            else{
                index.add(code);
                CodeMap.put(code,new Integer[]{1});
            }
        }
    }
    void makeforest(){
        for(int i=0;i<index.size();i++){
            int code=index.get(i);
            forest.add(new BinaryTree(CodeMap.get(code)[0],code));
        }
    }
    void test() {
    	BinaryTree a =forest.dummyhead;
    	while(a!=null) {
    		System.out.println(a.val);
    		a=a.next;
    	}
    }
    void HuffmanTree() {
    	while(!forest.isonly()) {
    		forest.add(new BinaryTree(forest.top().val+forest.second().val,forest.top(),forest.second()));
    		forest.pop();forest.pop();
    	}
    }
    public void nodesmap(BinaryTree node) {
    	if(node.left==null&&node.right==null) {
    		res.put(node.label,temp.toString());
    		return;
    	}
    	temp.add(0);
    	nodesmap(node.left);
    	temp.pop();
    	temp.add(1);
    	nodesmap(node.right); 
    	temp.pop();
    }
    public void output() throws IOException {
    	for(int i=0;i<index.size();i++) {
            System.out.println(index.get(i));
    		isr.writeout(index.get(i).toString());
    		isr.writeout(res.get(index.get(i)));
    	}isr.writeout("\n");
    	for(int i=0;i<file.codings.size();i++) {
            System.out.println(file.codings.get(i));
            String out=res.get(file.codings.get(i));
            StringBuffer cutter=new StringBuffer();
            for(int j=0;j<out.length();j++) {
            	if(out.charAt(j)=='0'||out.charAt(j)=='1') {
            		cutter.append(out.charAt(j));
            	}
            }
            out=cutter.toString();
    		isr.writeout(out);
    	}
		isr.cancel();
    }

    public static void main(String[] args) throws IOException{
        Encoding a=new Encoding("test.txt","compress.isr");
        System.out.println(a.file.codings);
        System.out.println(a.index);
        System.out.println(a.res.get(108));
    }
}

package Coding;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import In.Readin;
import Tree.BinaryTree;
public class Decoding {
	Readin isr;
	ArrayList<String> mappings;
	ArrayList<Integer> codes;
	HashMap<String,String> treemap;
	String routes;
	BinaryTree root;
	String filepath;
	String target;
	public Decoding(String filepath,String target) throws IOException{
		this.filepath=filepath;
		this.target=target;
		isr=new Readin();
		isr.readisr(filepath);
		treemap=isr.treemap;
		routes=isr.routes;
		codes=new ArrayList<>();
		mappings=isr.mappings;
		treebuilding();
		decoding();
		solveout();
	}
	public void treebuilding(){
		root=new BinaryTree(0,-1);
		for(int i=0;i<mappings.size();i++) {
			BinaryTree ptr=root;
			String route=treemap.get(mappings.get(i));
			for(int j=0;j<route.length();j++) {
				if(route.charAt(j)=='0') {
					if(ptr.left==null) {
						ptr.left=new BinaryTree(0,-1);
					}ptr=ptr.left;
				}
				else {
					if(ptr.right==null) {
						ptr.right=new BinaryTree(0,-1);
					}ptr=ptr.right;
				}
			}
			ptr.label=Integer.valueOf(mappings.get(i));
		}
	}
	public void decoding() {
		int i=0;
		while(i<routes.length()) {
			BinaryTree ptr=root;
			while(!ptr.isnode())
			if(routes.charAt(i)=='0') {
				ptr=ptr.left;i++;
			}
			else {
				ptr=ptr.right;i++;
			}
			codes.add(ptr.label);
		}
	}
	public void solveout() throws IOException {
        FileOutputStream file = new FileOutputStream(target);
		for(int i=0;i<codes.size();i++) {
			file.write(codes.get(i));
		}
		file.close();
	}
	public static void main(String[] args) throws IOException {
		Decoding decoder=new Decoding("compress.isr","out.txt");
		System.out.println(decoder.mappings);
		System.out.println(decoder.routes);
		System.out.println(decoder.codes);
	}
}

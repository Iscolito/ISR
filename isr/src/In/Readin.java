package In;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Readin {
    int line;
    public ArrayList<Integer> codings;
	String filepath;
	public HashMap<String,String> treemap;
    public ArrayList<String> mappings;
    public String routes;
	
    public Readin(){
        line=0;
        codings=new ArrayList<>();
        treemap=new HashMap<>();
        mappings=new ArrayList<>();
    }
    public void readtxt(String filepath) throws IOException{
    	int data=0;
        FileInputStream file = new FileInputStream(filepath);
        while((data=file.read())!=-1){
            codings.add(data);
            line++;
        }
        file.close();
    }
    public void readisr(String filepath) throws IOException {
        File file = new File(filepath);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line=br.readLine();
        int i=0;
        while(i<line.length()) {
        	char ch=line.charAt(i);
        	StringBuffer tempcode=new StringBuffer();
        	StringBuffer temproute=new StringBuffer();
        	while(ch!='[') {
        		tempcode.append(ch);
        		i++;ch=line.charAt(i);
        	}
        	while(ch!=']') {
        		if(ch=='1'||ch=='0') {
        			temproute.append(ch);
        		}i++;ch=line.charAt(i);
        	}i++;mappings.add(tempcode.toString());
        	treemap.put(tempcode.toString(), temproute.toString());
        }
        routes=br.readLine();
        br.close();
    }
    public static void main(String[] args) {
        Readin a =new Readin();
        try{
            a.readtxt("./test.txt");
            System.out.println(a.codings);
        }catch(Exception e){
            System.out.println("wrong input");
        }
    }
}

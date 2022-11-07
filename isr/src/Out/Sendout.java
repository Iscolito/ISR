package Out;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class Sendout {
	File file;
	String filepath;
	FileOutputStream fos1;
	OutputStreamWriter dos1;
	public Sendout(String filepath) throws IOException{
		this.filepath=filepath;
		file=new File(filepath);
		if(!file.exists()) {
			file.createNewFile();
		}
		fos1=new FileOutputStream(file);
		dos1=new OutputStreamWriter(fos1);
	}
	public void writeout(String text) throws IOException{
		dos1.write(text);
	}
	public void cancel() throws IOException {
		dos1.close();
	}
}


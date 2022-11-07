package MainPage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import Coding.Encoding;
import Coding.Decoding;


public class MainPage {
	ComponentsSet components;
	public MainPage(){
		JFrame f=new JFrame("加密文件");
		f.setBounds(650, 270, 500, 300);
		f.setBackground(null);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		components=new ComponentsSet();
		components.set(f);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new MainPage();
	}
}

class ComponentsSet{

	//前端组件
    JTextField text1,text2,text3,text4;
    JButton button_reset,button_refresh,button_save,button_search,button_plan;
    JPanel container3,container_text,container4,container_read;
    JRadioButton checkBox1, checkBox2;
    ButtonGroup group;
    String[] readme;
    
    //后端输入
	int row,col;
	int[] pos;
    
    public ComponentsSet(){
    	readme=new String[5];
    	readme[0]=new String("ISR加密系统为任何类型文件提供加密和解码");
    	readme[1]=new String("请将待压缩文件和待解压文件置于和本文件同一目录下");
    	readme[2]=new String("在复选框中选择加密/解码操作，加密文件将被命名为compress.isr");
    	readme[3]=new String("输入文件全名（包括扩展名）即可");
    }
    void set(JFrame frame) {
    	//定义组件行
    	container_text=new JPanel(new FlowLayout(FlowLayout.LEFT, 6,6));
    	container3=new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 6)); 
    	container4=new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 6)); 
    	container_read=new JPanel(new FlowLayout(FlowLayout.LEFT, 6,6));
    	
    	text1=new JTextField(new String("test.txt"),11);
    	container_text.add(new JLabel("待加密文件名:"));
    	container_text.add(text1);
    	
    	text2=new JTextField(new String("compress.isr"),11);
    	container_text.add(new JLabel("待解码文件名:"));
    	container_text.add(text2);
    	



        button_save = new JButton("开始");
        button_save.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		int mode=checkBox1.isSelected()?0:1;
        		if(mode==0) {
        			try {
						new Encoding(text1.getText(),text3.getText());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null,"没有这个文件，请检查扩展名是否存在","警告",JOptionPane.WARNING_MESSAGE);
						e1.printStackTrace();
					}
        		}
        		if(mode==1) {
        			try {
						new Decoding(text2.getText(),text4.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
        		}
        	}
        });

    	text3=new JTextField(new String("compress.isr"),11);
    	container3.add(new JLabel("加密后文件名:"));
    	container3.add(text3);
    	
    	text4=new JTextField(new String("out.txt"),11);
    	container3.add(new JLabel("解码后文件名:"));
    	container3.add(text4);
        
        container4.add(new JLabel("选择加密/解码:"));
        checkBox1=new JRadioButton(new String("加密"),true);
        checkBox2=new JRadioButton(new String("解码"),false);
        group=new ButtonGroup();
        group.add(checkBox1);
        group.add(checkBox2);
        container4.add(checkBox1);
        container4.add(checkBox2);
        container4.add(new JLabel("按钮:"));
        container4.add(button_save);
        

        container_read.add(new JLabel(readme[0]));
        container_read.add(new JLabel(readme[1]));
        container_read.add(new JLabel(readme[2]));
        container_read.add(new JLabel(readme[3]));
        
        //Layout采取绝对布局
        container3.setBounds(0,30,500,30);
        container_text.setBounds(0,0,500,30);
        container4.setBounds(10,80,300,50);
        container_read.setBounds(10,130,400,100);
        frame.add(container_text);
        frame.add(container3);
        frame.add(container4);
        frame.add(container_read);
    }
}

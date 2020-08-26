import java.awt.event.*;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class Editor{
    public JLabel l1;
    public JTextField t1,t2;
    public JButton b1,b2;
    public JFrame j1;
public static void main(String[] args){
    Editor e= new Editor();
    e.setcomponent();
}
public void setcomponent(){
    j1= new JFrame("Simple notepad");
    j1.setVisible(true);
    j1.setSize(700,600);
    j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
t1= new JTextField("Enter file name or path");
l1= new JLabel();
t2= new JTextField("Your file text will be shown here ");
b1= new JButton("Open File");
b2= new JButton("Save Changes");
j1.add(l1);
j1.add(t1);
j1.add(t2);
j1.add(b1);
j1.add(b2);
t1.setBounds(10,20,350,20);
b1.setBounds(390,20,100,20);
t2.setBounds(10,50, 580, 600);
b2.setBounds(500,20, 150, 20);
FileOpener fo= new Editor.FileOpener();
FileSaver fs= new Editor.FileSaver();
b1.addActionListener(fo);
b2.addActionListener(fs);

}

class FileOpener implements ActionListener {
public void actionPerformed(ActionEvent e){
String s= t1.getText();
try{
FileInputStream fin= new FileInputStream(s);
String j="";
int i;
do{
i=fin.read();
if(i!=-1){
    j= j+ ((char)i);
}
}while(i!=-1);
t2.setText(j);
fin.close();
}catch(Exception ex){
    System.out.println("error occured");
}
}
}
class FileSaver implements ActionListener{
public void actionPerformed(ActionEvent e){
String s=t1.getText();
String s2=t2.getText();
try{
FileOutputStream fout=new FileOutputStream(s);
char ch[]= s2.toCharArray();
for(int i=0;i<s2.length();i++)
fout.write(ch[i]);
fout.close();

}catch(Exception ex){

}
}
}
}

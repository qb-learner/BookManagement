package bookManagement;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;

import java.sql.*;

public class register {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(641, 593);
		shell.setMaximumSize(641, 593);
		shell.setMinimumSize(641, 593);
		shell.setText("注册");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(85, 55, 76, 20);
		label.setText("账号：");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(85, 104, 76, 20);
		label_1.setText("密码：");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(85, 150, 76, 20);
		label_2.setText("确认密码：");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(85, 193, 76, 20);
		label_3.setText("昵称：");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(85, 236, 76, 20);
		lblNewLabel.setText("性别：");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(85, 282, 76, 20);
		lblNewLabel_1.setText("电话：");
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(85, 328, 76, 20);
		label_4.setText("年龄：");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(167, 52, 166, 26);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(167, 147, 166, 26);
		
		text_2 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_2.setBounds(167, 101, 166, 26);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(167, 190, 166, 26);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(167, 233, 166, 26);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(167, 279, 166, 26);
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBounds(167, 325, 166, 26);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		label_5.setBounds(358, 150, 120, 20);
		label_5.setText("*再确认一次密码");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		lblNewLabel_2.setBounds(358, 193, 232, 20);
		lblNewLabel_2.setText("*请输入您的昵称，2-10个字符");
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		label_6.setBounds(358, 236, 133, 20);
		label_6.setText("*只可输入'男'或'女'");
		
		Label label_7 = new Label(shell, SWT.NONE);
		label_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		label_7.setBounds(358, 328, 203, 20);
		label_7.setText("*只可输入0—200之间的整数");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(144, 430, 316, 79);
		btnNewButton.setText("注册");
		btnNewButton.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				boolean c = true;
				if(text.getText().length()<6||text.getText().length()>20) {
					MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_INFORMATION);
					dialog.setText("提示");
					dialog.setMessage("账号长度不符，请按照提示输入");
					dialog.open();
					text.setText("");
					c = false;
				}
				if(text_2.getText().length()<6||text_2.getText().length()>20) {
					MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_INFORMATION);
					dialog.setText("提示");
					dialog.setMessage("密码长度不符，请按照提示输入");
					dialog.open();
					text_2.setText("");
					text_1.setText("");
					c = false;
				}
				for(int i = 0; i < text.getText().length(); i++) {
					if(!check(text.getText().charAt(i))) {
						MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_INFORMATION);
						dialog.setText("提示");
						dialog.setMessage("账号含有非法字符，请按照提示输入");
						dialog.open();
						text.setText("");
						c = false;
						break;
					}
				}
				for(int i = 0; i < text_2.getText().length(); i++) {
					if(!check(text_2.getText().charAt(i))) {
						MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_INFORMATION);
						dialog.setText("提示");
						dialog.setMessage("密码含有非法字符，请按照提示输入");
						dialog.open();
						text_2.setText("");
						text_1.setText("");
						c = false;
						break;
					}
				}
				if(!text_1.getText().equals(text_2.getText())&&text_2.getText().length()!=0) {
					MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_INFORMATION);
					dialog.setText("提示");
					dialog.setMessage("密码与确认密码不同，请重新输入");
					dialog.open();
					text_2.setText("");
					text_1.setText("");
					c = false;
				}
				if(text_3.getText().length()<2||text_3.getText().length()>10||text_3.getText().contains(" ")) {
					MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_INFORMATION);
					dialog.setText("提示");
					dialog.setMessage("昵称格式不对，请按照提示输入");
					dialog.open();
					text_3.setText("");
					c = false;
				}
				if(!text_4.getText().equals("男")&&!text_4.getText().equals("女")) {
					MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_INFORMATION);
					dialog.setText("提示");
					dialog.setMessage("性别错误，请按照提示输入");
					dialog.open();
					text_4.setText("");
					c = false;
				}
				for(int i = 0; i < text_5.getText().length(); i++) {
					if(text_5.getText().charAt(i)>='0'&&text_5.getText().charAt(i)<='9'&&text_5.getText().length()<7||
					text_5.getText().length()>11||text_5.getText().charAt(0)=='0'||text_5.getText().contains(" ")) {
						MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_INFORMATION);
						dialog.setText("提示");
						dialog.setMessage("请输入正确的电话号码");
						dialog.open();
						text_5.setText("");
						c = false;
						break;
					}
				}
				if(!text_6.getText().matches("[0-9]+")||Integer.parseInt(text_6.getText())>200||
						Integer.parseInt(text_6.getText())<0||text_6.getText().charAt(0)=='0') {
					MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_INFORMATION);
					dialog.setText("提示");
					dialog.setMessage("请输入正确的年龄");
					dialog.open();
					text_6.setText("");
					c = false;
				}
				if(c) {
					Statement sm = null;
					try {
						sm = new connect().cnt().createStatement();
					} catch (ClassNotFoundException e2) {
						// TODO 自动生成的 catch 块
						e2.printStackTrace();
					} catch (SQLException e2) {
						// TODO 自动生成的 catch 块
						e2.printStackTrace();
					}
					try {
						sm.executeUpdate("insert into adminis values('"+text.getText()+"','"+text_4.getText()+
						"','"+text_3.getText()+"','"+text_5.getText()+"',"+Integer.parseInt(text_6.getText())+",'"+text_2.getText()+"')");
						MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_WORKING);
						dialog.setText("提示");
						dialog.setMessage("账号注册成功");
						dialog.open();
						shell.close();
						login window = new login();
						window.open();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			}
			private boolean check(char c) {
				return c>='a'&&c<='z'||c>='1'&&c<='9';
			}
		});
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(10, 506, 98, 30);
		button.setText("返回登录");
		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				shell.close();
				login window = new login();
				window.open();
			}
		});
		
		Label label_8 = new Label(shell, SWT.NONE);
		label_8.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		label_8.setBounds(358, 52, 203, 20);
		label_8.setText("*请输入6-20位字符或数字");
		
		Label label_8_1 = new Label(shell, SWT.NONE);
		label_8_1.setText("*请输入6-20位字符或数字");
		label_8_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		label_8_1.setBounds(358, 104, 203, 20);
		
		Label label_9 = new Label(shell, SWT.NONE);
		label_9.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		label_9.setBounds(358, 282, 203, 20);
		label_9.setText("*请输入正确电话号码");
		
		Label label_10 = new Label(shell, SWT.NONE);
		label_10.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		label_10.setBounds(85, 369, 219, 20);
		label_10.setText("*所有输入中不能含有空格");
	}
}

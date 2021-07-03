package bookManagement;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class login {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			login window = new login();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
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
	
	public String find(String zh, String mm) throws ClassNotFoundException, SQLException {
		Statement sm = new connect().cnt().createStatement();
		ResultSet rs;
		rs = sm.executeQuery("SELECT* FROM adminis");//SQL查询语句
		while (rs.next()) {
			String n1 = rs.getString(1);
			String n3 = rs.getString(3);
			String n6 = rs.getString(6);
			if(n1.trim().equals(zh)&&n6.trim().equals(mm)) return n3.trim();
		}
		return "";
	}
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(532, 407);
		shell.setText("书店图书销售管理系统");
		shell.setMaximumSize(532, 407);
		shell.setMinimumSize(532, 407);
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(87, 78, 35, 20);
		label.setText("账号：");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(87, 144, 35, 20);
		label_1.setText("密码：");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(144, 75, 258, 26);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(144, 141, 258, 26);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		btnNewButton.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.PUSH));
		btnNewButton.setToolTipText("");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(87, 211, 316, 54);
		btnNewButton.setText("登录");
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
				if(text_1.getText().length()<6||text_1.getText().length()>20) {
					MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_INFORMATION);
					dialog.setText("提示");
					dialog.setMessage("密码长度不符，请按照提示输入");
					dialog.open();
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
				for(int i = 0; i < text_1.getText().length(); i++) {
					if(!check(text_1.getText().charAt(i))) {
						MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_INFORMATION);
						dialog.setText("提示");
						dialog.setMessage("密码含有非法字符，请按照提示输入");
						dialog.open();
						text_1.setText("");
						c = false;
						break;
					}
				}
				if(c) {
					String a = "";
					try {
						a = find(text.getText().trim(), text_1.getText().trim());
					} catch (ClassNotFoundException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					if(a.length()!=0) {
						MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_WORKING);
						dialog.setText("欢迎进入系统");
						dialog.setMessage("登录成功! 您好,"+a);
						dialog.open();
						shell.close();
						mainInterface window = new mainInterface(a);
						window.open();
					}else {
						MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_WORKING);
						dialog.setText("提示");
						dialog.setMessage("登录失败，账号或密码错误");
						dialog.open();
					}
				}
			}

			private boolean check(char c) {
				return c>='a'&&c<='z'||c>='1'&&c<='9';
			}
		});
		
		Button btnNewButton_1 = new Button(shell, SWT.CENTER);
		btnNewButton_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNewButton_1.setFont(SWTResourceManager.getFont("微软雅黑", 9, SWT.PUSH));
		btnNewButton_1.setBounds(24, 309, 98, 30);
		btnNewButton_1.setText("注册账号");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		label_2.setBounds(86, 104, 305, 20);
		label_2.setText("*请输入6-20位字符或数字");
		
		Label label_2_1 = new Label(shell, SWT.NONE);
		label_2_1.setText("*请输入6-20位字符或数字");
		label_2_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		label_2_1.setBounds(86, 170, 305, 20);
		btnNewButton_1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				shell.close();
				register window = new register();
				window.open();
			}
		});

	}
}

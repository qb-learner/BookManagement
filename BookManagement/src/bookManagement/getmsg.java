package bookManagement;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class getmsg {

	protected Shell shell;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			getmsg window = new getmsg();
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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(415, 436);
		shell.setText("加入图书信息");
		shell.setMaximumSize(415, 436);
		shell.setMinimumSize(415, 436);
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(32, 80, 76, 20);
		label.setText("书名");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(32, 130, 76, 20);
		label_1.setText("作者");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(32, 180, 76, 20);
		label_2.setText("出版社");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(32, 230, 76, 20);
		label_3.setText("图书类型");
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(32, 280, 76, 20);
		label_4.setText("图书现价");
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(137, 334, 98, 30);
		button.setText("确定");
		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
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
					ResultSet rs;
					rs = sm.executeQuery("SELECT* FROM book");//SQL查询语句
					String n1 = null;
					while (rs.next()) {
						n1 = rs.getString(1);
					}
					String b = n1.trim().substring(1);
					int a = Integer.parseInt(b)+1;
					String c = "B";
					for(int i = 0; i < 9-Integer.toString(a).length(); i++) {
						c+="0";
					}
					c+=Integer.toString(a);
					sm.executeUpdate("insert into book values('"+c+"','"+text_1.getText()+
					"','"+text_2.getText()+"','"+text_3.getText()+"','"+text_4.getText()+"',"+"0"+","+text_5.getText().trim()+")");
					MessageBox dialog=new MessageBox(shell,SWT.OK|SWT.ICON_WORKING);
					dialog.setText("提示");
					dialog.setMessage("图书信息加入成功");
					dialog.open();
					shell.close();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(137, 80, 179, 26);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(137, 130, 179, 26);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(137, 180, 179, 26);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(137, 227, 179, 26);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(137, 274, 179, 26);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		label_5.setBounds(58, 26, 299, 20);
		label_5.setText("*新增图书必须为新书，且输入需按要求输入*");

	}
}

package com.felight.javamail;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class EmailUI { 
	
	private static void ShowProgressbar(){
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Wait");
		shell.setSize(400, 150);
	    ProgressBar pb3 = new ProgressBar(shell, SWT.SMOOTH);
	    pb3.setBounds(100, 70, 200, 20);
	    
	    Label label = new Label(shell, SWT.NULL);
	    label.setText("Sending");	    
	    label.setAlignment(SWT.RIGHT);
	    label.setBounds(10, 10, 80, 20);
	    shell.open();
	    pb3.setMaximum(100);
	    pb3.setSelection(0);
	    for(int i=0;i<100;i++){
	     	pb3.setSelection(i);
	     	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	    
	    //textUser.forceFocus();

	    // Set up the event loop.
	    /*while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        // If no more entries in event queue
	        display.sleep();
	      }
	    }*/

	    display.dispose();

	}
	
	public static void main(String[] Sachin) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Send Mail");
	    GridLayout gridLayout = new GridLayout(4, true);
	    gridLayout.verticalSpacing = 8;
	    shell.setLayout(gridLayout);
	    shell.setSize(600, 600);
	    // Username label and textbox
	    Label UnameLabel = new Label(shell, SWT.NULL);
	    UnameLabel.setText("Username: ");

	    Text UnameText = new Text(shell, SWT.SINGLE | SWT.BORDER);
	    GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
	    gridData.horizontalSpan = 3;
	    UnameText.setLayoutData(gridData);

	    //Password label and text box
	    Label passLabel = new Label(shell, SWT.NULL);
	    passLabel.setText("Password: ");

	    Text passText = new Text(shell, SWT.PASSWORD | SWT.BORDER);
	    gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
	    gridData.horizontalSpan = 3;
	    passText.setLayoutData(gridData);

	    // Mail to label and text box
	    Label ToLabel = new Label(shell, SWT.NULL);
	    ToLabel.setText("To: ");
	    
	    Text toText=new Text(shell,SWT.SINGLE|SWT.BORDER);
	    gridData=new GridData(gridData.HORIZONTAL_ALIGN_FILL);
	    gridData.horizontalSpan=3;
	    toText.setLayoutData(gridData);
	    
	    //Mail Subject Label and textbox
	    Label SubjectLabel = new Label(shell, SWT.NULL);
	    SubjectLabel.setText("Subject: ");
	    
	    Text SubjectText=new Text(shell,SWT.SINGLE|SWT.BORDER);
	    gridData=new GridData(gridData.HORIZONTAL_ALIGN_FILL);
	    gridData.horizontalSpan=3;
	    SubjectText.setLayoutData(gridData);
	    
	    //Mail body textbox and label
	    Label bodyLabel = new Label(shell, SWT.NULL);
	    bodyLabel.setText("Body: ");
	    
	    Text bodyText=new Text(shell,SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
	    gridData=new GridData(gridData.FILL_BOTH);
	    gridData.horizontalSpan=3;
	    bodyText.setLayoutData(gridData);
	    
	    // Send Button
	    
	    Button sendButton = new Button(shell, SWT.PUSH);
	    sendButton.setText("Send");
	    gridData=new GridData(gridData.HORIZONTAL_ALIGN_FILL);
	    gridData.horizontalSpan=3;
	    sendButton.setLayoutData(gridData);
	    sendButton.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				SendMail mail=new SendMail(UnameText.getText(), passText.getText(), toText.getText(), bodyText.getText(), SubjectText.getText());
				Thread t1=new Thread(){
					public void run() {
							ShowProgressbar();
					}
				};
				t1.start();
				mail.send();
				UnameText.setText("");
				passText.setText("");
				toText.setText("");
				SubjectText.setText("");
				bodyText.setText("");
				MessageBox messageBox = new MessageBox(shell, SWT.OK);
				messageBox.setText("Mail Sent");
				messageBox.setMessage("Mail Sent Syccessfully");
				MessageBox exitbox = new MessageBox(shell, SWT.YES|SWT.NO);
				exitbox.setText("Exit!");
				exitbox.setMessage("Do u want to Exit?.");
				int buttonID = exitbox.open();
				switch(buttonID) {
		          case SWT.YES:
		        	  System.exit(0);
		          case SWT.NO:
		        	  
		            break;
				}
			}
		});
	    
	    // Reset Button
	    
	    
	    Button resetButton = new Button(shell, SWT.PUSH);
	    resetButton.setText("Reset");
	    gridData=new GridData(gridData.HORIZONTAL_ALIGN_FILL);
	    gridData.horizontalSpan=3;
	    resetButton.setLayoutData(gridData);
	    resetButton.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				UnameText.setText("");
				passText.setText("");
				toText.setText("");
				SubjectText.setText("");
				bodyText.setText("");
				
			}
		});
	    
	    
	    
	    shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}

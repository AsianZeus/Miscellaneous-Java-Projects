import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLEditorKit;

import java.awt.print.PrinterException;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// Author @Akshat a.k.a Jerry

public class AdvNotepad {

	
	JFrame f1;
	JPanel OverPanel1;
	JTextField t1;
	JTextArea textArea;
	JDialog dlg;
	JScrollPane scrollPane;
	TextLineNumber tln;
	Point pnt;
	JTextPane textPane; 
	JScrollPane scrollPan;
	JFileChooser filech;
	File fileo;
	JMenuItem mf1;
	JMenuItem mf2;
	JMenuItem mf3;
	JMenuItem mf4;
	JMenuItem me1;
	JMenuItem me2;
	JMenuItem me3;
	
	String temp = null;
	
	public AdvNotepad() {
		initialize();
	}
	
	void initialize() {
		f1 = new JFrame("Advance Notepad");
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f1.getContentPane().setBackground(new Color(12, 20, 31));
		f1.setExtendedState( f1.getExtendedState()|JFrame.MAXIMIZED_BOTH );	
		f1.setMinimumSize(new Dimension(900, 750));
		f1.setLocationRelativeTo(null);
		
		

		JToolBar jtb = new JToolBar();
		jtb.setBackground(new Color(12, 20, 31));
		jtb.setLayout(new FlowLayout(FlowLayout.LEFT,10,15));
		jtb.setMargin(new Insets(0, 50, 5, 30));
		jtb.setFloatable(false);
		f1.getContentPane().add(jtb,BorderLayout.BEFORE_FIRST_LINE);
		
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		JComboBox<String> fnts= new JComboBox<String>(fonts);
		fnts.setBackground(Color.WHITE);
		fnts.setFocusable(false);
		fnts.setSelectedIndex(100);
		fnts.setFont(new Font("Doppio One", Font.PLAIN , 15));
		fnts.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String x = (String)fnts.getSelectedItem();
				int i = textPane.getFont().getSize();
				int j =textPane.getFont().getStyle();
				textPane.setFont(new Font(x, j, i));
			}
		});
		jtb.add(fnts);
		
		String[] size= {"8","9","10","11","12","14","16","18","20","22","24","26","28","36","48","60","72"};
		JComboBox<String> fsize= new JComboBox<String>(size);
		fsize.setFocusable(false);
		fsize.setFont(new Font("Doppio One", Font.PLAIN , 15));
		fsize.setBackground(Color.WHITE);
		fsize.setSelectedIndex(8);
		fsize.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String x = (String)fsize.getSelectedItem();
				String s = textPane.getFont().getFontName();
				int j =textPane.getFont().getStyle();
				textPane.setFont(new Font(s, j, Integer.parseInt(x)));
			}
		});
		jtb.add(fsize);
		
		JToggleButton bold = new JToggleButton("B");
		bold.setPreferredSize(new Dimension(40, 29));
		bold.setFocusable(false);
		bold.setBackground(Color.WHITE);
		bold.setFont(new Font("Doppio One", Font.BOLD , 20));
		bold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StyledDocument doc = (StyledDocument) textPane.getDocument();
			    int selectionEnd = textPane.getSelectionEnd();
			    int selectionStart = textPane.getSelectionStart();
			    Element element = doc.getCharacterElement(selectionStart);
			    AttributeSet as = element.getAttributes();
			    MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
				
			    if (selectionStart == selectionEnd) {
			    	return;
			    }
			    else
			    	if(bold.isSelected())
				{
					StyleConstants.setBold(asNew, true);
				    doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);
				}
				else
				{
					StyleConstants.setBold(asNew, false);
				    doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);	
				}
				
			}
		});
		jtb.add(bold);
		
		JToggleButton italics = new JToggleButton("I");
		italics.setPreferredSize(new Dimension(40, 29));
		italics.setFocusable(false);
		italics.setBackground(Color.WHITE);
		italics.setFont(new Font("Doppio One", Font.ITALIC , 20));
		italics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StyledDocument doc = (StyledDocument) textPane.getDocument();
			    int selectionEnd = textPane.getSelectionEnd();
			    int selectionStart = textPane.getSelectionStart();
			    if (selectionStart == selectionEnd) {
			      return;
			    }
			    Element element = doc.getCharacterElement(selectionStart);
			    AttributeSet as = element.getAttributes();
			    MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
				if(italics.isSelected())
				{
					StyleConstants.setItalic(asNew, true);
				    doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);	
				}
				else
				{
					StyleConstants.setItalic(asNew, false);
				    doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);
				}
				
			}
		});
		jtb.add(italics);
		
		JToggleButton underline = new JToggleButton("<html><u>U</u></html>");
		underline.setPreferredSize(new Dimension(40, 29));
		underline.setBackground(Color.WHITE);
		underline.setFocusable(false);
		underline.setFont(new Font("Doppio One", Font.PLAIN , 20));
		underline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StyledDocument doc = (StyledDocument) textPane.getDocument();
			    int selectionEnd = textPane.getSelectionEnd();
			    int selectionStart = textPane.getSelectionStart();
			    if (selectionStart == selectionEnd) {
			      return;
			    }
			    Element element = doc.getCharacterElement(selectionStart);
			    AttributeSet as = element.getAttributes();
			    MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
				if(underline.isSelected())
				{
					StyleConstants.setUnderline(asNew, true);
				    doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);
				    
				}
				else
				{
					StyleConstants.setUnderline(asNew, false);
				    doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);						
				}
				
			}
		});
		jtb.add(underline);
		
		JToggleButton subscript = new JToggleButton("<html>X<sub><font size=4>2</font></sub></html>");
		subscript.setPreferredSize(new Dimension(40, 29));
		subscript.setBackground(Color.WHITE);
		subscript.setFocusable(false);
		subscript.setFont(new Font("Doppio One", Font.PLAIN , 20));
		subscript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StyledDocument doc = (StyledDocument) textPane.getDocument();
			    int selectionEnd = textPane.getSelectionEnd();
			    int selectionStart = textPane.getSelectionStart();
			    if (selectionStart == selectionEnd) {
			      return;
			    }
			    Element element = doc.getCharacterElement(selectionStart);
			    AttributeSet as = element.getAttributes();
			    MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
				if(subscript.isSelected())
				{
					StyleConstants.setSubscript(asNew, true);
				    doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);
				}
				else
				{
					StyleConstants.setSubscript(asNew, false);
				    doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);					
				}
				
			}
		});
		jtb.add(subscript);
		
		JToggleButton superscript = new JToggleButton("<html>X<sup><font size=4>2</font></sup></html>");
		superscript.setPreferredSize(new Dimension(40, 29));
		superscript.setBackground(Color.WHITE);
		superscript.setFocusable(false);
		superscript.setFont(new Font("Doppio One", Font.PLAIN , 20));
		superscript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StyledDocument doc = (StyledDocument) textPane.getDocument();
			    int selectionEnd = textPane.getSelectionEnd();
			    int selectionStart = textPane.getSelectionStart();
			    if (selectionStart == selectionEnd) {
			      return;
			    }
			    Element element = doc.getCharacterElement(selectionStart);
			    AttributeSet as = element.getAttributes();
			    MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
				if(superscript.isSelected())
				{
					StyleConstants.setSuperscript(asNew, true);
				    doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);
				}
				else
				{
					StyleConstants.setSuperscript(asNew, false);
				    doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);
				}
				
			}
		});
		jtb.add(superscript);
		
		
		JToggleButton strikethrough = new JToggleButton("<html><s>abc</s></html>");
		strikethrough.setPreferredSize(new Dimension(40, 29));
		strikethrough.setBackground(Color.WHITE);
		strikethrough.setFocusable(false);
		strikethrough.setFont(new Font("Doppio One", Font.PLAIN , 20));
		strikethrough.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StyledDocument doc = (StyledDocument) textPane.getDocument();
			    int selectionEnd = textPane.getSelectionEnd();
			    int selectionStart = textPane.getSelectionStart();
			    if (selectionStart == selectionEnd) {
			      return;
			    }
			    Element element = doc.getCharacterElement(selectionStart);
			    AttributeSet as = element.getAttributes();
			    MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
				if(strikethrough.isSelected()){

			    StyleConstants.setStrikeThrough(asNew, true);
			    doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);
			    }
				else {
				    StyleConstants.setStrikeThrough(asNew, false);
				    doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);
				}
			}
		});
		jtb.add(strikethrough);
		
		
		JButton fcolor = new JButton(new ImageIcon("tag.png"));
		fcolor.setFocusable(false);
		fcolor.setPreferredSize(new Dimension(40, 29));
		fcolor.setBackground(Color.WHITE);
		fcolor.setFont(new Font("Doppio One", Font.BOLD , 20));
		fcolor.setRolloverIcon(new ImageIcon("tagx.png"));
		fcolor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser cc = new JColorChooser();
				Color c= cc.showDialog(f1, "Foreground Color", Color.WHITE);
				textPane.setForeground(c);
			}
		});
		jtb.add(fcolor);
		
		
		Font defont = new Font("Lucid Console", Font.PLAIN, 16);
		textPane = new JTextPane();
		textPane.setMargin(new Insets(10,10,10,10));
		textPane.setBackground(new Color(17, 30, 47));
		textPane.setForeground(Color.WHITE);
		textPane.setCaretColor(Color.WHITE);
		textPane.setFont(new Font("Lucid Console",Font.PLAIN,20));
		textPane.requestFocus();
		textPane.grabFocus();
		textPane.addKeyListener(new KeyAdapter(){
			
			public void keyTyped(KeyEvent e)
			{	
				if (e.isAltDown() && e.getKeyChar()=='n') {
	                mf1.doClick();
	            }
				if (e.isAltDown() && e.getKeyChar()=='o') {
	                mf2.doClick();
	            }
				if (e.isAltDown() && e.getKeyChar()=='s') {
	                mf3.doClick();
	            }
				if (e.isAltDown() && e.getKeyChar()=='p') {
	                mf4.doClick();
	            }
			}
		
		});
		
		scrollPane = new JScrollPane(textPane);
		tln = new TextLineNumber(textPane);
		tln.setBackground(new Color(12, 20, 31));
		tln.setForeground(new Color(136, 150, 152));
		//tln.setDigitAlignment(TextLineNumber.CENTER);
		tln.setBorderGap(tln.getBorderGap()+10);
		tln.setFont(new Font("Lucid Console",Font.BOLD,19));
		scrollPane.setRowHeaderView(tln);	
		f1.getContentPane().add(scrollPane);
		
		scrollPane.addKeyListener(new KeyAdapter(){
			
			public void keyTyped(KeyEvent e)
			{	
				if (e.isAltDown() && e.getKeyChar()=='n') {
	                mf1.doClick();
	            }
				if (e.isAltDown() && e.getKeyChar()=='o') {
	                mf2.doClick();
	            }
				if (e.isAltDown() && e.getKeyChar()=='s') {
	                mf3.doClick();
	            }
			}
		
		});
		
		
		
		final JPopupMenu popupmenu = new JPopupMenu("Edit");   
        JMenuItem cut = new JMenuItem("Cut");
        cut.setFont(defont);
        cut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x= textPane.getSelectedText();
				if(!x.equals(null)) {
				temp= x;
				textPane.replaceSelection("");
				}
				}
		});

        JMenuItem copy = new JMenuItem("Copy");  
        copy.setFont(defont);
        copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x= textPane.getSelectedText();
				if(!x.equals(null))
				temp=x;
				}
		});
        
        JMenuItem paste = new JMenuItem("Paste");  
        paste.setFont(defont);
        paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(temp!=null)
					
					if(textPane.getSelectedText()!=null)
					{
						textPane.replaceSelection(temp);
					}
					else{
						try {
							textPane.getDocument().insertString(textPane.getCaretPosition(), temp, null);
							}
							catch (BadLocationException dx) {
								dx.printStackTrace();
							}
						}
				}
		});
        
        JMenuItem def = new JMenuItem("Define");
        def.setFont(defont);
        popupmenu.add(cut); popupmenu.add(copy); popupmenu.add(paste); popupmenu.add(def);        
        pnt=null;
        textPane.addMouseListener(new MouseAdapter() {  
           public void mouseClicked(MouseEvent e) {  
        	   if(SwingUtilities.isRightMouseButton(e)) 
        	   {
        	   textPane.getSelectedText();
               popupmenu.show(textPane , e.getX(), e.getY());  
               pnt=e.getPoint();
        	   }
           }                 
        });
        def.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					String res =Search.getDef(textPane.getSelectedText());
					textArea.setText("\n"+res);
					dlg.setLocation(pnt.x+20,pnt.y+20);
					scrollPan.getViewport().setViewPosition(new Point(0,0));
					dlg.setVisible(true);
					
					}
				catch(Exception d) 
				{d.printStackTrace();}
			}
		});
        
        
        scrollPane.add(popupmenu);   
		
		
		
		dlg = new JDialog();
		dlg.setModal(true);
		dlg.setSize(300,210);
		dlg.setUndecorated(true);
		dlg.setBackground(new Color(0,0,0,0));
		dlg.setLocationRelativeTo(f1);
		
		
		JPanel pnl = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {
                    final int R = 37;
                    final int G = 51;
                    final int B = 66;
                    Paint p = new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 230),
                            0.0f, getHeight(), new Color(R, G, B, 250), true);
                    Graphics2D g2d = (Graphics2D)g;
                    g2d.setPaint(p);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };
        dlg.setContentPane(pnl);
        dlg.setLayout(null);
        
        JLabel Closebtn = new JLabel("<html><body><font size=6 color='#C0C0C0' face='Lucida Console'>X</font></body></html>");
        Closebtn.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
        Closebtn.setOpaque(true);
		Closebtn.setBackground(Color.BLACK);
        Closebtn.setBounds(277,0,20,20);
        Closebtn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
	        Closebtn.repaint();
	        dlg.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				Closebtn.setOpaque(true);
				Closebtn.setBackground(Color.BLACK);
				Closebtn.setText("<html><body><font size=6 color='White' face='Lucida Console'>X</font></body></html>");
				}

			@Override
			public void mouseExited(MouseEvent arg0) {
				Closebtn.setOpaque(false);
				Closebtn.setText("<html><body><font size=6 color='#C0C0C0' face='Lucida Console'>X</font></body></html>");
				Closebtn.repaint();
			}

		});
        textArea = new JTextArea(5,10);
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setForeground(Color.white);
		textArea.setFont(new Font("Arial", Font.BOLD, 14));
		textArea.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e) {
				dlg.repaint();	
			}

			public void mousePressed(MouseEvent e) {
				dlg.repaint();	
			}
			
			public void mouseClicked(MouseEvent e) {
				dlg.repaint();
				dlg.setLocation(e.getX(), e.getY());
			}
		});
		textArea.addMouseMotionListener(new MouseMotionAdapter() {

        	public void mouseDragged(MouseEvent e) {
        		dlg.setLocation(MouseInfo.getPointerInfo().getLocation());
        		dlg.repaint();
			}
		});
		
	
		scrollPan = new JScrollPane(textArea);
		scrollPan.getViewport().setOpaque(false);
		scrollPan.setOpaque(false);
		scrollPan.setBounds(0,0,300,210);
		scrollPan.getViewport().addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				dlg.repaint();
			}
		});

		dlg.add(Closebtn);
		dlg.add(scrollPan);
		
		JMenuBar mb = new JMenuBar();
		mb.setBackground(new Color(12, 20, 31));
		mb.setForeground(Color.white);
		JMenu menu1 = new JMenu("<html><p style='margin-bottom:5; margin-left:20; margin-right:20; margin-top:5'>File"); menu1.setFont(defont); menu1.setForeground(Color.white);
		menu1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				menu1.setFont(new Font("Lucid Console",Font.BOLD,16));
			}
			public void mouseExited(MouseEvent e) 
			{
				menu1.setFont(defont);
			}
		});
		
		mf1 = new JMenuItem("New         (Alt + N)"); mf1.setFont(defont); mf1.setForeground(Color.white); mf1.setBackground(new Color(12,20,31)); 
		mf1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdvNotepad();
			}
		});	
		
		
		mf2 = new JMenuItem("Open       (Alt + O)"); mf2.setFont(defont); mf2.setForeground(Color.white); mf2.setBackground(new Color(12, 20, 31));
		mf2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				filech = new JFileChooser("D:\\Workstuff");
				filech.setDialogTitle("Select a Text File");
				filech.setFileSelectionMode(JFileChooser.FILES_ONLY);
				filech.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Test Documents (*.txt)","txt", "text");
				filech.addChoosableFileFilter(filter);
				filech.showOpenDialog(f1);
				
				if((filech.getSelectedFile()==null)) {}
				else
				{
					fileo= filech.getSelectedFile();
					try
					{
						BufferedReader br = new BufferedReader(new FileReader(fileo));
						String s1="",s2="";                         
						while((s1=br.readLine())!=null){    
							s2+=s1+"\n";    }    
						new AdvNotepad().textPane.setText(s2);    
						br.close();
			        
					} 
					catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} 
					catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				
				}
				
			}
		});
		mf3 = new JMenuItem("Save       (Alt + S)"); mf3.setFont(defont); mf3.setForeground(Color.white); mf3.setBackground(new Color(12, 20, 31));
		mf3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				filech = new JFileChooser(FileSystemView.getFileSystemView());
				filech.setDialogTitle("Save Here");
				filech.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Documents (*.txt)","txt", "text");
				filech.addChoosableFileFilter(filter);
				filech.setSelectedFile(new File(filech.getCurrentDirectory().getAbsolutePath()+"/Untitled-1"));
				filech.showSaveDialog(f1);
				if((filech.getSelectedFile()==null)) {}
				else
				{
				fileo= filech.getSelectedFile();
				try 
				{
					if(!filech.getSelectedFile().getName().endsWith(".txt"))
					{
						filech.setSelectedFile(new File(filech.getSelectedFile().getPath()+".txt"));
					}
					PrintStream ps = new PrintStream(filech.getSelectedFile());
			        ps.print(textPane.getText());
			        ps.close();
				}
				catch(Exception ef) 
				{
					ef.printStackTrace();
				}
			}
		}
		});

		
		mf4 = new JMenuItem("Print        (Alt + P)"); mf4.setFont(defont); mf4.setForeground(Color.white); mf4.setBackground(new Color(12, 20, 31));
		mf4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    textPane.setContentType("text/plain");
                    JTextArea eprt = new JTextArea();
                    eprt.setText(textPane.getText());
                    boolean done = eprt.print();
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }	
			}
		});
		
		JMenuItem mf5 = new JMenuItem("Exit"); mf5.setFont(defont); mf5.setForeground(Color.white); mf5.setBackground(new Color(12, 20, 31));
		mf5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.gc();
				f1.dispose();
			}
		});
		JMenu menu2 = new JMenu("<html><p style='margin-bottom:5; margin-left:20; margin-right:20; margin-top:5'>Edit"); menu2.setFont(defont); menu2.setForeground(Color.white); menu2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				menu2.setFont(new Font("Lucid Console",Font.BOLD,16));
			}
			public void mouseExited(MouseEvent e) 
			{
				menu2.setFont(defont);
			}
		});
		
		me1 = new JMenuItem("Cut             (Ctrl + X)"); me1.setFont(defont); me1.setForeground(Color.white); me1.setBackground(new Color(12, 20, 31));
		me1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String x= textPane.getSelectedText();
				if(!x.equals(null)) {
				temp= x;
				textPane.replaceSelection("");
				}
			}
		});
		me2 = new JMenuItem("Copy         (Ctrl + C)"); me2.setFont(defont); me2.setForeground(Color.white); me2.setBackground(new Color(12, 20, 31));
		me2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String x= textPane.getSelectedText();
				if(!x.equals(null))
				temp=x;
			}
		});
		me3 = new JMenuItem("Paste        (Ctrl + V)"); me3.setFont(defont); me3.setForeground(Color.white); me3.setBackground(new Color(12, 20, 31));
		me3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(temp!=null)
					
					if(textPane.getSelectedText()!=null)
					{
						textPane.replaceSelection(temp);
					}
					else{
						try {
							textPane.getDocument().insertString(textPane.getCaretPosition(), temp, null);
							}
							catch (BadLocationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						}
		});
		JMenuItem me4 = new JMenuItem("Highlight"); me4.setFont(defont); me4.setForeground(Color.white); me4.setBackground(new Color(12, 20, 31));
		me4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    StyledDocument doc = (StyledDocument) textPane.getDocument();
			    int selectionEnd = textPane.getSelectionEnd();
			    int selectionStart = textPane.getSelectionStart();
			    if (selectionStart == selectionEnd) {
			      return;
			    }
			    
			    Element element = doc.getCharacterElement(selectionStart);
			    AttributeSet as = element.getAttributes();
			    MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
			   
			    if(StyleConstants.getBackground(asNew).equals(new Color(251, 237, 184,50))) 
			    {
			    	StyleConstants.setBackground(asNew, new Color(0, 0, 0,0));
				    doc.setCharacterAttributes(selectionStart, textPane.getSelectedText()
				        .length(), asNew, true);				
			    }
			    else
			    {
			    	StyleConstants.setBackground(asNew, new Color(251, 237, 184,50));
			    	doc.setCharacterAttributes(selectionStart, textPane.getSelectedText().length(), asNew, true);	
			    }
			}
		});
		
		
		mb.add(menu1);  mb.add(menu2); 
		
		menu1.add(mf1); menu1.add(mf2); menu1.add(mf3); menu1.add(mf4); menu1.add(mf5);
		menu2.add(me1); menu2.add(me2); menu2.add(me3); menu2.add(me4);
	
		
		f1.setJMenuBar(mb);
		f1.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new AdvNotepad();
			}
		});
	}
}

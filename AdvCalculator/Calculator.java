import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//@author Akshat a.k.a Jerry
public class Calculator {

	public JFrame f1;
	JPanel OverPanel1;
	JPanel OverPanel2;
	JPanel OverPanel3;
	JPanel OverPanel4;
	JLabel OverLabel;
	JLabel Historylbl;
	JLabel Displaylbl;
	JLabel showHistory;
	JTextField opvalue;
	JButton One;
	JButton Two;
	JButton Three;
	JButton Four;
	JButton Five;
	JButton Six;
	JButton Seven;
	JButton Eight;
	JButton Nine;
	JButton Zero;
	JButton Dot;
	JButton Del;
	JButton CE;
	JButton add;
	JButton sub;
	JButton mul;
	JButton div;
	JButton perc;
	JButton sqrt;
	JButton sq;	
	JButton xsqy;
	JButton ibyx;
	JButton result;
	JButton abs;	
	StringBuffer Expr;
	Stack<String> num;
	Stack<String> op;
	int flag=0;
	
	
	
	Calculator()
	{
		initialize();
	}
	
	void initialize() 
	{
		f1 = new JFrame("Advance Calculator");
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setSize(new Dimension(790, 530));
		f1.setLocationRelativeTo(null);
		f1.setResizable(false);
		
		Image imgx= new ImageIcon("C:\\Users\\akroc\\Documents\\Eclipse Workspace\\TRAVEL\\src\\Translucenx.png").getImage().getScaledInstance(820, 510, Image.SCALE_DEFAULT);
		ImageIcon image = new ImageIcon(imgx);
		
		OverPanel1 = new JPanel();
		OverPanel1.setPreferredSize(new Dimension(790, 530));
		OverPanel1.setLayout(null);
		OverPanel1.setOpaque(false);
		f1.getContentPane().add(OverPanel1);
		
		
		OverPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT,15,10));
		OverPanel2.setOpaque(false);
		OverPanel2.setSize(new Dimension(790, 530));
		OverPanel1.add(OverPanel2);
		
		Historylbl = new JLabel("");
		OverPanel2.add(Historylbl);
		Historylbl.setBorder(BorderFactory.createTitledBorder("<html><font color='white' size='4'>History</font></html>"));
		Historylbl.setPreferredSize(new Dimension(740, 50));
		Historylbl.setFont(new Font("Droid Sans", Font.PLAIN, 20));
		Historylbl.setHorizontalAlignment(JLabel.RIGHT);
		Historylbl.setForeground(Color.WHITE);
		
		Displaylbl = new JLabel("0");
		OverPanel2.add(Displaylbl);
		Displaylbl.setBorder(BorderFactory.createLineBorder(Color.white));
		Displaylbl.setHorizontalAlignment(JLabel.RIGHT);
		Displaylbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		Displaylbl.setPreferredSize(new Dimension(740, 50));
		Displaylbl.setForeground(Color.WHITE);
		

		OverPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT,18,15));
		OverPanel3.setOpaque(false);
		OverPanel3.setPreferredSize(new Dimension(330, 350));
		OverPanel2.add(OverPanel3);

		JLabel gap = new JLabel();
		gap.setPreferredSize(new Dimension(40, 350));
		OverPanel2.add(gap);
		
		OverPanel4 = new JPanel(new FlowLayout(FlowLayout.LEFT,18,15));
		OverPanel4.setOpaque(false);
		OverPanel4.setPreferredSize(new Dimension(340, 350));
		OverPanel2.add(OverPanel4);

		
		op = new Stack<String>();
		op.add("(");
		num = new Stack<String>();
		Expr= new StringBuffer();

		One = new JButton("1");
		OverPanel3.add(One,BorderLayout.AFTER_LAST_LINE);
		One.setHorizontalAlignment(JButton.CENTER);
		One.setBackground(new Color(30, 30, 30));
		One.setForeground(Color.white);
		One.setFont(new Font("Droid Sans", Font.PLAIN, 40));
		One.setFocusable(false);
		One.setPreferredSize(new Dimension(90, 70));
		One.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				One.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				One.setBackground(new Color(30, 30, 30));
			}
			public void mouseReleased(MouseEvent e) 
			{
				if(Displaylbl.getText().equals("0")) 
				{
					Displaylbl.setText("");
				}
				if(flag==1) 
				{
					Displaylbl.setText("");
					flag=0;
				}
				Displaylbl.setText(Displaylbl.getText()+"1");
				Expr.append("1");
				Historylbl.setText(Expr.toString());
			}
		});
		
		
		
		Two = new JButton("2");
		OverPanel3.add(Two,BorderLayout.AFTER_LAST_LINE);
		Two.setHorizontalAlignment(JButton.CENTER);
		Two.setBackground(new Color(30, 30, 30));
		Two.setForeground(Color.white);
		Two.setFont(new Font("Droid Sans", Font.PLAIN, 40));
		Two.setFocusable(false);
		Two.setPreferredSize(new Dimension(90, 70));
		Two.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				Two.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				Two.setBackground(new Color(30, 30, 30));
			}
			public void mouseReleased(MouseEvent e) 
			{
				if(Displaylbl.getText().equals("0")) 
				{
					Displaylbl.setText("");
				}
				if(flag==1) 
				{
					Displaylbl.setText("");
					flag=0;
				}
				Displaylbl.setText(Displaylbl.getText()+"2");
				Expr.append("2");
				Historylbl.setText(Expr.toString());
			}
		});
		

		Three = new JButton("3");
		OverPanel3.add(Three,BorderLayout.AFTER_LAST_LINE);
		Three.setHorizontalAlignment(JButton.CENTER);
		Three.setBackground(new Color(30, 30, 30));
		Three.setForeground(Color.white);
		Three.setFont(new Font("Droid Sans", Font.PLAIN, 40));
		Three.setFocusable(false);
		Three.setPreferredSize(new Dimension(90, 70));
		Three.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				Three.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				Three.setBackground(new Color(30, 30, 30));
			}
			public void mouseReleased(MouseEvent e) 
			{
				if(Displaylbl.getText().equals("0")) 
				{
					Displaylbl.setText("");
				}
				if(flag==1) 
				{
					Displaylbl.setText("");
					flag=0;
				}
				Displaylbl.setText(Displaylbl.getText()+"3");
				Expr.append("3");
				Historylbl.setText(Expr.toString());			}
		});

		
		
		Four = new JButton("4");
		OverPanel3.add(Four,BorderLayout.AFTER_LAST_LINE);
		Four.setHorizontalAlignment(JButton.CENTER);
		Four.setBackground(new Color(30, 30, 30));
		Four.setForeground(Color.white);
		Four.setFont(new Font("Droid Sans", Font.PLAIN, 40));
		Four.setFocusable(false);
		Four.setPreferredSize(new Dimension(90, 70));
		Four.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				Four.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				Four.setBackground(new Color(30, 30, 30));
			}
			public void mouseReleased(MouseEvent e) 
			{
				if(Displaylbl.getText().equals("0")) 
				{
					Displaylbl.setText("");
				}
				if(flag==1) 
				{
					Displaylbl.setText("");
					flag=0;
				}
				Displaylbl.setText(Displaylbl.getText()+"4");
				Expr.append("4");
				Historylbl.setText(Expr.toString());
			}
		});

				
		
		
		Five = new JButton("5");
		OverPanel3.add(Five,BorderLayout.AFTER_LAST_LINE);
		Five.setHorizontalAlignment(JButton.CENTER);
		Five.setBackground(new Color(30, 30, 30));
		Five.setForeground(Color.white);
		Five.setFont(new Font("Droid Sans", Font.PLAIN, 40));
		Five.setFocusable(false);
		Five.setPreferredSize(new Dimension(90, 70));
		Five.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				Five.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				Five.setBackground(new Color(30, 30, 30));
			}
			public void mouseReleased(MouseEvent e) 
			{
				if(Displaylbl.getText().equals("0")) 
				{
					Displaylbl.setText("");
				}
				if(flag==1) 
				{
					Displaylbl.setText("");
					flag=0;
				}
				Displaylbl.setText(Displaylbl.getText()+"5");
				Expr.append("5");
				Historylbl.setText(Expr.toString());			}
		});

		
		
		
		Six = new JButton("6");
		OverPanel3.add(Six,BorderLayout.AFTER_LAST_LINE);
		Six.setHorizontalAlignment(JButton.CENTER);
		Six.setBackground(new Color(30, 30, 30));
		Six.setForeground(Color.white);
		Six.setFont(new Font("Droid Sans", Font.PLAIN, 40));
		Six.setFocusable(false);
		Six.setPreferredSize(new Dimension(90, 70));
		Six.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				Six.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				Six.setBackground(new Color(30, 30, 30));
			}
			public void mouseReleased(MouseEvent e) 
			{
				if(Displaylbl.getText().equals("0")) 
				{
					Displaylbl.setText("");
				}
				if(flag==1) 
				{
					Displaylbl.setText("");
					flag=0;
				}
				Displaylbl.setText(Displaylbl.getText()+"6");
				Expr.append("6");
				Historylbl.setText(Expr.toString());
			}
		});


		
		Seven = new JButton("7");
		OverPanel3.add(Seven,BorderLayout.AFTER_LAST_LINE);
		Seven.setHorizontalAlignment(JButton.CENTER);
		Seven.setBackground(new Color(30, 30, 30));
		Seven.setForeground(Color.white);
		Seven.setFont(new Font("Droid Sans", Font.PLAIN, 40));
		Seven.setFocusable(false);
		Seven.setPreferredSize(new Dimension(90, 70));
		Seven.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				Seven.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				Seven.setBackground(new Color(30, 30, 30));
			}
			public void mouseReleased(MouseEvent e) 
			{
				if(Displaylbl.getText().equals("0")) 
				{
					Displaylbl.setText("");
				}
				if(flag==1) 
				{
					Displaylbl.setText("");
					flag=0;
				}
				Displaylbl.setText(Displaylbl.getText()+"7");
				Expr.append("7");
				Historylbl.setText(Expr.toString());
			}
		});

		
		
		
		
		Eight = new JButton("8");
		OverPanel3.add(Eight,BorderLayout.AFTER_LAST_LINE);
		Eight.setHorizontalAlignment(JButton.CENTER);
		Eight.setBackground(new Color(30, 30, 30));
		Eight.setForeground(Color.white);
		Eight.setFont(new Font("Droid Sans", Font.PLAIN, 40));
		Eight.setFocusable(false);
		Eight.setPreferredSize(new Dimension(90, 70));
		Eight.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				Eight.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				Eight.setBackground(new Color(30, 30, 30));
			}
			public void mouseReleased(MouseEvent e) 
			{
				if(Displaylbl.getText().equals("0")) 
				{
					Displaylbl.setText("");
				}
				if(flag==1) 
				{
					Displaylbl.setText("");
					flag=0;
				}
				Displaylbl.setText(Displaylbl.getText()+"8");
				Expr.append("8");
				Historylbl.setText(Expr.toString());
			}
		});
		
		
		
		Nine = new JButton("9");
		OverPanel3.add(Nine,BorderLayout.AFTER_LAST_LINE);
		Nine.setHorizontalAlignment(JButton.CENTER);
		Nine.setBackground(new Color(30, 30, 30));
		Nine.setForeground(Color.white);
		Nine.setFont(new Font("Droid Sans", Font.PLAIN, 40));
		Nine.setFocusable(false);
		Nine.setPreferredSize(new Dimension(90, 70));
		Nine.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				Nine.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				Nine.setBackground(new Color(30, 30, 30));
			}
			public void mouseReleased(MouseEvent e) 
			{
				if(Displaylbl.getText().equals("0")) 
				{
					Displaylbl.setText("");
				}
				if(flag==1) 
				{
					Displaylbl.setText("");
					flag=0;
				}
				Displaylbl.setText(Displaylbl.getText()+"9");
				Expr.append("9");
				Historylbl.setText(Expr.toString());
			}
		});

		
		Dot = new JButton(".");
		OverPanel3.add(Dot,BorderLayout.AFTER_LAST_LINE);
		Dot.setHorizontalAlignment(JButton.CENTER);
		Dot.setBackground(Color.DARK_GRAY);
		Dot.setForeground(Color.white);
		Dot.setFont(new Font("Droid Sans", Font.PLAIN, 40));
		Dot.setFocusable(false);
		Dot.setPreferredSize(new Dimension(90, 70));
		Dot.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				Dot.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				Dot.setBackground(Color.DARK_GRAY);
			}
			public void mouseReleased(MouseEvent e) 
			{
				Displaylbl.setText(Displaylbl.getText()+".");
			}
		});

				
		
		
		Zero = new JButton("0");
		OverPanel3.add(Zero,BorderLayout.AFTER_LAST_LINE);
		Zero.setHorizontalAlignment(JButton.CENTER);
		Zero.setBackground(new Color(30, 30, 30));
		Zero.setForeground(Color.white);
		Zero.setFont(new Font("Droid Sans", Font.PLAIN, 40));
		Zero.setFocusable(false);
		Zero.setPreferredSize(new Dimension(90, 70));
		Zero.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				Zero.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				Zero.setBackground(new Color(30, 30, 30));
			}
			public void mouseReleased(MouseEvent e) 
			{
				if(Displaylbl.getText().equals("0")) 
				{
					Displaylbl.setText("");
				}
				if(flag==1) 
				{
					Displaylbl.setText("");
					flag=0;
				}
				Displaylbl.setText(Displaylbl.getText()+"0");
				Expr.append("0");
				Historylbl.setText(Expr.toString());
			}
		});

		
		
		
		Del = new JButton("Del");
		OverPanel3.add(Del,BorderLayout.AFTER_LAST_LINE);
		Del.setHorizontalAlignment(JButton.CENTER);
		Del.setBackground(Color.DARK_GRAY);
		Del.setForeground(Color.white);
		Del.setFont(new Font("Droid Sans", Font.PLAIN, 35));
		Del.setFocusable(false);
		Del.setPreferredSize(new Dimension(90, 70));
		Del.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				Del.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				Del.setBackground(Color.DARK_GRAY);
			}
		});

		
		
		
		
		add = new JButton("+");
		OverPanel4.add(add,BorderLayout.AFTER_LAST_LINE);
		add.setHorizontalAlignment(JButton.CENTER);
		add.setBackground(Color.DARK_GRAY);
		add.setForeground(Color.white);
		add.setFont(new Font("Droid Sans", Font.PLAIN, 35));
		add.setFocusable(false);
		add.setPreferredSize(new Dimension(90, 70));
		add.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				add.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				add.setBackground(Color.DARK_GRAY);
			}
			public void mouseReleased(MouseEvent e) 
			{
				if(Historylbl.getText().isEmpty())
				{
				}
				else 
				{
					Pattern p = Pattern.compile("[0-9]");
					Matcher m = p.matcher(Expr.substring(Expr.length()-1, Expr.length()));
					if(m.find()) 
					{
						if(op.peek().equals("√")) 
						{
							Expr.append(" + ");											
							op.push("+");
							flag=1;
						}
						else
						{
							num.push(Displaylbl.getText());
							Expr.append(" + ");											
							op.push("+");
							flag=1;}
					}
					else 
					{
						if(Expr.charAt(Expr.length()-2)=='.') 
						{
							if(op.peek().equals("√")) 
							{
								Expr.deleteCharAt(Expr.length()-1);
								Expr.deleteCharAt(Expr.length()-1);
								op.push("+");
								Expr.append(" + ");
								flag=1;
							}
							else
							{
								num.push(Displaylbl.getText());
								Expr.deleteCharAt(Expr.length()-1);
								Expr.deleteCharAt(Expr.length()-1);
								op.push("+");
								Expr.append(" + ");
								flag=1;
							}
							
						}
						else {
							if(op.peek().equals("^")) 
							{
								Expr.append(" + ");											
								op.push("+");
								flag=1;
							}
							else if(op.peek().equals("^^")) 
							{
								Expr.append(" + ");											
								op.push("+");
								flag=1;
							}
							else {
								Expr.deleteCharAt(Expr.length()-1);
								Expr.deleteCharAt(Expr.length()-1);
								op.pop();
								op.push("+");
								Expr.append("+ ");
								flag=1;
							}
						}
					}
					
					Historylbl.setText(Expr.toString());
				}
			}
		});

		
		
		perc = new JButton("%");
		OverPanel4.add(perc,BorderLayout.AFTER_LAST_LINE);
		perc.setHorizontalAlignment(JButton.CENTER);
		perc.setBackground(Color.DARK_GRAY);
		perc.setForeground(Color.white);
		perc.setFont(new Font("Droid Sans", Font.PLAIN, 35));
		perc.setFocusable(false);
		perc.setPreferredSize(new Dimension(90, 70));
		perc.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				perc.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				perc.setBackground(Color.DARK_GRAY);
			}
			
			public void mouseReleased(MouseEvent e) 
			{

				if(Historylbl.getText().isEmpty())
				{
				}
				else 
				{
					Pattern p = Pattern.compile("[0-9]");
					Matcher m = p.matcher(Expr.substring(Expr.length()-1, Expr.length()));
					if(m.find()) 
					{
						if(op.peek().equals("√")) 
						{Expr.append(" % ");											
						op.push("%");
						flag=1;}
						else {
						num.push(Displaylbl.getText());
						Expr.append(" % ");											
						op.push("%");
						flag=1;
						}
					}
					else 
					{
						if(Expr.charAt(Expr.length()-2)=='.') 
						{
							if(op.peek().equals("√")) 
							{
								Expr.deleteCharAt(Expr.length()-1);
								Expr.deleteCharAt(Expr.length()-1);
								op.push("%");
								Expr.append(" % ");
								flag=1;
							}else
							{
							num.push(Displaylbl.getText());
							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							op.push("%");
							Expr.append(" % ");
							flag=1;
							}
						}
						else {
							if(op.peek().equals("^")) 
							{
								Expr.append(" % ");											
								op.push("%");
								flag=1;
							}
							else if(op.peek().equals("^^")) 
							{
								Expr.append(" + ");											
								op.push("+");
								flag=1;
							}
							else {

							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							op.pop();
							op.push("%");
							Expr.append("% ");
							flag=1;
							}
							}
					}
					
					Historylbl.setText(Expr.toString());
				}
			}
			

		});

		
		
		abs = new JButton("| x |");
		OverPanel4.add(abs,BorderLayout.AFTER_LAST_LINE);
		abs.setHorizontalAlignment(JButton.CENTER);
		abs.setBackground(Color.DARK_GRAY);
		abs.setForeground(Color.white);
		abs.setFont(new Font("Droid Sans", Font.PLAIN, 26));
		abs.setFocusable(false);
		abs.setPreferredSize(new Dimension(90, 70));
		abs.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				abs.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				abs.setBackground(Color.DARK_GRAY);
			}
			public void mouseReleased(MouseEvent e) 
			{
				if(num.isEmpty()) {
					
				if(num.peek().equals(Displaylbl.getText())) 
				{
					num.pop();
					int x= Math.abs(Integer.parseInt(Displaylbl.getText()));
					Expr.append(x);
					num.push(x+"");
				}
				}
			}
		});

		
		
		
		
		sub = new JButton("-");
		OverPanel4.add(sub,BorderLayout.AFTER_LAST_LINE);
		sub.setHorizontalAlignment(JButton.CENTER);
		sub.setBackground(Color.DARK_GRAY);
		sub.setForeground(Color.white);
		sub.setFont(new Font("Droid Sans", Font.PLAIN, 35));
		sub.setFocusable(false);
		sub.setPreferredSize(new Dimension(90, 70));
		sub.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				sub.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				sub.setBackground(Color.DARK_GRAY);
			}
			
			public void mouseReleased(MouseEvent e) 
			{

				if(Historylbl.getText().isEmpty())
				{
				}
				else 
				{
					Pattern p = Pattern.compile("[0-9]");
					Matcher m = p.matcher(Expr.substring(Expr.length()-1, Expr.length()));
					if(m.find()) 
					{
						if(op.peek().equals("√")) 
						{
							Expr.append(" - ");											
							op.push("-");
							flag=1;
						}
						else {
						num.push(Displaylbl.getText());
						Expr.append(" - ");											
						op.push("-");
						flag=1;
						}
					}
					else 
					{
						if(Expr.charAt(Expr.length()-2)=='.') 
						{
							if(op.peek().equals("√")) 
							{
								Expr.deleteCharAt(Expr.length()-1);
								Expr.deleteCharAt(Expr.length()-1);
								op.push("-");
								Expr.append(" - ");
								flag=1;
							}
							else {
							num.push(Displaylbl.getText());
							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							op.push("-");
							Expr.append(" - ");
							flag=1;
							}
							
						}
						else {
							if(op.peek().equals("^")) 
							{
								Expr.append(" - ");											
								op.push("-");
								flag=1;
							}
							else if(op.peek().equals("^^")) 
							{
								Expr.append(" + ");											
								op.push("+");
								flag=1;
							}
							else {

							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							op.pop();
							op.push("-");
							Expr.append("- ");
							flag=1;
							}
						}
					}
					
					Historylbl.setText(Expr.toString());
				}
			}
			
		});

		
		
		sq = new JButton("x²");
		OverPanel4.add(sq,BorderLayout.AFTER_LAST_LINE);
		sq.setHorizontalAlignment(JButton.CENTER);
		sq.setBackground(Color.DARK_GRAY);
		sq.setForeground(Color.white);
		sq.setFont(new Font("Droid Sans", Font.PLAIN, 35));
		sq.setFocusable(false);
		sq.setPreferredSize(new Dimension(90, 70));
		sq.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				sq.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				sq.setBackground(Color.DARK_GRAY);
			}
			public void mouseReleased(MouseEvent e) 
			{

				if(Historylbl.getText().isEmpty())
				{
				}
				else 
				{
					Pattern p = Pattern.compile("[0-9]");
					Matcher m = p.matcher(Expr.substring(Expr.length()-1, Expr.length()));
					
					if(m.find()) 
					{
						if(op.peek().equals("√")) 
						{
							flag=1;
						}
						else
						{
						num.push(Displaylbl.getText());
						Expr.append("²");											
						op.push("^");
						flag=1;
						}
					}
					else 
					{
						if(Expr.charAt(Expr.length()-2)=='.') 
						{
							num.push(Displaylbl.getText());
							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							op.push("^");
							Expr.append("²");
							flag=1;
						} 
						else {
							if(Expr.charAt(Expr.length()-2)=='²') 
							{
							}
							else {
							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							op.pop();
							op.push("^");
							Expr.append("²");
							flag=1;
							}
						}
					}
					
					Historylbl.setText(Expr.toString());
				}
			}
			
		});

		
		
		
		xsqy = new JButton("x³"); 
	    OverPanel4.add(xsqy,BorderLayout.AFTER_LAST_LINE);
		xsqy.setHorizontalAlignment(JButton.CENTER);
		xsqy.setBackground(Color.DARK_GRAY);
		xsqy.setForeground(Color.white);
		xsqy.setFont(new Font("Droid Sans", Font.PLAIN, 35));
		xsqy.setFocusable(false);
		xsqy.setPreferredSize(new Dimension(90, 70));
		xsqy.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				xsqy.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				xsqy.setBackground(Color.DARK_GRAY);
			}
			
			public void mouseReleased(MouseEvent e) 
			{

				if(Historylbl.getText().isEmpty())
				{
				}
				else 
				{
					Pattern p = Pattern.compile("[0-9]");
					Matcher m = p.matcher(Expr.substring(Expr.length()-1, Expr.length()));
					
					if(m.find()) 
					{
						if(op.peek().equals("√")) 
						{
							flag=1;
						}
						else
						{
						num.push(Displaylbl.getText());
						Expr.append("³");											
						op.push("^^");
						flag=1;
						}
					}
					else 
					{
						if(Expr.charAt(Expr.length()-2)=='.') 
						{
							num.push(Displaylbl.getText());
							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							op.push("^^");
							Expr.append("³");
							flag=1;
						}
						else {
							if(Expr.charAt(Expr.length()-2)=='³') 
							{
							}
							else {
							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							op.pop();
							op.push("^^");
							Expr.append("³");
							flag=1;
							}
						}
					}
					
					Historylbl.setText(Expr.toString());
				}
			}
		});

		
		
		
		
		
		mul = new JButton("×");
		OverPanel4.add(mul,BorderLayout.AFTER_LAST_LINE);
		mul.setHorizontalAlignment(JButton.CENTER);
		mul.setBackground(Color.DARK_GRAY);
		mul.setForeground(Color.white);
		mul.setFont(new Font("Droid Sans", Font.PLAIN, 35));
		mul.setFocusable(false);
		mul.setPreferredSize(new Dimension(90, 70));
		mul.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				mul.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				mul.setBackground(Color.DARK_GRAY);
			}
			public void mouseReleased(MouseEvent e) 
			{

				if(Historylbl.getText().isEmpty())
				{
				}
				else 
				{
					Pattern p = Pattern.compile("[0-9]");
					Matcher m = p.matcher(Expr.substring(Expr.length()-1, Expr.length()));
					if(m.find()) 
					{
						if(op.peek().equals("√")) 
						{Expr.append(" × ");											
						op.push("*");
						flag=1;}
						else {
						num.push(Displaylbl.getText());
						Expr.append(" × ");											
						op.push("*");
						flag=1;
						}
					}
					else 
					{
						if(Expr.charAt(Expr.length()-2)=='.') 
						{
							if(op.peek().equals("√")) 
							{
								Expr.deleteCharAt(Expr.length()-1);
								Expr.deleteCharAt(Expr.length()-1);
								op.push("*");
								Expr.append(" × ");
								flag=1;
							}else
							{
							num.push(Displaylbl.getText());
							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							op.push("*");
							Expr.append(" × ");
							flag=1;
							}
						}
						else {
							if(op.peek().equals("^")) 
							{
								Expr.append(" × ");											
								op.push("*");
								flag=1;
							}
							else if(op.peek().equals("^^")) 
							{
								Expr.append(" + ");											
								op.push("+");
								flag=1;
							}
							else {

							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							op.pop();
							op.push("*");
							Expr.append("× ");
							flag=1;
							}
							}
					}
					
					Historylbl.setText(Expr.toString());
				}
			}
			
		});

		
		

		
		sqrt = new JButton("√");
		OverPanel4.add(sqrt,BorderLayout.AFTER_LAST_LINE);
		sqrt.setHorizontalAlignment(JButton.CENTER);
		sqrt.setBackground(Color.DARK_GRAY);
		sqrt.setForeground(Color.white);
		sqrt.setFont(new Font("Droid Sans", Font.PLAIN, 35));
		sqrt.setFocusable(false);
		sqrt.setPreferredSize(new Dimension(90, 70));
		sqrt.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				sqrt.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				sqrt.setBackground(Color.DARK_GRAY);
			}
			public void mouseReleased(MouseEvent e) 
			{

				if(Historylbl.getText().isEmpty())
				{
				}
				else 
				{
					Pattern p = Pattern.compile("[0-9]");
					Matcher m = p.matcher(Expr.substring(Expr.length()-1, Expr.length()));
					if(op.peek().equals("√")) {}
					else {
					if(m.find()) 
					{
						num.push(Displaylbl.getText());
						Expr.replace((Expr.length()-Displaylbl.getText().length()), Expr.length(), " √"+Displaylbl.getText());
						op.push("√");
						flag=1;
					}
					else 
					{
						if(Expr.charAt(Expr.length()-2)=='.') 
						{
							if(op.peek().equals("√")) 
							{
								Expr.deleteCharAt(Expr.length()-1);
								Expr.deleteCharAt(Expr.length()-1);
								op.push("√");
								Expr.replace((Expr.length()-Displaylbl.getText().length()), Expr.length(), " √"+Displaylbl.getText());
								flag=1;
							}
							else
							{
							num.push(Displaylbl.getText());
							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							op.push("√");
							Expr.replace((Expr.length()-Displaylbl.getText().length()), Expr.length(), " √"+Displaylbl.getText());
							flag=1;
							}
						}
						else {
							if(op.peek().equals("^")) 
							{
								Expr.deleteCharAt(Expr.length()-1);
								Expr.deleteCharAt(Expr.length()-1);
								op.pop();
								op.push("√");
								Expr.replace((Expr.length()-Displaylbl.getText().length()), Expr.length(), " √"+Displaylbl.getText());
								flag=1;
							}
							else if(op.peek().equals("^^")) 
							{
								Expr.deleteCharAt(Expr.length()-1);
								Expr.deleteCharAt(Expr.length()-1);
								op.pop();
								op.push("√");
								Expr.replace((Expr.length()-Displaylbl.getText().length()), Expr.length(), " √"+Displaylbl.getText());
								flag=1;
							}
							else {

								Expr.deleteCharAt(Expr.length()-1);
								Expr.deleteCharAt(Expr.length()-1);
								Expr.deleteCharAt(Expr.length()-1);
								op.pop();
								op.push("√");
								Expr.replace((Expr.length()-Displaylbl.getText().length()), Expr.length(), " √"+Displaylbl.getText());
								flag=1;
							}
							}
					}
					
					Historylbl.setText(Expr.toString());
				}
			}
			}
			
		});
		
		
		
		
		
		
		CE = new JButton("Clear");
		OverPanel4.add(CE,BorderLayout.AFTER_LAST_LINE);
		CE.setHorizontalAlignment(JButton.CENTER);
		CE.setBackground(Color.DARK_GRAY);
		CE.setForeground(Color.white);
		CE.setFont(new Font("Droid Sans", Font.PLAIN, 24));
		CE.setFocusable(false);
		CE.setPreferredSize(new Dimension(90, 70));
		CE.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				CE.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				CE.setBackground(Color.DARK_GRAY);
			}
			public void mouseReleased(MouseEvent e) 
			{
				op.clear();
				op.push("(");
				num.clear();
				Expr.delete(0, Expr.length());
				Displaylbl.setText("");
				Historylbl.setText("");
			}
		});


		
		
		
		
		div = new JButton("÷");
		OverPanel4.add(div,BorderLayout.AFTER_LAST_LINE);
		div.setHorizontalAlignment(JButton.CENTER);
		div.setBackground(Color.DARK_GRAY);
		div.setForeground(Color.white);
		div.setFont(new Font("Droid Sans", Font.PLAIN, 35));
		div.setFocusable(false);
		div.setPreferredSize(new Dimension(90, 70));
		div.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				div.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				div.setBackground(Color.DARK_GRAY);
			}
			public void mouseReleased(MouseEvent e) 
			{

				if(Historylbl.getText().isEmpty())
				{
				}
				else 
				{
					Pattern p = Pattern.compile("[0-9]");
					Matcher m = p.matcher(Expr.substring(Expr.length()-1, Expr.length()));
					if(m.find()) 
					{
						
						if(op.peek().equals("√")) 
						{
							Expr.append(" ÷ ");											
							op.push("/");
							flag=1;
						}
						
						else 
						{
						num.push(Displaylbl.getText());
						Expr.append(" ÷ ");											
						op.push("/");
						flag=1;
						}
						
					}
					else 
					{
						if(Expr.charAt(Expr.length()-2)=='.') 
						{
							if(op.peek().equals("√")) 
							{
								Expr.deleteCharAt(Expr.length()-1);
								Expr.deleteCharAt(Expr.length()-1);
								op.push("/");
								Expr.append(" ÷ ");
								flag=1;	
							}else 
							{
							num.push(Displaylbl.getText());
							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							op.push("/");
							Expr.append(" ÷ ");
							flag=1;
							}
						}
						else {
							if(op.peek().equals("^")) 
							{
								Expr.append(" ÷ ");											
								op.push("/");
								flag=1;
							}
							else if(op.peek().equals("^^")) 
							{
								Expr.append(" + ");											
								op.push("+");
								flag=1;
							}
							else {

							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							op.pop();
							op.push("/");
							Expr.append("÷ ");
							flag=1;
							}
						}
					}
					
					Historylbl.setText(Expr.toString());
				}
				System.out.println(num+" "+op+" "+ Expr);
			}
			
		});

		
		

		ibyx = new JButton("<html>1&frasl;<sub>x</sub></html>");
		OverPanel4.add(ibyx,BorderLayout.AFTER_LAST_LINE);
		ibyx.setHorizontalAlignment(JButton.CENTER);
		ibyx.setBackground(Color.DARK_GRAY);
		ibyx.setForeground(Color.white);
		ibyx.setFont(new Font("Droid Sans", Font.PLAIN, 30));
		ibyx.setFocusable(false);
		ibyx.setPreferredSize(new Dimension(90, 70));
		ibyx.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				ibyx.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				ibyx.setBackground(Color.DARK_GRAY);
			}
			public void mouseReleased(MouseEvent e) 
			{

				if(Historylbl.getText().isEmpty())
				{
				}
				else 
				{
					Pattern p = Pattern.compile("[0-9]");
					Matcher m = p.matcher(Expr.substring(Expr.length()-1, Expr.length()));
					if(m.find()) 
					{
						if(op.peek().equals("√")) 
						{
							flag=1;
						}
						else {
							Expr.delete(Expr.length()-Displaylbl.getText().length(), Expr.length());
							float a = Float.parseFloat(Displaylbl.getText());
							float temp= 1/a;
							Expr.append(temp+"   ");
							if(num.isEmpty() ) {}
							else if(!num.peek().equals(Displaylbl.getText())) {}
							else
							num.pop();
							num.add(""+temp);
							flag=1;
						}
					}
					else 
					{
						if(op.peek().equals("√")) 
						{
							flag=1;
						}
						else 
						if(Expr.charAt(Expr.length()-2)=='.') 
						{
							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							Expr.delete(Expr.length()-Displaylbl.getText().length(), Expr.length());
							float a = Float.parseFloat(Displaylbl.getText());
							float temp= 1/a;
							Expr.append(temp+"   ");
							if(num.isEmpty()) {}
							else if(!num.peek().equals(Displaylbl.getText())) {}
							else
							num.pop();
							num.add(""+temp);
							flag=1;
						}
						else {
							if(op.peek().equals("^")) 
							{
								flag=1;
							}
							else if(op.peek().equals("^^")) 
							{
								Expr.append(" + ");											
								op.push("+");
								flag=1;
							}
							else {

							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							Expr.deleteCharAt(Expr.length()-1);
							op.pop();
							Expr.delete(Expr.length()-Displaylbl.getText().length(), Expr.length());
							float a = Float.parseFloat(Displaylbl.getText());
							float temp= 1/a;
							Expr.append(temp+"   ");
							if(num.isEmpty()) {}
							else if(!num.peek().equals(Displaylbl.getText())) {}
							else
							num.pop();
							num.add(""+temp);
							flag=1;
							}
							}
					}
					
					Historylbl.setText(Expr.toString());
				}
			}

		});
		
		
		

		
		
		
	
		
		result = new JButton("=");
		OverPanel4.add(result,BorderLayout.AFTER_LAST_LINE);
		result.setHorizontalAlignment(JButton.CENTER);
		result.setBackground(Color.DARK_GRAY);
		result.setForeground(Color.white);
		result.setFont(new Font("Droid Sans", Font.PLAIN, 35));
		result.setFocusable(false);
		result.setPreferredSize(new Dimension(90, 70));
		result.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) 
			{
				result.setBackground(Color.GRAY);
			}
			public void mouseExited(MouseEvent e) 
			{				
				result.setBackground(Color.DARK_GRAY);
			}
		});

		
		
		OverLabel = new JLabel("");
		OverLabel.setSize(new Dimension(820, 510));		
		OverPanel1.add(OverLabel);
		OverLabel.setPreferredSize(new Dimension(618, 401));
		OverLabel.setIcon(image);
		f1.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		ColorGlide cg = new ColorGlide();
		cg.start();
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				new Calculator();
			}
		});

	
	}
}

/*
 * if(num.size()>1) 
				{
					if(num.get(num.size()-1).contains(".") || num.get(num.size()-2).contains(".")) {
						Float n1= Float.parseFloat(num.pop());
						Float n2= Float.parseFloat(num.pop());
					
						if(String.format("%.2f", n1+n2).endsWith("00"))
						{
							Displaylbl.setText(Integer.parseInt(n1+n2+"")+"");
							num.push(n1+n2+"");
						}
						else 
						{
							Displaylbl.setText((float)n1+n2+"");
							num.push(n1+n2+"");
						}
					}
				
					else 
					{
						Integer n1= Integer.parseInt(num.pop());
						Integer n2= Integer.parseInt(num.pop());
						Displaylbl.setText(n1+n2+"");	
						num.push(n1+n2+"");
					}
					flag=1;
				}
				else
				Displaylbl.setText("");

*/



import java.util.Scanner;

interface words
{
	 String getword();
	
}
class basic_words implements words
{
	public String getword()
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter worrd in uppercase");
		String str=sc.nextLine();
		return str;
	}
}

 class Lower implements words
{
	 public words w;
	 public Lower(words w)
	 {
		 this.w=w;
	 }
	 
	// w.getword();
	public String getword() {
		
		//w.getword();
		return convertlower(w);
	}
	public String convertlower( words w)
	{
		//System.out.println("converted to Lower:"+w.getword().toLowerCase());
		return w.getword().toLowerCase();
	}
}

public class ass2 {

	public static void main(String[] args) {

		words c=new basic_words();
	//	Shape r=new Rectangle();
		
		words rc=new Lower(c);
		

		System.out.println("Lower:"+rc.getword());
//		
//		
	}

}

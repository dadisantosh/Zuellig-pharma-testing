
package utility;

public class T {

	  static int i,c=0;
	    static int wordcount(String s)
	    {
	        char ch[]= new char[s.length()];
	        for(i=0;i<s.length();i++)
	        {
	            ch[i]= s.charAt(i);
	            if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )
	            c++;
	        }
	        return c;
	    }
	    
	    public static void main (String args[])
	    {
	        int count =T.wordcount("   kunal  works      at incture   ");
	      
	        
	        System.out.println("count = "+count );
	    }
	
	}


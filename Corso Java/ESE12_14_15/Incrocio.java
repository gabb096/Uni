import java.util.Random;

public class Incrocio
  {
	Random ran = new Random();
	  public String generaTarga() 
	  {
		  int a = 0;
		  a = ran.nextInt(999);
		  if(a<100)
		   return "RM 0"+ a;
		  else
			  return "RM "+ a;
	  }
  }
	
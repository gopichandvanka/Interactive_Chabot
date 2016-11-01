import java.util.HashMap;
import java.util.Scanner;

public class BotConsole {
	
	
	public static void main(String args[])
	{
		FactoryEnterpriseBot botFactory=new FactoryEnterpriseBot();
		ParsingHelper parseHelper = new ParsingHelper();
	    Scanner s=new Scanner(System.in);
	    String input=parseHelper.cleanSentence(s.nextLine());
	    String taggedSentence=parseHelper.getTaggedSentence(input);
	  	HashMap taggedMap= parseHelper.getTaggedMap(input, taggedSentence);
	    String allWordsSingular=parseHelper.changePularToSingular(botFactory.getChatSession(), input, taggedMap);
	    String lamatizedInput=parseHelper.getLamatizedforWord(taggedMap, allWordsSingular);
	    
	    System.out.println(lamatizedInput);
	    
	}

}

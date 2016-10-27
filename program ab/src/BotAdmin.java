import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;
import java.util.Scanner;

import org.alicebot.ab.*;
import edu.stanford.nlp.*;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class BotAdmin {
	
	public static void synset(){
		WordNetUtils wordnet = new WordNetUtils();
		wordnet.getSynsets("pending");
	}
	public static void main(String args[]){
		String botname="alice"; 
		String path = "C:/Users/JRAMLAL/Desktop/NLP/program-ab";
		Bot bot = new Bot(botname, path);
	    Chat chatSession1 = new Chat(bot);
		Scanner scr = new Scanner(System.in);
		while(true){
			System.out.print("Please type: ");
			String request = scr.nextLine();
			
			//for(int i=0;i<tokenizeRequest.length;i++){
			request = request.replaceAll("(?:'(?:[tdsm]|[vr]e|ll))+\\b", "");
			request = request.replaceAll("[,.;'\"?]","");
	        //}
	        
	        
	        System.out.println(request);
	        String POSSentence="";
			MaxentTagger tagger = new MaxentTagger("english-left3words-distsim.tagger");
			List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new StringReader(request));
		    for (List<HasWord> sentence : sentences) {
		        List<TaggedWord> tSentence = tagger.tagSentence(sentence);
		        POSSentence = Sentence.listToString(tSentence, false);
		    }
		    System.out.println(POSSentence);
		    String tokenizeRequest[] = request.split("\\s+");
		    String tokenizePOS[] = POSSentence.split("\\s+");
			for(int i = 0;i<tokenizeRequest.length;i++){
				String tagsplit[] = tokenizePOS[i].split("/");
				if(tagsplit[0].trim().equals(tokenizeRequest[i].trim())){
					if(tagsplit[1].equals("JJ")||tagsplit[1].equals("JJR")||tagsplit[1].equals("JJS")||tagsplit[1].equals("NN")||tagsplit[1].equals("NNP")||tagsplit[1].equals("NNS")||tagsplit[1].equals("NNPS")||tagsplit[1].equals("RB")
							||tagsplit[1].equals("RBR")||tagsplit[1].equals("RBS")||tagsplit[1].equals("VB")||tagsplit[1].equals("VBD")||tagsplit[1].equals("VBG")||tagsplit[1].equals("VBN")||tagsplit[1].equals("VBP")||tagsplit[1].equals("VBZ")){
			            String ans = chatSession1.multisentenceRespond("root word of " + tokenizeRequest[i].trim());
			            if(!ans.equalsIgnoreCase("unknown"))
			                tokenizeRequest[i] = ans;
					}
				}
	        }
	
//	        StringBuilder builder = new StringBuilder();
//	        for(String s : tokenizeRequest) {
//	            builder.append(s);
//	            builder.append(" ");
//	        }
//	        request = builder.toString();
		}
	}
}

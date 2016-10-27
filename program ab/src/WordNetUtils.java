
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;
import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.AdjectiveSynset;

public class WordNetUtils {
    private static WordNetDatabase wordNetDatabase;

    public WordNetUtils() {
        System.setProperty("wordnet.database.dir", "C:\\Program Files (x86)\\WordNet\\2.1\\dict");
        wordNetDatabase = WordNetDatabase.getFileInstance();
    }

    public void getSynsets(String word) {
    	Synset[] textSynsets = wordNetDatabase.getSynsets(word, SynsetType.ADJECTIVE);
    	
    	AdjectiveSynset nounSynset = (AdjectiveSynset) textSynsets[0];
    	
    	NounSynset[] wordForms = nounSynset.getUsages();
//        for(Synset synset : textSynsets) {
//            String[] wordForms = synset.getWordForms();
//            int count = 0;
//            for(String w : wordForms) {
//                System.out.println(w);
//            	count++;
//            }
//        }
    	
    	for(String s: wordForms[0].getWordForms()){
    		System.out.println(s);
    	}
    }

}

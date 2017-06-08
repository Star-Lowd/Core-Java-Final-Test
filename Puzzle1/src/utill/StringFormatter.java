package utill;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringFormatter {
	String input = "";
	private static final String REGEX = "/";
	public StringFormatter(String input) {
		this.input  = input ;
	}

	private List<String> castStringToList(){
		List<String> tokensAndText = new ArrayList<>();
		StringTokenizer tokenizer = new StringTokenizer(input, REGEX, true);
		while(tokenizer.hasMoreTokens()){
			tokensAndText.add(tokenizer.nextToken());
		}
		return tokensAndText;
		
	}
	
	public String toUnix(){
		String unixCommand = "";
		Object[] inputs = castStringToList().toArray();
		
		for(int a = 0 ; a < inputs.length; a++){
			switch (inputs[a].toString()) {
			case "/":
				unixCommand += inputs[a];
				break;
			case "//":
				unixCommand += "/";
				break;
			case "..":{
				unixCommand = unixCommand.replaceAll(inputs[a-2]+"/", "");
				break;
			}
			case "." : {
				unixCommand += "";
				break;
			}
			default:
				unixCommand += inputs[a];
			}
		}
		unixCommand = unixCommand.replaceAll("//", "/");
		unixCommand = unixCommand.replaceAll("//", "/");
		return unixCommand;
	}
	
	
}

package utill;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class NumberToString {
	
	private int number ;
	private static final Map<Integer , String> MapDatas ;
	static{
		MapDatas = new HashMap<>();
		MapDatas.put(1, "one");
		MapDatas.put(2, "two");
		MapDatas.put(3, "three");
		MapDatas.put(4, "four");
		MapDatas.put(5, "five");
		MapDatas.put(6, "six");
		MapDatas.put(7, "seven");
		MapDatas.put(8, "eight");
		MapDatas.put(9, "nine");
		
		//number greater than 1 string length
		MapDatas.put(20, "twenty");
		MapDatas.put(30, "thirty");
		MapDatas.put(40, "fourty");
		MapDatas.put(50, "fifty");
		MapDatas.put(60, "sixty");
		MapDatas.put(70, "seventy");
		MapDatas.put(80, "eighty");
		MapDatas.put(90, "ninety");
		//11 numbers
		MapDatas.put(11, "eleven");
		MapDatas.put(12, "twelve");
		MapDatas.put(13, "thirteen");
		MapDatas.put(14, "fourtheen");
		MapDatas.put(15, "fiveteen");
		MapDatas.put(16, "sixteen");
		MapDatas.put(17, "seventeen");
		MapDatas.put(18, "eighteen");
		MapDatas.put(19, "nineteen");
	}
	
	NumberToString(int number){
		this.number = number ;
	}
	
	private List<String> toListArray (){
		return Arrays.asList((number+"").split(""));
	}
	private static String toEnglishLengthTwo(int input){
		String text = input+"";
		String englishFormat = "";
		englishFormat += MapDatas.get(Integer.parseInt(text.charAt(0)+"0"))+" ";
		englishFormat += MapDatas.get(Integer.parseInt(text.charAt(1)+""))+" ";
		return englishFormat;
	}
	
	private static String toEnglishLengthFourFive(int input){
		String text = input+"";
		String englishFormat = "";
		String lengthThree = "";
		if (text.length() == 4){
			englishFormat = MapDatas.get(Integer.parseInt(text.charAt(0)+""))+" Thousand ";
			lengthThree = text.charAt(1)+""+text.charAt(2)+text.charAt(3);
		}
		else if (text.length() == 5){
			englishFormat = MapDatas.get(Integer.parseInt(text.charAt(0)+""+text.charAt(1))) + " Thousand ";
			lengthThree = text.charAt(2)+""+text.charAt(3)+text.charAt(4);
		}
		
		englishFormat += toEnglishLengthThree(Integer.parseInt(lengthThree));
		return englishFormat;
	}
	
	private static String toEnglishLengthSix(int input){
		String text = input+"";
		String englishFormat = "";
		
		if (text.length() == 6){
			String subNumber = "";
			englishFormat = MapDatas.get(Integer.parseInt(text.charAt(0)+""))+" Hundred ";
			subNumber = text.charAt(1)+""+text.charAt(2);
			
			englishFormat += toEnglishLengthTwo(Integer.parseInt(subNumber))+"Thousand ";
			subNumber = text.charAt(3)+""+text.charAt(4)+text.charAt(5);
			
			englishFormat += toEnglishLengthThree(Integer.parseInt(subNumber));
		}
		
		return englishFormat;
	}
	
	private static String toEnglishLengthSeven(int input){
		String text = input+"";
		String englishFormat = "";
		
		if (text.length() == 7){
			String subNumber = "";
			englishFormat = MapDatas.get(Integer.parseInt(text.charAt(0)+""))+" Million ";
			subNumber = text.replaceFirst(text.charAt(0)+"", "");
			//System.out.println(subNumber);
			englishFormat += toEnglishLengthSix(Integer.parseInt(subNumber));
		}
		
		return englishFormat;
	}
	
	private static String toEnglishLengthThree(int input){
		
		String text = input+"";
		String englishFormat = "";
		
		if (text.length() == 3){
			
			englishFormat = MapDatas.get(Integer.parseInt(text.charAt(0)+""))+" Hundrend ";
			englishFormat += MapDatas.get(Integer.parseInt(text.charAt(1)+"0"))+" ";
			englishFormat += MapDatas.get(Integer.parseInt(text.charAt(2)+""))+" ";
			
		}
		
		return englishFormat;
	}
	
	public static String numberToWord(int input){
		String inputs = input+"";
		String output = "";
		
		switch (inputs.length()) {
		case 7:
			output = toEnglishLengthSeven(input);
			break;
		case 6:
			output = toEnglishLengthSix(input);
			break;
		case 5:
			output = toEnglishLengthFourFive(input);
			break;
			
		case 4:
			output = toEnglishLengthFourFive(input);
			break;
		case 3:
			output = toEnglishLengthThree(input);
			break;
		case 2:
			output = toEnglishLengthTwo(input);
			break;
			
		case 1:
			output = MapDatas.get(Integer.parseInt(inputs));
			break;
		default:
			break;
		}
		return output;
	}
	
	public static void main(String[] args) {
		String out = NumberToString.numberToWord(13457);
		System.out.println(out);
	}
	
}

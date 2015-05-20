import java.util.HashMap;


public class main {

	public static void main(String[] args) {
		System.out.println(compress("abcabcaabc"));

	}
	static public String compress(String stream) {
		String tags="";
		HashMap<String, Integer> dictionary=new HashMap<String,Integer>();
		int tagnum=1;
		int current=0;
		String str="";
		while(current<stream.length()) {
			str+=stream.charAt(current);
			if(dictionary.get(str)==null) {
				if(str.length()==1){
					tags+="0"+"|";
					tags+=str+"|";
					dictionary.put(str, tagnum);
				}
				else{
					tags+=dictionary.get(str.substring(0,str.length()-1))+"|";
					dictionary.put(str, tagnum);
					tags+=str.charAt(str.length()-1)+"|";
				}
				str="";
				tagnum++;
			}
			current++;
		}
		return tags;
	}
}


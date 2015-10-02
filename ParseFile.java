import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

//AIM/Current Address/Email/Mobile/Land-Phone/Residence/School-Mailbox/Clubs/Windows-Live/Google-Talk/Yahoo/(Grad-school)/Emails/Detail/ICQ/skype/activities
public class ParseFile {

	ArrayList<String> keyList;
	HashMap<String,String> matchMap;
	MatchResult gResult;
	int musicCount;
	int movieCount;
	int tvCount;

	public HashMap<String,String> prepareParse(String inputFile){
		//keyList=new ArrayList<String>();
		matchMap=new HashMap<String,String>();
		//String example="D:\\My Documents\\Everything\\Java\\ParseJob\\cherry\\standard_with_php\\CSV_CMU_Visible_20071102.csv";
		gResult=null;
		musicCount=0;
		movieCount=0;
		tvCount=0;

		//Scanner scanner=new Scanner(new File(example));
		//String key=scanner.nextLine();
		//String[] keyArray=key.split(",");
		for(int i=0;i<keyList.size();i++){
			//keyList.add(keyArray[i]);
			matchMap.put(keyList.get(i),"<dt>"+keyList.get(i)+":</dt>");
		}
		matchMap.put("Gender","<dt>Sex:</dt>");
		matchMap.put("Interested-In", "<dt>Interested In:</dt>");
		matchMap.put("Music", "<dt>Favorite Music:</dt>");
		matchMap.put("Movies", "<dt>Favorite Movies:</dt>");
		matchMap.put("Books", "<dt>Favorite Books:</dt>");
		matchMap.put("About_me", "<dt>About Me:</dt>");
		matchMap.put("Tv", "<dt>Favorite TV Shows:</dt>");
		matchMap.put("Looking-For", "<dt>Looking For:</dt>");
		matchMap.put("Time-Period", "<dt>Time Period:</dt>");
		matchMap.put("Grad-School", "<dt>Grad School:</dt>");
		matchMap.put("High-Schools", "<dt>High Schools:</dt>");
		matchMap.put("siblings", "<dt>Siblings:</dt>");
		matchMap.put("parents", "<dt>Parents:</dt>");
		matchMap.put("reveal_partner", "<dt>Relationship Status:</dt>");
		//matchMap.put("Friends", "<h5 class=\"box_header UITitle UITitle_h5\">Friends</h5>");


		HashMap<String,String> map=new HashMap<String,String>();
		String fileName=inputFile.substring(87);
		String fileLoc="/opt/facebook/raw_files/2010/20100101-rev/cmu/visible/"+fileName;
		map.put("File Loc", fileLoc);
		matchMap.remove("File Loc");
		map.put("From", "CMU");
		matchMap.remove("From");
		map.put("Visible", "yes");
		matchMap.remove("Visible");
		map.put("UserID", fileName.split("\\.")[0]);
		System.out.println("UserID"+map.get("UserID"));
		matchMap.remove("UserID");
		return map;
	}
	public ParseFile(){
		keyList=new ArrayList<String>();
		matchMap=new HashMap<String,String>();
		String example="D:\\My Documents\\Everything\\Java\\ParseJob\\cherry\\standard_with_php\\CSV_CMU_Visible_20071102.csv";
		try {
			Scanner scanner=new Scanner(new File(example));
			String key=scanner.nextLine();
			String[] keyArray=key.split(",");
			for(int i=0;i<keyArray.length;i++){
				keyList.add(keyArray[i]);
				matchMap.put(keyArray[i],"<dt>"+keyArray[i]+":</dt>");
			}
			matchMap.put("Gender","<dt>Sex:</dt>");
			matchMap.put("Interested-In", "<dt>Interested In:</dt>");
			matchMap.put("Music", "<dt>Favorite Music:</dt>");
			matchMap.put("Movies", "<dt>Favorite Movies:</dt>");
			matchMap.put("Books", "<dt>Favorite Books:</dt>");
			matchMap.put("About_me", "<dt>About Me:</dt>");
			matchMap.put("Tv", "<dt>Favorite TV Shows:</dt>");
			matchMap.put("Looking-For", "<dt>Looking For:</dt>");
			matchMap.put("Time-Period", "<dt>Time Period:</dt>");
			matchMap.put("Grad-School", "<dt>Grad School:</dt>");
			matchMap.put("High-Schools", "<dt>High Schools:</dt>");
			matchMap.put("siblings", "<dt>Siblings:</dt>");
			matchMap.put("parents", "<dt>Parents:</dt>");
			matchMap.put("reveal_partner", "<dt>Relationship Status:</dt>");
			//matchMap.put("Friends", "<h5 class=\"box_header UITitle UITitle_h5\">Friends</h5>");
			keyList.add("Friends");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public HashMap<String,String> parse(String inputFile){
		Scanner scanner=null;
		HashMap<String,String> map=new HashMap<String,String>();
		map=this.prepareParse(inputFile);
		String line=null;
		String value=null;

		try {
			map.put("Name", this.parseName(inputFile));
			matchMap.remove("Name");
			File f=new File(inputFile);
			scanner = new Scanner(f);
			Object[] matchKey=matchMap.keySet().toArray();
			int lnumber=0;
			while(scanner.hasNextLine()){
				lnumber++;
				line=scanner.nextLine();
				/*if(lnumber==38){
					String testLine=scanner.nextLine();
				}*/
				for(int i=0;i<matchMap.size()||i<matchKey.length;i++){
					/*if(lnumber==51){
						System.out.println(lnumber);
					}*/
					/*if(lnumber==51&&matchKey[i].toString().contains("Grad-School")){
						System.out.println(lnumber+":"+"Grad School");
					}*/
					if(matchMap.containsKey(matchKey[i])){
						if(line.contains(matchMap.get(matchKey[i]))){
							value=this.parseValue(line,matchMap.get(matchKey[i]),lnumber,f);
							map.put(matchKey[i].toString(), value);
							matchMap.remove(matchKey[i]);
						}
					}
				}
				matchMap.keySet().toArray(matchKey);

				//For Friend parsing
				String friendKey="<h5 class=\"box_header UITitle UITitle_h5\">Friends</h5>";
				if(line.contains(friendKey)){
					map.put("Friends", this.parseFriends(line, friendKey,lnumber,f));
				}
			}
			map.put("music_count", String.valueOf(musicCount));
			map.put("music_word_count", this.wordCount(map.get("Music")));
			map.put("movies_count", String.valueOf(movieCount));
			map.put("movies_word_count", this.wordCount(map.get("Movies")));
			map.put("tv_count", String.valueOf(tvCount));
			map.put("tv_word_count", this.wordCount(map.get("Tv")));
			map.put("declared_fields_count", this.parseFieldsCount(map));

		} catch(FileNotFoundException e) {
			System.err.println("Cannot find the file");
		} finally {
			if(scanner!= null) scanner.close();
		}
		return map;

	}

	public String wordCount(String str){
		if(str==null){
			return String.valueOf(0);
		}
		int count=0;
		str=str.replace("#@", " ");
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==' '){
				count++;
			}
		}
		System.out.println(count);
		return String.valueOf(count);
	}
	public String parseFieldsCount(HashMap<String,String> map){
		int count=0;
		for(int i=0;i<map.size();i++){
			if(map.get(keyList.get(i))!=null&&!keyList.get(i).equals("0")){
				count++;
			}
		}
		System.out.println(count);
		return String.valueOf(count);
	}
	public String parseFriends(String line,String keyMatch, int lnumber, File f) throws FileNotFoundException{
		Scanner scanner=new Scanner(line);
		scanner.findInLine(keyMatch+".*</a>");
		MatchResult result=null;
		String value=null;

		try{
		result=scanner.match();
		}catch(IllegalStateException e){
			result=this.illegalStateExceptionHanddle(lnumber, keyMatch+".*</a>",line,f);
			gResult=null;
		}
		
		if(result==null){
			return null;
		}
		value=result.group(0);

		if(value.contains("</a>")){
			value=value.substring(0, value.indexOf("</a>"));
			value=value.substring(value.lastIndexOf(">")+1,value.length()-8);
		}

		value=value.replace(",", "#@");
		System.out.println("Friends:"+value);
		return value;
	}

	public String parseValue(String line,String keyMatch,int lnumber,File f) throws FileNotFoundException{
		if(keyMatch.contains("Grad School")){
			System.out.println("Grad School");
		}
		String value=null;
		String temp1=null;
		String temp2="";
		String temp3="";
		Scanner scanner=new Scanner(line);
		scanner.findInLine(keyMatch+".*</dd>");
		MatchResult result=null;
		/*ArrayList<String> specialStr=new ArrayList<String>();
		specialStr.add("</li>");
		specialStr.add("</a>");*/

		try{
			result=scanner.match();
		}catch(IllegalStateException e){
			result=this.illegalStateExceptionHanddle(lnumber, keyMatch+".*</dd>",line,f);
			gResult=null;
		}


		//String result1=result.group(0);
		if(result==null){
			return null;
		}
		scanner=new Scanner(result.group(0));
		scanner.findInLine("<dd>.*</dd>");
		result=scanner.match();
		value=result.group(0).substring(4, result.group(0).length()-5);

		if(value.contains("</dd>")){
			value=value.substring(0, value.indexOf("</dd>"));
		}

		value=value.replaceAll("<br\\s*/>", "#@");

		/*if(value.contains("</li>")){
			scanner=new Scanner(value).useDelimiter("</li>");
			while(scanner.hasNext()){
				temp1=scanner.next();
				temp1=temp1.substring(temp1.indexOf("<li>")+1);
				temp2=temp2+temp1;
			}
			value=temp2;
			temp1=null;
			temp2="";
		}*/
		int count=0;
		if(value.contains("<span>")&&keyMatch.equals("<dt>Relationship Status:</dt>")&&matchMap.containsKey("Relationship Status")){
			scanner=new Scanner(value);
			scanner.findInLine("<span>.*<a");
			result=scanner.match();
			value=result.group(0).substring(6,result.group(0).length()-2);
		}

		if(value.contains("</a>")){
			scanner=new Scanner(value).useDelimiter("</a>");
			while(scanner.hasNext()){
				temp1=scanner.next();
				/*char lala=temp1.charAt(temp1.lastIndexOf("<li>")+4);
				if(temp1.charAt(temp1.lastIndexOf("<li>")+4)!='<'){
					Scanner tempS=new Scanner(temp1);
					tempS.findInLine("<li>.*<a");
					temp3=tempS.match().group(0);
				}*/
				temp1=temp1.substring(temp1.lastIndexOf(">")+1)+"#@";
				temp2=temp2+temp1;
				count++;
			}
			value=temp2;
			temp2="";
		}


		if(keyMatch.equals("<dt>Favorite Music:</dt>")){
			musicCount=count;
			System.out.println("musicCount"+musicCount);
		}

		if(keyMatch.equals("<dt>Favorite Movies:</dt>")){
			movieCount=count;
			System.out.println("movieCount:"+movieCount);
		}

		if(keyMatch.equals("<dt>Favorite TV Shows:</dt>")){
			tvCount=count;
			System.out.println("tvCount:"+tvCount);
		}
		count=0;
		value=value.replace(",", "#@");

		while(value.endsWith("#@")){
			value=value.substring(0, value.length()-2);
		}

		System.out.println(keyMatch+":"+value);
		return value;
	}

	public MatchResult illegalStateExceptionHanddle(int lnumber,String matchStr,String line,File f) throws FileNotFoundException{
		Scanner scanner1=new Scanner(f);
		int number=0;
		while(number<lnumber){
			scanner1.nextLine();
			number++;
		}
		//String testLine=scanner1.nextLine();
		Scanner scanner2=new Scanner(line);

		scanner2.findInLine(matchStr);
		MatchResult result=null;
		try{
			result=scanner2.match();
		}catch(IllegalStateException e){
			//testLine=scanner1.nextLine();
			if(scanner1.hasNextLine()){
				line=line+scanner1.nextLine();
				lnumber++;
				this.illegalStateExceptionHanddle(lnumber, matchStr,line,f);
			}

		}
		if(result!=null){
			String a=result.group(0);
			gResult=result;
		}
		return gResult;
	}

	public void writeToFile(HashMap<String,String> map,File file){

		FileOutputStream out;
		StringBuffer header=new StringBuffer();
		StringBuffer value=new StringBuffer();
		StringBuffer context=new StringBuffer();

		try {
			out = new FileOutputStream(file);
			OutputStreamWriter osw;
			osw = new OutputStreamWriter(out, "UTF8");

			BufferedWriter bw = new BufferedWriter(osw);

			for(int i=0;i<keyList.size();i++){
				header.append(keyList.get(i)+",");
				value.append(map.get(keyList.get(i))+",");
			}
			header.append("\r\n");
			value.append("\r\n");
			context=header.append(value);
			bw.write(context.toString());

			bw.close();
			osw.close();
			out.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getHeader(){
		StringBuffer header=new StringBuffer();
		for(int i=0;i<keyList.size();i++){
			header.append(keyList.get(i)+",");
		}
		header.append("\r\n");
		return header.toString();
	}

	public String getValue(HashMap<String,String> map){
		StringBuffer value=new StringBuffer();
		for(int i=0;i<keyList.size();i++){
			value.append(map.get(keyList.get(i))+",");
		}
		value.append("\r\n");
		return value.toString();
	}

	public void writeHeader(File file){
		FileOutputStream out;
		StringBuffer header=new StringBuffer();
		StringBuffer value=new StringBuffer();
		StringBuffer context=new StringBuffer();

		try {
			out = new FileOutputStream(file);
			OutputStreamWriter osw;
			osw = new OutputStreamWriter(out, "UTF8");

			BufferedWriter bw = new BufferedWriter(osw);

			for(int i=0;i<keyList.size();i++){
				header.append(keyList.get(i)+",");
			}
			header.append("\r\n");
			context=header.append(value);
			bw.write(context.toString());

			bw.close();
			osw.close();
			out.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String parseName(String inputFile) throws FileNotFoundException{
		//Pattern pattern=Pattern.compile("<title>(\\D)*</title>");
		Scanner scanner=new Scanner(new File(inputFile));
		Pattern pattern=Pattern.compile(".title.");
		scanner.useDelimiter(pattern);
		String name=null;
		int i=0;
		while(scanner.hasNext()){
			i++;
			String key = scanner.next();
			if(i==2){
				name=key;
			}
		}
		if(name ==null){
			System.out.println("Stop");
		}
		name=name.substring(10, name.length()-1);
		//System.out.println(name);
		return name;
	}

	public void printTest(HashMap<String,String> map){
		for(int i=0;i<map.size();i++){
			String key=(String) map.keySet().toArray()[i];
			System.out.println(key+":"+map.get(key));
		}
	}

	public boolean checkFile(String f){
		Scanner s=null;
		try {
			s = new Scanner(new File(f));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(s==null){
			return false;
		}
		return s.hasNextLine();
	}
	public static void main(String[] args){
		ParseFile parseFile=new ParseFile();
		String outFile="d:/CSV_CMU_Visible_20100101.csv";
		File file = new File(outFile);

		FileOutputStream out;
		String header=null;
		String path="D:\\My Documents\\Everything\\Java\\ParseJob\\cherry\\what you need to work on\\20100101_0000";
		//String path="D:\\My Documents\\Everything\\Java\\ParseJob\\cherry\\test";
		//String path="D:\\My Documents\\Everything\\Java\\ParseJob\\cherry\\what you need to work on\\20100101\\20100101_0000";
		File rootDir=new File(path);
		String[] fileList=rootDir.list();

		try {
			out = new FileOutputStream(file);
			OutputStreamWriter osw;
			osw = new OutputStreamWriter(out, "UTF8");

			BufferedWriter bw = new BufferedWriter(osw);

			header=parseFile.getHeader();
			bw.write(header);

			for(int i=0;i<fileList.length;i++){
				String inputFile=rootDir.getAbsolutePath()+"\\"+fileList[i];
				if(!parseFile.checkFile(inputFile)){
					continue;
				}
				HashMap<String,String> map=parseFile.parse(inputFile);
				bw.write(parseFile.getValue(map));
			}

			bw.close();
			osw.close();
			out.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		/*String inputFile="D:\\My Documents\\Everything\\Java\\ParseJob\\cherry\\what you need to work on\\20100101_0000\\1381500068.html";
		//String inputFile="D:\\My Documents\\Everything\\Java\\ParseJob\\cherry\\what you need to work on\\20100101\\20100101_0000\\584459982.html";
		HashMap<String,String> map=parseFile.parse(inputFile);
		parseFile.writeToFile(map,file);*/

	}
}

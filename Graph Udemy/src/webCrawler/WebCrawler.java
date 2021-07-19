package webCrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
	
	private Queue<String> queue;
	private List<String> discoveredWebsites;

	public WebCrawler(){
		this.queue=new LinkedList<>();
		this.discoveredWebsites=new ArrayList<>();
	}
	
	public void discoverWeb(String root){
		String regExp="http://(\\w+\\.)*(\\w+)";
		Pattern pattern=Pattern.compile(regExp);
		this.queue.add(root);
		this.discoveredWebsites.add(root);
		while(!queue.isEmpty()){
			String temp=queue.poll();
			String rawHTML=readURL(temp);
			Matcher matcher=pattern.matcher(rawHTML);
			while(matcher.find()){
				String actualURL=matcher.group();
				if(!discoveredWebsites.contains(actualURL)){
					discoveredWebsites.add(actualURL);
					System.out.println("Website has been found with URL : "+actualURL);
					queue.add(actualURL);
				}
			}
		}
	}
	
	private String readURL(String temp){
		String rawHTML="";
		try{
			URL url=new URL(temp);
			BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine="";
			while((inputLine=br.readLine())!=null){
				rawHTML+=inputLine;
			}
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return rawHTML;
	}
	
}

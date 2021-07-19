package webCrawler;

public class Application {
	
	public static void main(String[] args) {
		WebCrawler crawler=new WebCrawler();
		String rootURL="http://www.google.com";
		crawler.discoverWeb(rootURL);
	}

}

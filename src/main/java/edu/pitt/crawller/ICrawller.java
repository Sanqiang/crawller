package edu.pitt.crawller;

public interface ICrawller {
	
	public String getNextUrl();

	public String getFirstUrl();

	public String getLastUrl();

	public void crawlToFile();
	
	public String processFile(String data);
	
	public boolean hasNextPage();
}

package edu.pitt.crawller;

import org.json.JSONArray;
import org.json.JSONObject;

public class CNETCrawller extends AbstractCrawller {

	String _siteId = "311569";
	boolean _is_reach_last;

	public CNETCrawller(String product_id) {
		this._page = 0;
		this._product_id = product_id;
		this._is_reach_last = false;
	}

	public String getNextUrl() {
		return getUrl(this._page++);
	}

	public String getFirstUrl() {
		return getNextUrl();
	}

	public String getLastUrl() {
		return getUrl(-1);
	}

	public void crawlToFile() {
		String json = RequestUtility.getResponse(getFirstUrl());
		// TODO page operation
	}

	public boolean hasNextPage() {
		return this._is_reach_last;
	}

	public String processFile(String data) {
		JSONObject main_obj = new JSONObject();
		
		JSONArray content_arr = main_obj.getJSONObject("headDocument").getJSONArray("content");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < content_arr.length(); i++) {
			JSONObject review_obj = content_arr.getJSONObject(i);
			String bodyHtml = review_obj.getString("bodyHtml");
			long createdAt = review_obj.getLong("createdAt");
			sb.append(bodyHtml).append("\t").append(createdAt).append("\n");
			
			//TODO json format unclear
		}
		return sb.toString();
	}

	private String getUrl(int page) {
		// init/last page when page = -1
		if (page == -1) {
			return "http://bootstrap.cnet.fyre.co/bs3/v3.1/cnet.fyre.co/" + this._siteId + "/" + this._product_id
					+ "/init";
		} else {
			return "http://bootstrap.cnet.fyre.co/bs3/v3.1/cnet.fyre.co/" + this._siteId + "/" + this._product_id + "/"
					+ this._page++ + ".json";
		}
	}

}

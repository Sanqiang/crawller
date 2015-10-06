package edu.pitt.crawller;

public abstract class AbstractCrawller implements ICrawller {
	protected String _product_id;
	protected int _page;
	protected String _path_storage;

	public int getPage() {
		return this._page;
	}

	public String getProductId() {
		return this._product_id;
	}

	public void setProductId(String product_id) {
		this._product_id = product_id;
	}

	public String getPathStorage() {
		return this._path_storage;
	}
}

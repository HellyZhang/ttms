package cn.tedu.ttms.common.entity;

public class PageObject {
	/**
	 * 当前页面
	 */
	private int pageCurrent = 1;
	/**
	 * 每页显示记录数
	 */
	private int pagesSize = 2;
	/**
	 * 页面总数
	 */
	private int pagesCount;
	/**
	 * 起始记录
	 */
	private int startCount;
	/**
	 * 记录总数
	 */
	private int rowCount;

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getPagesSize() {
		return pagesSize;
	}

	public void setPagesSize(int pagesSize) {
		this.pagesSize = pagesSize;
	}

	public int getPagesCount() {
		pagesCount = rowCount / pagesSize;
		if (rowCount % pagesSize != 0) {
			pagesCount++;
		}
		return pagesCount;
	}

	public void setPagesCount(int pages) {
		this.pagesCount = pages;
	}

	public int getStartCount() {
		startCount = (this.pageCurrent - 1) * pagesSize;
		return startCount;
	}

	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	@Override
	public String toString() {
		return "PageObject [pageCurrent=" + pageCurrent + ", pagesSize=" + pagesSize + ", pagesCount=" + pagesCount
				+ ", startCount=" + startCount + ", rowCount=" + rowCount + "]";
	}

}

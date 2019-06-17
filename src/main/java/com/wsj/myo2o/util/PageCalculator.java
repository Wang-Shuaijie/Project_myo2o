package com.wsj.myo2o.util;
/**
 * 计算当前记录数以及总页数
 * @author WangShuaiJie
 *
 */
public class PageCalculator {

	public static int calculatePageCount(int totalCount, int pageSize) {
		int idealPage = totalCount / pageSize;
		int totalPage = (totalCount % pageSize == 0) ? idealPage : (idealPage + 1);
		return totalPage;
	}

	public static int calculateRowIndex(int pageIndex, int pageSize) {
		return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
	}
}


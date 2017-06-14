package kr.groupware.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Paging
{
	private int					totalArticles;

	private int					currentPage;

	private int					showPages;

	private int					articlesPerPage;

	private int					limitStart;

	private int					startPage;

	private int					lastPage;

	private int					prevPage;

	private int					nextPage;

	private int					prevBlock;

	private int					nextBlock;

	@JsonIgnore
	private Map<String, Object> searchData	= null;

	public Paging ()
	{
	}

	public Paging (int currentPage, int showPages, int articlesPerPage)
	{
		this.totalArticles = 0;

		if (currentPage == 0)
			currentPage = 1;

		this.currentPage = currentPage;
		this.showPages = showPages;
		this.articlesPerPage = articlesPerPage;
		this.limitStart = (currentPage - 1) * articlesPerPage;
	}

	public Paging (int currentPage, int showPages, int articlesPerPage,
				   Map<String, Object> searchData)
	{
		this (currentPage, showPages, articlesPerPage);

		this.searchData = searchData;
	}

	public Paging (int totalArticles, int currentPage, int showPages,
				   int articlesPerPage)
	{
		this.totalArticles = totalArticles;
		this.currentPage = currentPage;
		this.showPages = showPages;
		this.articlesPerPage = articlesPerPage;

		settingPagingData();
	}

	public void setTotalArticles (int val)
	{
		this.totalArticles = val;

		settingPagingData();
	}

	protected void settingPagingData()
	{
		// startPage
		this.startPage = this.currentPage - (this.currentPage - 1)
			% this.showPages;

		// lastPage
		this.lastPage = (int) Math.ceil ((double) this.totalArticles
			/ this.articlesPerPage);
		if (this.lastPage <= 0)
			this.lastPage = 1;

		// prevPage
		if (this.currentPage == 1)
			this.prevPage = 1;
		else
			this.prevPage = this.currentPage - 1;

		// nextPage
		if (this.currentPage == this.lastPage)
			this.nextPage = this.lastPage;
		else
			this.nextPage = this.currentPage + 1;

		// prevBlock
		this.prevBlock = this.currentPage - (this.currentPage - 1)
			% this.showPages - this.showPages;

		// nextBlock
		this.nextBlock = this.currentPage - (this.currentPage - 1)
			% this.showPages + this.showPages;
	}

	/**
	 * iBatis 에 넘기기 위한 map 객체로 만든다.
	 *
	 * @return : 검색 데이터가 포함된 map
	 */
	public Map<String, Object> makeMap ()
	{
		Map<String, Object> mapData = new HashMap<> ();

		mapData.put ("limitStart", limitStart);
		mapData.put ("articlesPerPage", articlesPerPage);
		mapData.put ("showPages", showPages);
		mapData.put ("currentPage", currentPage);
		mapData.put ("totalArticles", totalArticles);
		mapData.put ("isList", "T");

		// 검색 조건이 NULL 이 아니면 검색조건을 추가한다.
		if (searchData != null) {
			mapData.putAll(searchData);
		}
//		if(sortData != null){
//			mapData.putAll(sortData);
//		}
		return mapData;
	}

	/**
	 * iBatis 에 넘기기 위한 map 객체로 만든다. (Count 용)
	 *
	 * @return 맵객체
	 */
	public Map<String, Object> makeCntMap ()
	{
		return (searchData != null) ? searchData : new HashMap<> ();
	}
}

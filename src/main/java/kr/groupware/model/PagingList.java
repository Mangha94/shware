package kr.groupware.model;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PagingList<T>
{

	private List<T>	listData	= null;

	private Paging	paging;

	public List<T> getListData() {
		return listData;
	}

	public void setListData(List<T> listData) {
		this.listData = listData;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	public PagingList ()
	{
	}

	public PagingList (List<T> listData, Paging paging)
	{
		this.listData = listData;
		this.paging = paging;
	}
}

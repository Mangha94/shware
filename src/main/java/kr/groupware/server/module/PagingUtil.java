package kr.groupware.server.module;

import java.util.Collection;
import java.util.List;

/**
 * Created by purre on 2017-06-11.
 */
public class PagingUtil
{
	/**
	 * 페이징의 현재 번호를 리턴한다.
	 * @param totalArticle : 전체 데이터 수
	 * @param articlePerPage : 한페이지 표수 데이터 수
	 * @param currentPage : 현재 페이지
	 * @param nowIdx : 현재 Index (1 부터 시작함)
	 * @return
	 */
	public static int num (int totalArticle, int articlePerPage, int currentPage, int nowIdx)
	{
		nowIdx = nowIdx - 1;

		return totalArticle - nowIdx - (articlePerPage * (currentPage - 1));
	}

	/**
	 * 컬랙션의 사이즈를 리턴한다.
	 * @param col : 컬랙션
	 * @return : 사이즈
	 */
	public static int size (Collection<?> col)
	{
		return col.size ();
	}

	public static int size (List<?> list)
	{
		return list.size ();
	}
}

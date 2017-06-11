package kr.groupware.server.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import kr.groupware.server.module.PagingUI;

/**
 * Created by purre on 2017-06-11.
 */
public class PagingTag extends TagSupport
{
	private PagingUI paging;

	public PagingTag ()
	{
		paging = new PagingUI ();
	}

	@Override
	public int doStartTag () throws JspException
	{
		try
		{
			if (pageContext != null)
				pageContext.getOut ().print (paging.makeHtml ());
		}
		catch (IOException e)
		{
			e.printStackTrace ();
		}

		return SKIP_BODY;
	}

	public void setCurrentPage (int currentPage)
	{
		paging.setCurrentPage (currentPage);
	}

	public void setTotalArticles (int totalArticles)
	{
		paging.setTotalArticles (totalArticles);
	}

	public void setShowPages (int showPages)
	{
		paging.setShowPages (showPages);
	}

	public void setArticlesPerPage (int articlesPerPage)
	{
		paging.setArticlesPerPage (articlesPerPage);
	}

	public void setNextPage (int nextPage)
	{
		paging.setNextPage (nextPage);
	}

	public void setFuncName (String funcName)
	{
		paging.setFuncName (funcName);
	}
}

package kr.groupware.server.module;

import kr.groupware.model.Paging;
import kr.groupware.model.SearchData;
import kr.groupware.model.member.MemberSearchData;

/**
 * Created by purre on 2017-06-11.
 */
public class PagingUI {
    protected int currentPage;
    protected int totalArticles;
    protected int showPages;
    protected int articlesPerPage;

    private int startPage = 0;
    private int lastPage = 0;
    private int prevPage = 0;
    private int nextPage = 0;
    private int prevBlock = 0;
    private int nextBlock = 0;

    protected String searchVal;
    protected String searchFrom;

    private String funcName = "onPage";

    public PagingUI() {
    }

    public PagingUI(Paging paging) {
        setArticlesPerPage(paging.getArticlesPerPage());
        setCurrentPage(paging.getCurrentPage());
        setTotalArticles(paging.getTotalArticles());
        setShowPages(paging.getShowPages());
    }

    public PagingUI(Paging paging, String funcName) {
        this(paging);

        this.funcName = funcName;
    }

    public StringBuffer makeHtml() {
        StringBuffer str = new StringBuffer("");

        try {
            // 시작 페이지
            startPage = currentPage - ((currentPage - 1) % showPages);

            // 마지막 페이지
            lastPage = (int) Math.ceil((double) totalArticles / articlesPerPage);

            if (lastPage <= 0)
                lastPage = 1;

            //이전 페이지
            // 다음 페이지
            if (currentPage == lastPage)
                nextPage = lastPage;
            else
                nextPage = currentPage + 1;

            // prevBlock
            prevBlock = currentPage - (currentPage - 1) % showPages - showPages;

            // nextBlock
            nextBlock = currentPage - (currentPage - 1) % showPages + showPages;

            str.append("<nav aria-label=\"Page navigation example\">\n" +
                    "                  <ul class=\"pagination\">");
            // 현재 페이지와 이전 페이지가 같다면 동작 안함
            if (startPage == currentPage) {
                str.append("<li class=\"page-item\">" +
                        "                    <a href=\"javascript:onPage(" + startPage + "," + articlesPerPage + ")\" class=\"page-link\" aria-label=\"Previous\">\n" +
                        "                                    <span aria-hidden=\"true\">&laquo;</span>\n" +
                        "                                    <span class=\"sr-only\">Previous</span>\n" +
                        "                                </a>\n" +
                        "                            </li>");
            } else {
                str.append("<li class=\"page-item\">\n" +
                        "                    <a href=\"javascript:onPage(" + (currentPage - 1) + "," + articlesPerPage + ")\" class=\"page-link\" aria-label=\"Previous\">\n" +
                        "                                    <span aria-hidden=\"true\">&laquo;</span>\n" +
                        "                                    <span class=\"sr-only\">Previous</span>\n" +
                        "                                </a>\n" +
                        "                            </li>");
            }

            if (lastPage > 0) {
                for (int i = startPage; i < (startPage + showPages); i++) {
//					if (i > startPage)
//						str.append ("<span>│</span>");

                    if (i == currentPage) {
                        str.append("<li class=\"page-item active\">\n" +
                                "                                              <span class=\"page-link\">\n" +
                                "                                                      " + i + "\n" +
                                "                                                <span class=\"sr-only\">(current)</span>\n" +
                                "                                              </span>\n" +
                                "                     </li>");
                    } else {
                        str.append("<li class=\"page-item\">\n" +
                                "                        <a href=\"javascript:onPage(" + i + "," + articlesPerPage + ")\" class=\"page-link\">" + i + "</a>\n" +
                                "                      </li>");

                    }
                    if (i == lastPage)
                        break;

                }
            }

            if (nextPage == lastPage) {
                str.append("<li class=\"page-item\">" +
                        "                                <a href=\"javascript:onPage(" + lastPage + "," + articlesPerPage +")\" class=\"page-link\" aria-label=\"Next\">\n" +
                        "                                    <span aria-hidden=\"true\">&raquo;</span>\n" +
                        "                                    <span class=\"sr-only\">Next</span>\n" +
                        "                                </a>\n</li>");
            } else {
                str.append("<li class=\"page-item\">\n" +
                        "                                <a href=\"javascript:onPage(" + nextPage + "," + articlesPerPage + ")\" class=\"page-link\" aria-label=\"Next\">\n" +
                        "                                    <span aria-hidden=\"true\">&raquo;</span>\n" +
                        "                                    <span class=\"sr-only\">Next</span>\n" +
                        "                                </a>\n</li>");
            }


            str.append("</ul>\n" +
                    "                    </nav>");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return str;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalArticles(int totalArticles) {
        this.totalArticles = totalArticles;
    }

    public void setShowPages(int showPages) {
        this.showPages = showPages;
    }

    public void setArticlesPerPage(int articlesPerPage) {
        this.articlesPerPage = articlesPerPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public void setPrevBlock(int prevBlock) {
        this.prevBlock = prevBlock;
    }

    public void setNextBlock(int nextBlock) {
        this.nextBlock = nextBlock;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    @Override
    public String toString() {
        return "PagingUI [currentPage=" + currentPage + ", totalArticles=" + totalArticles + ", showPages=" + showPages + ", articlesPerPage=" + articlesPerPage + ", startPage=" + startPage + ", lastPage=" + lastPage + ", nextPage=" + nextPage + ", prevBlock=" + prevBlock + ", nextBlock=" + nextBlock + ", funcName=" + funcName + "]";
    }
}

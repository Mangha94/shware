package kr.groupware.model;

/**
 * Created by Lsh on 2017-06-01.
 */
public class Paging {
    public void paing(){
        int page = 22;
        int countList = 10;
        int countPage = 10;

        int totalCount = 255;

        int totalPage = totalCount / countList;

        if (totalCount % countList > 0) {
            totalPage++;
        }

        if (totalPage < page) {
            page = totalPage;
        }

        int startPage = ((page - 1) / 10) * 10 + 1;

        int endPage = startPage + countPage - 1;

        if (endPage > totalPage) {
            endPage = totalPage;
        }

        if (startPage > 1) {
            System.out.print("<a href=\"?page=1\">처음</a>");
        }

        if (page > 1) {
            System.out.println("<a href=\"?page=" + (page - 1)  + "\">이전</a>");
        }

        for (int iCount = startPage; iCount <= endPage; iCount++) {
            if (iCount == page) {
                System.out.print(" <b>" + iCount + "</b>");
            } else {
                System.out.print(" " + iCount + " ");
            }
        }
        if (page < totalPage) {
            System.out.println("<a href=\"?page=" + (page + 1)  + "\">다음</a>");
        }
        if (endPage < totalPage) {
            System.out.print("<a href=\"?page=" + totalPage + "\">끝</a>");
        }
    }
}

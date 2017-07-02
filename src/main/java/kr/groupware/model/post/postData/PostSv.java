package kr.groupware.model.post.postData;

import kr.groupware.model.Paging;
import kr.groupware.model.PagingList;

import java.util.List;

public interface PostSv {
    /**
     * 게시물 내용을 가져온다
     * @param postNo 게시물 넘버
     * @return
     */
    PostData getPost(int postNo);

    /**
     * 게시물을 등록한다
     * @param postData 새로 쓴 게시물 내용
     * @return
     */
    boolean addPost(PostData postData);

    /**
     * 게시물을 수정한다
     * @param postData 수정된 데이터
     * @return
     */
    boolean modifyPost(PostData postData);

    /**
     * 게시물을 삭제한다
     * @param postNo
     * @return
     */
    boolean deletePost(int postNo);

    /**
     * 게시물의 총 갯수를 구한다
     */
    int getPostCnt();

    /**
     * 조건에 만족하는 게시물 목록을 가져와 페이징을 한다
     * @param paging
     * @param postSearchData
     * @return
     */
    PagingList<PostData> searchPost(Paging paging, PostSearchData postSearchData);
}

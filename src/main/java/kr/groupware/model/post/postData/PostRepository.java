package kr.groupware.model.post.postData;

import java.util.List;
import java.util.Map;

public interface PostRepository {
    /**
     * 해당 게시판에 있는 게시물들을 가져온다
     * @param boardNo 게시판
     * @return
     */
    List<PostData> getPosts(int boardNo);

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
     * 포스트를 찾는다
     * @param searchMap
     * @return
     */
    List<PostData> searchPost(Map<String,Object> searchMap);

    /**
     * 찾은 포스트의 전체 갯수를 구한다
     * @param searchMap
     * @return
     */
    int searchPostCnt (Map<String,Object> searchMap);
}

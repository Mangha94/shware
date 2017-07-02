package kr.groupware.model.post.postData;


import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PostRepositoryImp extends SqlSessionDaoSupport implements PostRepository{
    public List<PostData> getPosts(int boardNo){
        return getSqlSession().selectList("postData.getPosts",boardNo);
    }

    @Override
    public PostData getPost(int postNo){
        return getSqlSession().selectOne("postData.getPost",postNo);
    }

    @Override
    public boolean addPost(PostData postData){
        return getSqlSession().insert("postData.addPost",postData)>0;
    }

    @Override
    public boolean modifyPost(PostData postData){
        return getSqlSession().update("postData.modifyPost",postData)>0;
    }

    @Override
    public boolean deletePost(int postNo){
        return getSqlSession().delete("postData.deletePost",postNo)>0;
    }

    @Override
    public int getPostCnt(){
        return getSqlSession().selectOne("postData.getPostCnt");
    }

    @Override
    public List<PostData> searchPost(Map<String,Object> searchMap){
        return getSqlSession().selectList("postData.searchPost",searchMap);
    }

    @Override
    public int searchPostCnt(Map<String,Object> searchMap){
        return getSqlSession().selectOne("postData.searchPostCnt",searchMap);
    }
}

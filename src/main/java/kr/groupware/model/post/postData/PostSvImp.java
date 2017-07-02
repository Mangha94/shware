package kr.groupware.model.post.postData;

import kr.groupware.model.Paging;
import kr.groupware.model.PagingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostSvImp implements PostSv {
    @Autowired PostRepository postRepository;

    @Override
    public PostData getPost(int postNo){
        return postRepository.getPost(postNo);
    }

    @Override
    public boolean addPost(PostData postData){
                postData.setPostingDate(new Date());
                return postRepository.addPost(postData);
    }

    @Override
    public boolean modifyPost(PostData postData){
        postData.setModifyDate(new Date());
        return postRepository.modifyPost(postData);
    }

    @Override
    public boolean deletePost(int postNo){
        return postRepository.deletePost(postNo);
    }

    @Override
    public int getPostCnt(){
        return postRepository.getPostCnt();
    }

    @Override
    public PagingList<PostData> searchPost(Paging paging, PostSearchData postSearchData){
        paging.setSearchData(postSearchData.makeMap());

        paging.setTotalArticles(postRepository.searchPostCnt(paging.makeCntMap()));
        return new PagingList<> (postRepository.searchPost(paging.makeMap()),paging);
    }

}

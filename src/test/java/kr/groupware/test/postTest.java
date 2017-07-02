package kr.groupware.test;

import kr.groupware.model.post.postData.PostData;
import kr.groupware.model.post.postData.PostSv;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations={
                "classpath:common.xml",
                "classpath:db.xml"
        }
)
public class postTest {
    @Autowired
    PostSv postSv;
    @Test
    public void test() throws Exception {
//        PostData postData=new PostData();
//        postData.setBoardNo(1);
//        postData.setPostName("test");
//        postData.setPostContent("test");
//        postData.setPostedId("test");
//        postSv.addPost(postData);
//
//        System.out.println(postSv.getPost(2));
//
//        PostData post=postSv.getPost(2);
//
//        post.setPostName("test1");
//        post.setPostContent("test2");
//        postSv.modifyPost(post);
//
//        System.out.println(postSv.getPost(2));
//
//        postSv.deletePost(2);

        System.out.println(postSv.getPostCnt());


    }
}

package kr.groupware.model.post.postData;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class PostData {
    private int postNo;
    private int boardNo;
    private String postName;
    private String postContent;
    private Date postingDate;
    private Date modifyDate;
    private String postedId;
    private int viewCnt;
    private int commentCnt;

    public PostData(){
        this.viewCnt=0;
        this.commentCnt=0;
    }
}


package kr.groupware.server.controller.post;

import kr.groupware.model.Paging;
import kr.groupware.model.PagingList;
import kr.groupware.model.post.postData.PostData;
import kr.groupware.model.post.postData.PostSearchData;
import kr.groupware.model.post.postData.PostSv;
import kr.groupware.model.system.board.BoardSettingData;
import kr.groupware.model.system.board.BoardSettingSv;
import kr.groupware.server.controller.MenuSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/post")
public class postCt {
    @Autowired
    private PostSv postSv;

    @Autowired
    private MenuSetting menuSetting;

    @Autowired
    private BoardSettingSv boardSettingSv;

    /**
     * 포스트 리스트를 뿌린다
     * @param searchFrom 검색항목
     * @param searchVal 검색내용
     * @param pageNo 현재 페이지 넘버
     * @param pageSize 현재 한번에 볼 포스트 갯수
     * @param boardNo 게시판 넘버
     * @return 포스트 리스트
     */
    @RequestMapping(value = "postList.do",method = RequestMethod.GET)
    public ModelAndView getPosts(
            @RequestParam(value = "searchFrom", required = false, defaultValue = "") String searchFrom,
            @RequestParam(value = "searchVal", required = false, defaultValue = "") String searchVal,
            @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "boardNo",required = false)Integer boardNo
    ){
        ModelAndView mv=new ModelAndView("/post/postList");

        menuSetting.menuSetting(mv);

        PostSearchData searchData = new PostSearchData();
        if(boardNo!=null){
            searchData.setBoardNo(boardNo);
        }
        if (searchFrom.equals("postName")) {
            searchData.setPostName(searchVal);
        } else if (searchFrom.equals("postedId")) {
            searchData.setPostedId(searchVal);
        }

        Paging paging = new Paging (pageNo, 10, pageSize);

        PagingList<PostData> pagingList = postSv.searchPost(paging, searchData);

        if(boardNo!=null) {
            BoardSettingData getBoardSetting = boardSettingSv.getBoardSetting(boardNo);
            mv.addObject("boardSetting",getBoardSetting);
        }

        mv.addObject ("paging", pagingList.getPaging ());
        mv.addObject ("pagingList", pagingList);
        mv.addObject("searchFrom",searchFrom);
        mv.addObject("searchVal",searchVal);
        return mv;
    }

    /**
     * 해당 게시물 정보를 가져온다
     * @param postNo 게시물
     * @return
     */
    @RequestMapping(value = "getPost.do",method = RequestMethod.GET)
    public ModelAndView getPost(
            @RequestParam(value = "postNo",required = false)int postNo,
            @RequestParam(value = "boardNo",required = false)Integer boardNo
    ){
        ModelAndView mv=new ModelAndView("/post/getPost");

        //메뉴셋팅
        menuSetting.menuSetting(mv);

        if(boardNo!=null) {
            BoardSettingData getBoardSetting = boardSettingSv.getBoardSetting(boardNo);
            mv.addObject("boardSetting",getBoardSetting);
        }

        PostData getPost=postSv.getPost(postNo);

/*        String content=getPost.getPostContent();
        content = content.replace("\n","<br>");
        getPost.setPostContent(content);*/

        mv.addObject("getPost",getPost);
        return mv;
    }

    @RequestMapping(value="modifyPostForm.do",method = RequestMethod.GET)
    public ModelAndView modifyPostForm(
            @RequestParam(value = "postNo",required = false)int postNo,
            @RequestParam(value="boardNo",required = false)Integer boardNo
    ){
        ModelAndView mv=new ModelAndView("/post/addPostForm");

        //메뉴셋팅
        menuSetting.menuSetting(mv);
        BoardSettingData boardSettingData=boardSettingSv.getBoardSetting(boardNo);
        PostData getPost=postSv.getPost(postNo);


        mv.addObject("boardSetting",boardSettingData);
        mv.addObject("getPost",getPost);
        return mv;
    }

    /**
     * 게시물을 쓰기 위한 폼으로 창을 이동
     * @return
     */
    @RequestMapping(value = "/addPostForm.do",method = RequestMethod.GET)
    public ModelAndView addPostForm(
            @RequestParam(value = "boardNo",required = false)Integer boardNo
    ){
        ModelAndView mv=new ModelAndView("/post/addPostForm");

        //메뉴셋팅
        menuSetting.menuSetting(mv);

        BoardSettingData boardSettingData=boardSettingSv.getBoardSetting(boardNo);

        mv.addObject("boardSetting",boardSettingData);
        return mv;
    }

    /**
     * 게시물을 추가한다
     * @param postData 추가할 게시물 정보
     * @return
     */
    @RequestMapping(value = "addPost.do",method = RequestMethod.POST)
    public String addPost(
            PostData postData
    ){
        postSv.addPost(postData);

        return "redirect:/post/postList.do?boardNo="+postData.getBoardNo();
    }


    @RequestMapping(value = "modifyPost.do",method = RequestMethod.POST)
    public String modifyPost(
            @RequestParam(value = "postName",required = false)String postName,
            @RequestParam(value = "postedId",required = false)String postedId,
            @RequestParam(value = "postContent",required = false)String postContent,
            @RequestParam(value = "postNo",required = false)int postNo,
            @RequestParam(value = "boardNo",required = false)Integer boardNo

    ){
        PostData postData=postSv.getPost(postNo);
        postData.setPostedId(postedId);
        postData.setPostContent(postContent);
        postData.setPostName(postName);

        postSv.modifyPost(postData);

        return "redirect:/post/postList.do?boardNo="+boardNo;
    }

    /**
     * 게시물을 삭제한다
     * @param postNo 삭제할 게시물 넘버
     * @return
     */
    @RequestMapping(value="deletePost.do",method = RequestMethod.GET)
    public String deletePost(
            @RequestParam(value = "postNo",required = false)int postNo,
            @RequestParam(value = "boardNo",required = false)int boardNo
    ){
        postSv.deletePost(postNo);

        return "redirect:/post/postList.do?boardNo="+boardNo;
    }
}

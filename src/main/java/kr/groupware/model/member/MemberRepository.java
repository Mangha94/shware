package kr.groupware.model.member;

import java.util.List;
import java.util.Map;

public interface MemberRepository {
    //리스트 가져오기
    List<MemberData> getMembers();
    //하나 가져오기
    MemberData getMember(String memberId);
    //중복체크
    int getCountMemberId(String memberId);
    //페이지 셋팅
    List<MemberData> setMemberPage(Map<String,Integer>setMemberPageData);
    //등록하기
    void addMember(MemberData memberData);
    //삭제하기
    void deleteMember(String memberId);
    //수정하기
    void modifyMember(MemberData memberData);
    //전체 갯수 구하기
    int getCount();
    //멤버찾기
    List<MemberData> searchMember(Map<String,Object> searchMap);
    //검색 된 회원 갯수 구하기
    int getSearchMemberResultCount(Map<String,String> searchMap);
}

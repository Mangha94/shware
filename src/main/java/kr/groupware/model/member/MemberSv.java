package kr.groupware.model.member;


import java.util.List;

import kr.groupware.model.SetPagingData;

public interface MemberSv {
    //리스트 가져오기
    List<MemberData> getMembers();
    //하나 가져오기
    MemberData getMember(String memberId);

    boolean existMemberId(String memberId);
    //페이지 셋팅
    List<MemberData> setMemberPage(int pageNo,int pageSize);
    //등록하기
    void addMember(MemberData memberData) throws Exception;
    //삭제하기
    void deleteMember(String memberId);
    //수정하기
    void modifyMember(MemberData memberData);
    //전체 갯수 구하기
    int getCount();
    //검색된 회원 갯수 구하기
    int getSearchMemberResultCount(MemberSearchData msd);
    //회원 검색
    List<MemberData> searchMember(MemberSearchData msd,SetPagingData setPagingData);
}

package kr.groupware.model.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import kr.groupware.model.Paging;
import kr.groupware.model.PagingList;

@Service
public class MemberSvImp implements MemberSv {
    @Autowired MemberRepository memberRepository;
    //리스트 가져오기
    @Override
    public List<MemberData> getMembers(){
        return memberRepository.getMembers();
    }
    //하나 가져오기
    @Override
    public MemberData getMember(String memberId){
        return memberRepository.getMember(memberId);
    }

    /**
     *
     * @param memberId 회원아이디
     * @return
     */
    @Override
    public boolean existMemberId(String memberId) {
        return memberRepository.getCountMemberId(memberId) > 0;
    }

    //등록하기
    @Override
    public void addMember(MemberData memberData) throws Exception
    {
		if (!existMemberId(memberData.getMemberId()))
		{
			memberData.setRegistrationDate(new Date());
			memberRepository.addMember(memberData);
		}
		else
			throw new Exception("중복된 아이디입니다");

    }
    //삭제하기
    @Override
    public void deleteMember(String memberId){
        memberRepository.deleteMember(memberId);
    }
    //수정하기
    @Override
    public void modifyMember(MemberData memberData){
        memberData.setModifyDate(new Date());
        memberRepository.modifyMember(memberData);
    }

    @Override
    public int getCount(){
        return memberRepository.getCount();
    }

	@Override
    public PagingList<MemberData> searchMember (Paging paging, MemberSearchData searchData)
	{
		paging.setSearchData (searchData.makeMap ());

		// 검색된 데이터의 총 데이터수
		paging.setTotalArticles (memberRepository.searchMemberCnt (paging.makeCntMap ()));

        return new PagingList<> (memberRepository.searchMember (paging.makeMap ()), paging);
    }

    @Override
    public int getSearchMemberResultCount(MemberSearchData msd){
        return memberRepository.searchMemberCnt (msd.makeMap());
    }
}

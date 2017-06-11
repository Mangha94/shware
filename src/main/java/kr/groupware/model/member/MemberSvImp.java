package kr.groupware.model.member;

import kr.groupware.model.Paging;
import kr.groupware.model.SetPagingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<MemberData> setMemberPage(int pageNo,int pageSize){
        Integer firstNo=(pageSize *pageNo)- pageSize;
        Integer lastNo=(pageSize *pageNo);
        SetPagingData setPagingData=new SetPagingData();
        setPagingData.setFirstNo(firstNo);
        setPagingData.setLastNo(lastNo);
        return memberRepository.setMemberPage(setPagingData.makeMap());
    }
    //등록하기
    @Override
    public boolean addMember(MemberData memberData) throws Exception {

            if (!existMemberId(memberData.getMemberId()))
            {
                memberData.setRegistrationDate(new Date());
                memberRepository.addMember(memberData);
                return true;
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
    public List<MemberData> searchMember(MemberSearchData msd, SetPagingData setPagingData){
        Map<String,Object>mapData=new HashMap<>();
        if (msd.getName() != null && msd.getName().trim ().length () > 0)
            mapData.put ("name", msd.getName());

        if (msd.getMemberId() != null && msd.getMemberId().trim ().length () > 0)
            mapData.put ("memberId", msd.getMemberId());

        if (msd.getEmail() != null && msd.getEmail().trim ().length () > 0)
            mapData.put ("email", msd.getEmail());
        mapData.put ("firstNo", setPagingData.getFirstNo());
        mapData.put ("lastNo", setPagingData.getLastNo());

        return memberRepository.searchMember(mapData);
    }

    @Override
    public int getSearchMemberResultCount(MemberSearchData msd){
        return memberRepository.getSearchMemberResultCount(msd.makeMap());
    }
}

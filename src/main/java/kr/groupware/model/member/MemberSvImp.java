package kr.groupware.model.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    @Override
    public List<MemberData> setMemberPage(MemberPageData memberPageData){
        return memberRepository.setMemberPage(memberPageData.makeMap());
    }
    //등록하기
    @Override
    public void addMember(MemberData memberData){
        try {
            MemberSearchData msd = new MemberSearchData();
            msd.setMemberId(memberData.getMemberId());
            if (searchMember(msd).size() == 0) {
                memberData.setRegistrationDate(new Date());
                memberRepository.addMember(memberData);
            }
        }catch (Exception E){
            System.out.println("중복된 아이디입니다");
        }
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
    public List<MemberData> searchMember(MemberSearchData msd){
        return memberRepository.searchMember(msd.makeMap());
    }
}

package kr.groupware.model.member;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MemberRepositoryImp extends SqlSessionDaoSupport implements MemberRepository {
    @Override
    public List<MemberData> getMembers(){
        return getSqlSession().selectList("memberData.getMembers");
    }

    @Override
    public MemberData getMember(String memberId){
        return getSqlSession().selectOne("memberData.getMember",memberId);
    }

    @Override
    public List<MemberData> setMemberPage(Map<Integer,Integer> pageMap){
        return getSqlSession().selectList("memberData.setMemberPage",pageMap);
    }
    @Override
    public void addMember(MemberData memberData){
        getSqlSession().insert("memberData.addMember",memberData);
    }

    @Override
    public void deleteMember(String memberId){
        getSqlSession().delete("memberData.deleteMember",memberId);
    }

    @Override
    public void modifyMember(MemberData memberData){
        getSqlSession().update("memberData.modifyMember",memberData);
    }

    @Override
    public int getCount(){
        return getSqlSession().selectOne("memberData.getCount");
    }

    @Override
    public List<MemberData> searchMember(Map<String,String> searchMap){
        return getSqlSession().selectList("memberData.searchMember",searchMap);
    }
}

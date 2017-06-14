package kr.groupware.model.member;


import kr.groupware.model.Paging;
import kr.groupware.model.PagingList;

public interface MemberSv {
    /**
     * 해당 회원정보를 가져온다
     * @param memberId 가져올 회원 아이디
     * @return 해당 회원 정보
     */
    MemberData getMember(String memberId);

    /**
     * 아이디 중복체크
     * @param memberId 중복체크할 아이디
     * @return 중복된 아이디면 true
     *          중복되지 않은 아이디면 false
     */
    boolean existMemberId(String memberId);

    /**
     * 회원을 등록한다
     * @param memberData 신규 회원정보
     * @throws Exception 필수값체크 및 아이디 중복체크
     */
    void addMember(MemberData memberData) throws Exception;

    /**
     * 회원탈퇴
     * @param memberId 탈퇴할 아이디
     */
    void deleteMember(String memberId);

    /**
     * 회원정보 수정
     * @param memberData 수정된 회원정보
     */
    void modifyMember(MemberData memberData);

    /**
     * 회원 전체수를 구한다
     * @return 회원 전체수
     */
    int getCount();

	/**
	 * 회원 검색
 	 * @param paging 페이징 객체
	 * @param searchData 검색 데이터
	 * @return 페이징 리스트
	 */
    PagingList<MemberData> searchMember (Paging paging, MemberSearchData searchData);
}

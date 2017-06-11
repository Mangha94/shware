package kr.groupware.model.member;

import java.util.Map;

import kr.groupware.lib.StrLib;
import kr.groupware.model.SearchData;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 회원 검색을 위한 클래스
 */
@EqualsAndHashCode (callSuper = true)
@Data
public class MemberSearchData extends SearchData
{
    private String name;

    private String memberId;

    private String email;

    @Override
    public Map<String, Object> makeMap ()
    {
		Map<String, Object> mapData = super.makeMap ();

		if (StrLib.isEmptyStr (name))
            mapData.put ("name", name);

        if (StrLib.isEmptyStr (memberId))
            mapData.put ("memberId", memberId);

		if (StrLib.isEmptyStr (email))
            mapData.put ("email", email);

        return mapData;
    }
}

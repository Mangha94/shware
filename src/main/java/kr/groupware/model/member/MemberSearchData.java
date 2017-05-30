package kr.groupware.model.member;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class MemberSearchData {
    private String name;
    private String memberId;
    private String email;

    public Map<String, String> makeMap ()
    {
        Map<String, String> mapData = new HashMap<>();

        if (name != null && name.trim ().length () > 0)
            mapData.put ("name", name);

        if (memberId != null && memberId.trim ().length () > 0)
            mapData.put ("memberId", memberId);

        if (email != null && email.trim ().length () > 0)
            mapData.put ("email", email);

        return mapData;
    }
}

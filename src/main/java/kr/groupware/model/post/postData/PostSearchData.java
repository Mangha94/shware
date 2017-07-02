package kr.groupware.model.post.postData;

import kr.groupware.lib.StrLib;
import kr.groupware.model.SearchData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;


@EqualsAndHashCode(callSuper = true)
@Data
public class PostSearchData extends SearchData
{
    private String postedId;

    private String postName;

    private Integer boardNo;

    @Override
    public Map<String, Object> makeMap ()
    {
        Map<String, Object> mapData = super.makeMap ();

        if (StrLib.isExistStr (postedId))
            mapData.put ("postedId", postedId);

        if (StrLib.isExistStr (postName))
            mapData.put ("postName", postName);

        mapData.put ("boardNo", boardNo);

        return mapData;
    }
}
package kr.groupware.lib;

/**
 * Created by purre on 2017-06-11.
 */
public class StrLib
{
	/**
	 * 문자열 null 체크  null 이거나 빈공백이면 true 리턴
	 * @param str 스트링
	 * @return null 또는 비어있는 스트링인지 체크 결과
	 */
	public static boolean isEmptyStr (String str)
	{
		return str == null || str.trim ().length () == 0;
	}

	/**
	 * 문자열이 데이터가 있다면 true
	 * @param str 스트링
	 * @return
	 */
	public static boolean isExistStr (String str)
	{
		return !isEmptyStr (str);
	}
}

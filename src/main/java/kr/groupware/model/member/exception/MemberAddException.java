package kr.groupware.model.member.exception;

/**
 * Created by purre on 2017-07-02.
 */
public class MemberAddException extends Exception
{
	public enum MemberAddExceptionType
	{
		/**
		 * 아이디가 입력되지 않음
		 */
		ID_NOT_INPUT,

		/**
		 * 이름이 입력되지 않음
		 */
		NAME_NOT_INPUT,

		/**
		 * 존재하는 아이디
		 */
		EXIST_MEMBER,
	}

	MemberAddExceptionType exceptionType;

	public MemberAddException (MemberAddExceptionType exceptionType)
	{
		this.exceptionType = exceptionType;
	}

	public MemberAddExceptionType getExceptionType ()
	{
		return exceptionType;
	}
}

package kr.groupware.model.rank.spot;

/**
 * 직책이 지워져도 되는지 확인하는 인터페이스
 *
 * Created by Lsh on 2017-07-14.
 */
public interface QusSpotDelete {
    boolean isDelete(SpotData spotData);
}

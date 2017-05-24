package kr.groupware.model.rank.position;

import java.util.List;

public interface PositionSv {
//    리스트 뿌리기
    List<PositionData> getPositions();
//    하나 가져온다
    PositionData getPosition(int positionNo);
//    직책추가
    void addPosition(PositionData positionData);
//    직책수정
    void modifyPosition(PositionData positionData);
//    직책삭제
    void deletePosition(int positionNo);

}
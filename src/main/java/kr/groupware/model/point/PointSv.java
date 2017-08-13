package kr.groupware.model.point;

import java.util.List;

public interface PointSv {
    List<PointData> getHistory(String memberId);

    void insertUseHistory(PointData pointData);

    void insertChargeHistory(PointData pointData);
}

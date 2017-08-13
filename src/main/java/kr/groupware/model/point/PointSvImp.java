package kr.groupware.model.point;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PointSvImp implements PointSv{
    @Autowired
    private PointRepository pointRepository;

    @Override
    public List<PointData> getHistory(String memberId){
        return pointRepository.getHistory(memberId);
    }

    @Override
    public void insertUseHistory(PointData pointData){
        pointData.setUseDate(new Date());
        pointRepository.insertUseHistory(pointData);
    }

    @Override
    public void insertChargeHistory(PointData pointData){
        pointData.setChargeDate(new Date());
        pointRepository.insertChargeHistory(pointData);
    }
}

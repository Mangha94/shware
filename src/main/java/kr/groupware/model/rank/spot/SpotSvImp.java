package kr.groupware.model.rank.spot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotSvImp implements SpotSv {
    @Autowired SpotRepository spotRepository;
    @Autowired(required = false) List<QusSpotDelete> qusSpotDelete;

    @Override
    public List<SpotData>getSpots(){
        return spotRepository.getSpots();
    }

    @Override
    public SpotData getSpot(int spotNo){
        return spotRepository.getSpot(spotNo);
    }
    @Override
    public void addSpot(SpotData spotData){
        spotRepository.addSpot(spotData);
    }

    @Override
    public void modifySpot(SpotData spotData){
        spotRepository.modifySpot(spotData);
    }

    @Override
    public void deleteSpot(int spotNo){
        SpotData spotData=getSpot(spotNo);
        for(QusSpotDelete isQus : qusSpotDelete){
            if(!isQus.isDelete(spotData)){
                return;
            }
        }
        spotRepository.deleteSpot(spotNo);
    }
}

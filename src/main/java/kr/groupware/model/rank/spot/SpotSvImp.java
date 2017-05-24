package kr.groupware.model.rank.spot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotSvImp implements SpotSv {
    @Autowired SpotRepository spotRepository;

    @Override
    public List<SpotData>getSpots(){
        return spotRepository.getSpots();
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
        spotRepository.deleteSpot(spotNo);
    }
}

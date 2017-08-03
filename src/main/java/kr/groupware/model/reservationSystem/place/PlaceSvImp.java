package kr.groupware.model.reservationSystem.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lsh on 2017-07-30.
 */
@Service
public class PlaceSvImp implements PlaceSv{
    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<PlaceData>getPlaces(){
        return placeRepository.getPlaces();
    }

    @Override
    public PlaceData getPlace(String place){
        return placeRepository.getPlace(place);
    }

    @Override
    public void insertPlace(PlaceData placeData){
        placeRepository.insertPlace(placeData);
    }

    @Override
    public void modifyPlace(PlaceData placeData){
        placeRepository.modifyPlace(placeData);
    }

    @Override
    public void deletePlace(int placeNo){
        placeRepository.deletePlace(placeNo);
    }


}

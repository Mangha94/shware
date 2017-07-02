package kr.groupware.model.rank.position;

import kr.groupware.model.rank.event.PositionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionSvImp implements PositionSv {
    @Autowired PositionRepository positionRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public List<PositionData> getPositions(){
        return positionRepository.getPositions();
    }

    @Override
    public PositionData getPosition(int positionNo){
        return positionRepository.getPosition(positionNo);
    }

    @Override
    public void addPosition(PositionData positionData){
        positionRepository.addPosition(positionData);
    }

    @Override
    public void modifyPosition(PositionData positionData){
        positionRepository.modifyPosition(positionData);
    }

    @Override
    public void deletePosition(int positionNo){

        PositionData position = getPosition(positionNo);

        positionRepository.deletePosition(positionNo);

        applicationContext.publishEvent(new PositionEvent(position));
    }
}

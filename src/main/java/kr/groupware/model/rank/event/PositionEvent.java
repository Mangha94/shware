package kr.groupware.model.rank.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Lsh on 2017-06-30.
 */
public class PositionEvent extends ApplicationEvent
{
    public PositionEvent(Object source) {
        super(source);
    }
}

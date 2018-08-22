package com.hengyi.japp.netease;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;


/**
 * Created by jzb on 16-10-26.
 */
public class Resources {
//    @Produces
//    @PersistenceContext
//    private EntityManager em;

    @Produces
    public Logger produceLog(InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
    }

}

package com.debuggeandoideas.services;

import com.debuggeandoideas.models.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Map;

//@Service
@Log
@Getter
@Component //IoC
public class GauntletServiceImpl implements GauntletService {


    private final Stone reality;
    private final Stone soul;
    private final Stone mind;
    private final Stone power;
    private final Stone space;
    private final Stone time;

    @Autowired
    public GauntletServiceImpl(
            @Qualifier("reality") Stone reality,
            @Qualifier("soul") Stone soul,
            @Qualifier("mind") Stone mind,
            @Qualifier("power") Stone power,
            @Qualifier("space") Stone space,
            @Qualifier("time") Stone time) {
        this.reality = reality;
        this.soul = soul;
        this.mind = mind;
        this.power = power;
        this.space = space;
        this.time = time;
    }


    @Override
    public void useGauntlet(String stoneName) {

        switch (stoneName) {
            case "reality" -> log.info("Use stone: " + this.reality);
            case "soul" -> log.info("Use stone: " + this.soul);
            case "mind" -> log.info("Use stone: " + this.mind);
            case "power" -> log.info("Use stone: " +this.power);
            case "space" -> log.info("Use stone: " + this.space);
            case "time" -> log.info("Use stone: " + this.time);

            default -> throw new IllegalArgumentException("Invalid name");
        }
    }

    @Override
    public void useFullPower() {

        if (this.time != null && this.reality != null &&
                this.space != null  && this.mind != null
                && this.power != null && this.soul != null ) {
            log.info("USING ALL POWER");
        } else {
            throw new IllegalStateException("Cant be using full power because service have field null");
        }
    }


}

package com.syndicate.datacollector

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
class PlayerInfo {

    long id
    String name
    boolean onCurrentRoster
    String fromYear
    String toYear
    String playerCode
    long teamId
    String teamCity
    String teamName
    String teamAbbreviation
    String teamCode
    String gamesPlayedFlag
    int price
    String position

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }
}

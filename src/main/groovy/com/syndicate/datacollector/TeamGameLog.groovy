package com.syndicate.datacollector

import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Temporal
import javax.persistence.TemporalType
import java.util.Date;
import javax.persistence.Entity;

@Entity
public class TeamGameLog {

    @Id
    long id
    Date date

    @ManyToOne
    Team team

    @ManyToOne
    Team opponent

    int ptsFor
    int ptsAgainst
    int three_ptrsFor
    int three_ptrsAgainst
    int offReboundsFor
    int offReboundsAgainst
    int defReboundsFor
    int defReboundsAgainst
    int stealsFor
    int stealsAgainst
    int blocksFor
    int blocksAgainst
    int tosCommitted
    int tosForced
    int assistsFor
    int assistsAgainst

    boolean isHomeTeam

    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date
    }
}

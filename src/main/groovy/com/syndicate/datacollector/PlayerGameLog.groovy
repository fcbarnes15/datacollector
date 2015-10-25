package com.syndicate.datacollector

import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Temporal
import javax.persistence.TemporalType
import java.util.Date;
import javax.persistence.Entity;

@Entity
public class PlayerGameLog {

    @Id
    long id
    Date date

    @ManyToOne
    Team team

    @ManyToOne
    Team opponent

    @ManyToOne
    Player player

    float minutes
    int pts
    int three_ptrs
    int offRebounds
    int defRebounds
    int steals
    int blocks
    int turnovers
    int assists

    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date
    }
}

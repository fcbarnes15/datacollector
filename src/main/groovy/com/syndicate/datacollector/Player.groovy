package com.syndicate.datacollector


import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Player {

    @Id
    long id
    long dkId
    String name

    @ManyToOne
    Team currentTeam

    int currentSalary
    String position
    int numGamesPlayed
    float minutes
    int pts
    int three_ptrs
    int offRebounds
    int defRebounds
    int steals
    int blocks
    int turnovers
    int assists

    @OneToMany (mappedBy = "player")
    Set<PlayerGameLog> gameLogs
}

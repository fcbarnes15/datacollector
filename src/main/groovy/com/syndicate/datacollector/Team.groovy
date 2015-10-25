package com.syndicate.datacollector

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany


@Entity
public class Team {

    @Id
    long id

    String teamCity
    String teamName
    String teamAbbreviation
    String teamCode
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

    @OneToMany (mappedBy="team")
    Set<TeamGameLog> gameLogs

    @OneToMany(mappedBy="currentTeam")
    Set<Player> players;

}

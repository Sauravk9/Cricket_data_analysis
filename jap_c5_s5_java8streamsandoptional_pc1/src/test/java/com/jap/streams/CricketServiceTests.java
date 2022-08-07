package com.jap.streams;


import com.jap.streams.Cricket;
import com.jap.streams.CricketService;
import com.jap.streams.Country;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CricketServiceTests {


    private static final String MSG_01 = "existing batsman should be returned in an optional";
    private static final String MSG_02 = "should return empty optional for null or empty inputs";
    private static final String MSG_03 = "should return empty optional for non existing batsman";
    private static final String MSG_04 = "should return a string with batsman name for the given country code in ascending order, separated by comma and enclosed in []";
    private static final String MSG_05 = "should return null for null or empty inputs";
    private static final String MSG_06 = "should return empty map for null or empty inputs";
    private static final String MSG_07 = "should return a map with player name and totalRuns scored, for players who have played more than 50 matches";
    private static final String MSG_08 = "should return the highest runs scored by any batsman for a given country";
    private static final String MSG_09 = "should return zero for null or empty inputs";
    private static final String MSG_10 = "should return a linkedList of player names for a given country who have scored more than 5000 runs, in descending order";
    private static final String MSG_11 = "exception CountryNotFoundException should be thrown";

    private CricketService batsmanService;
    private List<Cricket> batsmanList;
    private Cricket batsmanVirat;

    @BeforeEach
    public void setUp() {
        batsmanService = new CricketService();
        batsmanVirat = new Cricket("Virat", 55, 6000, 150, new Country("IN", "India"));
        batsmanList = List.of(
                batsmanVirat,
                new Cricket("Dhoni", 110, 8000, 120, new Country("IN", "India")),
                new Cricket("Ponting", 105, 5500, 55, new Country("AU", "Australia")),
                new Cricket("Hayden", 45, 5000, 105, new Country("AU", "Australia")),
                new Cricket("Jonty", 49, 4000, 60, new Country("SA", "SouthAfrica")),
                new Cricket("Duminy", 75, 4500, 125, new Country("SA", "SouthAfrica")),
                new Cricket("Rahul", 25, 3000, 75, new Country("IN", "India"))
        );
    }

    @AfterEach
    public void tearDown() {
        batsmanService = null;
    }

    @Test
    public void givenListOfBatsmanReturnMoreThan50Matches(){

        List list = batsmanService.getPlayerNamePlayedMoreThan50Matches(batsmanList);
        assertEquals(4,list.size());
    }

    @Test
    public void givenListOfBatsmanReturnHighestRunsScoredByBatsman(){
        Integer run = batsmanService.getHighestRunsScoredByCricketer(batsmanList,"Australia");
        assertEquals(105,run);

    }

}

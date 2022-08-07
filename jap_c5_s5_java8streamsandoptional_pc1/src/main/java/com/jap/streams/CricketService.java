package com.jap.streams;
import java.util.*;
import java.util.stream.Collectors;

public class CricketService {

    /**
     * Given a country and a name, find the cricketer from the entire data list of cricket players
     */
    public Optional<Cricket> getCricketerName(List<Cricket> cricketList, String cricketerName, String countryName) {
        Optional<Cricket> cricketer=cricketList.stream().filter(p->p.getName().equals(cricketerName)&& p.getCountry().getName().equals(countryName)).findFirst();
        return cricketer;
    }

    /**
     *
     * Sort the list of cricketers in alphabetical order of their names belonging to a particular country.
     */
    public List<String> getCricketerNamesForCountry(List<Cricket> cricketList, String countryName) {
        List<String> names=new ArrayList();
        cricketList.stream().filter(p->p.getCountry().equals(countryName)).sorted((o1,o2)->o1.getName().compareTo(o2.getName())).forEach(s->names.add(s.getName()));

        return names;
    }

    /**
     * Search for cricketers who have played more than 50 matches
     *
     */
    public List<Cricket> getPlayerNamePlayedMoreThan50Matches(List<Cricket> cricketList) {


        List<Cricket> li=cricketList.stream().filter((a)->a.getMatchesPlayed()>50).collect(Collectors.toList());

        return li;
    }

    /**
     *
     *Find the cricketers who have scored the highest runs for their country
     */
    public Integer getHighestRunsScoredByCricketer(List<Cricket> cricketList, String countryName)
    {
        return cricketList.stream().filter((a)->a.getCountry().getName().equalsIgnoreCase(countryName)).sorted((a,b)->b.getHighestScore()-a.getHighestScore()).collect(Collectors.toList()).get(0).getHighestScore();

    }

}
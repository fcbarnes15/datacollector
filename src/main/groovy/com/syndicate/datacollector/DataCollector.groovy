package com.syndicate.datacollector

import groovy.json.JsonSlurper
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DataCollector {
  
    static void main(String... args) {

        def jsonSlurper = new JsonSlurper()

        def result = jsonSlurper.parseText(getPlayerInfoFromNBAStatsSite())

        ArrayList<Player> playerList = new ArrayList<>()

        result.resultSets[0].rowSet.each { it ->

            playerList.add(new Player(id: it[0],
                  name: it[1],
                  onCurrentRoster: it[2],
                  fromYear: it[3],
                  toYear: it[4],
                  playerCode: it[5],
                  teamId: it[6],
                  teamCity: it[7],
                  teamName: it[8],
                  teamAbbreviation: it[9],
                  teamCode: it[10],
                  gamesPlayedFlag: it[11]
            ))
        }

        System.out.println("Number Of Players in Player List = $playerList.size")
    }

    static String getPlayerInfoFromNBAStatsSite() {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet("http://stats.nba.com/stats/commonallplayers?IsOnlyCurrentSeason=1&LeagueID=00&Season=2015-16");

            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            return responseBody
        } finally {
            httpclient.close();
        }


    }



}
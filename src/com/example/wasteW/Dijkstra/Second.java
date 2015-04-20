package com.example.wasteW.Dijkstra;

import android.content.SyncStatusObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Luffy on 4/9/2015.
 */
public class Second
{
    public static Map<Stop, String> visited = new HashMap<Stop, String>();
    public static List<RouteResult> findRoutes(Stop start, Stop end)
    {
        System.out.println("coming here");
        List<RouteResult> queue = new ArrayList<RouteResult>();
        List<RouteResult> res = new ArrayList<RouteResult>();
        queue.add(new RouteResult().addNext(start, null));
        int cnt = 3;
        while (cnt > 0)
        {
            List<RouteResult> nextQ = new ArrayList<RouteResult>();
            for (int k = 0; k < queue.size(); k++)
            {
                RouteResult prevRes = queue.get(k);
                Stop startFrom = prevRes.stops.get(prevRes.stops.size() - 1); // end stop
                List<Route> routesFromStop = getAllRoutesFromStop(startFrom);
                System.out.println("routes " + routesFromStop.get(0).stopSeq.get(0).id);
                for (int i = 0; i < routesFromStop.size(); i++)
                {
                    Route route = routesFromStop.get(i);
                    List<Stop> stopSeq = route.stopSeq;
                    System.out.println("Routes in line " + route.stopSeq.get(0).id);
                    for (int j = 0; j < stopSeq.size(); j++)
                    {
                        Stop stop = stopSeq.get(j);

                        if (stop.id == end.id)
                        {
                            // output route
                            res.add(prevRes.addNext(stop, route));
                        } else if (isAlreadyVisited(stop))
                        {
                            // do nothing and break
                            break;
                        } else
                        {
                            // insert in que, mark visited
                            nextQ.add(prevRes.addNext(stop, route));
                            visited.put(stop, String.valueOf(true));
                        }
                    }
                }
            }
            cnt--;
            queue = nextQ;
        }
        return res;
    }
    private static boolean isAlreadyVisited(Stop stop)
    {
        if(visited.containsKey(stop))
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        Stop start = new Stop("1");
        Stop end = new Stop("2");
        List<RouteResult> result = findRoutes(start, end);
        for (int i = 0; i < result.size(); i++)
        {
            RouteResult routeResult = result.get(i);
            routeResult.print();
        }
    }
    public static ArrayList<Route> getAllRoutesFromStop(Stop stop)
    {
        ArrayList<Route> ans = new ArrayList<Route>();
        List<Stop> stopList = new ArrayList<Stop>();
        stopList.add(new Stop("2"));
        ans.add(new Route(stopList));
        return ans;
    }
}

class RouteResult
{
    List<Stop> stops;
    List<Route> routes;

    public RouteResult()
    {
        stops = new ArrayList<Stop>();
        routes = new ArrayList<Route>();
    }

    public RouteResult addNext(Stop stop, Route route)
    {
        stops.add(stop);
        routes.add(route);
        return this;
    }

    public void print()
    {
        System.out.print("Start - ");
        for(int i= 1; i < stops.size(); i++)
        {
            System.out.print( stops.get(i).id + " via route " + routes.get(i).print() + " >>> " + stops.get(i).id + " - ");
        }
    }
}
class Stop
{
    public String id;
    public Stop(String id)
    {
        this.id = id;
    }
}

class Route
{
    public List<Stop> stopSeq;
    public Route(List<Stop> stopSequence)
    {
        stopSeq = stopSequence;
    }

    public String print()
    {
        String s = "";
        for (int i = 0; i < stopSeq.size(); i++)
        {
            s = s + stopSeq.get(i).id +  "-";
        }
        return s;
    }
}

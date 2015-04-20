package com.example.wasteW.db;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.couchbase.lite.*;
import com.couchbase.lite.android.AndroidContext;
import com.couchbase.lite.auth.Authenticator;
import com.couchbase.lite.auth.BasicAuthenticator;
import com.couchbase.lite.replicator.Replication;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class DBHandler
{

    public static final String DATABASE_NAME = "mumbaicb";
    public static final String VIEW_STOPS_BY_MODE = "stopsByMode";
    public static final String VIEW_ROUTES_BY_MODE = "routesByMode";
    private final Context context;
    private Database _database;
    private Manager _dbManager;

    public DBHandler(Context context)
    {
        this.context = context;

        init();
    }

    private void init()
    {

        try
        {
            _dbManager = new Manager(new AndroidContext(context), Manager.DEFAULT_OPTIONS);
            createDbIfNotExists();

            URL url = new URL("https://ikervelockrodegilytheyed:USraThgMQEMU3A5gbVSr7OQ3@welkin.cloudant.com/geocoding");
            Authenticator auth = new BasicAuthenticator("ikervelockrodegilytheyed", "USraThgMQEMU3A5gbVSr7OQ3");
            Replication pull = _database.createPullReplication(url);
            pull.setFilter("test/stops");
            //pull.setAuthenticator(auth);
            pull.setContinuous(false);
            pull.addChangeListener(new Replication.ChangeListener()
            {
                @Override
                public void changed(Replication.ChangeEvent changeEvent)
                {
                    Log.d("RRRR", changeEvent.getCompletedChangeCount() + " changed");
                }
            });
            //pull.start();
            Log.d("CB", "total docs count " + _database.getDocumentCount());

            createStopsView();
            //createRoutesView();
           // printADocument();
        } catch (IOException e)
        {
            Log.e("RRRR", "Cannot create Manager instance", e);
            return;
        } catch (CouchbaseLiteException e)
        {
            e.printStackTrace();
        }
    }

    private void printADocument()
    {   // Let's find the documents that have conflicts so we can resolve them:
        Query query = _database.createAllDocumentsQuery();
        query.setLimit(1);
        query.setAllDocsMode(Query.AllDocsMode.ALL_DOCS);
        QueryEnumerator result = null;
        try
        {
            result = query.run();
            for (Iterator<QueryRow> it = result; it.hasNext(); )
            {
                QueryRow row = it.next();
                Document document = row.getDocument();
                Map<String, Object> properties = document.getProperties();
                for (String key : properties.keySet())
                {
                    Log.d("document", "key : " + key + " value" + properties.get(key));

                }


            }

        } catch (CouchbaseLiteException e)
        {
            e.printStackTrace();
        }

    }

    private void createDbIfNotExists() throws CouchbaseLiteException
    {
        _database = _dbManager.getExistingDatabase(DATABASE_NAME);
        if (_database == null)
        {
            Log.d("CB", " db does not exist .. creating new one");
            _database = _dbManager.getDatabase(DATABASE_NAME);


        }
        List<View> allViews = _database.getAllViews();
        Log.d("CB:VC", "total number of views" + allViews.size());
        for (View view : allViews)
        {
            Log.d("CB:VN", view.getName());
        }
        _database.addChangeListener(new Database.ChangeListener()
        {
            @Override
            public void changed(Database.ChangeEvent changeEvent)
            {

                Log.d("CB:DC", " on db Changed event ..dc count" + _database.getDocumentCount());
            }
        });
    }

    private void createStopsView()
    {
        // Create a view and register its map function:
        View stopView = _database.getView(VIEW_STOPS_BY_MODE);
        stopView.setMap(new Mapper()
        {
            @Override
            public void map(Map<String, Object> document, Emitter emitter)
            {
                String docType = (String) document.get("dtype");
                Log.d("mymy", "in onMap for createStopsView");
                if (TextUtils.equals(docType, "stop"))
                {
                    String stopName = (String) document.get("name");
                    String mode = (String) document.get("stype");
                    List<Object> key = new ArrayList<Object>();
                    key.add(mode);
                    HashMap<String,Object> values = new HashMap<String, Object>();
                    values.put("name",stopName);
                    values.put("city",document.get("city"));
                    emitter.emit(mode, stopName);

                    Log.d("view", "stop name " + stopName + " mode " + mode);
                }

            }


        }, "9.9");


    }


    public void fetchStop()
    {
        Query query = _database.getView(VIEW_STOPS_BY_MODE).createQuery();
        String busMode = "BUS";
        query.setStartKey(busMode);
        query.setEndKey("BUS");
        QueryEnumerator result = null;
        try
        {
            result = query.run();
            Log.d("CB", "query cnt " + result.getCount());
            for (Iterator<QueryRow> it = result; it.hasNext(); )
            {
                QueryRow row = it.next();
                Log.d("CB", "documet " + row.getDocument().getProperty("dtype"));
                Log.d("CB", "documet " + row.getDocument().getProperty("stype"));



            }
        } catch (CouchbaseLiteException e)
        {
            e.printStackTrace();
        }

    }

    public void fetchRoutes()
    {
        Query query = _database.getView(VIEW_STOPS_BY_MODE).createQuery();
        String busMode = "BUS";
        query.setStartKey(busMode);
        query.setEndKey("BUS");
        QueryEnumerator result = null;
        try
        {
            result = query.run();
            Log.d("CB", "query cnt " + result.getCount());
            for (Iterator<QueryRow> it = result; it.hasNext(); )
            {
                QueryRow row = it.next();
                Log.d("CB", "documet " + row.getDocument().getProperty("dtype"));
                Log.d("CB", "documet " + row.getDocument().getProperty("stype"));



            }
        } catch (CouchbaseLiteException e)
        {
            e.printStackTrace();
        }

    }

    private void createRoutesView()
    {
        Log.d("mymy", "starting createRoutesView");
        // Create a view and register its map function:
        View routeView = _database.getView(VIEW_ROUTES_BY_MODE);
        routeView.setMap(new Mapper()
        {
            @Override
            public void map(Map<String, Object> document, Emitter emitter)
            {
                String docType = (String) document.get("dtype");
                Log.d("mymy", "in onMap for createRoutesView");

                if (TextUtils.equals(docType, "route"))
                {
                    Log.d("mymy", "yes they are equal");
                    String routeName = (String) document.get("name");
                    HashMap<String,Object> values = new HashMap<String, Object>();
                    values.put("name", routeName);
                    values.put("city",document.get("city"));
                    values.put("stop_seq",document.get("stop_seq"));
                    emitter.emit(routeName, document.get("stop_seq"));

                }
                Log.d("mymy", "vaasdf");
            }


        }, "9.9");


    }
}

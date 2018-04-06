package com.example.shubhamgoel.maciot;

/**
 * Created by shubhamgoel on 06/03/18.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.github.nkzawa.emitter.Emitter;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;


public class InnerPage extends AppCompatActivity {


    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};
    List<Object> heroList;

    //the listview
    ListView listView;

    MyListAdapter adapter;

   /* public static Socket mSocket;
    {
        try {
            mSocket = IO.socket("http://172.20.10.2:3000");
        } catch (URISyntaxException e) {

            Log.i("catch", "This is my message");

        }
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      //  MainActivity.mSocket.connect();
        setContentView(R.layout.inner_page);

        TextView textView = (TextView) findViewById(R.id.textView);
        if(MainActivity.mSocket.connected()) {
            textView.setText("Connected");
            MainActivity.mSocket.on("UpdateUi",onStopTyping);
        }
        else
            textView.setText("Connection Problem! Check the server");

      /*  ListView lv = new ListView(this);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);*/



        heroList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.mobile_list);

        //adding some values to our list
        heroList.add(new Object("Set Cable Size", "1.5 ","mm2"));
        heroList.add(new Object("Set Cable Diameter", "2.55 ","mm"));
        heroList.add(new Object( "Actual Cable Diameter", "2.56","mm"));
        heroList.add(new Object( "Actual Line Speed", "676","MPM"));
        heroList.add(new Object( "Ext-1 Screw Rpm", "40.1","Rpm"));
        heroList.add(new Object( "Ext-1 Motor Current", "101.5","Amp"));
        heroList.add(new Object( "Ext-1 Motor Temperature", "45","degree"));
        heroList.add(new Object( "Ext-1 Melt Temperature", "145","degree"));
        heroList.add(new Object( "Ext-1 Melt Pressure", "135","bar"));
        heroList.add(new Object( "Ext-2 Screw Rpm", "50.1","Rpm"));
        heroList.add(new Object( "Ext-2 Motor Current", "25.5","Amp"));
        heroList.add(new Object( "Ext-2 Motor Temperature", "48","degree"));
        heroList.add(new Object( "Ext-2 Melt Temperature", "141","degree"));
        heroList.add(new Object( "Ext-2 Melt Pressure", "145","bar"));
        heroList.add(new Object( "Length Counter Meter", "2000.5","meter"));
        heroList.add(new Object( "Total No. of Spark", "25","No's"));
        heroList.add(new Object( "Actual Spark Tester Voltage", "10.5","KV"));
        heroList.add(new Object( "Line Running Status", "true",""));
        heroList.add(new Object( "Payoff-1 Running Status", "true",""));
        heroList.add(new Object( "Payoff-2 Running Status", "true",""));
        heroList.add(new Object( "Ext-1 Running Status", "true",""));
        heroList.add(new Object( "Ext-2 Running Status", "true",""));
        heroList.add(new Object( "Exit Capstan Running Status", "true",""));
        heroList.add(new Object( "Tup-1 Running Status", "true",""));
        heroList.add(new Object( "Tup-2 Running Status", "true",""));


        //creating the adapter
        adapter = new MyListAdapter(this, R.layout.activity_listview, heroList);

        //attaching adapter to the listview
        listView.setAdapter(adapter);

    }
    private Emitter.Listener onStopTyping = new Emitter.Listener() {

        @Override
        public void call(final java.lang.Object... args) {
            InnerPage.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONArray data = (JSONArray) args[0];
                    String newValue,index;
                    try
                    {

                        for(int i=0;i<data.length();i++)
                        {
                            heroList.get(data.getJSONObject(i).getInt("index") -1).setValue(data.getJSONObject(i).getString("newValue"));
                        }

                        adapter.ListModified();
                    }
                    catch (Exception e)
                    {
                        Log.e("Catch", e.getMessage());
                        return;
                    }
                   // removeTyping(username);
                }
            });
        }
    };

    void clickFunction(View v)
    {
        Log.i("btntag", "This is my message");
       // heroList.add(new Object( "Spark tester voltagscdscdce", "1hgh1.0 KV"));
       // notifyDataSetChanged();
        heroList.get(2).setValue("900");
         adapter.ListModified();
    }
}
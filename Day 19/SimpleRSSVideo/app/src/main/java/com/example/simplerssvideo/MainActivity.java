package com.example.simplerssvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvRss;
    ArrayList<String> titles;
    ArrayList<String> links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvRss = (ListView) findViewById(R.id.lvRss);

        titles = new ArrayList<String>();
        links = new ArrayList<String>();

        lvRss.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Uri uri = Uri.parse(links.get(position));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        }
        );

        //starts the background async thread
        new ProcessInBackground().execute();
    }

    public InputStream getInputStream(URL url)
    {
        try
        {
            // returns content frm the url as an input stream
            return url.openConnection().getInputStream();
        }
        catch (IOException e)
        {
            return null;
        }
    }

    public class ProcessInBackground extends AsyncTask<Integer, Void, Exception>
    {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);

        Exception exception = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog.setMessage("loading rss feed, please wait");
            progressDialog.show();
        }

        @Override
        protected Exception doInBackground(Integer... integers) {
            try
            {
                // url with rss feed, NOTE THAT THIS LINK NO LONGER WORKS SO APP WILL FAIL
                URL url = new URL("http://feeds.news24.com/articles/fin24/tech/res");

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

                factory.setNamespaceAware(false);

                XmlPullParser xpp = factory.newPullParser();

                xpp.setInput(getInputStream(url), "UTF_8");

                boolean insideItem = false;

                int eventType = xpp.getEventType();

                // loop through rss tags from rss file
                while (eventType != XmlPullParser.END_DOCUMENT)
                {
                    if (eventType == XmlPullParser.START_TAG)
                    {
                        // checks the tags that are within the item tag
                        if (xpp.getName().equalsIgnoreCase("item"))
                        {
                            insideItem = true;
                        }
                        else if (xpp.getName().equalsIgnoreCase("title"))
                        {
                            // if tag is inside item, add it to the title arrayList
                            if (insideItem)
                            {
                                titles.add(xpp.nextText());
                            }
                        }
                        else if (xpp.getName().equalsIgnoreCase("link"))
                        {
                            // if tag is inside item, add it to the links arrayList
                            if (insideItem)
                            {
                                links.add(xpp.nextText());
                            }
                        }
                        else if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item"))
                        {
                            insideItem = false;
                        }

                        eventType = xpp.next();
                    }
                }
                exception = null;
            }
            catch (MalformedURLException e)
            {
                exception = e;
            }
            catch (XmlPullParserException e)
            {
                exception = e;
            }
            catch (IOException e)
            {
                exception = e;
            }

            return exception;
        }

        @Override
        protected void onPostExecute(Exception s) {
            super.onPostExecute(s);

            // create the arrayAdapter to set on the list view
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, titles);

            lvRss.setAdapter(adapter);

            progressDialog.dismiss();
        }
    }
}
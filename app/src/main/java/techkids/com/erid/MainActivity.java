package techkids.com.erid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import techkids.com.erid.databases.DatabaseHandle;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.toString();
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv_story);

        StoryAdapter storyAdapter = new StoryAdapter(this, R.layout.item_list_story,
                DatabaseHandle.getInstance(this).getListStory());
        listView.setAdapter(storyAdapter);
    }
}

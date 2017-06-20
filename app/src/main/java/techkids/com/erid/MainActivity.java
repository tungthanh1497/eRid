package techkids.com.erid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import techkids.com.erid.databases.DatabaseHandle;
import techkids.com.erid.databases.StoryModel;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.toString();
    ListView listView;
    private View view1, view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        view1 = getLayoutInflater().inflate(R.layout.activity_main, null);
        view2 = getLayoutInflater().inflate(R.layout.content, null);
        setContentView(view1);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv_story);

        StoryAdapter storyAdapter = new StoryAdapter(this, R.layout.item_list_story,
                DatabaseHandle.getInstance(this).getListStory());
        listView.setAdapter(storyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StoryModel storyModel = (StoryModel) listView.getItemAtPosition(position);
                ImageView avatar = (ImageView) findViewById(R.id.iv_avatar);
                TextView title = (TextView) findViewById(R.id.tv_title_2);
                TextView author = (TextView) findViewById(R.id.tv_author_2);
                TextView description = (TextView) findViewById(R.id.tv_description_2);

                try {
//                    String[] image = storyModel.getImage().split(",");
//                    byte[] decodeByte = Base64.decode(image[1], Base64.DEFAULT);
//                    Bitmap bitmap = BitmapFactory.decodeByteArray(decodeByte, 0, decodeByte.length);
//                    avatar.setImageBitmap(bitmap);

                    title.setText(storyModel.getTitle());
                    author.setText(storyModel.getAuthor());
                    description.setText(storyModel.getDescription());
                }catch (Exception e){
                    Log.d(TAG, "exception: " +e);
                }



                setContentView(view2);
            }
        });
    }

}

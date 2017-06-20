package techkids.com.erid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import techkids.com.erid.databases.StoryModel;

/**
 * Created by tungthanh.1497 on 06/17/2017.
 */

public class StoryAdapter extends ArrayAdapter<StoryModel>{

    private Context context;
    private int resource;
    private List<StoryModel> storyModelList;


    public StoryAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<StoryModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.storyModelList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.item_list_story, null);
        StoryModel storyModel = storyModelList.get(position);

        TextView tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        TextView tvAuthor = (TextView) itemView.findViewById(R.id.tv_author);
        ImageView ivStory = (ImageView) itemView.findViewById(R.id.iv_story);

        tvTitle.setText(storyModel.getTitle());
        tvAuthor.setText(storyModel.getAuthor());

        String[] image = storyModel.getImage().split(",");
        byte[] decodeByte = Base64.decode(image[1], Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodeByte, 0, decodeByte.length);
        ivStory.setImageBitmap(bitmap);

        convertView = itemView;
        return convertView;
    }
}

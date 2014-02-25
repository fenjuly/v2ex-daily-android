package com.yugy.v2ex.daily.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.view.MenuItem;

import com.yugy.v2ex.daily.R;
import com.yugy.v2ex.daily.activity.swipeback.SwipeBackActivity;
import com.yugy.v2ex.daily.fragment.TopicFragment;

/**
 * Created by yugy on 14-2-24.
 */
public class TopicActivity extends SwipeBackActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        if(savedInstanceState == null){
            TopicFragment topicFragment = new TopicFragment();
            if(getIntent().hasExtra("argument")){
                topicFragment.setArguments(getIntent().getBundleExtra("argument"));
            }
            getFragmentManager().beginTransaction().add(R.id.container_activity_topic, topicFragment).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if(NavUtils.shouldUpRecreateTask(this, upIntent)){
                    TaskStackBuilder.create(this).addNextIntentWithParentStack(upIntent).startActivities();
                }else{
                    upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

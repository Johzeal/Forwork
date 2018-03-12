package com.example.zhujiaxiang.forwork.foot;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.zhujiaxiang.forwork.MainActivity;
import com.example.zhujiaxiang.forwork.R;
import com.example.zhujiaxiang.forwork.find.FindActivity;
import com.example.zhujiaxiang.forwork.mine.MineActivity;
import com.example.zhujiaxiang.forwork.tools.ClearCacheActivity;
import com.example.zhujiaxiang.forwork.tools.CollectionActivity;
import com.example.zhujiaxiang.forwork.tools.TicklingActivity;

/**
 * Created by zhujiaxiang on 18/3/8.
 */

public class NavActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext = this;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    private ImageButton mImgBtn_footprint;
    private ImageButton mImgBtn_irrelevance;
    private ImageButton mImgBtn_weather;
    private ImageButton mImgBtn_health;
    private ImageButton mImgBtn_friendtalk;
    private ImageButton mImgBtn_data;
    private FloatingActionButton mFloatingActionButton;
    private Button mBtn_find;
    private Button mBtn_mine;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        init();

        // 设置导航菜单宽度
        ViewGroup.LayoutParams params = mNavigationView.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels * 1 / 2;
        mNavigationView.setLayoutParams(params);
        //  点击NavigationView中的menu产生的反应
        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(new NavigationView.
                    OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_location:
                            Toast.makeText(mContext, "今日行走12832步", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.nav_test:
                            Toast.makeText(mContext, "点击了做过的测试", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.nav_collect:
                            Intent intent_collection = new Intent(NavActivity.this, CollectionActivity.class);
                            startActivity(intent_collection);
                            break;
                        case R.id.nav_logout:
                            Intent intent_logout = new Intent(NavActivity.this, MainActivity.class);
                            startActivity(intent_logout);
                            finish();
                            break;
                        case R.id.nav_suggestion:
                           Intent intent_sugestion = new Intent(NavActivity.this, TicklingActivity.class);
                            startActivity(intent_sugestion);
                            break;
                        case R.id.nav_clearCache:
                            ClearCacheActivity.clearAllCache(getApplicationContext());
                            Toast.makeText(mContext, "缓存已清除", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    item.setChecked(true);
                    //关闭抽屉
                    mDrawerLayout.closeDrawer(mNavigationView);
                    //或者：drawerLayout.closeDrawers();
                    return true;
                }
            });
        }
    }
    //  初始化
    private void init() {
        //  分别定义了FootActivity上的ImageButton
        mImgBtn_footprint = (ImageButton)findViewById(R.id.ImgBtn_footprint);
        mImgBtn_irrelevance = (ImageButton)findViewById(R.id.ImgBtn_irrelevance);
        mImgBtn_weather = (ImageButton)findViewById(R.id.ImgBtn_weather);
        mImgBtn_health = (ImageButton)findViewById(R.id.ImgBtn_health);
        mImgBtn_friendtalk = (ImageButton)findViewById(R.id.ImgBtn_friendtalk);
        mImgBtn_data = (ImageButton)findViewById(R.id.ImgBtn_data);
        mFloatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        mBtn_find = (Button)findViewById(R.id.btn_findgray2);
        mBtn_mine = (Button)findViewById(R.id.btn_minegray2);
        //定义DraweLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //定义NavigationView
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        //  产生点击事件
        mImgBtn_footprint.setOnClickListener(this);
        mImgBtn_irrelevance.setOnClickListener(this);
        mImgBtn_weather.setOnClickListener(this);
        mImgBtn_data.setOnClickListener(this);
        mImgBtn_friendtalk.setOnClickListener(this);
        mImgBtn_health.setOnClickListener(this);
        mFloatingActionButton.setOnClickListener(this);
        mBtn_find.setOnClickListener(this);
        mBtn_mine.setOnClickListener(this);
    }

//    private void initActionBar() {
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("足迹");
//        actionBar.setDisplayHomeAsUpEnabled(true);
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.floatingActionButton:
                mDrawerLayout.openDrawer(mNavigationView);
                break;
            case R.id.ImgBtn_footprint:
                Intent intent_footprint = new Intent(NavActivity.this,FootPrintActivity.class);
                startActivity(intent_footprint);
                break;
            case R.id.ImgBtn_health:
                Intent intent_health = new Intent(NavActivity.this,HealthActivity.class);
                startActivity(intent_health);
                break;
            case R.id.ImgBtn_irrelevance:
                break;
            case R.id.ImgBtn_data:
                Intent intent_data = new Intent(NavActivity.this,DataActivity.class);
                startActivity(intent_data);
                break;
            case R.id.ImgBtn_friendtalk:
                Intent intent_friendtalk = new Intent(NavActivity.this,FriendTalkActivity.class);
                startActivity(intent_friendtalk);
                break;
            case R.id.ImgBtn_weather:
                Intent intent_weather = new Intent(NavActivity.this,WeatherActivity.class);
                startActivity(intent_weather);
                break;
            case R.id.btn_findgray2:
                Intent intent_find = new Intent(NavActivity.this,FindActivity.class);
                startActivity(intent_find);
                overridePendingTransition(0,0);
                finish();
                break;
            case R.id.btn_minegray2:
                Intent intent_mine = new Intent(NavActivity.this, MineActivity.class);
                startActivity(intent_mine);
                overridePendingTransition(0,0);
                finish();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

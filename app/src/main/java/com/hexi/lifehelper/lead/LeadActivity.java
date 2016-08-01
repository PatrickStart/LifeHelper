package com.hexi.lifehelper.lead;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.hexi.lifehelper.R;
import com.hexi.lifehelper.activity.HomeActivity;
import com.hexi.lifehelper.base.BaseActivity;
import com.hexi.lifehelper.util.SharePreTools;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by he.xx on 2016/7/30.
 */
public class LeadActivity extends BaseActivity {
    LeadPagerAdapter adapter;
    @Bind(R.id.lead_viewpager)
    ViewPager leadViewpager;
    @Bind(R.id.lead_circle)
    CircleIndicator leadCircle;
    List<View> list;
    ImageView[] img;
    LayoutInflater inflater;
    boolean flag = false;//判断ViewPager滑动到最后一页
    SharePreTools share;

    @Override
    public void setLayout() {
        share = SharePreTools.getInstance(this);
        setContentView(R.layout.lead);
        ButterKnife.bind(this);
        if (!share.getIsFirstUse()) {
            startActivity(HomeActivity.class, R.anim.enter_alpha, R.anim.exit_alpha);
            finish();
        }

    }

    @Override
    public void loadData() {
        list = new ArrayList<View>();
        img = new ImageView[3];
        inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        ImageView iv0 = (ImageView) inflater.inflate(R.layout.imageview, null);
        ImageView iv1 = (ImageView) inflater.inflate(R.layout.imageview, null);
        ImageView iv2 = (ImageView) inflater.inflate(R.layout.imageview, null);
        iv0.setImageResource(R.mipmap.ic_launcher);
        iv1.setImageResource(R.mipmap.ic_launcher);
        iv2.setImageResource(R.mipmap.ic_launcher);
        list.add(iv0);
        list.add(iv1);
        list.add(iv2);

    }

    @Override
    public void setView() {
        adapter = new LeadPagerAdapter(this);
        adapter.setList(list);
        leadViewpager.setAdapter(adapter);
        leadCircle.setViewPager(leadViewpager);
        leadViewpager.addOnPageChangeListener(listener);
    }

    private ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {
            switch (state) {
                case 0://当前如果什么都没做，并且是最后一个item了实现跳转
                    if (!flag && (leadViewpager.getCurrentItem() == (list.size() - 1))) {
                        startActivity(HomeActivity.class, R.anim.enter_alpha, R.anim.exit_alpha);
                        share.isFirstUse();
                        finish();
                    }

                    flag = true;
                    break;

                case 1://如果当前正在滑动，但是并没有滑动完成，滑动完成以后flag是false  所以跳转是应该判断非flag
                    flag = false;
                    break;

                case 2://如果还能继续滑动并且已经滑动完成，flag的值为true，说明还能滑动
                    flag = true;
                    break;

            }
        }
    };


    @Override
    public void onClick(View v) {

    }
}

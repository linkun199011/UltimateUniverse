package com.ustclin.max.ultimateuniverse;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.ustclin.max.ultimateuniverse.fragment.BagFragment;
import com.ustclin.max.ultimateuniverse.fragment.BattleFragment;
import com.ustclin.max.ultimateuniverse.fragment.CampFragment;
import com.ustclin.max.ultimateuniverse.fragment.EquipmentFragment;
import com.ustclin.max.ultimateuniverse.fragment.SettingsFragment;

/**
 * 项目主Activity
 *
 * @author LinKun
 */
public class FragmentActivity extends Activity implements OnClickListener {
    private Context mContext;
    private final int CAMP = 0;
    private final int EQUIPMENT = 1;
    private final int BAG = 2;
    private final int BATTLE = 3;
    private final int SETTINGS = 4;

    // 营地
    private CampFragment campFragment;
    private ImageView campImage;
    private TextView campText;

    // 装备
    private EquipmentFragment equipmentFragment;
    private ImageView equipmentImage;
    private TextView equipmentText;

    // 背包
    private BagFragment bagFragment;
    private ImageView bagImage;
    private TextView bagText;

    // 战斗
    private BattleFragment battleFragment;
    private ImageView battleImage;
    private TextView battleText;

    // 设置
    private SettingsFragment settingsFragment;
    private ImageView settingsImage;
    private TextView settingsText;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFormat(PixelFormat.TRANSLUCENT);// （这个对宿主没什么影响，建议声明）
        super.onCreate(savedInstanceState);
        mContext = this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fragment_main);
        // 初始化布局元素
        initViews();
        fragmentManager = getFragmentManager();
        // 第一次启动时选中第0个tab
        setTabSelection(CAMP);
    }

    /**
     * 在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。
     */
    private void initViews() {
        View campLayout;
        View equipmentLayout;
        View bagLayout;
        View battleLayout;
        View settingsLayout;

        campLayout = findViewById(R.id.camp_layout);
        campImage = (ImageView) findViewById(R.id.camp_image);
        campText = (TextView) findViewById(R.id.camp_text);

        equipmentLayout = findViewById(R.id.equipment_layout);
        equipmentImage = (ImageView) findViewById(R.id.equipment_image);
        equipmentText = (TextView) findViewById(R.id.equipment_text);

        bagLayout = findViewById(R.id.bag_layout);
        bagImage = (ImageView) findViewById(R.id.bag_image);
        bagText = (TextView) findViewById(R.id.bag_text);

        battleLayout = findViewById(R.id.battle_layout);
        battleImage = (ImageView) findViewById(R.id.battle_image);
        battleText = (TextView) findViewById(R.id.battle_text);

        settingsLayout = findViewById(R.id.settings_layout);
        settingsImage = (ImageView) findViewById(R.id.settings_image);
        settingsText = (TextView) findViewById(R.id.settings_text);

        campLayout.setOnClickListener(this);
        equipmentLayout.setOnClickListener(this);
        bagLayout.setOnClickListener(this);
        battleLayout.setOnClickListener(this);
        settingsLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.camp_layout:
                setTabSelection(CAMP);
                break;
            case R.id.equipment_layout:
                setTabSelection(EQUIPMENT);
                break;
            case R.id.bag_layout:
                setTabSelection(BAG);
                break;
            case R.id.battle_layout:
                setTabSelection(BATTLE);
                break;
            case R.id.settings_layout:
                setTabSelection(SETTINGS);
                break;
            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index 每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
     */
    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case CAMP:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                campImage.setImageResource(R.drawable.footer_camp_selected);
                campText.setTextColor(mContext.getResources().getColor(R.color.footerText));
                if (campFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    campFragment = new CampFragment();
                    transaction.add(R.id.content, campFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(campFragment);
                }
                break;
            case EQUIPMENT:
                // 当点击了联系人tab时，改变控件的图片和文字颜色
                equipmentImage.setImageResource(R.drawable.footer_equipment_selected);
                equipmentText.setTextColor(mContext.getResources().getColor(R.color.footerText));
                if (equipmentFragment == null) {
                    // 如果ContactsFragment为空，则创建一个并添加到界面上
                    equipmentFragment = new EquipmentFragment();
                    transaction.add(R.id.content, equipmentFragment);
                } else {
                    // 如果ContactsFragment不为空，则直接将它显示出来
                    transaction.show(equipmentFragment);
                }
                break;
            case BAG:
                // 当点击了动态tab时，改变控件的图片和文字颜色
                bagImage.setImageResource(R.drawable.footer_bag_selected);
                bagText.setTextColor(mContext.getResources().getColor(R.color.footerText));
                if (bagFragment == null) {
                    // 如果NewsFragment为空，则创建一个并添加到界面上
                    bagFragment = new BagFragment();
                    transaction.add(R.id.content, bagFragment);
                } else {
                    // 如果NewsFragment不为空，则直接将它显示出来
                    transaction.show(bagFragment);
                }
                break;

            case BATTLE:
                // 当点击了动态tab时，改变控件的图片和文字颜色
                battleImage.setImageResource(R.drawable.footer_battle_selected);
                battleText.setTextColor(mContext.getResources().getColor(R.color.footerText));
                if (battleFragment == null) {
                    // 如果NewsFragment为空，则创建一个并添加到界面上
                    battleFragment = new BattleFragment();
                    transaction.add(R.id.content, battleFragment);
                } else {
                    // 如果NewsFragment不为空，则直接将它显示出来
                    transaction.show(bagFragment);
                }
                break;
            case SETTINGS:
                // 当点击了设置tab时，改变控件的图片和文字颜色
                settingsImage.setImageResource(R.drawable.footer_settings_selected);
                settingsText.setTextColor(mContext.getResources().getColor(R.color.footerText));
                if (settingsFragment == null) {
                    // 如果SettingFragment为空，则创建一个并添加到界面上
                    settingsFragment = new SettingsFragment();
                    settingsFragment.setActivity(this);
                    transaction.add(R.id.content, settingsFragment);
                } else {
                    // 如果SettingFragment不为空，则直接将它显示出来
                    transaction.show(settingsFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        campImage.setImageResource(R.drawable.footer_camp_unselected);
        campText.setTextColor(Color.parseColor("#82858b"));

        equipmentImage.setImageResource(R.drawable.footer_equipment_unselected);
        equipmentText.setTextColor(Color.parseColor("#82858b"));

        bagImage.setImageResource(R.drawable.footer_bag_unselected);
        bagText.setTextColor(Color.parseColor("#82858b"));

        battleImage.setImageResource(R.drawable.footer_battle_unselected);
        battleText.setTextColor(Color.parseColor("#82858b"));

        settingsImage.setImageResource(R.drawable.footer_settings_unselected);
        settingsText.setTextColor(Color.parseColor("#82858b"));
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (campFragment != null) {
            transaction.hide(campFragment);
        }
        if (equipmentFragment != null) {
            transaction.hide(equipmentFragment);
        }
        if (bagFragment != null) {
            transaction.hide(bagFragment);
        }
        if (battleFragment != null) {
            transaction.hide(battleFragment);
        }
        if (settingsFragment != null) {
            transaction.hide(settingsFragment);
        }
    }
}

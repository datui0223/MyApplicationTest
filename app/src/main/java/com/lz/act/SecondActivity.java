package com.lz.act;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lz.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by DELL on 2017/11/2.
 */

public class SecondActivity extends AppCompatActivity {
    @BindView(R.id.tv_go)
    TextView tv_go;
    @BindView(R.id.bt_add)
    Button bt_add;
    @BindView(R.id.bt_del)
    Button bt_del;
    @BindView(R.id.bt_del_all)
    Button bt_del_all;
    @BindView(R.id.bt_update)
    Button bt_update;
    @BindView(R.id.bt_find)
    Button bt_find;
    @BindView(R.id.bt_find_all)
    Button bt_find_all;
    @BindView(R.id.bt_addId)
    Button bt_addId;
    @BindView(R.id.bt_del_table)
    Button bt_del_table;
    @BindView(R.id.bt_toone)
    Button bt_toone;
    @BindView(R.id.bt_tomany)
    Button bt_tomany;
    @BindView(R.id.bt_ntom)
    Button bt_ntom;
    @BindView(R.id.bt_find_link)
    Button bt_find_link;
    @BindView(R.id.et_input)
    EditText et_input;
    @BindView(R.id.bt_ok)
    Button bt_ok;

    @BindView(R.id.iv_show)
    SimpleDraweeView iv_show;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.tv_go)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.bt_add:

                break;
            case R.id.bt_ok:

                break;
            case R.id.bt_del:

                break;
            case R.id.bt_find:

                break;
            default:

                break;
        }
    }
}

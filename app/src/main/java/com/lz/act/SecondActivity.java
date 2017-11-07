package com.lz.act;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lz.myapplication.R;
import com.lz.utils.ImageController;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    @BindView(R.id.sv_second)
    ScrollView sv_second;

    @BindView(R.id.iv_show)
    SimpleDraweeView iv_show;
    @BindView(R.id.iv_show1)
    SimpleDraweeView iv_show1;
    @BindView(R.id.iv_show2)
    SimpleDraweeView iv_show2;
    @BindView(R.id.iv_show3)
    SimpleDraweeView iv_show3;
    @BindView(R.id.iv_show4)
    SimpleDraweeView iv_show4;
    @BindView(R.id.iv_show5)
    SimpleDraweeView iv_show5;
    @BindView(R.id.iv_show6)
    SimpleDraweeView iv_show6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        Uri uri = Uri.parse("http://pic.58pic.com/58pic/13/66/58/20258PICpDh_1024.png");
        Uri uri1 = Uri.parse("http://mpic.tiankong.com/935/cce/935cce5611ee35530947666ef1201206/640.jpg");
        Uri uri2 = Uri.parse("http://mpic.tiankong.com/e05/aac/e05aac559997cbdab5666ef4d49af70e/640.jpg");
        Uri uri3 = Uri.parse("http://mpic.tiankong.com/f9f/419/f9f4194cb05d1334f42b1650585c2250/640.jpg");
        Uri uri4 = Uri.parse("http://mpic.tiankong.com/265/1d6/2651d66b9aa6f9ca423562fb3ab77c95/640.jpg");
        Uri uri5 = Uri.parse("http://mpic.tiankong.com/c91/3b8/c913b8fcb780a36977bef6543518bd83/640.jpg");
        Uri uri6 = Uri.parse("http://mpic.tiankong.com/b5a/e1e/b5ae1e7663d94c2ced8072c79c625665/640.jpg");
        ImageController imageController = new ImageController(iv_show,this,uri);
        ImageController imageController1 = new ImageController(iv_show1,this,uri1);
        ImageController imageController2 = new ImageController(iv_show2,this,uri2);
        ImageController imageController3 = new ImageController(iv_show3,this,uri3);
        ImageController imageController4 = new ImageController(iv_show4,this,uri4);
        ImageController imageController5 = new ImageController(iv_show5,this,uri5);
        ImageController imageController6 = new ImageController(iv_show6,this,uri6);
        iv_show.setController(imageController.getDraweeController());
        iv_show1.setController(imageController1.getDraweeController());
        iv_show2.setController(imageController2.getDraweeController());
        iv_show3.setController(imageController3.getDraweeController());
        iv_show4.setController(imageController4.getDraweeController());
        iv_show5.setController(imageController5.getDraweeController());
        iv_show6.setController(imageController6.getDraweeController());
//        iv_show.setImageURI(uri);
    }


//    @OnClick(R.id.tv_go)
//    public void onClick(View view){
//        switch (view.getId()){
//            case R.id.bt_add:
//
//                break;
//            case R.id.bt_ok:
//
//                break;
//            case R.id.bt_del:
//
//                break;
//            case R.id.bt_find:
//
//                break;
//            default:
//
//                break;
//        }
//    }
}

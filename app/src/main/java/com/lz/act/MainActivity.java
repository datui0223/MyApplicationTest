package com.lz.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lz.bean.MemberInfo;
import com.lz.bean.User;
import com.lz.dao.MemberInfoDao;
import com.lz.dao.UserDao;
import com.lz.myapplication.MyApplication;
import com.lz.myapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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


    UserDao userDao;
    MemberInfoDao memberInfoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tv_go.setMovementMethod(new ScrollingMovementMethod());
        bt_toone.setOnClickListener(this);
        bt_tomany.setOnClickListener(this);
        bt_ntom.setOnClickListener(this);
        bt_find_link.setOnClickListener(this);
        bt_add.setOnClickListener(this);
        bt_del_table.setOnClickListener(this);
        bt_addId.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_del_all.setOnClickListener(this);
        bt_del.setOnClickListener(this);
        bt_find.setOnClickListener(this);
        bt_find_all.setOnClickListener(this);
        bt_ok.setOnClickListener(this);
        bt_ok.setOnClickListener(this);
        tv_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class)
                        .putExtra("flag1","test")
                );
            }
        });
        userDao = MyApplication.getInstance().getDaoSession().getUserDao();
        memberInfoDao = MyApplication.getInstance().getDaoSession().getMemberInfoDao();

    }

    int tableFlag = 1;//1一对一，2一对多，3,多对多

    @Override
    public void onClick(View view) {
        try {

            switch (view.getId()) {
                case R.id.bt_add:
                    for (int i = 1; i < 10; i++) {
                        User user = new User();
                        user.setName("li" + i);
                        user.setAge(i);
                        userDao.insert(user);
                    }
                    break;
                case R.id.bt_ok:
                    startActivity(new Intent(MainActivity.this,SecondActivity.class).putExtra("flag1","null"));
                    break;
                case R.id.bt_addId:
                    User user2 = new User();
                    user2.setName("li" + et_input.getText().toString());
                    user2.setAge(Integer.valueOf(et_input.getText().toString()));
                    user2.setUid(Long.valueOf(et_input.getText().toString()));
                    user2.setFlag("flag" + et_input.getText().toString());
                    User usera4 = userDao.queryBuilder().where(UserDao.Properties.Uid.eq(et_input.getText().toString())).build().unique();
                    if (usera4 == null) {
                        userDao.insert(user2);
                    } else {
                        Toast.makeText(MainActivity.this, "failiue", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.bt_del:
                    userDao.deleteByKey(Long.valueOf(et_input.getText().toString()));
                    break;
                case R.id.bt_del_all:
                    userDao.deleteAll();
                    memberInfoDao.deleteAll();
                    break;
                case R.id.bt_update:
                    User user = userDao.queryBuilder().where(UserDao.Properties.Uid.eq(et_input.getText())).build().unique();
                    if (user != null) {
                        user.setName("update");
                        userDao.update(user);
                    } else {
                        Toast.makeText(MainActivity.this, "failiue", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.bt_find:
                    User user1 = getUserById(Long.valueOf(et_input.getText().toString()));
                    if (user1 != null) {
                        tv_go.setText(user1.toString());
//                    if(user1.getFlag()==null){
////                        User user6 = userDao.queryBuilder().where(UserDao.Properties.Uid.eq(et_input.getText())).build().unique();
//                        user1.setFlag("flag"+et_input.getText().toString());
//                        userDao.update(user1);
//                        tv_go.setText("已添加flag");
//                    }else {
//                        tv_go.setText(user1.toString());
//                    }
                    } else {
                        Toast.makeText(MainActivity.this, "failiue", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.bt_find_all:
                    tv_go.setText("");
                    List<User> list = userDao.loadAll();
                    for (int i = 0; i < list.size(); i++) {
                        tv_go.append(list.get(i).toString() + "\n");
                    }
                    break;
                case R.id.bt_del_table:
                    MyApplication.getInstance().getDaoSession().deleteAll(User.class);
                    break;
                case R.id.bt_toone:
                    tableFlag = 1;
                    for (int i = 1; i < 10; i++) {
                        MemberInfo info = new MemberInfo();
                        info.setGrade(i);
                        info.setWealthPoint(Long.valueOf(i));
                        memberInfoDao.insert(info);
                    }
                    break;
                case R.id.bt_tomany:
                    tableFlag = 2;
                    break;
                case R.id.bt_ntom:
                    tableFlag = 3;
                    break;
                case R.id.bt_find_link:
                    switch (tableFlag) {
                        case 1:
                            tableFlag = 4;
                            MemberInfo info = userDao.queryBuilder().where(UserDao.Properties.Uid.eq(et_input.getText())).build().unique().getMemberInfo();
                            tv_go.setText(info.toString());
                            break;
                        case 2:
                            tableFlag = 5;
                            break;
                        case 3:
                            tableFlag = 6;
                            break;
                        case 4:
                            tv_go.setText("");
                            List<MemberInfo> listMember = memberInfoDao.loadAll();
                            for (int i = 0; i < listMember.size(); i++) {
                                tv_go.append(listMember.get(i).toString());
                            }
                            tableFlag = 1;
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        default:
                            break;
                    }

                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            tv_go.setText(e.toString());
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    User getUserById(Long id) {
        User user = userDao.load(id);
        return user;
    }
}

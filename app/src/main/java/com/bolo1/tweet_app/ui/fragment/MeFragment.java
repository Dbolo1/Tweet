package com.bolo1.tweet_app.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bolo1.tweet_app.MainActivity;
import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.app.Tweet;
import com.bolo1.tweet_app.bean.PostFromService;
import com.bolo1.tweet_app.bean.User;
import com.bolo1.tweet_app.http.NetToService;
import com.bolo1.tweet_app.http.NetWorkCode;
import com.bolo1.tweet_app.ui.uitls.ConstantValue;
import com.bolo1.tweet_app.ui.uitls.LogUtils;
import com.bolo1.tweet_app.ui.uitls.Sputil;
import com.bolo1.tweet_app.ui.uitls.ToastUtil;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 菠萝 on 2018/4/20.
 */

public class MeFragment extends BaseFragment implements View.OnClickListener {

    private EditText et_test1;
    private EditText et_test2;
    private EditText et_test3;
    private Button bt_register, bt_query;
    public  TextView tv_me_login;
    public ImageView iv_me_user;
    public TextView tv_me_user_name;
    public LinearLayout ll_me_user_des;
    public ListView lv_me;
    private PostFromService pfs;
    private User user;


    private Handler handler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 101:
                    //登录成功刷新信息
                    refreshUserDes(msg.obj);
                    break;
            }
        }
    };

    /**
     * 刷新用户信息
     * @param obj
     */
    private void refreshUserDes(Object obj) {
        User user= (User) obj;
        LogUtils.e("----------------------------进入登录信息"+login_state+"用户数据"+user.toString());
        if(login_state&&!"".equals(user.toString())){
            tv_me_login.setText(getResources().getString(R.string.exit_login));
            tv_me_user_name.setText(user.getUser_name());
            if(!"".equals(user.getUser_icon())){
                Glide.with(getActivity()).load(user.getUser_icon()).into(iv_me_user);
            }else {
                iv_me_user.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
            }
            Sputil.putBoolean(getActivity(),ConstantValue.ISLOGIN,true);
            Sputil.putString(getActivity(),ConstantValue.USER_LOGIN_DES,tmpUser.toString());
            ///-----------------

        }else {
            tv_me_login.setText(getResources().getString(R.string.login));
        }
    }

    @Nullable
    @Override
    public View getLoadView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Context context = getContext();
        View view = LayoutInflater.from(getContext()).inflate(R.layout.me_layout, null);
        initView(view);
        return view;
    }



    private void initView(View view) {
        ///登录的点击
        tv_me_login = view.findViewById(R.id.tv_me_login);
        if (Sputil.getBoolean(getActivity(),ConstantValue.ISLOGIN,false)){
            tv_me_login.setText(getResources().getString(R.string.exit_login));
        }else {
            tv_me_login.setText(getResources().getString(R.string.login));
        }

        tv_me_login.setOnClickListener(this);
        tv_me_user_name =view.findViewById(R.id.tv_me_user_name);
        iv_me_user =view.findViewById(R.id.iv_me_user);
        ll_me_user_des =view.findViewById(R.id.ll_me_user_des);
        lv_me =view.findViewById(R.id.lv_me);
    }
    AlertDialog loginDialog =null;
    AlertDialog registerDialog=null;
    Button bt_register_dialog=null;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_me_login:
                //判断现在是否是在线
                isLogin();
                break;
            case R.id.bt_login_register:
                //注册账号
              //  loginDialog.dismiss();
                isRegister();
                break;
        }
    }

    private void isRegister() {
        registerDialog = new AlertDialog.Builder(getActivity()).create();
        View registerView = View.inflate(getActivity(), R.layout.register_dialog, null);
        final EditText et_register_dialog_password = registerView.findViewById(R.id.et_register_dialog_password);
        final   EditText et_register_dialog_userName = registerView.findViewById(R.id.et_register_dialog_userName);
        final   EditText et_register_dialog_email = registerView.findViewById(R.id.et_register_dialog_email);
        bt_register_dialog = registerView.findViewById(R.id.bt_register_dialog);
        bt_register_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //注册账号是否成功
                String tmpRegisterPass = et_register_dialog_password.getText().toString();
                String tmpRegisterName = et_register_dialog_userName.getText().toString();
                String tmpRegisterEmail = et_register_dialog_email.getText().toString();
                if (!tmpRegisterEmail.equals("")&&!tmpRegisterPass.equals("")&&!tmpRegisterName.equals("")){
                    //向服务器发送注册信息//注册成功关闭对话框
                    boolean b = registerUser(tmpRegisterEmail, tmpRegisterPass, tmpRegisterName);
                    if(b){
                        registerDialog.dismiss();
                    }
                }
            }
        });
        registerDialog.setTitle(getResources().getString(R.string.register));
        registerDialog.setView(registerView);
        registerDialog.show();
    }





    private void isLogin() {
        DialogInterface.OnClickListener dialoglistener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case DialogInterface.BUTTON_POSITIVE:
                        //积极
                        login_state=false;
                        Sputil.putBoolean(getActivity(),ConstantValue.ISLOGIN,false);
                        Sputil.putString(getActivity(),ConstantValue.USER_LOGIN_DES,"");
                        LogUtils.e("j进入list--s"+Sputil.getBoolean(getActivity(),ConstantValue.ISLOGIN,false));
                        if (Sputil.getBoolean(getActivity(),ConstantValue.ISLOGIN,false)){
                            tv_me_login.setText(getResources().getString(R.string.exit_login));
                        }else {
                            tv_me_login.setText(getResources().getString(R.string.login));
                        }
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        //消极
                        dialogInterface.dismiss();
                        break;
                }
            }
        };


        MainActivity mainActivity = (MainActivity) getActivity();
        Boolean isLogin= Sputil.getBoolean(getActivity(),ConstantValue.ISLOGIN,false);
        if(isLogin){
            //退出
            final AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
            builder.setTitle(getResources().getString(R.string.logout_dialog_title));
            builder.setPositiveButton("确定",dialoglistener);
            builder.setNegativeButton("取消",dialoglistener);
            final AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }else {
            //登录
            //跳出登录框
            //  ToastUtil.show(getActivity(),"login");
            loginDialog = new AlertDialog.Builder(getActivity()).create();
            View inflate = View.inflate(getActivity(), R.layout.login_dialog, null);
            loginDialog.setView(inflate);
            loginDialog.setIcon(getResources().getDrawable(R.mipmap.user_login));
            loginDialog.setTitle(getResources().getString(R.string.login));
            final EditText et_login_dialog_id = inflate.findViewById(R.id.et_login_dialog_id);
            final EditText et_login_dialog_pass = inflate.findViewById(R.id.et_login_dialog_pass);
            Button bt_login_register = inflate.findViewById(R.id.bt_login_register);
            Button bt_login_dialog = inflate.findViewById(R.id.bt_login_dialog);
            bt_login_register.setOnClickListener(MeFragment.this);
            bt_login_dialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //登录比对服务器
                    String tmpid = et_login_dialog_id.getText().toString();
                    String tmpPass = et_login_dialog_pass.getText().toString();
                    if(!tmpid.equals("")&&!tmpPass.equals("")){
                        //连接到数据库进行对比//成功关闭对话框
                        boolean b = login2Service(tmpid, tmpPass);
                        if(b){
                            loginDialog.dismiss();
                        }
                    }
                }
            });
            loginDialog.show();
        }
    }

    /**
     * 注册账号
     * @param tmpRegisterEmail
     * @param tmpRegisterPass
     * @param tmpRegisterName
     */
    boolean register_state;
    private boolean registerUser(String tmpRegisterEmail, String tmpRegisterPass, String tmpRegisterName) {
        pfs = new PostFromService();
        pfs.setType(NetWorkCode.REGISTER_USER);
        user = new User();
        user.setUser_id(tmpRegisterEmail);
        user.setUser_name(tmpRegisterName);
        user.setUser_pass(tmpRegisterPass);
        user.setData_type(NetWorkCode.REGISTER_USER);
        pfs.setBody(user.toString());
        NetToService netToService = new NetToService(user, new NetToService.OnCallBackServiceData() {
            @Override
            public void onFailure(String s)
            {
                register_state=false;
                ToastUtil.show(getActivity(),s);
            }

            @Override
            public void onSucceed(Object objects) {
                ///返回的数据  1为成功 0为失败
                Log.d("tag", "解析的数据- tweet---" + objects.toString());
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(objects.toString());
                    String tmp=jsonObject.getString(user.getData_type());
                    User user1 = new Gson().fromJson(tmp, User.class);
                    Message message = new Message();
                    message.obj=getResources().getString(R.string.register_succeed);
                    Tweet.getHandler().sendMessage(message);
                    Log.d("tag", "解析的数据- tweet---" + objects.toString());
                    register_state=true;

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread = new Thread(netToService);
        thread.start();
        return register_state;
    }

    /**
     * 登录到服务器
     * @param tmpid
     * @param tmpPass
     */
    boolean login_state;
    public User tmpUser;
    private boolean login2Service(String tmpid, String tmpPass) {

        pfs = new PostFromService();
        pfs.setType(NetWorkCode.LOGIN_USER);
        final User user = new User();
        user.setUser_id(tmpid);
        user.setUser_pass(tmpPass);
        user.setData_type(NetWorkCode.LOGIN_USER);     //   BeanToJson.create(user);
        pfs.setBody(user.toString());

        NetToService netToService = new NetToService(user, new NetToService.OnCallBackServiceData() {
            @Override
            public void onFailure(String s) {
                LogUtils.d(s);
                login_state=false;
            }

            @Override
            public void onSucceed(Object objects) {
                 ///返回的数据  1为成功 0为失败
                Log.d("tag", "解析的数据- tweet---" + objects.toString());
                LogUtils.d("-----login----"+objects.toString());
                try {
                    JSONObject jsonObject = new JSONObject(objects.toString());
                    String tmp=jsonObject.getString(user.getData_type());
                    tmpUser = new Gson().fromJson(tmp, User.class);
                    Message m1 = new Message();
                    m1.obj=getResources().getString(R.string.login_succeed);
                    Tweet.getHandler().sendMessage(m1);
                    Log.d("tag", "解析的数据- tweet---" + objects.toString());
                    login_state=true;
                    //将登录信息填入用户单
                    Message message1 = new Message();
                    message1.obj=tmpUser;
                    message1.what=101;
                    handler.sendMessageDelayed(message1,1000);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread = new Thread(netToService);
        thread.start();


        return login_state;
    }
}

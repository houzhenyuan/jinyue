//存用户数据

package test.com.jinyue;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 86758 on 2017/11/14 0014.
 */


public class SharePreference {

    public Context context;
    public SharePreference(Context context)
    {
        this.context = context;
    }

    /****设置状态  false为安装后第一次登录，true为已经登录过****/
    public void setState()
    {
        SharedPreferences sp = context.getSharedPreferences("first_login_save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isLogin", true);
        editor.commit();
    }

    //设置复选框标签为true，即选中
    public void setMeiWenTrue(){
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("MeiWenChecked", true);
        editor.commit();
    }
    public void setZeXueTrue(){
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("ZeXueChecked", true);
        editor.commit();
    }
    public void setTuiLiTrue(){
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("TuiLiChecked", true);
        editor.commit();
    }
    public void setKeHuanTrue(){
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("KeHuanChecked", true);
        editor.commit();
    }
    public void setJiTangTrue(){
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("JiTangChecked", true);
        editor.commit();
    }
    public void setGuWenTrue(){
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("GuWenChecked", true);
        editor.commit();
    }
    public void setJiShiTrue(){
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("JiShiChecked", true);
        editor.commit();
    }

    //设置复选框标签为false，即未选中
    public void setMeiWenFalse(){
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("MeiWenChecked", false);
        editor.commit();
    }
    public void setZeXueFalse(){
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("ZeXueChecked", false);
        editor.commit();
    }
    public void setTuiLiFalse(){
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("TuiLiChecked", false);
        editor.commit();
    }
    public void setJiTangFalse(){
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("JiTangChecked", false);
        editor.commit();
    }
    public void setKeHuanFalse(){
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("KeHuanChecked", false);
        editor.commit();
    }
    public void setGuWenFalse(){
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("GuWenChecked", false);
        editor.commit();
    }
    public void setJiShiFalse(){
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("JiShiChecked", false);
        editor.commit();
    }

    /***获取状态***/
    public boolean getState()
    {
        SharedPreferences sp = context.getSharedPreferences("first_login_save", Context.MODE_PRIVATE);
        boolean b = sp.getBoolean("isLogin", false);
        return b;
    }

    public boolean getMeiWen()
    {
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        boolean b = sp.getBoolean("MeiWenChecked", false);
        return b;
    }
    public boolean getZeXue()
    {
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        boolean b = sp.getBoolean("ZeXueChecked", false);
        return b;
    }
    public boolean getTuiLi()
    {
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        boolean b = sp.getBoolean("TuiLiChecked", false);
        return b;
    }
    public boolean getJiTang()
    {
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        boolean b = sp.getBoolean("JiTangChecked", false);
        return b;
    }
    public boolean getKeHuan()
    {
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        boolean b = sp.getBoolean("KeHuanChecked", false);
        return b;
    }
    public boolean getGuWen()
    {
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        boolean b = sp.getBoolean("GuWenChecked", false);
        return b;
    }
    public boolean getJiShi()
    {
        SharedPreferences sp = context.getSharedPreferences("tags_save", Context.MODE_PRIVATE);
        boolean b = sp.getBoolean("JiShiChecked", false);
        return b;
    }
}

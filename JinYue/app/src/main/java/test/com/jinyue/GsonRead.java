package test.com.jinyue;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王国华 on 2017/11/16.
 */

public class GsonRead {
    public String Title;
    public String Auther;
    public String Text;


    public static List getGson(String jsonString, String Title, String Auther, String Text) {
        Gson gson = new Gson();
        GsonRead gsonRead = gson.fromJson(jsonString, GsonRead.class);
        Title = gsonRead.Title;
        Auther = gsonRead.Auther;
        Text = gsonRead.Text;
        System.out.println(Title);
        System.out.println(Text);
        List<String> list = new ArrayList<String>();
        list.add(Title);
        list.add(Auther);
        list.add(Text);
        return list;
    }




}

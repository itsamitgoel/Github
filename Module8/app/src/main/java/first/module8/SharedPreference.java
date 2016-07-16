package first.module8;

/**
 * Created by 2015 on 12-Jul-16.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class SharedPreference {

    public static final String PREFS_NAME = "AOP_PREFS";
    public static final String KEY_NAME = "name";
    public static final String KEY_URL = "photo_url";
    SharedPreferences settings  ;
    Editor editor;
    public SharedPreference() {
        super();
    }
    public void savename(Context context, String text) {
        SharedPreferences settings;
        settings =  context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.putString(KEY_NAME, text);
        editor.commit();
    }
    public void saveurl(Context context, String text) {
        SharedPreferences settings;


        //settings = PreferenceManager.getDefaultSharedPreferences(context);

        settings =  context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.putString(KEY_URL, text);
        editor.commit();
    }
    public String getname(Context context ) {

        SharedPreferences settings;
        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);


        String s = settings.getString(KEY_NAME,null);
        return s;

    }
    public String geturl(Context context) {
        SharedPreferences settings;
        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        String s = settings.getString(KEY_URL, null);
        return s;

    }
    public void clearit()
    {
        editor.clear();
        editor.commit();
    }
}

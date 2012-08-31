package appinventor.ai_brandonlnelson15.PokeMyGummy;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.appbrain.AppBrain;
import com.papaya.cross.promotion.CrossPromotion;
import com.papaya.cross.promotion.CrossPromotionConfig;
import com.tapfortap.AdView;
import com.tapfortap.TapForTap;


public class PokeMyGummyActivity extends Activity {
	
    int count = 0;
    MediaPlayer mediaPlayer;
    private int hits = 0;
    private WebView mWebView;
    private AdView adView;
    //private Context cunt;
    
    //public static final int INVISIBLE = 4;
    //public static final int VISIBLE = 0;
    
    //FOR REVMOB
    //private static String APPLICATION_ID = "501b7dd76336dc00080000f5";
    
    
    //FOR SLIDE|ME
    private static String APPLICATION_ID = "58a5b9bfa5e04de0f1a216796b94b856"; 

    public  static CrossPromotion CrossPromotionObject;
    
    
    /*
    private void openActionView(String url){

        Intent updateIntent = null;

        updateIntent = new Intent(Intent.ACTION_VIEW,

                Uri.parse(url));

        startActivity(updateIntent);

    }
    */
    
    private static String tapfortap;
    private static String appbrainbanner;
    private static String appflood;
    
    private static boolean tft;
    private static boolean abb;
    private static boolean afl;
    
    
    public void showAd() {
    	//RevMobAds.showFullscreenAd(this, APPLICATION_ID);
    }
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        
        AppBrain.init(this);

        
        try {
	        tapfortap = AppBrain.getSettings().get("tapfortap", "on");
	        appbrainbanner = AppBrain.getSettings().get("appbrainbanner", "on");
	        appflood = AppBrain.getSettings().get("appflood", "on");
        }
        catch(Exception e) {
        	Toast.makeText(this, "AppBrain settings could not be retrieved.", Toast.LENGTH_LONG).show();
        }
        
        
        if(tapfortap=="on") {
        	tft=true;
        }
        else if(tapfortap=="off"){
        	tft=false;
        }
        else {
        	tft=false;
        }
        

        if(appbrainbanner=="on") {
        	abb=true;
        }
        else if(appbrainbanner=="off"){
        	abb=false;
        }
        else {
        	abb=false;
        }
        

        if(appflood=="on") {
        	afl=true;
        }
        else if(appflood=="off") {
        	afl=false;
        }
        else{
        	afl=false;
        }
       
        
        //RevMobAds.startSession(this, APPLICATION_ID);
        
              
        if(tft) {
	        TapForTap.setDefaultAppId("f1fc6a00-c2f3-012f-fa76-4040d804a637");
	        TapForTap.checkIn(this);
        }
        else{}
        
        setContentView(R.layout.main);

        if(afl) {
	        CrossPromotionObject=new CrossPromotion(this, "BSMr5yh2evMx9cbp",
	        		"5w20Stad155L503aeac5", CrossPromotionConfig.AD_ALL,CrossPromotionConfig.PANEL_LANDSCAPE);
	
	        CrossPromotionObject.showPanel(this,CrossPromotionConfig.PANEL_TOP);
        }
        else{}
        
        
        final Button button01 = (Button) findViewById(R.id.button01);

        if(tft) {
        	adView = (AdView) findViewById(R.id.ad_view);
        }
        else{}
        
        
        final LinearLayout bannerLayout = (LinearLayout) findViewById(R.id.banner);
        
        if(!abb) {
        	bannerLayout.removeAllViews();
        }
        else{}
        

        final int[] array01;
        array01 = new int[10];
        array01[0]=R.drawable.button_bluegummy;
        array01[1]=R.drawable.button_pinkgummy;
        array01[2]=R.drawable.button_greengummy;
        array01[3]=R.drawable.button_magentagummy;
        array01[4]=R.drawable.button_orangegummy;
        array01[5]=R.drawable.button_tealgummy;
        array01[6]=R.drawable.button_purplegummy;
        array01[7]=R.drawable.button_darkbluegummy;
        array01[8]=R.drawable.button_yellowgummy;
        array01[9]=R.drawable.button_redgummy;
        
        mediaPlayer = MediaPlayer.create(this, R.raw.lucigiggle);

        
       
        
        
        final Activity a = this;
        
        
        button01.setOnClickListener(new View.OnClickListener() {
    
        	
			@Override
			public void onClick(View v) {
				

					button01.setBackgroundResource(array01[count]);
					count+=1;
					hits+=1;
					
					if(count>=10)
					{
						count=0;
					}
					
					if(hits>=20)
					{
						AppBrain.getAds().showInterstitial(a);
						hits=0;
					}
					
					mediaPlayer.start();
	
				}
				
		});
        
        if(tft) {
        	adView.loadAds();
        }
        else{}
        
    }
    
    
    public void onBackPressed() {
    	super.onBackPressed();
    	
    	AppBrain.getAds().showInterstitial(this);
    }
    
    
    public void onResume() {
    	super.onResume();
    	
    	if(tft) {
    		adView.loadAds();
    	}
    	else{}

    	//RevMobAds.startSession(this, APPLICATION_ID);

    }

}
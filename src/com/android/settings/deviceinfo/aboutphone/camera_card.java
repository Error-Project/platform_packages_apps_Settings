package com.android.settings.deviceinfo.aboutphone;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.dashboard.DashboardFragment;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.os.SystemProperties;

public class camera_card extends Specs_base{
    public camera_card(@NonNull Context context) {
        super(context);
        abrir(context,null,0);
    }

    public camera_card(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        abrir(context,attrs,0);
    }

    public camera_card(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        abrir(context,null,defStyleAttr);
    }

    protected void abrir(Context context, AttributeSet attrs, int defStyleAttr){
        super.abrir(context);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.palladium_name, defStyleAttr, 0);
        setLayoutParams(new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams pl = new LinearLayout.LayoutParams(new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setLayoutParams(pl);
        ImageView logo = new ImageView(context);
        logo.setMaxWidth(10);
        logo.setMaxHeight(10);
        logo.setImageResource(R.drawable.ic_about_camera);
        logo.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        TextView card_title = new TextView(context);
        TextView card_summary = new TextView(context);
        if(SystemProperties.get("ro.palladium.build.status").equals("OFFICIAL")){
            card_title.setText("Camera");
            card_title.setTextSize(13);
            card_title.setGravity(Gravity.CENTER);
            card_title.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            
            if(!(SystemProperties.get("ro.palladium.device").equals("miatoll"))){
                card_summary.setText(SystemProperties.get("ro.palladiumdevice.camera"));
            }
            else{
                if(SystemProperties.get("ro.boot.hwname").equals("excalibur")){
                    card_summary.setText("64MP+8MP+5MP+2MP");
                }
                else{
                    card_summary.setText("48MP+8MP+5MP+2MP");
                }
            }
            card_summary.setGravity(Gravity.CENTER);
            card_summary.setTextSize(10);
        }    
        else 
        {
            card_title.setText("Unknown");
            card_title.setTextSize(15);
            card_title.setGravity(Gravity.CENTER);
            card_title.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            card_summary.setText("Unknown");
            card_summary.setGravity(Gravity.CENTER);
            card_summary.setTextSize(11);
        }  
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(0,10,0,0);
        card_summary.setLayoutParams(params);
        setElevation(10);
        linearLayout.addView(logo);
        linearLayout.addView(card_title);
        linearLayout.addView(card_summary);
        layout.addView(linearLayout);
        a.recycle();
    }

}
package com.MoonLord.MyStudy;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.MoonLord.My;
import com.MoonLord.MyActivity;


public class MainActivity extends MyActivity{

	LinearLayout MainLayout;
	Fragment ContentFragment;

	@Override
	public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
            	ContentFragment = My.Fragment.FadeIn(R.id.content, FragmentA.Instance(), ContentFragment);
                break;
            case R.id.button2:
            	ContentFragment = My.Fragment.FadeIn(R.id.content, FragmentB.Instance(), ContentFragment);
                break;
            case R.id.button3:
            	ContentFragment = My.Fragment.FadeIn(R.id.content, FragmentC.Instance(), ContentFragment);
                break;
            case R.id.button4:
            	ContentFragment = My.Fragment.FadeIn(R.id.content, FragmentD.Instance(), ContentFragment);
                break;
            default:
                break;
        }
    }
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        My.Activity.BindOnClick(new int[]{R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.MAIN});
        
        MainLayout=(LinearLayout)findViewById(R.id.MAIN); 
        
        new My.Timer.IntervalTimerTask(20){
        	@Override
			public void run() {
            	MainLayout.setBackgroundColor(My.Maths.SmoothChangeLightColor.NewColor());
			}
        };
    }
}

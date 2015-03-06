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
        
       My.Class.KeyValue A = new My.Class.KeyValue("123","456");
       My.Class.KeyValue B = new My.Class.KeyValue(A);
       B.SetKeyAndValueUnique(true);
       A.SetKeyUnique(true);
       B.Add("123","456");
       B.Add("123","458");
       B.Add("123","459");
       A.Add("123","454");
       
        My.Toast.Show(A.Length());
        My.Toast.Show(B.KeyToArray().length);
    }
}

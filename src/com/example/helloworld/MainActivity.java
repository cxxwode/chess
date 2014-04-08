package com.example.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	private GridLayout gridLayout;
	
	private int rows, columns;
	
//	private ImageView imageView;
	private ImageView[][] imageViews;
	
	private String tag = "MainActivity";
 	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridlayout_main);
        
        
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;  // 屏幕宽度（像素）
        int height = metric.heightPixels;  // 屏幕高度（像素）
        
        Log.i(tag, width + ":" + height);
        
        gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        rows = gridLayout.getRowCount();
        columns = gridLayout.getColumnCount();
        
        imageViews = new ImageView[rows][columns];
        
        Log.i(tag, rows + ":" + columns);
        
    	LayoutInflater inflater = getLayoutInflater();
//		View layout = inflater.inflate(R.layout.onegrid, null);
//		ImageView imageView = (ImageView) layout.findViewById(R.id.onewChess);
        for(int i = 0; i < rows; i++) {
        	for(int j = 0; j < columns; j++){
        		//这句必须放循环里面
        		View layout = inflater.inflate(R.layout.onegrid, null);  
        		ImageView imageView = (ImageView) layout.findViewById(R.id.onewChess);
        		imageViews[i][j] = imageView;
        		gridLayout.addView(imageViews[i][j]);
        		if(i == 0 || j == 0 || i == rows-1 || j == columns-1)
        			imageView.setVisibility(View.VISIBLE);
        	}
        }
        

//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}

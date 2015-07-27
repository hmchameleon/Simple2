package com.example.chameleon.simple2;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Observer;


public class MainActivity extends Activity{

    private RelativeLayout mRelativeLayout;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRelativeLayout = (RelativeLayout)findViewById(R.id.RelativeLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onRedButtonClick(View view) {
        mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.redColor));
    }

    public void onYellowButtonClick(View view) {
        mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.yellowColor));
    }

    public void onGreenButtonClick(View view) {
        mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.greenColor));
    }

    private int NUMB_ACTIVITY=0;
    public void onActivityButtonClick(View view) {
        Intent intent = new Intent(MainActivity.this,AboutActivity.class);
        startActivityForResult(intent, NUMB_ACTIVITY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        TextView mTextView = (TextView)findViewById(R.id.textView);
        if(requestCode == NUMB_ACTIVITY){
            if(resultCode == RESULT_OK){
                mTextView.setText(data.getStringExtra(AboutActivity.QUESTIONS));
            }
            else
                mTextView.setText("");
        }

    }
}

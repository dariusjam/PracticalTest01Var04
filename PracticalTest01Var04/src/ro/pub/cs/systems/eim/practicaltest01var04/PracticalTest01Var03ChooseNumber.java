package ro.pub.cs.systems.eim.practicaltest01var04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01Var03ChooseNumber extends Activity {

	
	private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	 
	private Button button1 = null;
	private EditText editText1 = null;
	
	private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements Button.OnClickListener {
	 
	    @Override
	    public void onClick(View view) {
	      switch(view.getId()) {
	        case R.id.button1:
	          Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02PlayActivity.class);
		  	   EditText editText2 = (EditText)findViewById(R.id.editText1);
		  	   int number = Integer.parseInt(editText2.getText().toString());
	          intent.putExtra("number", number);
	          startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
	          break;
	      }
	   }
	}
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_choose_number);
        
        EditText editText1 = (EditText)findViewById(R.id.editText1);
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(buttonClickListener);     
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
      if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
        Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
      }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_var03_choose_number, menu);
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
}

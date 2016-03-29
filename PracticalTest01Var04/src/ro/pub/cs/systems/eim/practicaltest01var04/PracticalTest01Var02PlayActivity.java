package ro.pub.cs.systems.eim.practicaltest01var04;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var02PlayActivity extends Activity {

	private EditText editText1 = null;
	private EditText editText2 = null;
	private Button button1 = null;
	int numar_de_ghicit;
	private Button button2 = null;
	int  n;
	int scor = 0;
	
	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	private class ButtonClickListener implements View.OnClickListener {
	    @Override
	    public void onClick(View view) {
	      switch(view.getId()) {
	        case R.id.button1:
	          Random rand = new Random();
	          n = rand.nextInt(10);
	          EditText editText3 = (EditText)findViewById(R.id.editText1);
	          editText3.setText(String.valueOf(n));
	          
	         /* try {
	              Thread.sleep(2000);
	          } catch (InterruptedException interruptedException) {
	              interruptedException.printStackTrace();
	          }*/
	            //EditText editText3 = (EditText)findViewById(R.id.editText1);
	            //editText2.setText(String.valueOf(""));
	            break;
	            
	         case R.id.button2:
	        	if(numar_de_ghicit == n) {
	        		scor++;
	        		editText2 = (EditText)findViewById(R.id.editText2);
	        		editText2.setText(String.valueOf(scor));
	        	} else {
	        		editText2.setText(String.valueOf(scor));
	        	}
	          break;
	          
	         case R.id.button3:
	        	 setResult(RESULT_CANCELED, null);
		         break;
	      }
	   }
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var02_play);
		
	    Intent intent = getIntent();
	    if (intent != null && intent.getExtras().containsKey("number")) {
	      numar_de_ghicit = intent.getIntExtra("number", -1);
	    }
		
	    editText2 = (EditText)findViewById(R.id.editText2);
		editText2.setText(String.valueOf(scor));
	    
		button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(buttonClickListener);
		button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(buttonClickListener);
		
		Button button3 = (Button)findViewById(R.id.button3);
	    button3.setOnClickListener(buttonClickListener);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var02_play, menu);
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

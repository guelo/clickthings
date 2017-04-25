package miguel.clickthings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		Event event = (Event) getIntent().getExtras().get("EVENT");

		((TextView)findViewById(R.id.textView)).setText(event.toString());
	}
}

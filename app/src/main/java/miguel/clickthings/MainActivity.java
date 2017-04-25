package miguel.clickthings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

	ArrayList<Event> events = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState != null) {
			events = savedInstanceState.getParcelableArrayList("events");
		}

		RecyclerView list = (RecyclerView) findViewById(R.id.list);
		final Adapter adapter = new Adapter();
		list.setAdapter(adapter);
		list.setLayoutManager(new LinearLayoutManager(this));

		findViewById(R.id.btn1).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				events.add(new Event(new Date(), "button 1", "click"));
				adapter.notifyDataSetChanged();
			}
		});
		findViewById(R.id.btn1).setOnLongClickListener(new OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				events.add(new Event(new Date(), "button 1", "long click"));
				adapter.notifyDataSetChanged();
				return true;
			}
		});
		findViewById(R.id.btn2).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				events.add(new Event(new Date(), "button 2", "click"));
				adapter.notifyDataSetChanged();
			}
		});
		findViewById(R.id.btn2).setOnLongClickListener(new OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				events.add(new Event(new Date(), "button 2", "long click"));
				adapter.notifyDataSetChanged();
				return true;
			}
		});
		findViewById(R.id.btn3).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				events.add(new Event(new Date(), "button 3", "click"));
				adapter.notifyDataSetChanged();
			}
		});
		findViewById(R.id.btn3).setOnLongClickListener(new OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				events.add(new Event(new Date(), "button 3", "long click"));
				adapter.notifyDataSetChanged();
				return true;
			}
		});

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putParcelableArrayList("events", events);
		super.onSaveInstanceState(outState);
	}

	class Adapter extends RecyclerView.Adapter<ViewHolder> {

		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.row, null);
			return new ViewHolder(view);
		}

		@Override
		public void onBindViewHolder(ViewHolder holder, int position) {
			holder.bind(events.get(position));
		}

		@Override
		public int getItemCount() {
			return events.size();
		}
	}

	class ViewHolder extends RecyclerView.ViewHolder {

		private final TextView buttonTv;
		private final TextView dateTv;
		private final TextView eventTv;

		public ViewHolder(View itemView) {
			super(itemView);

			dateTv = (TextView) itemView.findViewById(R.id.timestamp);
			eventTv = (TextView) itemView.findViewById(R.id.event);
			buttonTv = (TextView) itemView.findViewById(R.id.whichbutton);
		}

		public void bind(final Event event) {
			dateTv.setText(event.date.toString());
			eventTv.setText(event.event);
			buttonTv.setText(event.button);
			itemView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent i = new Intent(MainActivity.this, Main2Activity.class);
					i.putExtra("EVENT", event);
					startActivity(i);
				}
			});
		}
	}
}

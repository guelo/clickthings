package miguel.clickthings;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

class Event implements Parcelable {
	Date date;
	String button;
	String event;

	public Event(Date date, String button, String event) {
		this.date = date;
		this.button = button;
		this.event = event;
	}

	protected Event(Parcel in) {
		button = in.readString();
		event = in.readString();
		date = (Date) in.readSerializable();
	}

	public static final Creator<Event> CREATOR = new Creator<Event>() {
		@Override
		public Event createFromParcel(Parcel in) {
			return new Event(in);
		}

		@Override
		public Event[] newArray(int size) {
			return new Event[size];
		}
	};

	@Override
	public String toString() {
		return "Event{" +
			"date=" + date +
			", button='" + button + '\'' +
			", event='" + event + '\'' +
			'}';
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(button);
		dest.writeString(event);
		dest.writeSerializable(date);
	}
}

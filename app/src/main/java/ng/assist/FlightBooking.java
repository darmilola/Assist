package ng.assist;


import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.asksira.webviewsuite.WebViewSuite;

import androidx.appcompat.app.AppCompatActivity;


public class FlightBooking extends AppCompatActivity {


    WebViewSuite webViewSuite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_booking);
        webViewSuite = findViewById(R.id.webViewSuite);
    }

    @Override
    public void onBackPressed() {
        if (!webViewSuite.goBackIfPossible()) super.onBackPressed();
    }

    @Override
    public void onResume() {

        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        }
    }
}

package com.example.googlemaptrack;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etFromlocation;
    private EditText etTolocation;
    private Button btnGetDirection;

    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFromlocation = findViewById(R.id.etFromLocation);
        etTolocation = findViewById(R.id.etToLocation);
        btnGetDirection = findViewById(R.id.btnGetDirection);

        btnGetDirection.setOnClickListener(v -> {
            String userLocation = etFromlocation.getText().toString();
            String userDestination = etTolocation.getText().toString();

            if (userLocation.isEmpty() || userDestination.isEmpty()) {
                Toast.makeText(this, "Please enter both locations", Toast.LENGTH_SHORT).show();
            } else {
                getDirections(userLocation, userDestination);
            }
        });
    }

    private void getDirections(String from, String to) {
        try {
            Uri uri = Uri.parse("https://www.google.com/maps/dir/" + Uri.encode(from) + "/" + Uri.encode(to));
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (ActivityNotFoundException exception) {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}

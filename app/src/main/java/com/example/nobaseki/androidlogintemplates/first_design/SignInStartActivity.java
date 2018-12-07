package com.example.nobaseki.androidlogintemplates.first_design;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.nobaseki.androidlogintemplates.R;

public class SignInStartActivity extends AppCompatActivity {


    Button btn_signIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_1_start);

        getSupportActionBar().hide();

        btn_signIn = findViewById(R.id.button_sign_in);

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activateCircularReveal(v);
            }
        });


    }

    private void activateCircularReveal(View view) {
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, view, "transition");
        int revealX = (int) (view.getX() + view.getWidth() / 2);
        int revealY = (int) (view.getY() + view.getHeight() / 2);

        Intent intent = new Intent(this, SignInEndActivity.class);
        intent.putExtra(SignInEndActivity.EXTRA_CIRCULAR_REVEAL_X, revealX);
        intent.putExtra(SignInEndActivity.EXTRA_CIRCULAR_REVEAL_Y, revealY);

        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
}

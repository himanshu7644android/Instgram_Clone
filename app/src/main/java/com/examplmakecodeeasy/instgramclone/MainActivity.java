package com.examplmakecodeeasy.instgramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.examplmakecodeeasy.instgramclone.databinding.ActivityMainBinding;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());






    }

    public void helloWorldIsTapped(View view){

        ParseObject boxer = new ParseObject("Boxer");
        boxer.put("punch_speed",2000);
        boxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e== null){
                    Toast.makeText(MainActivity.this, "boxer objest is seved sucessfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public  void  KICKBOXER(View mview) {

        try {
            ParseObject kickBoxer = new ParseObject("KickBoxer");
            kickBoxer.put("puch_speed", Integer.parseInt(binding.edtname.getText().toString()));
            kickBoxer.put("kick_power", Integer.parseInt(binding.edtPower.getText().toString()));
            kickBoxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {


                        FancyToast.makeText(MainActivity.this, kickBoxer.get("puch_speed") + "", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

                    } else {

                        FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();


                    }
                }
            });

        } catch (Exception e) {
            FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
        }

    }
}
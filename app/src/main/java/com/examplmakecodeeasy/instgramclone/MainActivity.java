package com.examplmakecodeeasy.instgramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.examplmakecodeeasy.instgramclone.databinding.ActivityMainBinding;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    private String allKickBoxer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.txtGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("KickBoxer");
                parseQuery.getInBackground("r05knu5rwj", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {

                        if (object != null && e == null){
                            binding.txtGetData.setText(object.get("puch_speed")+"");
                        }
                    }
                });
            }
        });

        binding.getAllData.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                allKickBoxer = "";
                ParseQuery<ParseObject> queryAll = ParseQuery.getQuery("KickBoxer");
                queryAll.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if (e == null){
                            if (objects.size() > 0){

                                for (ParseObject Kickboxer : objects){
                                    allKickBoxer = allKickBoxer + Kickboxer.get("puch_speed") +"\n";
                                }
                                FancyToast.makeText(MainActivity.this, allKickBoxer, FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

                            }else {
                                FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

                            }
                        }
                    }
                });
            }
        });






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
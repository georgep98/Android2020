package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "Hello world!";
    static CharSequence savedText;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendMessage();
            }
        });

        if(savedText != null) {
            TextView mTextView = findViewById(R.id.textView2);
            mTextView.setText(savedText);
        }
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void sendMessage() {
        EditText text = (EditText)findViewById(R.id.edit_text);
        String value = text.getText().toString();
        new AlertDialog.Builder(MainActivity.this)
                .setMessage("Are you sure you want to Acess " + value + '?')
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        try {
                            EditText text = (EditText)findViewById(R.id.edit_text);
                            String value = text.getText().toString();
                            String url = value;
                            dialog.cancel();
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                        }
                        catch (Exception e) {
                            Toast.makeText(getApplicationContext(),"Something went wrong !",Toast.LENGTH_LONG).show();
                        }
                        finally {
                            Toast.makeText(getApplicationContext(),"Operation Done !",Toast.LENGTH_LONG).show();
                        }

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(getApplicationContext(),"Okey!",Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                }).show();



    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    protected void onStart() {
        super.onStart();
        Context context = getApplicationContext();
        CharSequence text = "onStart has been Called";
        int length= Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, length);
        toast.show();
    }

    protected void onResume() {
        super.onResume();
        Context context = getApplicationContext();
        CharSequence text = "onResume has been Called";
        int length = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, length);
        toast.show();
    }

    }



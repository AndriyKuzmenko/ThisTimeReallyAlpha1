package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity
{
    EditText email, password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        mAuth = FirebaseAuth.getInstance();
    }

    public void button(View view)
    {
        Intent si=new Intent(this, Main2Activity.class);
        startActivity(si);
    }

    public void button1(View view)
    {
        Intent si=new Intent(this, Main3Activity.class);
        startActivity(si);
    }

    public void button2(View view)
    {
        mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }
                        else
                            {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    public void updateUI(FirebaseUser u)
    {
        if(u==null) Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
        else Toast.makeText(MainActivity.this, "Account creation successful", Toast.LENGTH_SHORT).show();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    /**
     * @param item - the item that was selected
     * @return - when the user selects an item, this code will go to the specified activity.
     */

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int i=item.getItemId();

        if(i==R.id.AnimationScreen)
        {
            Intent si=new Intent(this, Main2Activity.class);
            startActivity(si);
        }
        else if(i==R.id.GraphScreen)
        {
            Intent si=new Intent(this, Main3Activity.class);
            startActivity(si);
        }

        return true;
    }
}
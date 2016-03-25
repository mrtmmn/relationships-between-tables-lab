package com.example.maratmamin.twotableslab;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Employee employee;
    DBHelper dbHelper;
    Button addData;
    Button employeesSameCompany;
    Button compInBoston;
    Button compHighestSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbHelper.getINSTANCE(MainActivity.this);

        addData = (Button)findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dbHelper.insertRow();
//                dbHelper.insertRowDepartment();
            }
        });
        employeesSameCompany = (Button)findViewById(R.id.employees_same_company);
        employeesSameCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        compInBoston = (Button)findViewById(R.id.companies_in_boston);
        compInBoston.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        compHighestSalary = (Button)findViewById(R.id.companies_salaries);
        compHighestSalary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO: Try AlertDialog as separat class!!!!!

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // Get the layout inflater
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setView(inflater.inflate(R.layout.dialog, null))
                        // Add action buttons
                        .setPositiveButton("add data", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                                EditText ssn = (EditText)findViewById(R.id.ssn);
                                String receiveSsn = ssn.getText().toString();

                                EditText first = (EditText)findViewById(R.id.first_name);
                                String receiveFirst = first.getText().toString();

                                EditText last = (EditText)findViewById(R.id.last_name);
                                String receiveLast = last.getText().toString();

                                EditText year = (EditText)findViewById(R.id.year_of_birth);
                                String receiveYear = year.getText().toString();

                                EditText city = (EditText)findViewById(R.id.city);
                                String receiveCity = city.getText().toString();

                                employee = new Employee(receiveSsn, receiveFirst, receiveLast, receiveYear, receiveCity);
                                dbHelper.insertRow(employee);

                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                builder.create();
                builder.show();



            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

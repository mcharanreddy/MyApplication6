package com.example.mchar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    MainActivity ma;
    int i=0;
    private static final int NUM_ROWS =5;
    private static final int NUM_COLS =1 ;
    Button buttons[][]=new Button[NUM_ROWS][NUM_COLS];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateButtons();
    }

    private void populateButtons() {
        TableLayout table=(TableLayout)findViewById(R.id.tableForButtons);
        for (int row=0;row<NUM_ROWS;row++){
            TableRow tableRow= new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            table.addView(tableRow);

            for (int col=0;col<NUM_COLS;col++){
                final int FINAL_COL=col;
                final int FINAL_ROW=row;

                Button button=new Button(this);

                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f));

                button.setText("" + ma.c[i]+ "");
                i++;
                button.setPadding(0,0,0,0);
                button.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                gridButtonClicked(FINAL_ROW,FINAL_COL);

                            }
                        }
                );
                tableRow.addView(button);
                buttons[row][col]=button;

            }
        }
    }

    private void gridButtonClicked(int row,int col) {
        Toast.makeText(this,"button clicked:"+ row +","+col ,Toast.LENGTH_SHORT).show();
        Button button=buttons[row][col];




    }
}
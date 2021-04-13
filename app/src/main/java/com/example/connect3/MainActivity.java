package com.example.connect3;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int[] gamestate={2,2,2,2,2,2,2,2,2};

    int[][] winningplaces = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    int activeplayer=0;

    public void change(View view){

        ImageView counter = (ImageView) view;

        boolean action= true;

        int tappedcounter= Integer.parseInt(counter.getTag().toString());


        if (gamestate[tappedcounter]==2&& action) {

            counter.setTranslationY(-1500);

            gamestate[tappedcounter]= activeplayer;


            if (activeplayer == 0) {

                counter.setImageResource(R.drawable.yellow);

                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);

                activeplayer = 0;
            }

            counter.animate().translationYBy(1500).rotation(1500).setDuration(300);

            String winner;

            for (int[] winningplaces : winningplaces){

                if(gamestate[winningplaces[0]]==gamestate[winningplaces[1]] && gamestate[winningplaces[1]]==gamestate[winningplaces[2]] && gamestate[winningplaces[0]]!=2){

                    if(activeplayer==1){

                        winner="Yellow";

                    }else{
                        winner="Red";
                    }

                    action=false;


                    TextView textView = (TextView) findViewById(R.id.textView);

                    Button button = (Button)findViewById(R.id.button);

                    textView.setText(winner + " Won");

                    textView.setVisibility(View.VISIBLE);

                    button.setVisibility(View.VISIBLE);

                }
            }
        }
    }

    public void again(View view){

        TextView textView = (TextView) findViewById(R.id.textView);

        Button button = (Button)findViewById(R.id.button);

        textView.setVisibility(View.INVISIBLE);

        button.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);

        for(int i=0;i<gridLayout.getChildCount();i++){

            ImageView counter= (ImageView) gridLayout.getChildAt(i);

            counter.setImageDrawable(null);

        }
        for (int i=0;i<gamestate.length;i++){

            gamestate[i]=2;
        }

        activeplayer=0;
        boolean action=true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
package com.example.kvr.android6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //klasa sluzaca do rysowania na oknie aplikacji.
    public class MyView extends View {
        public MyView(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
            //nic nie zmieniamy
        }

        @Override
        //glowna funkcja rysujace
        protected void onDraw(Canvas canvas) {
            // TODO Auto-generated method stub
                super.onDraw(canvas);
                //pobranie dlugosci i wysokosci ekranu
                int x = getWidth();
                int y = getHeight();

                int radius;
                Paint paint = new Paint();//miejsce na rysowanie
                Paint p = new Paint();
                paint.setStyle(Paint.Style.FILL);//pedzel wypelniajacy
                paint.setColor(Color.WHITE);//kolor bialy
                canvas.drawPaint(paint); //odrysowanie okna kolorem bialym

                //rysowanie kola
                // Use Color.parseColor to define HTML colors
                paint.setColor(Color.parseColor("#CD5C5C"));//ustaw nowy kolor
                radius = 400;					//promien kola
                canvas.drawCircle(x / 2, y / 2, radius, paint); //narysuj kolo w srodku ekranu


                //rysowanie kola
                // Use Color.parseColor to define HTML colors
                paint.setColor(Color.parseColor("#FFFFFF"));//ustaw nowy kolor
                radius = 60;					//promien kola
                canvas.drawCircle(x / 2 - 190, y / 2 - 200, radius, paint); //narysuj kolo w srodku ekranu
                canvas.drawCircle(x / 2 + 190, y / 2 - 200, radius, paint); //narysuj kolo w srodku ekranu

                //Rysowanie luku
                p.setColor(Color.WHITE);
                RectF rectF = new RectF(x/2-100, y/2, x/2+100, y/2+200);
                canvas.drawArc (rectF, 0, 180, true, p);


        }
    };

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

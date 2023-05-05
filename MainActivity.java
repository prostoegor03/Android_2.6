package com.example.homework1_markizov;

import static java.lang.StrictMath.sqrt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startButton = findViewById(R.id.firstbtn);
        startButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        //Объявим поле для вывода
        TextView textViewResultTr = findViewById(R.id.tvResultTriangle);
        TextView textViewResultRect = findViewById(R.id.tvResultRectangle);
        //Переменные для сторон треугольника
        EditText TriangFirst = findViewById(R.id.First);
        EditText TriangSecond = findViewById(R.id.Second);
        EditText TriangThird = findViewById(R.id.Third);

        //перенесем считанные значения в переменные
        String firstTriang = TriangFirst.getText().toString();
        String secondTriang = TriangSecond.getText().toString();
        String thirdTriang = TriangThird.getText().toString();

        if(!firstTriang.isEmpty() && !secondTriang.isEmpty() && !thirdTriang.isEmpty()) {
            int intFirstTriang = Integer.parseInt(firstTriang);
            int intSecondTriang = Integer.parseInt(secondTriang);
            int intThirdTriang = Integer.parseInt(thirdTriang);

            float p = (intFirstTriang + intSecondTriang + intThirdTriang) / 2;
            double triangSquare = sqrt(p * (p - intFirstTriang) * (p - intSecondTriang) * (p - intThirdTriang));
            int triangPerimetr = intThirdTriang + intSecondTriang + intThirdTriang;
            textViewResultTr.setText("Площадь треугольника: " + triangSquare + " " +"Периметр треугольника" + triangPerimetr);
        }else{
            textViewResultTr.setText("Для старон треугольника были введены некоректные значения");
            Log.w("Homework1_Markizov","Empty triangle Term");
            Toast.makeText(getApplicationContext(),"Invalid triangle terms",Toast.LENGTH_LONG).show();
        }



        //Переменные для сторон Прямоугольника
        EditText RectFirst = findViewById(R.id.secFirst);
        EditText RectSecond = findViewById(R.id.secSecond);

        String firstRect = RectFirst.getText().toString();
        String secondRect = RectSecond.getText().toString();

        if (!firstRect.isEmpty() && !secondRect.isEmpty()){

            int intFirstRect= Integer.parseInt(firstRect);
            int intSecondRect = Integer.parseInt(secondRect);

            int rectSquare = intFirstRect * intSecondRect ;
            int rectPerimetr =(intFirstRect + intSecondRect)*2;
            textViewResultRect.setText("Площадь прямоугольника: "+rectSquare + " " +"Периметр прямоугольника" + rectPerimetr);
        }else{
        Log.w("Homework1_Markizov","Empty rectangle Term");
        Toast.makeText(getApplicationContext(),"Invalid rectangl terms",Toast.LENGTH_LONG).show();
        textViewResultRect.setText("Для сторон прямоугольника были введены некоректные значения");
        }


    }
}
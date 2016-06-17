package com.example.a442509097.my_textview_select2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * 注: TextView必须要声明为android:textIsSelectable="true"
 */
public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private String string = "LG has announced four new smartphones that join the X family, and its already existent members, the X cam and X screen. According to the official wording, the new X power, X mach, X style and X max “share many of the top end features found on LG’s flagship G and V series handsets”.\n" +
            "\n" +
            "“Greater battery capacity, faster processor, more sophisticated styling or a larger display”, are each one key selling point and main feature of these four newcomers. The LG X power features a 4,100mAh battery in a slim, 7.9mm-thick case, with PE+ fast-charging technology, claimed to charge at twice the normal speed.\n" +
            "\n" +
            "The LG X mach has a 1.8GHz processor and LTE Cat. 9 3CA capabilities and a Quad HD Quantum display in a form factor that’s slightly curved.\n" +
            "\n" +
            "The LG X style differentiates itself from the rest thanks to “its elegant design boasting gracefully curving lines and extra-slim body”, while the LG X max has a large screen.\n" +
            "\n" +
            "Pricing and availability have not yet been announced, these being market-specific, and a full list of specs is not yet available from LG, but we’ll update the post as soon as we get our hands on it. LG has announced four new smartphones that join the X family, and its already existent members, the X cam and X screen. According to the official wording, the new X power, X mach, X style and X max \"share many of the top end features found on LG’s flagship G and V series handsets\". \"Greater battery capacity, faster ...";

    private String text;
    String regular = "[\n\r`~!@#$%^&*()+=|{}:;,\\[\\].<>/?~！@#￥%……&*（）——+|{}\\-【】‘；：”“。，、？\\\"]"; //过滤


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(string);
        text = textView.getText().toString().replaceAll(regular, " ");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int s = textView.getSelectionStart(); //从1开始计数
                if (s == text.length()) { //判断如果是处于最后一位;因为index是以0开始的,所以这是为了防止报错
                    s = s - 1;
                    System.out.println("我是最后一位了");
                }
                System.out.println("我是开头-> " + text.charAt(s)); //传入的是index参数
                for (int i = 0; i < 15; i++) {
                    int t = 0;
                    t = s + i;
                    String c = String.valueOf(text.charAt(t));
                    if (c.equals(" ")) {
                        //t现在就是最近的空格位置
                        i = 15; //如果匹配,提前结束循环
                        String substring = text.substring(0, t);
                        String z[] = substring.split(" ");
                        System.out.println("我是输出-> " + z[z.length - 1]); //选择最后一个
                    }
                }
            }
        });
    }
}

package com.tianyapeng.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.tianyapeng.act.R;

/**
 * Created by TianYapeng on 2017/2/17 0017.
 */

//当前类注释:通讯录界面右边的字码指示
public class SideBar extends View {

    //触摸事件
    private OnTouchingLetterChangeListener onTouchingLetterChangeListener;
    //26个英文字母
    public static String[] b = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    private int choose = -1;
    //定义实例化画笔
    private Paint paint = new Paint();

    private TextView Dialog_text;

    public void setTextView(TextView mTextView) {
        this.Dialog_text = mTextView;
    }

    public SideBar(Context context) {
        super(context);
    }

    public SideBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SideBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //重写onDraw方法
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //获取屏幕的宽度和高度
        int width = getWidth();
        int height = getHeight();
        //获取每个字母的宽度
        int singleHeight = height / b.length;
        for (int i = 0; i < b.length; i++) {
            paint.setColor(Color.GRAY);
            paint.setTypeface(Typeface.DEFAULT);
            paint.setAntiAlias(true);
            paint.setTextSize(16);
            //选中的状态
            if (i == choose) {
                paint.setColor(Color.parseColor("#FFFFFF"));
                paint.setFakeBoldText(true);
            }
            //X坐标等于中间-字符串的一半
            float xPos = width / 2 - paint.measureText(b[i]) / 2;
            float yPos = singleHeight * i + singleHeight;
            canvas.drawText(b[i], xPos, yPos, paint);
            paint.reset();  //重置画笔
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        final float y=event.getY(); //点击y坐标
        final int oldChoose=choose;
        final OnTouchingLetterChangeListener listener=onTouchingLetterChangeListener;
        //点击y坐标所占用总高度比例*b数组的长度就等于点击b中的个数
        final int c= (int) (y/getHeight()*b.length);

        switch (event.getAction()){
            //抬起
            case MotionEvent.ACTION_UP:
                setBackgroundDrawable(new ColorDrawable(0x00000000));
                choose=-1;
                invalidate();
                if (Dialog_text!=null) {
                Dialog_text.setVisibility(View.INVISIBLE);
                }
                break;

            default:
                setBackgroundResource(R.drawable.sidebar_bg);
                if(oldChoose!=c){
                    if(c>=0&&c<b.length){
                        listener.onTouchingLetterChange(b[c]);
                    }
                    if(Dialog_text!=null){
                        Dialog_text.setText(b[c]);
                        Dialog_text.setVisibility(View.VISIBLE);
                    }
                    choose=c;
                    invalidate();
                }

                break;
        }

        return true;
    }

    //向外公开的方法
    public void setOnTouchingLetterChangeListener(OnTouchingLetterChangeListener onTouchingLetterChangeListener) {
        this.onTouchingLetterChangeListener = onTouchingLetterChangeListener;
    }

    //接口
    public interface OnTouchingLetterChangeListener {
        public void onTouchingLetterChange(String s);
    }
}

























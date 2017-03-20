package com.yusufakson.hackathonbitaksigetirproject.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.yusufakson.hackathonbitaksigetirproject.model.ItemElements;

import java.util.List;

/**
 * Created by yusuf on 20.3.2017.
 */

public class DrawingView extends View {


    private Paint drawPaint;
    private List<ItemElements> itemElementsList;

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void initialize(List<ItemElements> elementsList) {
        itemElementsList = elementsList;
        setupPaint();
        postInvalidate();
    }

    private void setupPaint() {
        drawPaint = new Paint();
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (itemElementsList != null) {
            for (ItemElements item : itemElementsList) {
                drawPaint.setColor(Color.parseColor("#" + item.getColor()));
                if (item.getType().equals("circle")) {
                    canvas.drawCircle(item.getXPosition(), item.getYPosition(), item.getR(), drawPaint);
                }
                if (item.getType().equals("rectangle")) {
                    canvas.drawRect(item.getXPosition(), item.getYPosition(), item.getWidth(), item.getHeight(), drawPaint);
                }
            }
        }
    }
}

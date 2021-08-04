package jp.wings.nikkeibp.memoapp

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

//Viewクラスを継承
class MyView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    //線を引く・色とか太さ・座標
    private val path = Path()
    private val paint = Paint()
    private var drawX = 0F
    private var drawY = 0F

    //描画設定【色・スタイル・線の細さ】
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20F
        canvas?.drawPath(path,paint)

    }

    //描画
    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {

        //タッチポジション【x座標・y 座標】
        drawX = event!!.x
        drawY = event.y

        //タッチしながら動かす
        when(event.action){
            MotionEvent.ACTION_DOWN -> path.moveTo(drawX,drawY)
            MotionEvent.ACTION_MOVE -> path.lineTo(drawX,drawY)
        }

        //再描画を実行
        invalidate()
        return true
    }

    //描画を消す処理
    fun clearCanvas(){
        path.reset()
        invalidate()
    }
}
package jp.wings.nikkeibp.memoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //idの取得【変数宣言】
        val myView = findViewById<MyView>(R.id.myView)
        val btnClear = findViewById<Button>(R.id.btnClear)

        //ボタン押下時の処理
        btnClear.setOnClickListener {

            //描画を消す【My.ViewクラスのclearCanvasメソッド使用】
            myView.clearCanvas()
        }
    }
}
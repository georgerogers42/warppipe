package com.georgerogers42.warppipe

import _root_.java.io._
import _root_.android.app.Activity
import _root_.android.os.Bundle
import _root_.android.widget._
import _root_.android.view._
import _root_.android.content._
import _root_.org.tautua.markdownpapers._
class WarpActivity extends Activity {
  import Implicits._
  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    val layout = new LinearLayout(this)
    layout.setOrientation(LinearLayout.VERTICAL)
    val convert = new EditText(this)
    convert.setLines(10)
    val md = new Markdown()
    val result = new EditText(this)
    result.setLines(10)
    val txt = getIntent.getStringExtra("android.intent.extra.TEXT")
    convert.setText(if(txt != null) txt else "This program is covered under GPL v. 3 it can be downloaded [here](http://github.com/georgerogers42/warppipe)")
    val button = new Button(this)
    button.setText("Markdown")
    button.setOnClickListener((x : View) => {
      val o = new StringWriter()
      md.transform(new StringReader(convert.getText), o)
      result.setText(o.toString)
    })
    layout.addView(convert)
    layout.addView(button)
    layout.addView(result)
    setContentView(layout)
  }
}

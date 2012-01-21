package com.georgerogers42.warppipe

import _root_.java.io._
import _root_.android.app.Activity
import _root_.android.os.Bundle
import _root_.android.widget._
import _root_.android.view._
import _root_.org.tautua.markdownpapers._

object Implicits {
  def using[A <% {def close()}](x : A)(f : A => Unit) {
    try {
      f(x)
    } finally {
      x.close()
    }
  }
  implicit def functionOnClick(f : View => Unit) : View.OnClickListener = {
    new View.OnClickListener(){
      def onClick(v : View) = f(v)
    }
  }
  implicit def charSeq2String(s : CharSequence) = s.toString()
}

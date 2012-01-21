package com.georgerogers42.warppipe.tests

import junit.framework.Assert._
import _root_.android.test.AndroidTestCase

class UnitTests extends AndroidTestCase {
  def testPackageIsCorrect {
    assertEquals("com.georgerogers42.warppipe", getContext.getPackageName)
  }
}
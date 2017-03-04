package com.sunny.grokkingalgorithms.harryhe.chap2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import  org.junit.Assert.*;

/**
 * Created by sundas on 3/4/2017.
 */
public class PalindromeCheckerTest {

  private int oddPalindromeNumber = 121;

  private int evenPalindromeNumber = 1221;

  private int oddNotPalindromeNumber = 123;

  private int evenNotPalindromeNumber = 1223;

  @Before
  public void setupNumber(){

  }

  @Test
  public void testIsPalindromeV1Positive() throws Exception {
    Assert.assertTrue(PalindromeChecker.isPalindromeV1(oddPalindromeNumber));
    Assert.assertTrue(PalindromeChecker.isPalindromeV1(evenPalindromeNumber));
  }

  @Test
  public void testIsPalindromeV1Negative() throws Exception {
    Assert.assertFalse(PalindromeChecker.isPalindromeV1(oddNotPalindromeNumber));
    Assert.assertFalse(PalindromeChecker.isPalindromeV1(evenNotPalindromeNumber));
  }

  @Test
  public void testIsPalindromeV2Positive() throws Exception {
    Assert.assertTrue(PalindromeChecker.isPalindromeV2(oddPalindromeNumber));
    Assert.assertTrue(PalindromeChecker.isPalindromeV2(evenPalindromeNumber));
  }

  @Test
  public void testIsPalindromeV2Negative() throws Exception {
    Assert.assertFalse(PalindromeChecker.isPalindromeV2(oddNotPalindromeNumber));
    Assert.assertFalse(PalindromeChecker.isPalindromeV2(evenNotPalindromeNumber));
  }

  @Test
  public void testReverseNumber() throws Exception {
    Assert.assertEquals(PalindromeChecker.reverseNumber(oddPalindromeNumber), 121);
    Assert.assertEquals(PalindromeChecker.reverseNumber(evenPalindromeNumber), 1221);
    Assert.assertEquals(PalindromeChecker.reverseNumber(oddNotPalindromeNumber), 321);
    Assert.assertEquals(PalindromeChecker.reverseNumber(evenNotPalindromeNumber), 3221);
  }
}
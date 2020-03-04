package com.b07.f19.e3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.b07.f19.e3.Course;
import com.b07.f19.e3.SingleLectureCourse;

import java.lang.reflect.Field;
import java.util.ArrayList;
import org.junit.Test;

public class SingleLectureCourseTest {

  @Test
  public void constructorTest_NullAndZero() {
    new SingleLectureCourse(null, null, null, 0, 0);
    assertTrue(true);
  }

  @Test
  public void constructorTest_NullAndZeroWithExceptions() {
    new SingleLectureCourse(null, null, null, null, 0, 0);
    assertTrue(true);
  }

  @Test
  public void constructorTest_NullAndZeroExceptNameWithExceptions() {
    new SingleLectureCourse("SampleName", null, null, null, 0, 0);
    assertTrue(true);
  }

  @Test
  public void constructorTest_NullAndZeroExceptCodeWithException() {
    new SingleLectureCourse(null, "AAAA11", null, null, 0, 0);
    assertTrue(true);
  }

  @Test
  public void constructorTest_NullAndZeroExceptDay() {
    new SingleLectureCourse(null, null, CourseDay.FR, 0, 0);
    assertTrue(true);
  }

  @Test
  public void constructorTest_NullAndZeroExceptTime() {
    new SingleLectureCourse(null, null, null, 10, 0);
    assertTrue(true);
  }

  @Test
  public void constructorTest_NullAndZeroExceptLength() {
    new SingleLectureCourse(null, null, null, 0, 1);
    assertTrue(true);
  }

  @Test
  public void constructorTest_AllFilledInExceptName() {
    new SingleLectureCourse(null, "AAAA11", CourseDay.MO, 10, 2);
    assertTrue(true);
  }

  @Test
  public void constructorTest_AllFilledInExceptCode() {
    new SingleLectureCourse("SampleName", null, CourseDay.MO, 10, 2);
    assertTrue(true);
  }

  @Test
  public void constructorTest_AllFilledInExceptDay() {
    new SingleLectureCourse("SampleName", "AAAA11", null, 10, 2);
    assertTrue(true);
  }

  @Test
  public void constructorTest_AllFilledIn() {
    new SingleLectureCourse("SampleName", "AAAA11", CourseDay.MO, 10, 2);
    assertTrue(true);
  }

  @Test
  public void constructorTest_AllFilledInTimeLowerBound() {
    new SingleLectureCourse("SampleName", "AAAA11", CourseDay.MO, 8, 2);
    assertTrue(true);
  }

  @Test
  public void constructorTest_AllFilledInTimeUpperBound() {
    new SingleLectureCourse("SampleName", "AAAA11", CourseDay.MO, 20, 2);
    assertTrue(true);
  }

  @Test
  public void constructorTest_AllFilledInlengthLowerBound() {
    new SingleLectureCourse("SampleName", "AAAA11", CourseDay.MO, 10, 0);
    assertTrue(true);
  }

  @Test
  public void constructorTest_AllFilledInlengthUpperBound() {
    new SingleLectureCourse("SampleName", "AAAA11", CourseDay.MO, 10, 3);
    assertTrue(true);
  }

  @Test
  public void getCourseCodeTest_Null() {
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    assertNull(course.getCourseCode());
  }

  @Test
  public void getCourseCodeTest_EmptyString() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("code");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, "");
    assertEquals("", course.getCourseCode());
  }

  @Test
  public void getCourseCodeTest_ProperCode() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("code");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, "AAAA11");
    assertEquals("AAAA11", course.getCourseCode());
  }

  @Test
  public void getCourseCodeTest_ImproperCode() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("code");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, "reGGie123");
    assertEquals("reGGie123", course.getCourseCode());
  }

  @Test
  public void getCourseDayTest_Null() {
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    assertNull(course.getCourseDay());
  }

  @Test
  public void getCourseDayTest_MO() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseDay");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, CourseDay.MO);
    assertEquals(CourseDay.MO, course.getCourseDay());
  }

  @Test
  public void getCourseDayTest_TU() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseDay");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, CourseDay.TU);
    assertEquals(CourseDay.TU, course.getCourseDay());
  }

  @Test
  public void getCourseDayTest_WE() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseDay");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, CourseDay.WE);
    assertEquals(CourseDay.WE, course.getCourseDay());
  }

  @Test
  public void getCourseDayTest_TH() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseDay");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, CourseDay.TH);
    assertEquals(CourseDay.TH, course.getCourseDay());
  }

  @Test
  public void getCourseDayTest_FR() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseDay");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, CourseDay.FR);
    assertEquals(CourseDay.FR, course.getCourseDay());
  }

  @Test
  public void getCourseNameTest_Null() {
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    assertNull(course.getCourseName());
  }

  @Test
  public void getCourseNameTest_EmptyString() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("name");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, "");
    assertEquals("", course.getCourseName());
  }

  @Test
  public void getCourseNameTest_NoSpaces() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("name");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, "TestingIsFrustrating1");
    assertEquals("TestingIsFrustrating1", course.getCourseName());
  }

  @Test
  public void getCourseNameTest_WithSpaces() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("name");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, "Testing Is Frustrating 1");
    assertEquals("Testing Is Frustrating 1", course.getCourseName());
  }

  @Test
  public void getCourseNameTest_WithWhiteSpaces() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("name");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, "Testing Is Frustrating\n\n\t 1");
    assertEquals("Testing Is Frustrating\n\n\t 1", course.getCourseName());
  }

  @Test
  public void getCourseStartTimeTest_ProperValue() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseTime");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 10);
    assertEquals(10, course.getCourseStartTime());
  }

  @Test
  public void getCourseStartTimeTest_LowerBound() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseTime");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 8);
    assertEquals(8, course.getCourseStartTime());
  }

  @Test
  public void getCourseStartTimeTest_UpperBound() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseTime");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 20);
    assertEquals(20, course.getCourseStartTime());
  }

  @Test
  public void getCourseStartTimeTest_BelowLowerBound() throws NoSuchFieldException,
      SecurityException, IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseTime");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 0);
    assertEquals(0, course.getCourseStartTime());
  }

  @Test
  public void getCourseStartTimeTest_AboveUpperBound() throws NoSuchFieldException,
      SecurityException, IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseTime");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 29);
    assertEquals(29, course.getCourseStartTime());
  }

  @Test
  public void getExclusionListTest_Null() {
    Course course = new SingleLectureCourse("", "", null, CourseDay.MO, 10, 2);
    assertNull(course.getExclusionList());
  }

  @Test
  public void getExclusionListTest_OneCourse() throws IllegalArgumentException,
      IllegalAccessException, NoSuchFieldException, SecurityException {
    Field field = SingleLectureCourse.class.getDeclaredField("excludedCourses");
    field.setAccessible(true);
    Course course = new SingleLectureCourse("", "", null, CourseDay.MO, 10, 2);
    ArrayList<Course> excluded = new ArrayList<Course>();
    excluded.add(course);
    field.set(course, excluded);
    assertTrue(excluded.equals(course.getExclusionList()));
  }

  @Test
  public void getExclusionListTest_MultipleCourses() throws IllegalArgumentException,
      IllegalAccessException, NoSuchFieldException, SecurityException {
    Field field = SingleLectureCourse.class.getDeclaredField("excludedCourses");
    field.setAccessible(true);
    Course course = new SingleLectureCourse("", "", null, CourseDay.MO, 10, 2);
    Course course2 = new SingleLectureCourse("aa", "dad", null, CourseDay.MO, 12, 2);
    Course course3 = new SingleLectureCourse("aa", "plz", null, CourseDay.MO, 14, 2);
    ArrayList<Course> excluded = new ArrayList<Course>();
    excluded.add(course);
    excluded.add(course2);
    excluded.add(course3);
    field.set(course, excluded);
    assertTrue(excluded.equals(course.getExclusionList()));
  }

  @Test
  public void getLectureLengthTest_ProperValue() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("lectureLength");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 2);
    assertEquals(2, course.getLectureLength());
  }

  @Test
  public void getLectureLengthTest_LowerBound() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("lectureLength");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 1);
    assertEquals(1, course.getLectureLength());
  }

  @Test
  public void getLectureLengthTest_UpperBound() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("lectureLength");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 3);
    assertEquals(3, course.getLectureLength());
  }

  @Test
  public void getLectureLengthTest_BelowLowerBound() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("lectureLength");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 0);
    assertEquals(0, course.getLectureLength());
  }

  @Test
  public void getLectureLengthTest_AboveUpperBound() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("lectureLength");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 4);
    assertEquals(4, course.getLectureLength());
  }

  @Test
  public void setCourseCodeTest_Null() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("code");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    course.setCourseCode(null);
    assertNull(field.get(course));
  }

  @Test
  public void setCourseCodeTest_ProperCode() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("code");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    course.setCourseCode("ABCG14");
    assertEquals("ABCG14", field.get(course));
  }

  @Test
  public void setCourseCodeTest_ProperCodeLowerAlpha() throws NoSuchFieldException,
      SecurityException, IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("code");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    course.setCourseCode("AAAA00");
    assertEquals("AAAA00", field.get(course));
  }

  @Test
  public void setCourseCodeTest_ProperCodeUpperBound() throws NoSuchFieldException,
      SecurityException, IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("code");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    course.setCourseCode("ZZZZ99");
    assertEquals("ZZZZ99", field.get(course));
  }

  @Test
  public void setCourseCodeTest_EmptyString() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("code");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, "AAAA11");
    course.setCourseCode("");
    assertEquals("AAAA11", field.get(course));
  }

  @Test
  public void setCourseCodeTest_ImproperLowerCode() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("code");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, "AAAA11");
    course.setCourseCode("aaaa11");
    assertEquals("AAAA11", field.get(course));
  }

  @Test
  public void setCourseCodeTest_ImproperLengthShortCode() throws NoSuchFieldException,
      SecurityException, IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("code");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, "AAAA11");
    course.setCourseCode("AAA11");
    assertEquals("AAAA11", field.get(course));
  }

  @Test
  public void setCourseCodeTest_ImproperLengthPrefixCode() throws NoSuchFieldException,
      SecurityException, IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("code");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, "AAAA11");
    course.setCourseCode("PREFIXAAAA11");
    assertEquals("AAAA11", field.get(course));
  }

  @Test
  public void setCourseCodeTest_ImproperLengthSuffixCode() throws NoSuchFieldException,
      SecurityException, IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("code");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, "AAAA11");
    course.setCourseCode("AAAA11SUFFIX");
    assertEquals("AAAA11", field.get(course));
  }

  @Test
  public void setCourseDayTest_Null() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseDay");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    course.setCourseDay(null);
    assertNull(field.get(course));
  }

  @Test
  public void setCourseDayTest_MO() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseDay");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    course.setCourseDay(CourseDay.MO);
    assertEquals(CourseDay.MO, field.get(course));
  }

  @Test
  public void setCourseDayTest_TU() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseDay");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    course.setCourseDay(CourseDay.TU);
    assertEquals(CourseDay.TU, field.get(course));
  }

  @Test
  public void setCourseDayTest_WE() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseDay");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    course.setCourseDay(CourseDay.WE);
    assertEquals(CourseDay.WE, field.get(course));
  }

  @Test
  public void setCourseDayTest_TH() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseDay");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    course.setCourseDay(CourseDay.TH);
    assertEquals(CourseDay.TH, field.get(course));
  }

  @Test
  public void setCourseDayTest_FR() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseDay");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    course.setCourseDay(CourseDay.FR);
    assertEquals(CourseDay.FR, field.get(course));
  }

  @Test
  public void setCourseNameTest_Null() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("name");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    course.setCourseName(null);
    assertNull(field.get(course));
  }

  @Test
  public void setCourseNameTest_EmptyString() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("name");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    course.setCourseName("");
    assertEquals("", field.get(course));
  }

  @Test
  public void setCourseNameTest_LengthOneString() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("name");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    course.setCourseName("▼");
    assertEquals("▼", field.get(course));
  }

  @Test
  public void setCourseNameTest_StringNoSpaces() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("name");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    course.setCourseName("▼plzbro▲");
    assertEquals("▼plzbro▲", field.get(course));
  }

  @Test
  public void setCourseNameTest_StringWithSpaces() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("name");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    course.setCourseName("▼ plzbro ▲");
    assertEquals("▼ plzbro ▲", field.get(course));
  }

  @Test
  public void setCourseNameTest_StringWithWhitepaces() throws NoSuchFieldException,
      SecurityException, IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("name");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    course.setCourseName("▼ \t\t\nplzbro ▲");
    assertEquals("▼ \t\t\nplzbro ▲", field.get(course));
  }

  @Test
  public void setCourseStartTimeTest_properValue() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseTime");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 16);
    course.setCourseStartTime(10);
    assertEquals(10, field.get(course));
  }

  @Test
  public void setCourseStartTimeTest_LowerBound() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseTime");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 16);
    course.setCourseStartTime(8);
    assertEquals(8, field.get(course));
  }

  @Test
  public void setCourseStartTimeTest_UpperBound() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseTime");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 16);
    course.setCourseStartTime(20);
    assertEquals(20, field.get(course));
  }

  @Test
  public void setCourseStartTimeTest_BelowLowerBound() throws NoSuchFieldException,
      SecurityException, IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseTime");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 16);
    course.setCourseStartTime(4);
    assertEquals(16, field.get(course));
  }

  @Test
  public void setCourseStartTimeTest_AboveUpperBound() throws NoSuchFieldException,
      SecurityException, IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("courseTime");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 16);
    course.setCourseStartTime(26);
    assertEquals(16, field.get(course));
  }

  @Test
  public void setExcludedCourseTest_NullCourse() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("excludedCourses");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    ArrayList<Course> excluded = new ArrayList<Course>();
    excluded.add(null);
    field.set(course, new ArrayList<Course>());
    course.setExcludedCourse((Course) null);
    assertTrue(excluded.equals(field.get(course)));
  }

  @Test
  public void setExcludedCourseTest_NullList() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("excludedCourses");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    ArrayList<Course> excluded = null;
    field.set(course, new ArrayList<Course>());
    course.setExcludedCourse((ArrayList<Course>) null);
    assertEquals(excluded, field.get(course));
  }

  @Test
  public void setExcludedCourseTest_ProperCourseNullField() throws NoSuchFieldException,
      SecurityException, IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("excludedCourses");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    ArrayList<Course> excluded = new ArrayList<Course>();
    excluded.add(course);
    field.set(course, null);
    course.setExcludedCourse((Course) null);
    assertTrue(excluded.equals(field.get(course)));
  }

  @Test
  public void setExcludedCourseTest_ProperCourse() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("excludedCourses");
    field.setAccessible(true);
    Course course = new SingleLectureCourse("SampleName", "AAAA11", CourseDay.MO, 10, 2);
    ArrayList<Course> excluded = new ArrayList<Course>();
    excluded.add(course);
    field.set(course, new ArrayList<Course>());
    course.setExcludedCourse(course);
    assertTrue(excluded.equals(field.get(course)));
  }

  @Test
  public void setExcludedCourseTest_ProperList() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("excludedCourses");
    field.setAccessible(true);
    Course course = new SingleLectureCourse("SampleName", "AAAA11", CourseDay.MO, 10, 2);
    ArrayList<Course> excluded = new ArrayList<Course>();
    excluded.add(course);
    excluded.add(course);
    excluded.add(course);
    field.set(course, new ArrayList<Course>());
    course.setExcludedCourse(excluded);
    assertTrue(excluded.equals(field.get(course)));
  }

  @Test
  public void setLectureLengthTest_properValue() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("lectureLength");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 3);
    course.setLectureLength(2);
    assertEquals(2, field.get(course));
  }

  @Test
  public void setLectureLengthTest_LowerBound() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("lectureLength");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 2);
    course.setLectureLength(1);
    assertEquals(1, field.get(course));
  }

  @Test
  public void setLectureLengthTest_UpperBound() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("lectureLength");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 2);
    course.setLectureLength(3);
    assertEquals(3, field.get(course));
  }

  @Test
  public void setLectureLengthTest_BelowLowerBound() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("lectureLength");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 2);
    course.setLectureLength(0);
    assertEquals(2, field.get(course));
  }

  @Test
  public void setLectureLengthTest_AboveUpperBound() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = SingleLectureCourse.class.getDeclaredField("lectureLength");
    field.setAccessible(true);
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    field.set(course, 2);
    course.setLectureLength(4);
    assertEquals(2, field.get(course));
  }

  @Test
  public void toStringTest_CheckValueNullAndZero() {
    Course course = new SingleLectureCourse(null, null, null, 0, 0);
    String expected = "CODE: null\nName: null\nnull 0 - 0\n";
    assertEquals(expected, course.toString());
  }
  
  @Test
  public void toStringTest_CheckValueImproperCourse() {
    Course course = new SingleLectureCourse("♂◙", "♀♫", CourseDay.FR, 16, 3);
    String expected = "CODE: ♀♫\nName: ♂◙\nFR 16 - 19\n";
    assertEquals(expected, course.toString());
  }
  
  @Test
  public void toStringTest_CheckValueProperCourse() {
    Course course = new SingleLectureCourse("I Hate Testing LOL", "CSCB07", CourseDay.MO, 15, 2);
    String expected = "CODE: CSCB07\nName: I Hate Testing LOL\nMO 15 - 17\n";
    assertEquals(expected, course.toString());
  }
}

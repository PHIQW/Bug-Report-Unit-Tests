package com.b07.f19.e3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.b07.f19.e3.CourseOverlapException;
import com.b07.f19.e3.StudentTimeTable;
import com.b07.f19.e3.TimeTable;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.junit.Test;

public class StudentTimeTableTest {

  @Test
  public void constructorTest_Zero()
      throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(0);
    Field field = StudentTimeTable.class.getDeclaredField("studentNumber");
    field.setAccessible(true);
    assertEquals(0, field.get(table));
  }

  @Test
  public void constructorTest_PositiveInt()
      throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(1);
    Field field = StudentTimeTable.class.getDeclaredField("studentNumber");
    field.setAccessible(true);
    assertEquals(1, field.get(table));
  }

  @Test
  public void constructorTest_NegativeInt()
      throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(-1);
    Field field = StudentTimeTable.class.getDeclaredField("studentNumber");
    field.setAccessible(true);
    assertEquals(-1, field.get(table));
  }

  @Test
  public void constructorTest_LargeInt()
      throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11111111);
    Field field = StudentTimeTable.class.getDeclaredField("studentNumber");
    field.setAccessible(true);
    assertEquals(11111111, field.get(table));
  }

  @Test
  public void constructorTest_LargeNegativeInt()
      throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(-11111111);
    Field field = StudentTimeTable.class.getDeclaredField("studentNumber");
    field.setAccessible(true);
    assertEquals(-11111111, field.get(table));
  }

  @Test
  public void addCourseTest_Null() throws CourseOverlapException {
    TimeTable table = new StudentTimeTable(11);
    table.addCourse(null);
    assertTrue(true);
  }

  @Test
  public void addCourseTest_OneRegularCourse_DefaultMaxCourses() throws CourseOverlapException {
    TimeTable table = new StudentTimeTable(11);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    table.addCourse(course);
    assertTrue(true);
  }

  @Test
  public void addCourseTest_OneRegularCourse_MaxCourses1() throws CourseOverlapException,
      NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(table, 1);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    table.addCourse(course);
    assertTrue(true);
  }

  @Test
  public void addCourseTest_OneRegularCourse_MaxCoursesNegative() throws CourseOverlapException,
      NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(table, -1);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    table.addCourse(course);
    assertTrue(true);
  }

  @Test
  public void addCourseTest_OneRegularCourse_MaxCourseslarge() throws CourseOverlapException,
      NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(table, 111111);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    table.addCourse(course);
    assertTrue(true);
  }

  @Test
  public void addCourseTest_MultipleDifferentCourses_MaxCoursesl() throws CourseOverlapException,
      NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(table, 1);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    Course courseB = new SingleLectureCourse("SampleCourse2", "AAAA12", CourseDay.MO, 9, 1);
    Course courseC = new SingleLectureCourse("SampleCourse3", "AAAA13", CourseDay.MO, 10, 2);
    table.addCourse(course);
    table.addCourse(courseB);
    table.addCourse(courseC);
    assertTrue(true);
  }

  @Test
  public void addCourseTest_MultipleDifferentCourses_MaxCoursesLarge()
      throws CourseOverlapException, NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(table, 6);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    Course courseB = new SingleLectureCourse("SampleCourse2", "AAAA12", CourseDay.MO, 9, 1);
    Course courseC = new SingleLectureCourse("SampleCourse3", "AAAA13", CourseDay.MO, 10, 2);
    table.addCourse(course);
    table.addCourse(courseB);
    table.addCourse(courseC);
    assertTrue(true);
  }

  @Test(expected = CourseOverlapException.class)
  public void addCourseTest_MultipleSameCourses_MaxCoursesl() throws CourseOverlapException,
      NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(table, 1);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    table.addCourse(course);
    table.addCourse(course);
    assertTrue(true);
  }

  @Test(expected = CourseOverlapException.class)
  public void addCourseTest_MultipleSameCourses_MaxCourseslarge() throws CourseOverlapException,
      NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(table, 6);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    table.addCourse(course);
    table.addCourse(course);
    assertTrue(true);
  }

  @Test(expected = CourseOverlapException.class)
  public void addCourseTest_OverlapTimeCourses_MaxCoursesLarge() throws CourseOverlapException,
      NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(table, 6);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    Course courseSameTime = new SingleLectureCourse("SampleCourse2", "AAAA12", CourseDay.MO, 8, 1);
    table.addCourse(course);
    table.addCourse(courseSameTime);
    assertTrue(true);
  }

  @Test(expected = CourseOverlapException.class)
  public void addCourseTest_OverlapCoursesDifferentTimes_MaxCoursesLarge()
      throws CourseOverlapException, NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(table, 6);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    Course courseSameNameAndCode =
        new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 9, 1);
    table.addCourse(course);
    table.addCourse(courseSameNameAndCode);
    assertTrue(true);
  }

  @Test(expected = CourseOverlapException.class)
  public void addCourseTest_ExclusionOverlapCourses_MaxCoursesLarge() throws CourseOverlapException,
      NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(table, 6);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    ArrayList<Course> exclusions = new ArrayList<Course>();
    exclusions.add(course);
    Course courseExcludesOriginal =
        new SingleLectureCourse("SampleCourse2", "AAAA12", exclusions, CourseDay.MO, 9, 1);
    table.addCourse(course);
    table.addCourse(courseExcludesOriginal);
    assertTrue(true);
  }

  @Test(expected = CourseOverlapException.class)
  public void addCourseTest_ExclusionOverlapCoursesExistsInTable_MaxCoursesLarge()
      throws CourseOverlapException, NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(table, 6);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    ArrayList<Course> exclusions = new ArrayList<Course>();
    exclusions.add(course);
    Course courseExcludesOriginal =
        new SingleLectureCourse("SampleCourse2", "AAAA12", exclusions, CourseDay.MO, 9, 1);
    table.addCourse(courseExcludesOriginal);
    table.addCourse(course);
    assertTrue(true);
  }

  @Test
  public void getMaxCourseTest_CheckDefaultValue() {
    TimeTable table = new StudentTimeTable(11);
    assertEquals(0, table.getMaxCourse());
  }

  @Test
  public void getMaxCourseTest_Zero() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(table, 0);
    assertEquals(0, table.getMaxCourse());
  }

  @Test
  public void getMaxCourseTest_PositiveInt() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(table, 1);
    assertEquals(1, table.getMaxCourse());
  }

  @Test
  public void getMaxCourseTest_NegativeInt() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(table, -1);
    assertEquals(-1, table.getMaxCourse());
  }

  @Test
  public void getMaxCourseTest_LargeInt() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(table, 11111111);
    assertEquals(11111111, table.getMaxCourse());
  }

  @Test
  public void getMaxCourseTest_LargeNegativeInt() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    field.set(table, -11111111);
    assertEquals(-11111111, table.getMaxCourse());
  }

  @Test
  public void printTimeTableTest_NoCourses() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    TimeTable table = new StudentTimeTable(11);
    table.printTimeTable();
    String expected = "Timetable for student: 11\r\n" + "MONDAY: \n" + "\r\n" + "TUESDAY: \n"
        + "\r\n" + "WEDNESDAY: \n" + "\r\n" + "THURSDAY: \n" + "\r\n" + "FRIDAY: \n\r\n";
    assertEquals(expected, outContent.toString());
  }

  @Test
  public void printTimeTableTest_MultipleCoursesCheckOrder() throws NoSuchFieldException,
      SecurityException, IllegalArgumentException, IllegalAccessException {
    Field field = StudentTimeTable.class.getDeclaredField("currentCourses");
    field.setAccessible(true);
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    TimeTable table = new StudentTimeTable(11);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    Course course2 = new SingleLectureCourse("SampleCourse2", "AAAA12", CourseDay.MO, 9, 1);
    ArrayList<Course> currentCourses = new ArrayList<Course>();
    currentCourses.add(course);
    currentCourses.add(course2);
    field.set(table, currentCourses);
    table.printTimeTable();
    String expected = "Timetable for student: 11\r\n" + "MONDAY: \n" + "CODE: AAAA11\n"
        + "Name: SampleCourse\n" + "MO 8 - 9\n" + "CODE: AAAA12\n" + "Name: SampleCourse2\n"
        + "MO 9 - 10\n" + "\r\n" + "TUESDAY: \n" + "\r\n" + "WEDNESDAY: \n" + "\r\n"
        + "THURSDAY: \n" + "\r\n" + "FRIDAY: \n" + "\r\n";
    assertEquals(expected, outContent.toString());
  }

  @Test
  public void printTimeTableTest_MultipleCoursesDifferentOrder() throws NoSuchFieldException,
      SecurityException, IllegalArgumentException, IllegalAccessException {
    Field field = StudentTimeTable.class.getDeclaredField("currentCourses");
    field.setAccessible(true);
     ByteArrayOutputStream outContent = new ByteArrayOutputStream();
     System.setOut(new PrintStream(outContent));
    TimeTable table = new StudentTimeTable(11);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    Course course2 = new SingleLectureCourse("SampleCourse2", "AAAA12", CourseDay.MO, 9, 1);
    ArrayList<Course> currentCourses = new ArrayList<Course>();
    currentCourses.add(course2);
    currentCourses.add(course);
    field.set(table, currentCourses);
    table.printTimeTable();
    String expected = "Timetable for student: 11\r\n" + "MONDAY: \n" + "CODE: AAAA11\n"
        + "Name: SampleCourse\n" + "MO 8 - 9\n" + "CODE: AAAA12\n" + "Name: SampleCourse2\n"
        + "MO 9 - 10\n" + "\r\n" + "TUESDAY: \n" + "\r\n" + "WEDNESDAY: \n" + "\r\n"
        + "THURSDAY: \n" + "\r\n" + "FRIDAY: \n" + "\r\n";
     assertEquals(expected, outContent.toString());
  }

  @Test
  public void removeCourseTest_Null() {
    TimeTable table = new StudentTimeTable(11);
    table.removeCourse(null);
    assertTrue(true);
  }

  @Test
  public void removeCourseTest_EmptyTable() {
    TimeTable table = new StudentTimeTable(11);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    table.removeCourse(course);
    assertTrue(true);
  }

  @Test
  public void removeCourseTest_NotInTable() throws NoSuchFieldException, SecurityException,
      IllegalArgumentException, IllegalAccessException {
    Field field = StudentTimeTable.class.getDeclaredField("currentCourses");
    field.setAccessible(true);
    TimeTable table = new StudentTimeTable(11);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    Course notIn = new SingleLectureCourse("SampleCourse2", "AAAA12", CourseDay.MO, 12, 1);
    ArrayList<Course> currentCourses = new ArrayList<Course>();
    currentCourses.add(course);
    field.set(table, currentCourses);
    table.removeCourse(notIn);
    assertTrue((currentCourses.equals(field.get(table))));
  }

  @Test
  public void removeCourseTest_InTable() throws IllegalArgumentException, IllegalAccessException,
      NoSuchFieldException, SecurityException {
    Field field = StudentTimeTable.class.getDeclaredField("currentCourses");
    field.setAccessible(true);
    TimeTable table = new StudentTimeTable(11);
    Course course = new SingleLectureCourse("SampleCourse", "AAAA11", CourseDay.MO, 8, 1);
    ArrayList<Course> currentCourses = new ArrayList<Course>();
    currentCourses.add(course);
    field.set(table, currentCourses);
    table.removeCourse(course);
    assertTrue((new ArrayList<Course>()).equals(field.get(table)));
  }

  @Test
  public void setMaxCourseTest_CheckDefaultValue()
      throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    assertEquals(0, field.get(table));
  }

  @Test
  public void setMaxCourseTest_Zero()
      throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    table.setMaxCourses(0);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    assertEquals(0, field.get(table));
  }

  @Test
  public void setMaxCourseTest_PositiveInt()
      throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    table.setMaxCourses(1);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    assertEquals(1, field.get(table));
  }

  @Test
  public void setMaxCourseTest_NegativeInt()
      throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    table.setMaxCourses(-1);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    assertEquals(-1, field.get(table));
  }

  @Test
  public void setMaxCourseTest_LargeInt()
      throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    table.setMaxCourses(11111111);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    assertEquals(11111111, field.get(table));
  }

  @Test
  public void setMaxCourseTest_LargeNegativeInt()
      throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    TimeTable table = new StudentTimeTable(11);
    table.setMaxCourses(-11111111);
    Field field = StudentTimeTable.class.getDeclaredField("maxCourses");
    field.setAccessible(true);
    assertEquals(-11111111, field.get(table));
  }

}

package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectEmployees {

	public static String result = "";
	
  public static void test(String[] args) {
    // �f�[�^�x�[�X�ڑ����
    String url      = "jdbc:mysql://localhost:3306/sampledb?useSSL=false";
    String user     = "root";
    String password = "";
    try(Connection conn = DriverManager.getConnection(url, user, password);
      PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees WHERE code = ?");) {

      // �R�}���h���C�������̕s�����������ꍇ
      if(args.length != 1) {
        throw new ArrayIndexOutOfBoundsException();
      }
      // �R�}���h���C���������擾
      String input_code = args[0];

      // �R�}���h���C���������v���[�X�z���_�ɃZ�b�g
      pstmt.setString(1, input_code);
      // SELECT���̎��s
      ResultSet res = pstmt.executeQuery();
   
      String message = ""; // ���b�Z�[�W�p�ϐ�
      // ResultSet����s���ǂ�������p�̃J�E���^�[�ϐ�
      int resCount = 0;
      // SELECT�������������ꍇ
      while(res.next()) {
        result +=
            "\n ==> "      +
            "code: "    + res.getString("code") + " " +
            "name: "    + res.getString("name") + " " +
            "age: "     + res.getInt("age")  + " " +
            "section: " + res.getString("section")
        ;
        resCount++;
  
      }
      // SELECT�����������Ȃ��Ă��G���[�ɂ͂Ȃ�Ȃ��̂ŁAResultSet���󂩂ǂ����Ŕ���
      if(resCount == 0) {
        message = "���̃��R�[�h�𒊏o�ł��܂���ł����B";
      } else {
        message = "���̃��R�[�h�𒊏o���܂����B"; 
      }
      System.out.println(message + "  CODE: " + input_code + result);
    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("�����ɏ]�ƈ��R�[�h���w�肵�Ă��������B");
    } catch(Exception e) {
      // ���̃G���[
    }

  }
  
  public static String getResult() {
	  return SelectEmployees.result;
  }

 

}
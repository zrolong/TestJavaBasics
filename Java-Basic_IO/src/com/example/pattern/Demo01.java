package com.example.pattern;

/**
 * ������֮��Ĺ�ϵ
 * 
 * ����
 * ������
 * 		����
 * 			�ۺϣ����������벿�֣���һ�µ��������� ������
 * 			��ϣ����������벿�֣�һ�µ���������   �������
 * �̳У��������ϵ
 * ʵ�֣���ں�ʵ����֮��Ĺ�ϵ
 * 
 * @author ���ɵĺ���
 *
 */
public class Demo01 {
	
	public static void main(String[] args) {
		
		Voice voice = new Voice(10);
		voice.say();
		Amplifier a = new Amplifier(voice);
		a.say();
	}

}
package com.kh.chap02_abstractAndInterface.part02_interface.model.vo;

/*
 * �������̽��� ���� ��� ����
 * -> ���� ��ӿ� ���� ������ �غ� ����
 * 
 * Ŭ������ : Ŭ���� extends Ŭ����
 * Ŭ���� �������̽� �� : Ŭ���� implements �������̽�, �������̽�
 * �������̽� �� : �������̽� extends �������̽�, �������̽�
 * ��Ӱ� ���� �� �� ���� : Ŭ���� extends Ŭ���� implements �������̽�
 */
public interface cellPhone extends Phone, Camera{
	// ��ȭ �ɱ�, ��ȭ �ޱ�, �Կ� ����� ��� �ް�
	// ���� ��� �߰�
	void charge();
}
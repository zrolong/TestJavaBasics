package com.example.collection;

/**
 * 1��˫�������Դӽ�β��ʼ���������Ч��
 * 			��JDK���������ô���ģ�
 * 
 * ��������λ�����Ч��
 * 
 * ����һλ / 2
 * ������λ * 2
 * 	
 * ��λЧ�ʱȳ���Ч�ʸ�
 * 
 * @author ���ɵĺ���
 *
 */

public class MyLinkedList {

	private LinkedListNode first;
	private LinkedListNode last;
	
	private int size;
	
	public void add(Object obj){
		LinkedListNode n = new LinkedListNode();
		if(first == null){
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);
			
			first = n;
			last = n;
			
			
		}else{
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);
			
			last.setNext(n);
			last = n;
		}
		size ++;
	}
	
	public int size(){
		return size;
	}
	
	public LinkedListNode node(int index){
		
		LinkedListNode temp = null;
		if(first == null){
			return null;
		}else{
			if(index < (size >> 1)){
				temp = first;
				
				for(int i = 0; i < index; i++ ){
					temp = temp.next;
				}
			}else{
				temp = last;
				
				for(int i = size -1; i > index; i--){
					temp = temp.previous;
				}
			}
			
			
		}
		return temp;
	}
	
	public Object get(int index) {
		
			LinkedListNode node = node(index);
			if(node != null){
				return node.obj;
			}else{
				return null;
			}
	}
	
	public void remove(int index){
		
		LinkedListNode temp = node(index);
		
		if(temp != null){
			LinkedListNode up = temp.getPrevious();
			LinkedListNode down = temp.getNext();
			
			up.next = down;
			down.previous = up;
			
			size--;
		}
	}
	
	public void add(int index,Object obj){

		LinkedListNode temp = node(index);
		LinkedListNode node = new LinkedListNode(null,obj,null);
		
		if(temp != null){
			LinkedListNode up = temp.previous;
			up.next = node;
			node.previous = up;
			node.next = temp; 
			temp.previous = node;
			size ++;
		}
	}
	
	public static void main(String[] args) {

		MyLinkedList list = new MyLinkedList();
		for(int i = 0; i < 100 ; i++){
			list.add(i);
		}
		
		System.out.println(list.get(0));
		System.out.println(list.get(56));
	}
	
}


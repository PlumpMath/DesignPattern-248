package com.cc.composite;

/**
 * ���ģʽ��ʱ�ֽв���-����ģʽ�ڴ����������νṹ������ʱ�ȽϷ��㣬������ϵͼ��
 * ʹ�ó�������������������һ����в����������ڱ�ʾ���νṹ�У���������������ȡ�
 * @author chao
 *
 */
public class Tree {
	TreeNode root = null;

	public Tree(String name) {
		root = new TreeNode(name);
	}

	public static void main(String[] args) {
		Tree tree = new Tree("A");
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");

		nodeB.add(nodeC);
		tree.root.add(nodeB);
		System.out.println(tree.root.getChildren());
		System.out.println("build the tree finished!");
	}
}
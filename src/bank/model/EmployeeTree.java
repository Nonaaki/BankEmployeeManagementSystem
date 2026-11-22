/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.model;

/**
 *
 * @author natvi
 */


import java.util.LinkedList;
import java.util.Queue;

public class EmployeeTree {

    private class Node {
        Employee employee;
        Node left;
        Node right;

        Node(Employee employee) {
            this.employee = employee;
        }
    }

    private Node root;

    // Insert employee into the tree
    public void insert(Employee employee) {
        root = insertNode(root, employee);
    }

    private Node insertNode(Node node, Employee employee) {

        if (node == null) {
            return new Node(employee);
        }

        String newName = employee.getFullName();
        String currentName = node.employee.getFullName();

        if (newName.compareToIgnoreCase(currentName) < 0) {
            node.left = insertNode(node.left, employee);
        } else {
            node.right = insertNode(node.right, employee);
        }

        return node;
    }

    // Display employees using level-order traversal
    public void levelOrder() {

        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node current = queue.remove();

            System.out.println(current.employee);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // Count all nodes
    public int countNodes() {
        return count(root);
    }

    private int count(Node node) {

        if (node == null) {
            return 0;
        }

        return 1 + count(node.left) + count(node.right);
    }

    // Calculate tree height
    public int getHeight() {
        return height(root);
    }

    private int height(Node node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}

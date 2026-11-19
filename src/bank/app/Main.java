/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.app;
import bank.service.FileService;

/**
 *
 * @author natvi
 */

public class Main {
public static void main(String[] args) {

FileService fileService = new FileService();
fileService.readFile("Applicants_Form.txt");
}
}
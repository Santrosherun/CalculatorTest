/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controller;

import core.controller.utils.Response;
import core.controller.utils.Status;
import core.models.History;
import core.models.Operation;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;

/**
 *
 * @author sddva
 */
public class HistoryController {
    
    public static Response update(){
        try {
            History history = History.getIntance();
            ArrayList<Operation> operations = history.getOperations();
            
            if(operations == null){
                return new Response("List does not exist", Status.NOT_FOUND);
            }
            
            if(operations.isEmpty()){
                return new Response("List might be empty", Status.NO_CONTENT);
            }
            Collections.reverse(operations);
            DefaultListModel model = new DefaultListModel();
            model.addAll(operations);
            
            return new Response("added", Status.OK, model);
            
        } catch (Exception e) {
            return new Response("Something went wrong", Status.NOT_FOUND);
        }
    }
    
    
}

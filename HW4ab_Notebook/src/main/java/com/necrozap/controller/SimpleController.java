/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necrozap.controller;

import com.necrozap.interactor.UserInteractor;
import com.necrozap.interactor.UserInteractorPrintException;
import com.necrozap.interactor.UserInteractorReadException;
import com.necrozap.repository.Repository;
import com.necrozap.repository.RepositoryException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author artem
 */
public class SimpleController implements Controller{

    private static final String CMD_HELP = "help";
    private static final String CMD_LOAD = "load";
    private static final String CMD_EXIT = "exit";
    private static final String CMD_ADD = "add";
    private static final String CMD_CLEAR = "clear";
    
    private Repository repository;
    private UserInteractor userInteractor;

    public SimpleController(Repository repository, UserInteractor userInteractor) {
        this.repository = repository;
        this.userInteractor = userInteractor;
    }
    
    private String load() throws RepositoryException{
        Object[] objs = this.repository.load();
        String result = "";
        for(Object obj: objs) {
            result += obj.toString() + "\n";
        }
        return result;
    }
    
    @Override
    public void init() {
        String command;
        String cmd;
        boolean exit = false;
        while (true) {
            try {
                userInteractor.print("\n$ ");
                command = userInteractor.read();
                cmd = command.split(" ")[0];
                switch (cmd) {
                    case CMD_HELP:
                        userInteractor.print("You can use next commands: help, load, exit, add, clear\n");
                        break;
                    case CMD_EXIT:
                        exit = true;
                        break;
                    case CMD_LOAD:
                        userInteractor.print(load());
                        break;
                    case CMD_ADD:
                        repository.save(command.replace(CMD_ADD + " ", ""));
                        break;
                    case CMD_CLEAR:
                        repository.clear();
                        break;
                    default:
                        userInteractor.print("Unknown command!");
                }
                if (exit) {
                    userInteractor.print("Goodbye!...\n");
                    break;
                }
            } catch (UserInteractorReadException | UserInteractorPrintException ex) {
                Logger.getLogger(SimpleController.class.getName()).log(Level.SEVERE, null, ex);
                break;
            } catch (RepositoryException ex) {
                Logger.getLogger(SimpleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public UserInteractor getUserInteractor() {
        return userInteractor;
    }

    public void setUserInteractor(UserInteractor userInteractor) {
        this.userInteractor = userInteractor;
    }
    
    
    
}

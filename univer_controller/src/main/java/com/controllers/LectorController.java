package com.controllers;

import com.models.Lector;
import com.services.LectorService;

public class LectorController {
    private LectorService lectorService;
    private Lector lector;

    public void setLectorService(LectorService lectorService) {
        this.lectorService = lectorService;
    }

    public LectorService getLectorService() {
        return lectorService;
    }

    public void authorized(String log, String pass) {
        if (lectorService.findLectorByLogPass(log, pass) != null) {
            lector = lectorService.findLectorByLogPass(log, pass);
            System.out.println(lector);
        }
    }

    public void getResultsForTest(int idTest) {
        if(lectorService.createDocumentResultByTest(idTest)!=null){
            System.out.println(lectorService.createDocumentResultByTest(idTest));
        }
    }

    public void createTest(String theme) {

    }

    public void putMark(int idStudent, int idTest, int mark) {
        if(lectorService.addMarkToStudent(idTest, idStudent, mark)){
            System.out.println("yey");
        }
    }

    public void addSubjectToLector(String Subject) {
        //todo
    }

    public void addTestToGroup(String group, int idTest) {
        if (lectorService.addTestToGroup(group, idTest)){
            System.out.println("yey");
        }
    }


}

package com.itclopedia.cources;

import com.itclopedia.cources.models.Serveys;

public class ServeysService {
    private ServeysDAO serveysDAO;

    public ServeysService(ServeysDAO serveysDAO) {
        this.serveysDAO = serveysDAO;
    }

    public void createServeys(Serveys serveys) {
        serveysDAO.addServeys(serveys);
    }

    public void updateServeys(Serveys serveys) {
        serveysDAO.updateServeys(serveys);
    }

    public void deleteServeys(int serveysId) {
        serveysDAO.deleteServeys(serveysId);
    }
}

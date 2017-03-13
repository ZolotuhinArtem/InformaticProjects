
import com.necrozap.controller.Controller;
import com.necrozap.controller.SimpleController;
import com.necrozap.database.tools.DataBaseConnector;
import com.necrozap.interactor.TerminalUserInteractor;
import com.necrozap.interactor.UserInteractor;
import com.necrozap.repository.NotebookDataBaseRepository;
import com.necrozap.repository.Repository;
import java.net.URISyntaxException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author artem
 */
public class Main {
    public static void main(String[] args) throws URISyntaxException {
        Main main = new Main();
    }
    
    public Main(){
        ApplicationContext context;
        context = new FileSystemXmlApplicationContext(getClass().getResource("/SpringXMLConfig.xml").toString());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mo.analysis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import mo.capture.RecordDialog;
import mo.capture.RecordableConfiguration;
import mo.organization.Configuration;
import mo.organization.Participant;
import mo.organization.ProjectOrganization;
import mo.organization.StageAction;
import mo.organization.StageModule;
import mo.organization.StagePlugin;

/**
 *
 * @author gustavo
 */
public class IndividualAnalisisAction implements StageAction {

    private final static String ACTION_NAME = "Analisis individual";
    private ProjectOrganization org;
    private Participant participant;
    private ArrayList<Configuration> configurations;
 //   private IndividualAnalisisDialog dialog;
    File storageFolder;
   // boolean isPaused = false;
    
    
    
    @Override
    public String getName() {return ACTION_NAME;}

    @Override
    public void init(ProjectOrganization organization, Participant participant, StageModule stage) {
    //init se ejecuta cuando el usuario hace click en realizar la accion
        
        this.org = organization;
        this.participant = participant;
        
        //se obtienen las configuraciones proveidas para la accion desde todos los plugins
        ArrayList<Configuration> configs = new ArrayList<>();
        for (StagePlugin plugin : stage.getPlugins()) {
            for (Configuration configuration : plugin.getConfigurations()) {
                configs.add(configuration);
            }
        }        
        
        //creo que se crea una carpeta en base a la etapa
        //aun no necesario
        storageFolder = new File(org.getLocation(),
                "participant-" + participant.id + "/"
                + stage.getCodeName().toLowerCase());
        storageFolder.mkdirs();
     
        
        
       //luego aca debe ir el dialogo
        //dialog = new AnalyzeDialog(configs);
      //  dialog = new IndividualAnalisisDialog(configs,participant);
       // configurations = dialog.showDialog();
       // AnalyzeConfiguration selected = (AnalyzeConfiguration) dialog.getSelected()  ;
        //selected.initAnalysis();
        
        //a partir de aca empieza la ejecucions del plugin, con un INIT()
                
    }
  
}

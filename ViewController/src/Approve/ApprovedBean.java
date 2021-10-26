package Approve;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
 
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import model.applications.AppModuleImpl;

import oracle.adf.model.binding.DCDataControl;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.ApplicationModule;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adfinternal.view.faces.bi.util.JsfUtils;

import oracle.jbo.RowSetIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;


public class ApprovedBean {
    private RichCommandButton approveStatus;

    public ApprovedBean() {
    }

    AppModuleImpl appM = (AppModuleImpl)this.getAppM();

    public void ApproveBtn(ActionEvent actionEvent) {
        //System.out.println("hi");
        ViewObject vo = appM.getMnjCourierInformationLineVO1();
        Row[] row = vo.getAllRowsInRange();
        //for (Row rowEach : row){
           // String statusVal = (String)rowEach.getAttribute("Status");
        String statusVal     = vo.getCurrentRow().getAttribute("Status1") != null ? vo.getCurrentRow().getAttribute("Status1").toString(): "null" ;
       // int lineId = Integer.parseInt(statusVal);
        //if (statusVal.equals("1")) {
            statusVal= "0";
        //} 
        //lineId=0;
       vo.getCurrentRow().setAttribute("Status1",statusVal);
        System.out.println(statusVal);
        //}
        appM.getDBTransaction().commit();
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding1 =  bindings.getOperationBinding("Commit");
                  operationBinding1.execute(); 
                    
                //vo.executeQuery();    
        
       // appM.getDBTransaction().commit();
        
        //vo.executeQuery();
        
        //ViewObjectImpl vo1=(ViewObjectImpl)this.DBTransaction().getRootApplicationModule().findViewObject("MnjCourierInformationLineVO");
    
        //DCBindingContainer bindings = ( DCBindingContainer)getBindings();
        //OperationBinding operationBinding1 =
          //  bindings.getOperationBinding("Commit");
        //operationBinding1.getParamsMap().put("Status",statusVal);
         //operationBinding1.execute();
         
         //bindings.findIteratorBinding("MnjCourierInformationLineVO1Iterator").executeQuery();
        
        //((RichInputText) JsfUtils.findComponentInRoot("id1")).setValue("hello world");
         
        //OperationBinding operationBinding12 =
          //  bindings.getOperationBinding("Execute");
        //operationBinding1.getParamsMap().put("Status",statusVal);
         //operationBinding1.execute();
         
         
         AdfFacesContext adfFacesContext=AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(approveStatus);
    }
 
    public ApplicationModule getAppM() {
          DCBindingContainer bindingContainer =
              (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
          //BindingContext bindingContext = BindingContext.getCurrent();
          DCDataControl dc =
              bindingContainer.findDataControl("AppModuleDataControl"); // Name of application module in datacontrolBinding.cpx
          AppModuleImpl appM = (AppModuleImpl)dc.getDataProvider();
          return appM;
    }
    public void setApproveStatus(RichCommandButton approveStatus) {
        this.approveStatus = approveStatus;
    }

    public RichCommandButton getApproveStatus() {
        return approveStatus;
    }
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void ApproveListener(ActionEvent actionEvent) {
        // Add event code here...
    }
}


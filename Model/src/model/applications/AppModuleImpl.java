package model.applications;

import model.View.MnjCourierInformationLineVOImpl;

import oracle.jbo.server.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Aug 17 11:48:25 BDT 2021
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AppModuleImpl extends ApplicationModuleImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public AppModuleImpl() {
    }

    /**
     * Container's getter for MnjCourierInformationLineVO1.
     * @return MnjCourierInformationLineVO1
     */
    public MnjCourierInformationLineVOImpl getMnjCourierInformationLineVO1() {
        return (MnjCourierInformationLineVOImpl)findViewObject("MnjCourierInformationLineVO1");
    }
}

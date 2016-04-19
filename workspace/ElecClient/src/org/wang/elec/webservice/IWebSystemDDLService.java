

/**
 * IWebSystemDDLService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:01:29 GMT)
 */

    package org.wang.elec.webservice;

    /*
     *  IWebSystemDDLService java interface
     */

    public interface IWebSystemDDLService {
          

        /**
          * Auto generated method signature
          * 
                    * @param findSystemByKeyword0
                
         */

         
                     public org.wang.elec.webservice.FindSystemByKeywordResponse findSystemByKeyword(

                        org.wang.elec.webservice.FindSystemByKeyword findSystemByKeyword0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param findSystemByKeyword0
            
          */
        public void startfindSystemByKeyword(

            org.wang.elec.webservice.FindSystemByKeyword findSystemByKeyword0,

            final org.wang.elec.webservice.IWebSystemDDLServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    

/**
 * IWebSystemDDLServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.1  Built on : Feb 20, 2016 (10:01:29 GMT)
 */
        package org.wang.elec.webservice;

        /**
        *  IWebSystemDDLServiceMessageReceiverInOut message receiver
        */

        public class IWebSystemDDLServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        IWebSystemDDLServiceSkeleton skel = (IWebSystemDDLServiceSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("findSystemByKeyword".equals(methodName)){
                
                org.wang.elec.webservice.FindSystemByKeywordResponse findSystemByKeywordResponse1 = null;
	                        org.wang.elec.webservice.FindSystemByKeyword wrappedParam =
                                                             (org.wang.elec.webservice.FindSystemByKeyword)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    org.wang.elec.webservice.FindSystemByKeyword.class);
                                                
                                               findSystemByKeywordResponse1 =
                                                   
                                                   
                                                         skel.findSystemByKeyword(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), findSystemByKeywordResponse1, false,
                                                    new javax.xml.namespace.QName("http://webservice.elec.wang.org", "findSystemByKeywordResponse"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            @SuppressWarnings("unused")
			private  org.apache.axiom.om.OMElement  toOM(org.wang.elec.webservice.FindSystemByKeyword param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.wang.elec.webservice.FindSystemByKeyword.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            @SuppressWarnings("unused")
			private  org.apache.axiom.om.OMElement  toOM(org.wang.elec.webservice.FindSystemByKeywordResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.wang.elec.webservice.FindSystemByKeywordResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.wang.elec.webservice.FindSystemByKeywordResponse param, boolean optimizeContent, javax.xml.namespace.QName elementQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.wang.elec.webservice.FindSystemByKeywordResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         @SuppressWarnings("unused")
						private org.wang.elec.webservice.FindSystemByKeywordResponse wrapfindSystemByKeyword(){
                                org.wang.elec.webservice.FindSystemByKeywordResponse wrappedElement = new org.wang.elec.webservice.FindSystemByKeywordResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        @SuppressWarnings("unused")
		private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        @SuppressWarnings("rawtypes") java.lang.Class type) throws org.apache.axis2.AxisFault{

        try {
        
                if (org.wang.elec.webservice.FindSystemByKeyword.class.equals(type)){
                
                        return org.wang.elec.webservice.FindSystemByKeyword.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
            
                if (org.wang.elec.webservice.FindSystemByKeywordResponse.class.equals(type)){
                
                        return org.wang.elec.webservice.FindSystemByKeywordResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
            
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        @SuppressWarnings("unused")
		private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    
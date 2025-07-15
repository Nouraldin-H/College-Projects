/*****************************************************************
 * File:  FacesConfigAndServletContextListener.java Course Materials
 * CST 8277
 * 
 * @author (original) Mike Norman
 * @author Teddy Yap
 *
 */
package com.algonquincollege.cst8277.regionalInventory.config;

import static jakarta.faces.application.ProjectStage.PROJECT_STAGE_PARAM_NAME;
import static jakarta.faces.application.ViewHandler.FACELETS_REFRESH_PERIOD_PARAM_NAME;
import static jakarta.faces.validator.BeanValidator.ENABLE_VALIDATE_WHOLE_BEAN_PARAM_NAME;

import jakarta.faces.annotation.FacesConfig;
import jakarta.faces.application.ProjectStage;
import jakarta.faces.webapp.FacesServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRegistration.Dynamic;
import jakarta.servlet.annotation.WebListener;

/**
 * Programmatically replace web.xml setup with this {@link ServletContextListener} <br/>
 * NB:  Some web.xml elements cannot be programmatically replaced, for example &lt;welcome-file-list&gt;
 *
 * <pre>
 * {@code
   <web-app
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns="https://jakarta.ee/xml/ns/jakartaee"
    xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_6_1.xsd"
    version="6.1">

    <context-param>
      <param-name>jakarta.faces.PROJECT_STAGE</param-name>
      <param-value>Development</param-value>
    </context-param>
    <context-param>
      <param-name>jakarta.faces.FACELETS_REFRESH_PERIOD</param-name>
      <param-value>0</param-value>
    </context-param>
    <context-param>
      <param-name>jakarta.faces.validator.ENABLE_VALIDATE_WHOLE_BEAN</param-name>
      <param-value>true</param-value>
    </context-param>

    <servlet>
      <servlet-name>Faces Servlet</servlet-name>
      <servlet-class>jakarta.faces.webapp.FacesServlet</servlet-class>
      <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
      <servlet-name>Faces Servlet</servlet-name>
      <url-pattern>*.xhtml</url-pattern>
    </servlet-mapping>
 </web-app>
   }
 * </pre>
 *
 * @author mwnorman
 * @author yapt
 */
@FacesConfig
@WebListener
public class FacesConfigAndServletContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContextListener.super.contextInitialized(sce);
		ServletContext sc = sce.getServletContext();

		// Registering the JSF Servlet
		Dynamic facesServlet = sc.addServlet("Faces Servlet", FacesServlet.class.getName());
		// Specifying the Servlet Mapping
		facesServlet.addMapping("*.xhtml");
		// Setting Priority, 0 or higher for eager, if negative then it's lazy
		facesServlet.setLoadOnStartup(1);
		// Context parameters
		sc.setInitParameter(FACELETS_REFRESH_PERIOD_PARAM_NAME, "0");
		sc.setInitParameter(PROJECT_STAGE_PARAM_NAME, ProjectStage.Development.name());
		sc.setInitParameter(ENABLE_VALIDATE_WHOLE_BEAN_PARAM_NAME, Boolean.TRUE.toString());
	}
}
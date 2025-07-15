/* File: AuthorDTO.java
 * Author: Stanley Pieda
 * Date: 2015
 * Modified: May/2022 changed Author to AuthorDTO - kriger
 * Description: Demonstration of DAO Design Pattern, MVC Design Pattern
 */
package transferobjects;

public class AuthorDTO {
    private Integer authorID;
    private String firstName;
    private String lastName;
    
    public Integer getAuthorID(){
    	return authorID;
    }
    public void setAuthorID(Integer authorID){
    	this.authorID = authorID;
    }
    
    public String getFirstName(){
    	return firstName;
    }
    public void setFirstName(String firstName){
    	this.firstName = firstName;
    }
    
    public String getLastName(){
    	return lastName;
    }
    public void setLastName(String lastName){
    	this.lastName = lastName;
    }
    
}

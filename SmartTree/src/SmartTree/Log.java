package SmartTree;

public class Log 
{
    /**
     * This Method allows to validate the data typed in the login class.
     * @autor Michell Pineda
     * @param user array in which users are stored with which may enter the software.
     * @param pass array in which the keys are stored with the user which will allow the software to enter.
     * @return an answer by checking if the username and password entered into the login class matches the data stored on the user and pass arrays.
     */
    public static boolean validarIngreso(String user, String pass){
        String usuario[]={"johan","michell","aleja"};
        String clave[]={"123","124","125"};
        for(int i = 0;i< usuario.length;i++){
            if((usuario[i].equals(user)) && (clave[i].equals(pass))){ 
                return true;
            }
        }
	return false; 	
    }
 
}
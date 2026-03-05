package Design;

//Interface for command pattern implementation.
//This interface defines a contract for classes that represent commands in the game.
//Any class implementing this interface must provide an implementation for the execute method.
public interface ICommand {
    
   //boolean indicating the success or failure of the execution.
    boolean execute();

}

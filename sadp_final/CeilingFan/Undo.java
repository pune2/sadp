//package SADP.Q7CeilingFan;

public class Undo implements Command {
    Fan fan;
    public Undo(Fan fan)
    {
        this.fan=fan;
    }
    public void execute()
    {
        fan.undo();
    }
    
}

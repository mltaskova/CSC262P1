package edu.smith.cs.csc262.coopsh.apps;

import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

/**
 * Created by mltaskova on 2/10/19.
 */
public class SetVar extends Task {

    String varName;
    String varValue;
    /**
     * All tasks are created with a possibly empty list of string arguments!
     *
     * @param env
     * @param args - much like public static void main!
     */
    public SetVar(ShellEnvironment env, String[] args) {
        super(env, args);
        if (args.length != 2) {
            System.err.println("set only supports 2 arguments!");
        }
        this.varName = args[0];
        this.varValue = args[1];
        env.variables.put(varName, varValue);
    }

    @Override
    protected void update() {
        this.closeOutput();
        this.exit(0);
    }
}

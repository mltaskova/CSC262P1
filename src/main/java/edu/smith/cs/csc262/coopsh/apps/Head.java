package edu.smith.cs.csc262.coopsh.apps;

import edu.smith.cs.csc262.coopsh.InputLine;
import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

/**
 * Created by mltaskova on 2/10/19.
 */
public class Head extends Task {

    int numElt;
    StringBuilder sb = new StringBuilder();

    public Head(ShellEnvironment env, String[] args) {
        super(env, args);
        if (args.length != 1) {
            System.err.println("head only supports 1 argument!");
        }
        this.numElt = Integer.parseInt(args[0]);
    }

    @Override
    protected void update() {
        InputLine line = this.input.poll();
        if (line == null) {
            // still waiting for more...
            return;
        }

        // only output and print when we've seen the whole file!
        if (numElt == 0) {
            this.closeOutput();
            this.exit(0);
            return;
        }

        // Otherwise, increment this count!
        this.println(line.get());
        numElt--;
    }
}

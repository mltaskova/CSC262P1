package edu.smith.cs.csc262.coopsh.apps;

import edu.smith.cs.csc262.coopsh.InputLine;
import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mltaskova on 2/10/19.
 */
public class Tail extends Task {

    int numElt;
    Queue<String> elts = new LinkedList<>();

    public Tail(ShellEnvironment env, String[] args) {
        super(env, args);
        numElt = Integer.parseInt(args[0]);
    }

    @Override
    protected void update() {
        InputLine line = this.input.poll();
        if (line == null) {
            // still waiting for more...
            return;
        }

        // only output and print when we've seen the whole file!
        if (line.isEndOfFile()) {
            for (String l : elts){
                this.println(l);
            }
            this.closeOutput();
            this.exit(0);
            return;
        }

        // Otherwise, increment this count!
        if (elts.size() == numElt)
            elts.poll();
        elts.add(line.get());
    }
}

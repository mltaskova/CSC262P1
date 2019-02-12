package edu.smith.cs.csc262.coopsh.apps;

import edu.smith.cs.csc262.coopsh.InputLine;
import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

import java.util.Arrays;

/**
 * Created by mltaskova on 2/10/19.
 */
public class Sort extends Task {

    char[] tempArr;
    StringBuilder sb = new StringBuilder();

    public Sort(ShellEnvironment env, String[] args) {
        super(env, args);
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
            tempArr = sb.toString().toCharArray();
            Arrays.sort(tempArr);
            println(new String(tempArr));
            this.closeOutput();
            this.exit(0);
            return;
        }

        // Otherwise, increment this count!
        sb.append(line.get());
    }
}

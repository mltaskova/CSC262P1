package edu.smith.cs.csc262.coopsh.apps;

import edu.smith.cs.csc262.coopsh.InputLine;
import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

import java.util.regex.Pattern;

/**
 * Created by mltaskova on 2/10/19.
 */
public class RegexGrep extends Task {

    Pattern p;

    public RegexGrep(ShellEnvironment env, String[] args) {
        super(env, args);
        p = Pattern.compile(args[0]);
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
            this.closeOutput();
            this.exit(0);
            return;
        }

        // Otherwise, increment this count!
        if (p.matcher(line.get()).find())
            this.println(line.get());
    }
}

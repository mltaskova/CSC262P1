package edu.smith.cs.csc262.coopsh.apps;

import edu.smith.cs.csc262.coopsh.InputLine;
import edu.smith.cs.csc262.coopsh.ShellEnvironment;
import edu.smith.cs.csc262.coopsh.Task;

import java.util.*;

/**
 * Created by mltaskova on 2/10/19.
 */
public class Sort extends Task {

    List<String> list = new LinkedList<>();

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
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            for (String l : list){
                this.println(l);
            }
            this.closeOutput();
            this.exit(0);
            return;
        }

        // Otherwise, increment this count!
        list.add(line.get());
    }
}
